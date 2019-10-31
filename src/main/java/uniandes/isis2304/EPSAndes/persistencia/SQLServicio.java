package uniandes.isis2304.EPSAndes.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLServicio {

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
	public SQLServicio(PersistenciaEPSAndes pp) {
		this.pp = pp;
	}
	public long adicionarServicio(PersistenceManager pm,long id )
	{
		Query q = pm.newQuery(SQL , "INSERT INTO" + pp.darTablaServicio() + "(id)" );
		q.setParameters(id);
		 return (long) q.executeUnique();
	}
	public long eliminarServicio(PersistenceManager pm,long id )
	{
		Query q = pm.newQuery(SQL , "DELETE FROM" + pp.darTablaServicio() + "where id = ?" );
		q.setParameters(id);
		 return (long) q.executeUnique();
	}
}
