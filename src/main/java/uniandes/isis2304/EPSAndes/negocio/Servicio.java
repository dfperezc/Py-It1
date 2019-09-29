package uniandes.isis2304.EPSAndes.negocio;

public class Servicio implements VOServicio{
	
	private long id;
	private int capacidad;
	private String horariosAtencion;
	
	
	
	/**
	 * @param id
	 * @param capacidad
	 * @param horariosAtencion
	 */
	public Servicio(long id, int capacidad, String horariosAtencion) {
		this.id = id;
		this.capacidad = capacidad;
		this.horariosAtencion = horariosAtencion;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}
	/**
	 * @return the horariosAtencion
	 */
	public String getHorariosAtencion() {
		return horariosAtencion;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	/**
	 * @param horariosAtencion the horariosAtencion to set
	 */
	public void setHorariosAtencion(String horariosAtencion) {
		this.horariosAtencion = horariosAtencion;
	}
	

}
