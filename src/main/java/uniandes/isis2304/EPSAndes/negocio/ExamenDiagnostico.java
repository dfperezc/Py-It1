package uniandes.isis2304.EPSAndes.negocio;

public class ExamenDiagnostico extends Servicio implements VOExamenDiagnostico{
	
	private String muestras;
	private String resultados;
	
	/**
	 * @param id
	 * @param capacidad
	 * @param horariosAtencion
	 * @param muestras
	 * @param resultados
	 */
	public ExamenDiagnostico(long id, int capacidad, String horariosAtencion, String muestras, String resultados) {
		super(id, capacidad, horariosAtencion);
		this.muestras= muestras;
		this.resultados = resultados;
		
	}

	/**
	 * @return the muestras
	 */
	public String getMuestras() {
		return muestras;
	}

	/**
	 * @return the resultados
	 */
	public String getResultados() {
		return resultados;
	}

	/**
	 * @param muestras the muestras to set
	 */
	public void setMuestras(String muestras) {
		this.muestras = muestras;
	}

	/**
	 * @param resultados the resultados to set
	 */
	public void setResultados(String resultados) {
		this.resultados = resultados;
	}

}
