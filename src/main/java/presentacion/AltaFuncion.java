package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;

import com.toedter.calendar.JDateChooser;

import interfaces.IControladorFuncion;
import manejadores.ManejadorFuncion;

@SuppressWarnings("serial")
public class AltaFuncion extends JInternalFrame implements ActionListener{
    private IControladorFuncion iconF;

    private JButton btnAceptar, btnCancelar, btnCopiar;
    private JPanel miPanel;
    private JLabel lblPlataforma, lblEspectaculos, lblNombre, lblFecha, lblHora, lblArtistasInv, lblFechaAlta, lblDots, lblTitulo;
    private JTextField txtNombre;
    private JSpinner spinHora, spinMin;
    private JDateChooser fechaFuncion, fechaAlta;
    private JComboBox<String> comboEspectaculos, comboPlataforma;
    private JList listaArtistas, listaArtistasCopia;
    private String nombresArtistas[] = {"1", "2", "3", "4", "1", "2", "3", "4", "1", "2", "3", "4"};

    // Constructor
    public AltaFuncion(IControladorFuncion iconF){
	 this.iconF = iconF;
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 add(miPanel);
	 setBounds(30, 30, 800, 600);
	 setResizable(false);
	 setClosable(false);
	 setIconifiable(false);
	 setBorder(null);
	 ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);

