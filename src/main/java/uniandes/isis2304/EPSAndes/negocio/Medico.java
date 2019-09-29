package uniandes.isis2304.EPSAndes.negocio;

public class Medico extends Usuario implements VOMedico{
	
	private Long id;
	private String especialidad;
	private String numeroRegistro;
	
	
	
	/**
	 * @param id
	 * @param especialidad
	 * @param numeroRegistro
	 */
	public Medico(Long id, String email, String nombre, int numeroDocumento, Rol rol, String tipoDocumento, String especialidad, String numeroRegistro) {
		super(id, email, nombre, numeroDocumento, rol, tipoDocumento);
		this.id = id;
		this.especialidad = especialidad;
		this.numeroRegistro = numeroRegistro;
	}
	/**
	 * @return the especialidad
	 */
	public String getEspecialidad() {
		return especialidad;
	}
	/**
	 * @return the numeroRegistro
	 */
	public String getNumeroRegistro() {
		return numeroRegistro;
	}
	/**
	 * @param especialidad the especialidad to set
	 */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	/**
	 * @param numeroRegistro the numeroRegistro to set
	 */
	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	
	
	

}
