package logica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario{
    @Id
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Date fNacimiento;

    public Usuario(String nickname, String nombre, String apellido, String email, Date fNacimiento){
	 super();
	 this.nickname = nickname;
	 this.nombre = nombre;
	 this.apellido = apellido;
	 this.email = email;
	 this.fNacimiento = fNacimiento;
    }

    public Usuario(){
	 // super();
    }

    public String getNickname(){
	 return nickname;
    }

    public String getNombre(){
	 return nombre;
    }

    public String getApellido(){
	 return apellido;
    }

    public String getEmail(){
	 return email;
    }

    public Date getfNacimiento(){
	 return fNacimiento;
    }

    public void setNickname(String nickname){
	 this.nickname = nickname;
    }

    public void setNombre(String nombre){
	 this.nombre = nombre;
    }

    public void setApellido(String apellido){
	 this.apellido = apellido;
    }

    public void setEmail(String email){
	 this.email = email;
    }

    public void setfNacimiento(Date fNacimiento){
	 this.fNacimiento = fNacimiento;
    }
}