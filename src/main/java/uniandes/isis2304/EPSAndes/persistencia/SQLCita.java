package uniandes.isis2304.EPSAndes.persistencia;

import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLCita {

	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las
	 * sentencias de acceso a la base de datos Se renombra acá para facilitar la
	 * escritura de las sentencias
	 */
	private final static String SQL = PersistenciaEPSAndes.SQL;

	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaEPSAndes pp;

	/**
	 * Constructor
	 * 
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLCita (PersistenciaEPSAndes pp) {
		this.pp = pp;
	}
	public long adicionarCita(PersistenceManager pm,long id ,long asistio, Date fecha , long idServicio ,String nombreServicio )
	{
		Query q = pm.newQuery(SQL , "INSERT INTO" + pp.darTablaCita() + "(id,asistio, fecha,idservicio,nombreservicio)" );
		q.setParameters(id,asistio,fecha,idServicio,nombreServicio);
		 return (long) q.executeUnique();
	}
	public long eliminarAfiliado(PersistenceManager pm,long id )
	{
		Query q = pm.newQuery(SQL , "DELETE FROM" + pp.darTablaCita() + "where id = ?" );
		q.setParameters(id);
		 return (long) q.executeUnique();
	}
}
