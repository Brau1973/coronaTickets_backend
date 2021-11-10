package publicadores;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtPaqueteEspectaculo;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import logica.Espectaculo;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorEspectaculoPublish {
	private Fabrica fabrica;
	private IControladorEspectaculo iconE;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorEspectaculoPublish() {
		fabrica = Fabrica.getInstancia();
		iconE = fabrica.getIControladorEspectaculo();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			System.out.println("Exception config Espectaculo");
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorEspectaculo", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorEspectaculo");
	}

	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return endpoint;
	}

	// LOS MÉTODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public void altaEspectaculo(DtEspectaculo dte, String nombrePlataforma){//throws EspectaculoRepetidoExcepcion {
		iconE.altaEspectaculo(dte, nombrePlataforma);
	}

	@WebMethod
	public Espectaculo obtenerEspectaculo(String nombre) {
		return iconE.obtenerEspectaculo(nombre);
	}

	@WebMethod
	public DtEspectaculo[] listarEspectaculos(String nombrePlataforma) { //vere
		List<DtEspectaculo> lst=iconE.listarEspectaculos(nombrePlataforma);
		DtEspectaculo[] arr=new DtEspectaculo[lst.size()];
		arr=lst.toArray(arr);
		return arr;
	}
	
	@WebMethod
	public DtEspectaculo[] obtenerAllDtEspectaculos(String nickname) { //ver
		List<DtEspectaculo> lst=iconE.obtenerAllDtEspectaculos(nickname);
		DtEspectaculo[] arr=new DtEspectaculo[lst.size()];
		arr=lst.toArray(arr);
		return arr;
	}

	@WebMethod (exclude = true) //ver
	public DtEspectaculo[] listEntityToDtEsp(List<Espectaculo> liste) {
		List<DtEspectaculo> lst=iconE.listEntityToDtEsp(liste);
		DtEspectaculo[] arr=new DtEspectaculo[lst.size()];
		arr=lst.toArray(arr);
		return arr;
	}

	@WebMethod
	public Espectaculo[] obtenerEspectaculo2(String plataforma) {
		List<Espectaculo> lst=iconE.obtenerEspectaculo2(plataforma);
		Espectaculo[] arr=new Espectaculo[lst.size()];
		arr=lst.toArray(arr);
		return arr;
	}

	@WebMethod
	public String[] obtenerEspectaculosArtista(String nickname) { // veer
		List<String> lst=iconE.obtenerEspectaculosArtista(nickname);
		String[] arr=new String[lst.size()];
		arr=lst.toArray(arr);
		return arr;
	}
	
	@WebMethod
	public DtFuncion[] obtenerEspectaculoFunciones(String nombreEsp){
		List<DtFuncion> lst=iconE.obtenerEspectaculoFunciones(nombreEsp);
		DtFuncion[] arr=new DtFuncion[lst.size()];
		arr=lst.toArray(arr);
		return arr;
	}
	
	@WebMethod
	public DtPaqueteEspectaculo[] obtenerEspectaculoPaquetes(String nombreEsp){
		List<DtPaqueteEspectaculo> lst=iconE.obtenerEspectaculoPaquetes(nombreEsp);
		DtPaqueteEspectaculo[] arr=new DtPaqueteEspectaculo[lst.size()];
		arr=lst.toArray(arr);
		return arr;
	}
	
	
}
