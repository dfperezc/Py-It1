package uniandes.isis2304.EPSAndes.negocio;

public class Terapia extends Servicio implements VOTerapia{
	
	private int numeroSesiones;
	private String tipo;
	
	/**
	 * @param id
	 * @param capacidad
	 * @param horariosAtencion
	 * @param numeroSesiones
	 * @param tipo
	 */
	public Terapia(long id, int capacidad, String horariosAtencion, int numeroSesiones, String tipo) {
		super(id, capacidad, horariosAtencion);
		this.numeroSesiones = numeroSesiones;
		this.tipo = tipo;
	}

	/**
	 * @return the numeroSesiones
	 */
	public int getNumeroSesiones() {
		return numeroSesiones;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param numeroSesiones the numeroSesiones to set
	 */
	public void setNumeroSesiones(int numeroSesiones) {
		this.numeroSesiones = numeroSesiones;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
