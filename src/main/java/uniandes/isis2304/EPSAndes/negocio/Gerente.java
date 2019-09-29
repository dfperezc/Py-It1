package uniandes.isis2304.EPSAndes.negocio;

public class Gerente extends Usuario implements VOGerente{

	/**
	 * @param id
	 * @param email
	 * @param nombre
	 * @param numeroDocumento
	 * @param rol
	 * @param tipoDocumento
	 */
	public Gerente(long id, String email, String nombre, int numeroDocumento, Rol rol, String tipoDocumento) {
		super(id, email, nombre, numeroDocumento, rol, tipoDocumento);
	}
}
