package uniandes.isis2304.EPSAndes.persistencia;

public class SQLUrgencia {

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
	public SQLUrgencia(PersistenciaEPSAndes pp) {
		this.pp = pp;
	}

}
