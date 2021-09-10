package controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import datatypes.DtFuncion;
import excepciones.FuncionRepetidaExcepcion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
import interfaces.Fabrica;
import interfaces.IControladorEspectaculo;
import interfaces.IControladorFuncion;
import logica.Espectaculo;
import interfaces.IControladorUsuario;
import logica.Artista;
import logica.Espectaculo;
import logica.Funcion;
import logica.Plataforma;
import manejadores.ManejadorEspectaculo;
import manejadores.ManejadorFuncion;
import manejadores.ManejadorPlataforma;
import persistencia.Conexion;
import manejadores.ManejadorPlataforma;

public class ControladorFuncion implements IControladorFuncion {

	public ControladorFuncion() {
		super();
	}

	public void altaFuncion(DtFuncion dtFuncion, String nombreEspectaculo) throws FuncionYaRegistradaEnEspectaculoExcepcion {
		IControladorEspectaculo iconE = Fabrica.getInstancia().getIControladorEspectaculo();
		Espectaculo espectaculo = iconE.obtenerEspectaculo(nombreEspectaculo);

		if (espectaculo.funcionYaRegistrada(dtFuncion.getNombre())) {
			throw new FuncionYaRegistradaEnEspectaculoExcepcion("La Funcion" + dtFuncion.getNombre()
					+ " ya esta registrada en el espectaculo " + espectaculo.getNombre());
		} else {
			ManejadorFuncion mF = ManejadorFuncion.getInstancia();
			IControladorUsuario iconU = Fabrica.getInstancia().getIControladorUsuario();
			List<Artista> artistas = new ArrayList<Artista>();
			dtFuncion.getArtistas().forEach((a) -> {
				artistas.add(iconU.obtenerArtista(a));
			});
			Funcion funcionACrear = new Funcion(dtFuncion.getNombre(), dtFuncion.getFecha(), dtFuncion.getHoraInicio(),
					dtFuncion.getRegistro(), artistas);
			espectaculo.agregarFuncion(funcionACrear);
			mF.agregarFuncion(funcionACrear);
		}
	}

	// converitr funcion a DtFuncion
	/*
	 * public Funcion obtenerFuncion(String nombre){ ManejadorFuncion mF =
	 * ManejadorFuncion.getInstancia(); Funcion funcion = mF.buscarFuncion(nombre);
	 * DtFuncion funciones = funcion.; return funciones; return null; }
	 */

	public Funcion obtenerFuncion(String nombre) {
		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
		return mF.buscarFuncion(nombre);
	}

	public List<Funcion> obtenerFuncionBD(String espectaculo) {
		ManejadorFuncion mF = ManejadorFuncion.getInstancia();
		return mF.obtenerFuncionesBD(espectaculo);
	}

	public List<DtFuncion> listarFunciones(String nomEsp) {
		ManejadorEspectaculo mE = ManejadorEspectaculo.getInstancia();
		Espectaculo espectaculo = mE.buscarEspectaculo(nomEsp);
		return espectaculo.getFuncionesDt();
	}

}
