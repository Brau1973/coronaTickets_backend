package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ModificarDatosUsuario extends JInternalFrame{
    private JButton btnConsulta;
    private JPanel miPanel;
    private JTextField txtBuscar;
    private JLabel lblTitulo;
    private String[] header = {"Nickname", "Nombre", "Apellido"};
    private String[][] data = {{"sebagl", "Sebastian", "Gonzalez"}, {"aldrinkpo", "Aldrin", "Rebella"}, {"leito", "Leonardo", "Mesa"}, {"lucs12", "Lucas", "Sugo"}};
    private String retorno;

    // Constructor
    public ModificarDatosUsuario(){
	 miPanel = new JPanel();
	 miPanel.setLayout(null);
	 add(miPanel);
	 setBounds(20, 20, 460, 400);
	 setResizable(false);
	 setClosable(true);
	 setIconifiable(false);
	 setBorder(null);
	 ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
	 lblTitulo = new JLabel();
	 lblTitulo.setText("Modificar Usuario");
	 lblTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
	 lblTitulo.setBounds(10, 1, 280, 25);
	 miPanel.add(lblTitulo);

	 DefaultTableModel model = new DefaultTableModel(data, header);
	 JTable tabUsuario = new JTable(model);
	 tabUsuario.setPreferredScrollableViewportSize(new Dimension(40, 290));
	 JScrollPane jsPane = new JScrollPane(tabUsuario);
	 jsPane.setBorder(new EmptyBorder(0, 10, 0, 20));
	 jsPane.setVisible(true);
	 add(jsPane, BorderLayout.SOUTH);

	 txtBuscar = new JTextField();
	 txtBuscar.setBounds(10, 45, 270, 25);
	 miPanel.add(txtBuscar);

	 // Boton Buscar
	 btnConsulta = new JButton();
	 btnConsulta.setText("Seleccionar...");
	 btnConsulta.setBounds(295, 45, 115, 25);
	 btnConsulta.addActionListener(new ActionListener(){
	     public void actionPerformed(ActionEvent e){
		  retorno = "Nickname:  " + data[1][0].toString() + "\n";
		  retorno += "Nombre:  " + data[1][1].toString() + "\n";
		  retorno += "Apellido:  " + data[1][2].toString() + "\n";
		  JOptionPane.showMessageDialog(null, retorno, "Informacion", JOptionPane.PLAIN_MESSAGE);
	     }
	 });
	 miPanel.add(btnConsulta);
    }
}