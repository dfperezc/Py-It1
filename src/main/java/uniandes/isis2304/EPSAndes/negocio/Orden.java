package uniandes.isis2304.EPSAndes.negocio;

public class Orden implements VOOrden{

	/**
	 * El identificador ÚNICO del administrador
	 */
	private long id;
	
	
	
	/**
	 * @param id
	 */
	public Orden(long id) {
		this.id = id;
	}

	/**
	 * @return El id del administrador
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id - El nuevo id del administrador
	 */
	public void setId(long id) {
		this.id = id;
	}
	
}
