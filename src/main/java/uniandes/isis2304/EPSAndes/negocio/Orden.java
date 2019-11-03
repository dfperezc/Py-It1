package uniandes.isis2304.EPSAndes.negocio;

public class Orden implements VOOrden{

	
	private long id;
	private long idServicio;
	
	

	public Orden(long id, long idServicio) {
		this.id = id;
		this.idServicio = idServicio;
	}


	public long getId() {
		return id;
	}
	public long getIdServicio() {
		return idServicio;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
