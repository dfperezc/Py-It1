package uniandes.isis2304.EPSAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.Gustan;

public class SQLRol {

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
	public SQLRol(PersistenciaEPSAndes pp) {
		this.pp = pp;
	}

	
	public long adicionarRol(PersistenceManager pm, String rol) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaRol() + "rol values ( ? )");
		q.setParameters(rol);
		return (long) q.executeUnique();
	}
	
	public List<Gustan> darGustan(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRol());
		q.setResultClass(Gustan.class);
		List<Gustan> resp = (List<Gustan>) q.execute();
		return resp;
	}
}
