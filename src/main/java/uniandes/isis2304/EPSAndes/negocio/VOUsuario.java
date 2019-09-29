package uniandes.isis2304.EPSAndes.negocio;

public interface VOUsuario {

	public long getId();
	public String getEmail() ;
	public String getNombre() ;
	public int getNumeroDocumento();
	public Rol getRol() ;
	public String getTipoDocumento();
	
}
