package uniandes.isis2304.EPSAndes.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.Gustan;
import uniandes.isis2304.EPSAndes.negocio.Rol;
import uniandes.isis2304.EPSAndes.negocio.TipoBebida;

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

	
	public long adicionarRol(PersistenceManager pm, long idRol, String rol) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaRol() + "(id, nombre) values (?, ?)");
		q.setParameters(idRol, rol);
		return (long) q.executeUnique();
	}
	
	public List<Rol> darRol(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRol());
		q.setResultClass(Rol.class);
		List<Rol> resp = (List<Rol>) q.execute();
		return resp;
	}
	
	public List<Rol> darRolPorNombre(PersistenceManager pm, String nombre) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRol() + " WHERE nombre = ?");
		q.setResultClass(Rol.class);
		q.setParameters(nombre);
		return (List<Rol>) q.executeList();
	}
	
	public List<Rol> darRoles(PersistenceManager pm) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaRol());
		q.setResultClass(Rol.class);
		return (List<Rol>) q.executeList();
	}
	
	public long eliminarRolPorId(PersistenceManager pm, long idRol) {
		Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaRol() + " WHERE id = ?");
		q.setParameters(idRol);
		return (long) q.executeUnique();
	}
}
