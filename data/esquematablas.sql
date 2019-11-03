--- Sentencias SQL para la creación del esquema de parranderos
--- Las tablas tienen prefijo A_ para facilitar su acceso desde SQL Developer

-- USO
-- Copie el contenido de este archivo en una pestaña SQL de SQL Developer
-- Ejecútelo como un script - Utilice el botón correspondiente de la pestaña utilizada

-- Creación del secuenciador
create sequence parranderos_sequence;

-- Creaación de la tabla USUARIO y especificación de sus restricciones
CREATE TABLE USUARIO
(
  ID NUMBER,
  EMAIL VARCHAR2 (255 BYTE),
  NOMBRE VARCHAR2 (255 BYTE),
  NUMERODOCUMENTO NUMBER (20,0),
  ROL VARCHAR2(50 BYTE),
  TIPODOCUMENTO VARCHAR2 (255 BYTE),
  CONSTRAINT USUARIO PRIMARY KEY (ID));


ALTER TABLE USUARIO
MODIFY NUMERODOCUMENTO NOT NULL
  ENABLE;

  ALTER TABLE USUARIO
  ADD  CHECK (ID>0)
ENABLE;

ALTER TABLE USUARIO
ADD CHECK (ROL IN ('AFILIADO', 'DOCTOR', 'GERENTE' , 'RECEPCIONISTA ', 'GERENTE' )) 
ENABLE;
  -- Creaación de la tabla GERENTE y especificación de sus restricciones
CREATE TABLE GERENTE
   (ID NUMBER, 
    IDGERENTEUSUARIO NUMBER, 
    CONSTRAINT GERENTE PRIMARY KEY (ID));

ALTER TABLE GERENTE
  ADD  CHECK (ID>0)
ENABLE;

ALTER TABLE GERENTE
  ADD CONSTRAINT FK_USUARIOGERENTE
  FOREIGN KEY (IDGERENTEUSUARIO)
  REFERENCES USUARIO(ID)
ENABLE;
-- Creaación de la tabla EPS y especificación de sus restricciones
CREATE TABLE EPS 
   (ID NUMBER, 
  NOMBRE VARCHAR2(255 BYTE), 
  IDGERENTE NUMBER, 
  CONSTRAINT EPS PRIMARY KEY (ID));
  
ALTER TABLE EPS
  ADD  CHECK (ID>0)
ENABLE;

ALTER TABLE EPS
ADD CONSTRAINT FK_GERENTE
    FOREIGN KEY (IDGERENTE)
    REFERENCES GERENTE(id)
ENABLE;
-- Creaación de la tabla IPS y especificación de sus restricciones
CREATE TABLE IPS 
   (ID NUMBER, 
    IDEPS NUMBER,
  LOCALIZACION VARCHAR2(255 BYTE), 
  NOMBRE VARCHAR2 (255 BYTE), 
  CONSTRAINT IPS PRIMARY KEY (ID));
  
ALTER TABLE IPS
 ADD  CHECK (ID>0)
ENABLE;

ALTER TABLE IPS
ADD CONSTRAINT FK_EPS
    FOREIGN KEY (IDEPS)
    REFERENCES GERENTE(id)
ENABLE;

CREATE TABLE ADMINISTRADOR
(
  ID NUMBER,
  IDUSUARIO NUMBER,
  IDEPS NUMBER,
  CONSTRAINT ADMINISTRADOR PRIMARY KEY (ID)
);

ALTER TABLE ADMINISTRADOR 
ADD CHECK (ID > 0)
ENABLE; 

ALTER TABLE ADMINISTRADOR
ADD CONSTRAINT IDUSUARIOADMINISTRADOR
FOREIGN KEY (IDUSUARIO)
REFERENCES USUARIO(ID)
ENABLE;

ALTER TABLE ADMINISTRADOR 
ADD CONSTRAINT IDEPSADMINISTRADOR
FOREIGN KEY (IDEPS)
REFERENCES EPS(ID)
ENABLE;

