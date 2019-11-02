package uniandes.isis2304.EPSAndes.negocio;

public class Recepcionista extends Usuario implements VORecepcionista{

	/**
	 * @param id
	 * @param email
	 * @param nombre
	 * @param numeroDocumento
	 * @param rol
	 * @param tipoDocumento
	 */
	public Recepcionista(long id, String email, String nombre, int numeroDocumento, String rol, String tipoDocumento) {
		super(id, email, nombre, numeroDocumento, rol, tipoDocumento);
	}
	public long getId()
	{
		return this.getId();
	}
	public String getEmail() 
	{
		return this.getEmail();
	}
	public String getNombre() 
	{
		return this.getNombre();
	}
	public long getNumeroDocumento() 
	{
		return this.getNumeroDocumento();
	}
	public String getRol()
	{
		return this.getRol();
	}
	public String getTipoDocumento()
	{
		return this.getTipoDocumento();
	}
}
