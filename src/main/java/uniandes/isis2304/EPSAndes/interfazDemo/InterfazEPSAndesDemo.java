/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                          * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.EPSAndes.interfazDemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.EPSAndes.interfazApp.PanelDatos;

import uniandes.isis2304.EPSAndes.negocio.VOGustan;
import uniandes.isis2304.EPSAndes.negocio.VORol;
import uniandes.isis2304.EPSAndes.negocio.VOUsuario;
import uniandes.isis2304.EPSAndes.negocio.VOVisitan;
import uniandes.isis2304.EPSAndes.negocio.EPSAndes;

/**
 * Clase principal de la interfaz
 * 
 * @author Germán Bravo
 */
@SuppressWarnings("serial")

public class InterfazEPSAndesDemo extends JFrame implements ActionListener {
	/*
	 * **************************************************************** Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(InterfazEPSAndesDemo.class.getName());

	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigDemo.json";

	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json";

	/*
	 * **************************************************************** Atributos
	 *****************************************************************/
	/**
	 * Objeto JSON con los nombres de las tablas de la base de datos que se quieren
	 * utilizar
	 */
	private JsonObject tableConfig;

	/**
	 * Asociación a la clase principal del negocio.
	 */
	private EPSAndes EPSAndes;

	/*
	 * **************************************************************** Atributos de
	 * interfaz
	 *****************************************************************/
	/**
	 * Objeto JSON con la configuración de interfaz de la app.
	 */
	private JsonObject guiConfig;

	/**
	 * Panel de despliegue de interacción para los requerimientos
	 */
	private PanelDatos panelDatos;

	/**
	 * Menú de la aplicación
	 */
	private JMenuBar menuBar;

	/*
	 * **************************************************************** Métodos
	 *****************************************************************/
	/**
	 * Construye la ventana principal de la aplicación. <br>
	 * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
	 */
	public InterfazEPSAndesDemo() {
		// Carga la configuración de la interfaz desde un archivo JSON
		guiConfig = openConfig("Interfaz", CONFIG_INTERFAZ);

		// Configura la apariencia del frame que contiene la interfaz gráfica
		configurarFrame();
		if (guiConfig != null) {
			crearMenu(guiConfig.getAsJsonArray("menuBar"));
		}

		tableConfig = openConfig("Tablas BD", CONFIG_TABLAS);
		EPSAndes = new EPSAndes(tableConfig);

		String path = guiConfig.get("bannerPath").getAsString();
		panelDatos = new PanelDatos();

		setLayout(new BorderLayout());
		add(new JLabel(new ImageIcon(path)), BorderLayout.NORTH);
		add(panelDatos, BorderLayout.CENTER);
	}

	/*
	 * **************************************************************** Métodos para
	 * la configuración de la interfaz
	 *****************************************************************/
	/**
	 * Lee datos de configuración para la aplicación, a partir de un archivo JSON o
	 * con valores por defecto si hay errores.
	 * 
	 * @param tipo       - El tipo de configuración deseada
	 * @param archConfig - Archivo Json que contiene la configuración
	 * @return Un objeto JSON con la configuración del tipo especificado NULL si hay
	 *         un error en el archivo.
	 */
	private JsonObject openConfig(String tipo, String archConfig) {
		JsonObject config = null;
		try {
			Gson gson = new Gson();
			FileReader file = new FileReader(archConfig);
			JsonReader reader = new JsonReader(file);
			config = gson.fromJson(reader, JsonObject.class);
			log.info("Se encontró un archivo de configuración válido: " + tipo);
		} catch (Exception e) {
//			e.printStackTrace ();
			log.info("NO se encontró un archivo de configuración válido");
			JOptionPane.showMessageDialog(null,
					"No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App",
					JOptionPane.ERROR_MESSAGE);
		}
		return config;
	}

