package uniandes.isis2304.EPSAndes.negocio;

import java.util.Date;

public class Afiliado extends Usuario implements VOAfiliado{

	private long id;
	private String estadoSalud;
	private Date fechaNacimiento;
	private String recetaActual;
	
	
	
	/**
	 * 
	 * @param id
	 * @param email
	 * @param nombre
	 * @param numeroDocumento
	 * @param rol
	 * @param tipoDocumento
	 * @param estadoSalud
	 * @param fechaNacimiento
	 * @param recetaActual
	 */
	public Afiliado(long id, String email, String nombre, int numeroDocumento, Rol rol, String tipoDocumento, String estadoSalud, Date fechaNacimiento, String recetaActual) {
		this.id = id;
		this.estadoSalud = estadoSalud;
		this.fechaNacimiento = fechaNacimiento;
		this.recetaActual = recetaActual;
	}
	public Afiliado() {
		this.id = 0;
		this.estadoSalud = "";
		Date demo = new Date(2019, 01, 01);
		this.fechaNacimiento = demo;
		this.recetaActual = "";
	}
	
	public long getID()
	{
		return id;
	}
	
	
	public String getEstadoSalud() {
		return estadoSalud;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public String getRecetaActual() {
		return recetaActual;
	}
	public void setEstadoSalud(String estadoSalud) {
		this.estadoSalud = estadoSalud;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public void setRecetaActual(String recetaActual) {
		this.recetaActual = recetaActual;
	}
	
	
	
}
