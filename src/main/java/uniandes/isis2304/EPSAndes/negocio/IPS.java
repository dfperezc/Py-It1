package uniandes.isis2304.EPSAndes.negocio;

public class IPS implements VOIPS{

	private String localizacion;
	private String nombre;
	
	
	/**
	 * @param localizacion
	 * @param nombre
	 */
	public IPS(String localizacion, String nombre) {
		this.localizacion = localizacion;
		this.nombre = nombre;
	}
	
	/**
	 * @return the localizacion
	 */
	public String getLocalizacion() {
		return localizacion;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param localizacion the localizacion to set
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
