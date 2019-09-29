package uniandes.isis2304.EPSAndes.negocio;

public class ProcedimientoEspecializado extends Servicio implements VOProcedimientoEspecializado{
	
	private String tipo;
	
	/**
	 * @param id
	 * @param capacidad
	 * @param horariosAtencion
	 * @param tipo
	 */
	public ProcedimientoEspecializado(long id, int capacidad, String horariosAtencion, String tipo) {
		super(id, capacidad, horariosAtencion);
		this.tipo = tipo;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
