package uniandes.isis2304.EPSAndes.negocio;

public class Hospitalizacion extends Servicio implements VOHospitalizacion{
	
	/**
	 * @param id
	 * @param capacidad
	 * @param horariosAtencion
	 */
	public Hospitalizacion(long id, int capacidad, String horariosAtencion) {
		super(id, capacidad, horariosAtencion);
	}

	
	public long getId()
	{
		return this.getId();
	}
	public int getCapacidad()
	{
		return this.getCapacidad();
		
	}
	public String hotariosAtencion()
	{
		return this.getHorariosAtencion();
	}
	
	
}