-- Creaación de la tabla VISITAN y especificación de sus restricciones
CREATE TABLE MEDICO 
(
  ID NUMBER,
  ESPECIALIDAD VARCHAR2 (255 BYTE),
  NUMEROREGISTRO VARCHAR2(255 BYTE), 
  IDUSUARIO NUMBER, 
  CONSTRAINT MEDICO PRIMARY KEY (ID)
);
ALTER TABLE MEDICO
ADD CONSTRAINT FK_USUARIOMEDICO
    FOREIGN KEY (IDUSUARIO)
    REFERENCES USUARIO(ID)
ENABLE;

ALTER TABLE MEDICO
  ADD   CHECK (ID>0)
ENABLE;

ALTER TABLE MEDICO
ADD CHECK (NOMBRE  IN ('PEDIATRIA','GINECOLOGIA','OPTOMETRIA','ODONTOLOGIA','LABORATORIO CLINICO','RAYOS X' )
ENABLE;

CREATE TABLE SERVICIO 
(
  ID NUMBER,
  CAPACIDAD NUMBER,
  NOMBRE VARCHAR2 (50 BYTE),
  IDIPS NUMBER,
  CONSTRAINT SERVICIO PRIMARY KEY (ID)
);

ALTER TABLE SERVICIO
  ADD  CHECK (ID>0)
ENABLE;

ALTER TABLE SERVICIO 
ADD CONSTRAINT FK_IPSSERVICIO
    FOREIGN KEY (IDIPS)
    REFERENCES IPS(ID)
ENABLE;

ALTER TABLE SERVICIO
ADD CHECK (NOMBRE  IN ('PEDIATRIA','GINECOLOGIA','OPTOMETRIA','ODONTOLOGIA','LABORATORIO CLINICO','RAYOS X' )
ENABLE;

CREATE TABLE CITA
(
  ID NUMBER,
  ASISTIO NUMBER,
  FECHA DATE,  
  IDSERVICIO NUMBER,
  NOMBRESERVICIO VARCHAR2 (255 BYTE),
  CONSTRAINT CITA PRIMARY KEY (ID)
); 

ALTER TABLE CITA
ADD CHECK (ID > 0)
ENABLE;  

ALTER TABLE CITA
ADD CONSTRAINT IDSERVICIOCITA
FOREIGN KEY (IDSERVICIO)
REFERENCES SERVICIO (ID)
ENABLE;

ALTER TABLE CITA
ADD CHECK (ASISTIO >= 0 AND ASISTIO <=1)
ENABLE;


-- Creaación de la tabla ORDEN y especificación de sus restricciones
CREATE TABLE ORDEN
   (ID NUMBER, 
   IDSERVICIO NUMBER, 
  CONSTRAINT ORDEN PRIMARY KEY (ID));
   
ALTER TABLE ORDEN
  ADD  CHECK (ID>0)
ENABLE;

ALTER TABLE ORDEN
  ADD CONSTRAINT FK_SERVICIOORDEN 
  FOREIGN KEY (IDSERVICIO)
  REFERENCES SERVICIO(ID)
ENABLE;

-- Creaación de la tabla AFILIADO y especificación de sus restricciones
CREATE TABLE AFILIADO
   (
    ID NUMBER, 
    ESTADOSALUD VARCHAR2 (255 BYTE), 
    FECHANACIMIENTO DATE,
    RECETAACTUAL VARCHAR2 (255 BYTE),
    IDORDEN NUMBER,
    IDUSUARIOAFILIADO NUMBER,
    IDEPS NUMBER,
    IDCITA NUMBER,  
    CONSTRAINT AFILIADO PRIMARY KEY (ID)
   );
  
ALTER TABLE AFILIADO
  ADD CHECK (ID>0)
ENABLE;

ALTER TABLE AFILIADO
 ADD CONSTRAINT FK_ORDENAFILIADO
   FOREIGN KEY (IDORDEN)
   REFERENCES ORDEN(ID)
   ENABLE; 

ALTER TABLE AFILIADO
 ADD CONSTRAINT FK_USUARIOAFILIADO
   FOREIGN KEY (IDUSUARIOAFILIADO)
   REFERENCES USUARIO(ID)
   ENABLE;

ALTER TABLE AFILIADO
ADD CONSTRAINT FK_IDEPS
FOREIGN KEY (IDEPS)
REFERENCES EPS(ID)
ENABLE;

ALTER TABLE AFILIADO 
ADD CONSTRAINT FK_CITAAFILIADO
FOREIGN KEY (IDCITA)
REFERENCES CITA(ID)
ENABLE;
   
-- Creaación de la tabla RECEPCIONISTA y especificación de sus restricciones
CREATE TABLE RECEPCIONISTA
(
  ID NUMBER,
  IDIPS NUMBER,
  IDUSUARIO NUMBER,
  CONSTRAINT RECEPCIONISTA PRIMARY KEY (ID)
);

ALTER TABLE RECEPCIONISTA
  ADD CONSTRAINT ID 
  CHECK (ID>0)
ENABLE;

ALTER TABLE RECEPCIONISTA
ADD CONSTRAINT FK_IPSRECEPCIONISTA
    FOREIGN KEY (IDIPS)
    REFERENCES IPS(id)
ENABLE;
    
ALTER TABLE RECEPCIONISTA
ADD CONSTRAINT FK_USUARIORECEPCIONISTA
    FOREIGN KEY (IDUSUARIO)
    REFERENCES USUARIO(id)
ENABLE;


CREATE TABLE JOINRECEPCITA
(
  IDCITA NUMBER,
  IDRECEPCIONISTA NUMBER,
  CONSTRAINT JOINRECEPCITA PRIMARY KEY (IDCITA ,IDRECEPCIONISTA)
);  

ALTER TABLE JOINRECEPCITA
ADD CONSTRAINT IDCITAJOIN
FOREIGN KEY (IDCITA)
REFERENCES CITA(ID)
ENABLE;

ALTER TABLE JOINRECEPCITA
ADD CONSTRAINT IDPERCEPJOIN
FOREIGN KEY (IDRECEPCIONISTA)
REFERENCES RECEPCIONISTA(ID)
ENABLE;

CREATE TABLE JOINMEDICOIPS
(
  IDMEDICO NUMBER,
  IDIPS NUMBER,
  CONSTRAINT JOINMEDICOIPS PRIMARY KEY (IDMEDICO,IDIPS)
);

ALTER TABLE JOINMEDICOIPS
ADD CONSTRAINT FK_MEDICOJOIN
    FOREIGN KEY (IDMEDICO)
    REFERENCES MEDICO(ID)
ENABLE;

ALTER TABLE JOINMEDICOIPS
ADD CONSTRAINT FK_IPSJOINMEDICOIPS
    FOREIGN KEY (IDIPS)
    REFERENCES IPS(ID)
    ENABLE;



CREATE TABLE EXAMENDIAGNOSTICO 
(
  IDSERVICIO NUMBER, 
  CONSTRAINT EXAMENDIAGNOSTICO PRIMARY KEY (IDSERVICIO)
);


ALTER TABLE EXAMENDIAGNOSTICO
ADD CONSTRAINT FK__SERVICIODIAGNOSTICO
 FOREIGN KEY (IDSERVICIO)
 REFERENCES SERVICIO(ID)
 ENABLE; 

CREATE TABLE  HOSPITALIZACION 
(
  IDSERVICIO NUMBER,
  CONSTRAINT HOSPITALIZACION PRIMARY KEY (IDSERVICIO)  
);

ALTER TABLE HOSPITALIZACION
ADD CONSTRAINT FK__SERVICIOHOSPITAL
 FOREIGN KEY (IDSERVICIO)
 REFERENCES SERVICIO(ID)
 ENABLE;

CREATE TABLE  CONSULTA 
(
  IDSERVICIO NUMBER,
  CONSTRAINT CONSULTA PRIMARY KEY (IDSERVICIO)  
);

ALTER TABLE CONSULTA
ADD CONSTRAINT FK__SERVICIOCONSULTA
 FOREIGN KEY (IDSERVICIO)
 REFERENCES SERVICIO(ID)
 ENABLE;

CREATE TABLE  CONTROL
(
  IDSERVICIO NUMBER,
  CONSTRAINT CONTROL PRIMARY KEY (IDSERVICIO)  
);

ALTER TABLE CONTROL
ADD CONSTRAINT FK__SERVICIOCONTROL
 FOREIGN KEY (IDSERVICIO)
 REFERENCES SERVICIO(ID)
 ENABLE;

CREATE TABLE  REMISION 
(
  IDSERVICIO NUMBER,
  CONSTRAINT REMISION PRIMARY KEY (IDSERVICIO)  
);

ALTER TABLE REMISION
ADD CONSTRAINT FK__SERVICIOREMISION
 FOREIGN KEY (IDSERVICIO)
 REFERENCES SERVICIO(ID)
 ENABLE;

CREATE TABLE TERAPIA 
(
  IDSERVICIO NUMBER,
  TIPO VARCHAR2 (50 BYTE),
  NUMEROSESIONES NUMBER(8,2),
  CONSTRAINT TERAPIA PRIMARY KEY (IDSERVICIO)  
);

ALTER TABLE TERAPIA
ADD CONSTRAINT FK__SERVICIOTERAPIA
 FOREIGN KEY (IDSERVICIO)
 REFERENCES SERVICIO(ID)
 ENABLE;

 CREATE TABLE  URGENCIA
(
  IDSERVICIO NUMBER,
  CONSTRAINT URGENCIA PRIMARY KEY (IDSERVICIO)  
);

ALTER TABLE URGENCIA
ADD CONSTRAINT FK__SERVICIOURGENCIA
 FOREIGN KEY (IDSERVICIO)
 REFERENCES SERVICIO(ID)
 ENABLE; 

 CREATE TABLE PROCEDIMIENTOESPECIALIZADO 
(
  IDSERVICIO NUMBER,
  TIPO  NUMBER(8,2),
  CONSTRAINT PROCEDIMIENTOESPECIALIZADO PRIMARY KEY (IDSERVICIO)  
);

ALTER TABLE PROCEDIMIENTOESPECIALIZADO
ADD CONSTRAINT FK__SERVICIOESPECIAL
 FOREIGN KEY (IDSERVICIO)
 REFERENCES SERVICIO(ID)
 ENABLE; 

CREATE TABLE TRABAJAN 
(
  ID NUMBER,
  IDMEDICO NUMBER,
  IDIPS NUMBER,
  CONSTRAINT TRABAJAN PRIMARY KEY (ID)
);

ALTER TABLE TRABAJAN 
ADD CHECK (ID>0)
ENABLE;

ALTER  TABLE  TRABAJAN 
ADD CONSTRAINT FK_MEDICOTRABAJA
FOREIGN KEY (IDMEDICO)
REFERENCES MEDICO(ID)
ENABLE; 

ALTER  TABLE  TRABAJAN 
ADD CONSTRAINT FK_IPSTRABAJA
FOREIGN KEY (IDIPS)
REFERENCES IPS(ID)
ENABLE;

CREATE TABLE HORARIOSERVICIO 
(
ID NUMBER,	-- opciones de cambio tabla horarios con medicos por que esos son como arreglos que tengan el id del servicio  estado.
IDMEDICO NUMBER,
HORARIO DATE,
IDSERVICIO NUMBER,
ESTADO VARCHAR2(255),
IDORDEN NUMBER,
CONSTRAINT HORARIOSERVICIO PRIMARY KEY (ID)
);

ALTER TABLE HORARIOSERVICIO
ADD CONSTRAINT FKMEDICOHORARIO
FOREIGN KEY (IDMEDICO)
REFERENCES MEDICO (ID)
ENABLE;


ALTER TABLE HORARIOSERVICIO
ADD CONSTRAINT FKSERVICIOHORARIO
FOREIGN KEY (IDSERVICIO)
REFERENCES SERVICIO(ID)
ENABLE;


ALTER TABLE HORARIOSERVICIO
ADD CONSTRAINT FKORDENHORARIO
FOREIGN KEY (IDORDEN)
REFERENCES ORDEN(ID)
ENABLE;

COMMIT;