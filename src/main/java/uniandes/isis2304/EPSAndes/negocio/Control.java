package uniandes.isis2304.EPSAndes.negocio;

public class Control extends Servicio implements VOControl{
	
	

	/**
	 * @param id
	 * @param capacidad
	 * @param horariosAtencion
	 */
	public Control(long id, int capacidad, String horariosAtencion) {
		super(id, capacidad, horariosAtencion);
	}
	@Override
	public long getId() 
	{
		return this.getId();
	}

}
