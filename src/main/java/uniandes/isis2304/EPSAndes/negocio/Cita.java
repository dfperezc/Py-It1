package uniandes.isis2304.EPSAndes.negocio;

public class Cita implements VOCita{
	
	private long id;
	private int cumplida;
	private int fecha;
	
	
	
	
	/**
	 * @param id
	 * @param cumplida
	 * @param fecha
	 */
	public Cita(long id, int cumplida, int fecha) {
		super();
		this.id = id;
		this.cumplida = cumplida;
		this.fecha = fecha;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return the cumplida
	 */
	public int getCumplida() {
		return cumplida;
	}
	/**
	 * @return the fecha
	 */
	public int getFecha() {
		return fecha;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @param cumplida the cumplida to set
	 */
	public void setCumplida(int cumplida) {
		this.cumplida = cumplida;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

}
