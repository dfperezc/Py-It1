/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.EPSAndes.negocio;

import java.sql.Timestamp;

/**
 * Interfaz para los métodos get de VISITAN. Sirve para proteger la información
 * del negocio de posibles manipulaciones desde la interfaz
 * 
 * @author Germán Bravo
 */
public interface VOVisitan {
	/*
	 * **************************************************************** Métodos
	 *****************************************************************/
	/**
	 * @return El idBebedor
	 */
	public long getIdBebedor();

	/**
	 * @return El idBar
	 */
	public long getIdBar();

	/**
	 * @return La fechaVisita
	 */
	public Timestamp getFechaVisita();

	/**
	 * @return El horario
	 */
	public String getHorario();

	/**
	 * @return Una cadena con la información básica
	 */
	@Override
	public String toString();

}