	/**
	 * Método para configurar el frame principal de la aplicación
	 */
	private void configurarFrame() {
		int alto = 0;
		int ancho = 0;
		String titulo = "";

		if (guiConfig == null) {
			log.info("Se aplica configuración por defecto");
			titulo = "Parranderos APP Default";
			alto = 300;
			ancho = 500;
		} else {
			log.info("Se aplica configuración indicada en el archivo de configuración");
			titulo = guiConfig.get("title").getAsString();
			alto = guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(50, 50);
		setResizable(true);
		setBackground(Color.WHITE);

		setTitle(titulo);
		setSize(ancho, alto);
	}

	/**
	 * Método para crear el menú de la aplicación con base em el objeto JSON leído
	 * Genera una barra de menú y los menús con sus respectivas opciones
	 * 
	 * @param jsonMenu - Arreglo Json con los menùs deseados
	 */
	private void crearMenu(JsonArray jsonMenu) {
		// Creación de la barra de menús
		menuBar = new JMenuBar();
		for (JsonElement men : jsonMenu) {
			// Creación de cada uno de los menús
			JsonObject jom = men.getAsJsonObject();

			String menuTitle = jom.get("menuTitle").getAsString();
			JsonArray opciones = jom.getAsJsonArray("options");

			JMenu menu = new JMenu(menuTitle);

			for (JsonElement op : opciones) {
				// Creación de cada una de las opciones del menú
				JsonObject jo = op.getAsJsonObject();
				String lb = jo.get("label").getAsString();
				String event = jo.get("event").getAsString();

				JMenuItem mItem = new JMenuItem(lb);
				mItem.addActionListener(this);
				mItem.setActionCommand(event);

				menu.add(mItem);
			}
			menuBar.add(menu);
		}
		setJMenuBar(menuBar);
	}
	
	//--------------------------Comienzo de los métodos necesarios para RF1--
	
	public void registrarRolesUsuario()
	{
		try {
			// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código
			boolean errorRoles = false;
			List<Rol> roles= EPSAndes.registrarRolesUsuario();
			if (roles == null) {
				roles = EPSAndes.registrarRolesUsuario();
				errorRoles = true;
			}
			List<VORol> lista = EPSAndes.darVORoles();
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Registro de roles";
			resultado += "\n\n************ registrando roles ************ \n";
			if (errorRoles) {
				resultado += "*** Exception registrando los roles !!\n";
				resultado += "*** Es probable que un rol ya existiera y hay restricción de UNICIDAD sobre el nombre del rol\n";
				resultado += "*** Revise el log de parranderos para más detalles\n";
			}
			resultado += "Adicionado los roles \n";
			resultado += "\n\n************ Inserciones Ejecutadas ************ \n";
			resultado += "\n" + listarRoles(lista);
			
			panelDatos.actualizarInterfaz(resultado);
		} catch (Exception e) {
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	
// inicio --------------------------------------------------------------------------------------	
	/**
	 * Demostración de creación, consulta y borrado de Tipos de Bebida Muestra la
	 * traza de la ejecución en el panelDatos
	 * 
	 * Pre: La base de datos está vacía Post: La base de datos está vacía
	 */
	public void registrarUsuarioDemo() 
	{
		try
		{
			String nombreTipo = JOptionPane.showInputDialog(this, "Nombre del Usuario",	"Adicionar Usuario", JOptionPane.QUESTION_MESSAGE);
			VOUsuario u =EPSAndes.adicionarUsuario(nombreTipo);
			if(nombreTipo != null )
			{
				if(u == null)
				{
					throw new Exception("no sepuedo insertar el usuario con nombre: " + nombreTipo);
				}
				String resultado = "en adicionarUsuario\n\n";
				resultado += "usuario adicionado exitosamente";
				resultado += "\n operacion terminada";
				panelDatos.actualizarInterfaz(resultado);
			}	
		
			else 
			{
				panelDatos.actualizarInterfaz("Operacion cancelada por el usuario");
			}

		
	}catch (Exception e)
	{
		String resultado = generarMensajeError(e);
		panelDatos.actualizarInterfaz(resultado);
	}

	}
	
	
	//final ----------------------------------------------------------------------------------
		//--------------------------final de los métodos necesarios para los RF1--
	/**
	 * Demostración de creación, consulta y borrado de Tipos de Bebida Muestra la
	 * traza de la ejecución en el panelDatos
	 * 
	 * Pre: La base de datos está vacía Post: La base de datos está vacía
	 */
	public void registrarIPS() {
		try {
			// Ejecución de la demo y recolección de los resultados
			// ATENCIÓN: En una aplicación real, los datos JAMÁS están en el código
			String nombreIPS = "nombregenericoIPS";
			boolean errorRol = false;
			VORol rol= EPSAndes.adicionarRol(nombreIPS);
			if (rol == null) {
				rol = EPSAndes.darRolPorNombre(nombreIPS);
				errorRol = true;
			}
			List<VORol> lista = EPSAndes.darVORoles();
			long tbEliminados = EPSAndes.eliminarRolPorId(rol.getId());

			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "Demo de creación y listado de Rol\n\n";
			resultado += "\n\n************ Generando datos de prueba ************ \n";
			if (errorRol) {
				resultado += "*** Exception creando rol !!\n";
				resultado += "*** Es probable que ese rol ya existiera y hay restricción de UNICIDAD sobre el nombre del rol\n";
				resultado += "*** Revise el log de parranderos para más detalles\n";
			}
			resultado += "Adicionado la IPS con nombre: " + nombreIPS + "\n";
			resultado += "\n\n************ Limpiando la base de datos ************ \n";
			resultado += tbEliminados + " Roles eliminados\n";
			resultado += "\n Demo terminada";

			panelDatos.actualizarInterfaz(resultado);
		} catch (Exception e) {
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
		
		//--------------------------final de los métodos necesarios para los RF1--	
	/*
	 * **************************************************************** Demos de
	 * TipoBebida
	 *****************************************************************/
	

	/**
	 * Genera una cadena de caracteres con la descripción de la excepcion e,
	 * haciendo énfasis en las excepcionsde JDO
	 * 
	 * @param e - La excepción recibida
	 * @return La descripción de la excepción, cuando es
	 *         javax.jdo.JDODataStoreException, "" de lo contrario
	 */
	private String darDetalleException(Exception e) {
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException")) {
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions()[0].getMessage();
		}
		return resp;
	}

	/**
	 * Genera una cadena para indicar al usuario que hubo un error en la aplicación
	 * 
	 * @param e - La excepción generada
	 * @return La cadena con la información de la excepción y detalles adicionales
	 */
	private String generarMensajeError(Exception e) {
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
		return resultado;
	}

	/**
	 * Limpia el contenido de un archivo dado su nombre
	 * 
	 * @param nombreArchivo - El nombre del archivo que se quiere borrar
	 * @return true si se pudo limpiar
	 */
	private boolean limpiarArchivo(String nombreArchivo) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(new File(nombreArchivo)));
			bw.write("");
			bw.close();
			return true;
		} catch (IOException e) {
//			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Abre el archivo dado como parámetro con la aplicación por defecto del sistema
	 * 
	 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
	 */
	private void mostrarArchivo(String nombreArchivo) {
		try {
			Desktop.getDesktop().open(new File(nombreArchivo));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * **************************************************************** Métodos de
	 * la Interacción
	 *****************************************************************/
	/**
	 * Método para la ejecución de los eventos que enlazan el menú con los métodos
	 * de negocio Invoca al método correspondiente según el evento recibido
	 * 
	 * @param pEvento - El evento del usuario
	 */
	@Override
	public void actionPerformed(ActionEvent pEvento) {
		String evento = pEvento.getActionCommand();
		try {
			Method req = InterfazEPSAndesDemo.class.getMethod(evento);
			req.invoke(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * **************************************************************** Programa
	 * principal
	 *****************************************************************/
	/**
	 * Este método ejecuta la aplicación, creando una nueva interfaz
	 * 
	 * @param args Arreglo de argumentos que se recibe por línea de comandos
	 */
	public static void main(String[] args) {
		try {

			// Unifica la interfaz para Mac y para Windows.
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			InterfazEPSAndesDemo interfaz = new InterfazEPSAndesDemo();
			interfaz.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
