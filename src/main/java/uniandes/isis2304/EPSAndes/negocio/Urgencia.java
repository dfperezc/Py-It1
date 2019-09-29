package uniandes.isis2304.EPSAndes.negocio;

public class Urgencia extends Servicio implements VOUrgencia{

	/**
	 * @param id
	 * @param capacidad
	 * @param horariosAtencion
	 */
	public Urgencia(long id, int capacidad, String horariosAtencion) {
		super(id, capacidad, horariosAtencion);
	}
	
}
