package interfaces;

import java.util.List;

import datatypes.DtEspectaculo;
import excepciones.EspectaculoRepetidoExcepcion;
import excepciones.FuncionYaRegistradaEnEspectaculoExcepcion;
import logica.Espectaculo;

public interface IControladorEspectaculo{
    public void altaEspectaculo(DtEspectaculo dte) throws EspectaculoRepetidoExcepcion;

    public List<Espectaculo> listarEspectaculos();

    public Espectaculo obtenerEspectaculo(String nombre);
    
    //public void agregarFuncion(String nombreEspectaculo,String nombreFuncion) throws FuncionYaRegistradaEnEspectaculoExcepcion;
    
    public List<Espectaculo> obtenerEspectaculo2(String plataforma);
    
    public List<DtEspectaculo> listarEspectaculos(String nombrePlataforma);
}