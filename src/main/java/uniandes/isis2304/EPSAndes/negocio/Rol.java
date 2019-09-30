package uniandes.isis2304.EPSAndes.negocio;

public class Rol implements VORol{

	private String tipo;
	private long id;
	

	/**
	 * @param tipo
	 */
	public Rol(String tipo) {
		this.tipo = tipo;
	}


	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
}
