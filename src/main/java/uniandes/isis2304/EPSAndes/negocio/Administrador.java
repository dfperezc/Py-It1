package uniandes.isis2304.EPSAndes.negocio;

public class Administrador  extends Usuario implements VOAdministrador{ 

	/**
	 * @param id
	 * @param email
	 * @param nombre
	 * @param numeroDocumento
	 * @param rol
	 * @param tipoDocumento
	 */
	public Administrador(long id, String email, String nombre, int numeroDocumento, Rol rol, String tipoDocumento) {
		super(id, email, nombre, numeroDocumento, rol, tipoDocumento);
	}
	

}
