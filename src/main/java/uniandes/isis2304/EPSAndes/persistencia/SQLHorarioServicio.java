package uniandes.isis2304.EPSAndes.persistencia;

import java.sql.Date;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.EPSAndes.negocio.HorarioServicio;
import uniandes.isis2304.EPSAndes.negocio.IPS;

public class SQLHorarioServicio 
{
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
	public SQLHorarioServicio(PersistenciaEPSAndes pp) {
		this.pp = pp;
	}
	public long adicionarHorarioServicio(PersistenceManager pm,long id ,Date horario ,long idServicio, String estado  )
	{
		Query q = pm.newQuery(SQL , "INSERT INTO" + pp.darTablaHorarioServicio() + "(id,horario,idservicio,estado)" );
		q.setParameters(id,horario ,idServicio ,estado);
		 return (long) q.executeUnique();
	}
	public long eliminarIPS(PersistenceManager pm,long id )
	{
		Query q = pm.newQuery(SQL , "DELETE FROM" + pp.darTablaHorarioServicio() + "where id = ?" );
		q.setParameters(id);
		 return (long) q.executeUnique();
	}
	public HorarioServicio darHorarioServicioPorId(PersistenceManager pm, long idIPS) {
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHorarioServicio() + " WHERE id = ?");
		q.setResultClass(HorarioServicio.class);
		q.setParameters(idIPS);
		return (HorarioServicio) q.executeUnique();
	}
}
