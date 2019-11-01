package uniandes.isis2304.EPSAndes.negocio;

public class Remision extends Servicio implements VORemision{
	
	/**
	 * @param id
	 * @param capacidad
	 * @param horariosAtencion
	 */
	public Remision(long id, int capacidad, String horariosAtencion) {
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