	 lblTitulo = new JLabel();
	 lblTitulo.setText("Alta de Funcion de Espectaculo");
	 lblTitulo.setBounds(10, 0, 300, 20);
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 17));
	 miPanel.add(lblTitulo);

	 lblPlataforma = new JLabel();
	 lblPlataforma.setText("Plataforma");
	 lblPlataforma.setBounds(10, 30, 200, 20);
	 miPanel.add(lblPlataforma);

	 comboPlataforma = new JComboBox<String>();
	 comboPlataforma.addItem("Seleccione Plataforma");
	 comboPlataforma.setBounds(220, 30, 200, 20);
	 miPanel.add(comboPlataforma);
	 comboPlataforma.addActionListener(this);

	 lblEspectaculos = new JLabel();
	 lblEspectaculos.setText("Espectaculos");
	 lblEspectaculos.setBounds(10, 60, 200, 20);
	 miPanel.add(lblEspectaculos);

	 comboEspectaculos = new JComboBox<String>();
	 comboEspectaculos.setBounds(220, 60, 200, 20);
	 miPanel.add(comboEspectaculos);

	 lblPlataforma = new JLabel();
	 lblPlataforma.setText("Datos De La Funcion");
	 lblPlataforma.setBounds(10, 90, 250, 20);
	 miPanel.add(lblPlataforma);

	 lblNombre = new JLabel();
	 lblNombre.setText("Nombre");
	 lblNombre.setBounds(10, 120, 200, 20);
	 miPanel.add(lblNombre);

	 txtNombre = new JTextField();
	 txtNombre.setBounds(220, 120, 200, 20);
	 miPanel.add(txtNombre);

	 lblFecha = new JLabel();
	 lblFecha.setText("Fecha de la Funcion");
	 lblFecha.setBounds(10, 150, 200, 20);
	 miPanel.add(lblFecha);

	 fechaFuncion = new JDateChooser();
	 fechaFuncion.setBounds(220, 150, 200, 20);
	 miPanel.add(fechaFuncion);

	 lblHora = new JLabel();
	 lblHora.setText("Hora de Inicio");
	 lblHora.setBounds(10, 180, 100, 20);
	 miPanel.add(lblHora);

	 lblArtistasInv = new JLabel();
	 lblArtistasInv.setText("Artistas invitados");
	 lblArtistasInv.setBounds(10, 210, 150, 20);
	 miPanel.add(lblArtistasInv);

	 listaArtistas = new JList<String>(nombresArtistas);
	 listaArtistas.setBounds(220, 210, 100, 100);
	 listaArtistas.setVisibleRowCount(5);
	 listaArtistas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	 miPanel.add(listaArtistas);

	 btnCopiar = new JButton(">>>");
	 btnCopiar.setBounds(330, 210, 70, 25);
	 btnCopiar.addActionListener(new ActionListener(){
	     public void actionPerformed(ActionEvent evento){
		  listaArtistasCopia.setListData(listaArtistas.getSelectedValues());
	     }
	 });

	 miPanel.add(btnCopiar);
	 Date date = new Date();
	 SpinnerDateModel m = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
	 spinMin = new javax.swing.JSpinner(m);
	 JSpinner.DateEditor de = new JSpinner.DateEditor(spinMin, "HH:mm");
	 spinMin.setEditor(de);
	 spinMin.setBounds(220, 180, 200, 20);
	 miPanel.add(spinMin);

	 listaArtistasCopia = new JList();
	 // listaArtistasCopia.setBounds(410, 210, 100, 100);
	 listaArtistasCopia.setVisibleRowCount(5);
	 // listaArtistasCopia.setFixedCellWidth( 100 );
	 // listaArtistasCopia.setFixedCellHeight( 25 );
	 listaArtistasCopia.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	 JScrollPane algo = new JScrollPane(listaArtistasCopia);
	 algo.setBounds(410, 210, 100, 100);
	 miPanel.add(algo);

	 lblFechaAlta = new JLabel();
	 lblFechaAlta.setText("Fecha de Alta");
	 lblFechaAlta.setBounds(10, 330, 200, 20);
	 miPanel.add(lblFechaAlta);

	 fechaAlta = new JDateChooser();
	 fechaAlta.setBounds(220, 330, 200, 20);
	 miPanel.add(fechaAlta);

	 // Boton Aceptar
	 btnAceptar = new JButton();
	 btnAceptar.setText("Aceptar");
	 btnAceptar.setBounds(200, 400, 115, 25);
	 miPanel.add(btnAceptar);
	 btnAceptar.addActionListener(this);

	 // Boton Cancelar
	 btnCancelar = new JButton();
	 btnCancelar.setText("Cancelar");
	 btnCancelar.setBounds(322, 400, 115, 25);
	 miPanel.add(btnCancelar);
	 btnCancelar.addActionListener(this);
    }

    // Inicializar ComboBox
    public void iniciarlizarComboBox(){
	 DefaultComboBoxModel<String> modelPlataformas = new DefaultComboBoxModel<String>(iconF.listarPlataformas());
	 comboPlataforma.setModel(modelPlataformas);

	 // ESPECTACULOS DE LA PLATAFORMA SELECCIONADA
	 // DefaultComboBoxModel<String> modelEspectaculos = new DefaultComboBoxModel<String>(iconF.listarEspectaculos());
	 // comboEspectaculos.setModel(modelEspectaculos);
    }

    private boolean checkFormulario(){
	 if(!txtNombre.getText().isEmpty() && fechaFuncion.getDate() != null && fechaAlta.getDate() != null){
	 }else{
	     JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
	     return false;
	 }
	 return true;
    }

    private void limpiarFormulario(){
	 this.txtNombre.setText("");
	 this.fechaFuncion.setDate(null);
	 this.spinHora.setValue(0);
	 this.spinMin.setValue(0);
	 // //Artistas invitados
	 this.fechaAlta.setDate(null);
    }

    @Override
    public void actionPerformed(ActionEvent e){
	 if(e.getSource() == comboPlataforma){
	     int hora = Integer.parseInt(this.spinHora.getValue().toString());
	     int minutos = Integer.parseInt(this.spinHora.getValue().toString());
	     Time horaInicio = new Time(hora, minutos, 0);
	     // System.out.println("horaInicio: " + horaInicio.toString());
	     String plataforma = this.comboPlataforma.getSelectedItem().toString();
	     ManejadorFuncion mF = ManejadorFuncion.getInstancia();
	     ArrayList<String> datos = mF.obtenerEspectaculo(plataforma);
	     if(datos.isEmpty()){
		  comboPlataforma.getModel().setSelectedItem("Seleccione Plataforma");
		  comboEspectaculos.getModel().setSelectedItem("Seleccione Espectaculo");
		  JOptionPane.showMessageDialog(this, "Esta plataforma no tiene espectaculos asociados.", "Agregar Espectaculo", JOptionPane.WARNING_MESSAGE);
	     }else
		  comboEspectaculos.getModel().setSelectedItem(mF.obtenerEspectaculo(plataforma));
	 }

	 // BOTON ACEPTAR
	 if(e.getSource() == btnAceptar){
	     if(checkFormulario()){
		  String espectaculo = (String) this.comboEspectaculos.getSelectedItem();
		  String nombreEspectaculo = this.txtNombre.getText();
		  Date fechaFuncion = this.fechaFuncion.getDate();
		  int hora = Integer.parseInt(this.spinHora.getValue().toString());
		  Time horaInicio = new Time(hora, 0, 0);
		  // //Artistas invitados
		  Date fechaAlta = this.fechaAlta.getDate();
		  /*	  try{
		      // this.iconF.altaFuncion(nombreEspectaculo, espectaculo, fechaFuncion, null, null, fechaAlta);
		      JOptionPane.showMessageDialog(this, "la plataforma se ha creado con Exito");
		  }catch(FuncionRepetidaExcepcion msg){
		      JOptionPane.showMessageDialog(this, msg.getMessage(), "Alta Plataforma", JOptionPane.ERROR_MESSAGE);
		  }*/
		  limpiarFormulario();
		  setVisible(false);
	     }
	 }

	 if(e.getSource() == btnCancelar){
	     limpiarFormulario();
	     setVisible(false);
	 }
    }
}

