package uniandes.isis2304.EPSAndes.negocio;

public class Consulta extends Servicio implements VOConsulta{
	
	private long id;

	/**
	 * @param id
	 */
	public Consulta(long id ,int capacidad, String horariosAtencion )
	{
		super(id, capacidad, horariosAtencion);
			
	}

	@Override
	public long getId() 
	{
		return this.getId();
	}

	
}
