package datatypes;

import java.util.Date;

public class DtEspectador extends DtUsuario{

	public DtEspectador(String nickname, String nombre, String apellido, String email, Date fNacimiento) {
		super(nickname, nombre, apellido, email, fNacimiento);
	}
}