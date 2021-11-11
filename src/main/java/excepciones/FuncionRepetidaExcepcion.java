package excepciones;

import javax.xml.ws.WebFault;

@WebFault
public class FuncionRepetidaExcepcion extends Exception{
	private static final long serialVersionUID = 1L;

	private String errorDetails;
	
	public FuncionRepetidaExcepcion(String string, String errorDetails) {
		super(string);
		this.errorDetails = errorDetails;
	}
	
	public String getFaultInfo() {
		return errorDetails;
	}
}
