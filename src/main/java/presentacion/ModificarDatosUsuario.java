package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
import interfaces.IControladorUsuario;

@SuppressWarnings("serial")
public class ModificarDatosUsuario extends JInternalFrame implements ActionListener{
	private IControladorUsuario iconU;
	private JPanel miPanel;
	private JTextField txtNickname, txtNombre, txtApellido, txtEmail;
	JPasswordField txtContrasenia;
	private JDateChooser dateFechaNac;
	private JComboBox<String> comboUsuarios;
	private JButton btnGuardar, btnCancelar, btnMostrar;
	private List<String> listUsuarios;
	private String imagenUsu;

	// Constructor
	public ModificarDatosUsuario(IControladorUsuario iconU){
		this.iconU = iconU;
		miPanel = new JPanel();
		miPanel.setLayout(null);
		add(miPanel);
		setBounds(15, 15, 800, 600);
		setResizable(false);
		setClosable(true);
		setIconifiable(false);
		setBorder(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

		// JLabel
		JLabel lblTitulo = new JLabel("Modificar Datos de Usuario");
		lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 19));
		lblTitulo.setBounds(10, 1, 270, 25);
		miPanel.add(lblTitulo);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new java.awt.Font("Verdana", 1, 12));
		lblUsuario.setBounds(10, 50, 150, 25);
		miPanel.add(lblUsuario);

		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setFont(new java.awt.Font("Verdana", 1, 12));
		lblNickname.setBounds(10, 80, 80, 25);
		miPanel.add(lblNickname);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new java.awt.Font("Verdana", 1, 12));
		lblNombre.setBounds(10, 110, 80, 25);
		miPanel.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new java.awt.Font("Verdana", 1, 12));
		lblApellido.setBounds(10, 140, 80, 25);
		miPanel.add(lblApellido);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new java.awt.Font("Verdana", 1, 12));
		lblEmail.setBounds(10, 170, 80, 25);
		miPanel.add(lblEmail);

		JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setFont(new java.awt.Font("Verdana", 1, 12));
		lblContrasenia.setBounds(10, 230, 150, 25);
		miPanel.add(lblContrasenia);

		JLabel lblfNacimiento = new JLabel("Fecha nacimiento:");
		lblfNacimiento.setFont(new java.awt.Font("Verdana", 1, 12));
		lblfNacimiento.setBounds(10, 200, 140, 25);
		miPanel.add(lblfNacimiento);

		// JComboBox
		comboUsuarios = new JComboBox<String>();
		comboUsuarios.setBounds(140, 48, 237, 25);
		miPanel.add(comboUsuarios);
		comboUsuarios.addActionListener(this);

		// JTextField
		txtNickname = new JTextField();
		txtNickname.setBounds(140, 78, 237, 25);
		txtNickname.setEditable(false);
		miPanel.add(txtNickname);

		txtNombre = new JTextField();
		txtNombre.setBounds(140, 108, 237, 25);
		miPanel.add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setBounds(140, 138, 237, 25);
		miPanel.add(txtApellido);

		txtEmail = new JTextField();
		txtEmail.setBounds(140, 168, 237, 25);
		txtEmail.setEditable(false);
		miPanel.add(txtEmail);

		dateFechaNac = new JDateChooser();
		dateFechaNac.setBounds(140, 198, 237, 25);
		miPanel.add(dateFechaNac);

		// txtContrasenia = new JTextField();
		// txtContrasenia.setBounds(140, 228, 237, 25);
		// miPanel.add(txtContrasenia);

		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(140, 228, 150, 25);
		txtContrasenia.setEchoChar('*');
		miPanel.add(txtContrasenia);

		btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(290, 228, 88, 24);
		miPanel.add(btnMostrar);
		btnMostrar.addActionListener(this);

		// Boton Guardar
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(140, 264, 116, 25);
		miPanel.add(btnGuardar);
		btnGuardar.addActionListener(this);

		// Boton Cancelar
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(263, 264, 116, 25);
		miPanel.add(btnCancelar);
		btnCancelar.addActionListener(this);
	}

	// Inicializar ComboBox
	public void iniciarlizarComboBox(){
		comboUsuarios.removeAllItems();
		listUsuarios = iconU.listarNicknameUsuarios();
		listUsuarios.forEach((a) -> {
			comboUsuarios.addItem(a);
		});
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e){

		if(e.getSource() == btnGuardar){
			String strnick = this.txtNickname.getText();
			String strnombre = this.txtNombre.getText();
			String strapellido = this.txtApellido.getText();
			String stremail = this.txtEmail.getText();
			Date dateRegistro = this.dateFechaNac.getDate();
			String strcontrasenia = this.txtContrasenia.getText();
			DtUsuario usuario = iconU.obtenerInfoUsuario(strnick);
			if(usuario instanceof DtArtista){				
				DtUsuario nuevo = new DtArtista(strnick, strnombre, strapellido, stremail, dateRegistro, null, null, strcontrasenia,
						imagenUsu,((DtArtista) usuario).getDescripcion(), ((DtArtista) usuario).getBiografia(), ((DtArtista) usuario).getLink());
				this.iconU.modificarUsuario(nuevo);
			}
			if(usuario instanceof DtEspectador){
				DtUsuario nuevo = new DtEspectador(strnick, strnombre, strapellido, stremail, dateRegistro, null, null, strcontrasenia,imagenUsu);
				this.iconU.modificarUsuario(nuevo);
			}
			JOptionPane.showMessageDialog(null, "Datos modificados correctamente");
			setVisible(false);
		}

		if(e.getSource() == btnCancelar){
			setVisible(false);
		}

		if(e.getSource() == btnMostrar){
			if(txtContrasenia.getEchoChar() == '*'){
				btnMostrar.setText("Ocultar");
				txtContrasenia.setEchoChar((char) 0);
			}else{
				btnMostrar.setText("Mostrar");
				txtContrasenia.setEchoChar('*');
			}
		}

		if(e.getSource() == comboUsuarios){
			if(this.comboUsuarios.getSelectedItem()!=null) {
				String strUsuario = this.comboUsuarios.getSelectedItem().toString();
				DtUsuario u = iconU.obtenerInfoUsuario(strUsuario);
				txtNickname.setText(u.getNickname());
				txtNombre.setText(u.getNombre());
				txtApellido.setText(u.getApellido());
				txtEmail.setText(u.getEmail());
				dateFechaNac.setDate(u.getfNacimiento());
				txtContrasenia.setText(u.getContrasenia());	
				imagenUsu = u.getImageName();
			}
		}
	}

}