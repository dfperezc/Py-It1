package uniandes.isis2304.EPSAndes.negocio;

public class Consulta extends Servicio implements VOConsulta{
	

	/**
	 * @param id
	 * @param capacidad
	 * @param horariosAtencion
	 */
	public Consulta(long id, int capacidad, String horariosAtencion) {
		super(id, capacidad, horariosAtencion);
	}

	
}
