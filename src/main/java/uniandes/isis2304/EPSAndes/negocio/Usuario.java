package uniandes.isis2304.EPSAndes.negocio;

public class Usuario implements VOUsuario{
	
	/**
	 * El identificador ÚNICO del administrador
	 */
	private long id;
	
	private String email;
	private String nombre;
	private int numeroDocumento;
	private Rol rol;
	private String tipoDocumento;
	
	
	public Usuario(long id, String email, String nombre, int numeroDocumento, Rol rol, String tipoDocumento) {
		this.id = id;
		this.email = email;
		this.nombre = nombre;
		this.numeroDocumento = numeroDocumento;
		this.rol = rol;
		this.tipoDocumento = tipoDocumento;
	}
	public long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getNombre() {
		return nombre;
	}
	public int getNumeroDocumento() {
		return numeroDocumento;
	}
	public Rol getRol() {
		return rol;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

}
