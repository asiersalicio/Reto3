package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import com.toedter.calendar.JDateChooser;

import Core.Main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Clase PaneSelTrayecto : En este panel los clientes pueden seleccionar el viaje deseado y la fecha.
 * @author IN1DM3B_18
 *
 */

public class PaneSelTrayecto {
	
	public JPanel pane;
	public JTextField FieldLinea;
	public JTextField FieldOrigen;
	public JTextField FieldBusqueda;
	public JComboBox comboBoxBusqueda;
	public JButton btnSelLinea;
	public JButton btnSelOrigen;
	public JTextField FieldDestino;
	public JButton btnSelDestino;
	public JDateChooser dateChooserIda;
	public JDateChooser dateChooserVuelta;
	public JCheckBox chckbxVuelta;
	public JButton btnBuscar;
	public JButton btnCerrarBusqueda;
	public JLabel lblNoHayBuses;
	public JLabel lblLinea;
	public JLabel lblOrigen;
	public JLabel lblDestino;
	public Label lblFechaIda;
	public Label lblFechaVuelta;
	public JLabel lbllogoPeke ;
	public JLabel lbllogoGrande;
	public JLabel lblCamposSinCompletar;
	private JLabel imgTrayecto;
	public JButton btnPlanoLineas;
	public JButton btnCerrarSesion;
	public JLabel lblSaludo;
	public JButton btnMiCuenta;
	public JLabel imgL1;
	public JLabel imgL2;
	public JLabel imgL3;
	public JLabel imgL4;
	
	public PaneSelTrayecto(Frame1 frame1)
	{
		pane = new JPanel();
		pane.setBackground(Color.WHITE);
		pane.setBounds(0, 0, 800, 600);
		pane.setLayout(null);
		
		frame1.frame1.getContentPane().add(pane);
		
		comboBoxBusqueda = new JComboBox();
		comboBoxBusqueda.setVisible(false);
		
		btnCerrarBusqueda = new JButton("X");
		btnCerrarBusqueda.setForeground(new Color(0, 51, 102));
		btnCerrarBusqueda.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		btnCerrarBusqueda.setVisible(false);
		btnCerrarBusqueda.setBackground(Color.WHITE);
		btnCerrarBusqueda.setBounds(724, 0, 76, 64);
		pane.add(btnCerrarBusqueda);
		
		comboBoxBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 30));
		comboBoxBusqueda.setBounds(0, 63, 800, 4);
		
		
		pane.add(comboBoxBusqueda);
		
		lblLinea = new JLabel("Linea :");
		lblLinea.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLinea.setForeground(new Color(0, 51, 102));
		lblLinea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblLinea.setBounds(92, 250, 126, 25);
		pane.add(lblLinea);
		
		lblOrigen = new JLabel("Origen :");
		lblOrigen.setHorizontalAlignment(SwingConstants.TRAILING);
		lblOrigen.setForeground(new Color(0, 51, 102));
		lblOrigen.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblOrigen.setBounds(92, 288, 126, 25);
		pane.add(lblOrigen);
		
		lblDestino = new JLabel("Destino :");
		lblDestino.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDestino.setForeground(new Color(0, 51, 102));
		lblDestino.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblDestino.setBounds(92, 330, 126, 25);
		pane.add(lblDestino);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(0, 51, 102));
		btnBuscar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		btnBuscar.setBackground(Color.WHITE);
		
		
		btnBuscar.setBounds(568, 505, 186, 44);
		pane.add(btnBuscar);
		
		dateChooserIda = new JDateChooser();
		dateChooserIda.setForeground(new Color(0, 51, 102));
		dateChooserIda.setBackground(Color.WHITE);
		dateChooserIda.setBounds(314, 367, 153, 29);
		dateChooserIda.getJCalendar().setMinSelectableDate(new Date());
		pane.add(dateChooserIda);
		Calendar LimitadorFecha = Calendar.getInstance(); LimitadorFecha.add(Calendar.WEEK_OF_YEAR, 2); LimitadorFecha.add(Calendar.DATE, -1); Date date = LimitadorFecha.getTime();
		dateChooserIda.getJCalendar().setMaxSelectableDate(date);
		
		
		lblFechaIda = new Label("Fecha de Ida :");
		lblFechaIda.setForeground(new Color(0, 51, 102));
		lblFechaIda.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		lblFechaIda.setBounds(193, 372, 115, 24);
		pane.add(lblFechaIda);
		
		dateChooserVuelta = new JDateChooser();
		dateChooserVuelta.setForeground(new Color(0, 51, 102));
		dateChooserVuelta.setBackground(Color.WHITE);
		dateChooserVuelta.setEnabled(false);
		dateChooserVuelta.setBounds(314, 406, 153, 29);
		dateChooserVuelta.getJCalendar().setMinSelectableDate(new Date());
		dateChooserIda.getJCalendar().setMaxSelectableDate(date);

		pane.add(dateChooserVuelta);
		
		lblFechaVuelta = new Label("Fecha de vuelta :");
		lblFechaVuelta.setForeground(new Color(0, 51, 102));
		lblFechaVuelta.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		lblFechaVuelta.setBackground(Color.WHITE);
		lblFechaVuelta.setBounds(170, 411, 148, 24);
		pane.add(lblFechaVuelta);
		
		FieldLinea = new JTextField();
		FieldLinea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		FieldLinea.setBackground(Color.WHITE);
		FieldLinea.setEditable(false);

		FieldLinea.setBounds(228, 250, 238, 30);
		pane.add(FieldLinea);
		FieldLinea.setColumns(10);
		
		FieldOrigen = new JTextField();
		FieldOrigen.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		FieldOrigen.setBackground(Color.WHITE);
		FieldOrigen.setEditable(false);
		FieldOrigen.setBounds(228, 288, 238, 31);
		pane.add(FieldOrigen);
		FieldOrigen.setColumns(10);
		
		FieldBusqueda = new JTextField();
		FieldBusqueda.setForeground(new Color(0, 51, 102));
		FieldBusqueda.setVisible(false);
		FieldBusqueda.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		FieldBusqueda.setToolTipText("");
		FieldBusqueda.setBounds(0, 0, 728, 64);
		pane.add(FieldBusqueda);
		FieldBusqueda.setColumns(10);
		
		lblSaludo = new JLabel("Hola, Test:");
		lblSaludo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblSaludo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaludo.setBounds(12, 8, 193, 25);
		pane.add(lblSaludo);
		
		btnSelLinea = new JButton("Seleccionar");
		btnSelLinea.setForeground(new Color(0, 51, 102));
		btnSelLinea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		btnSelLinea.setBackground(Color.WHITE);
		btnSelLinea.setBounds(469, 250, 159, 30);
		pane.add(btnSelLinea);
		
		btnSelOrigen = new JButton("Seleccionar");
		btnSelOrigen.setForeground(new Color(0, 51, 102));
		btnSelOrigen.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		btnSelOrigen.setBackground(Color.WHITE);
		btnSelOrigen.setEnabled(false);
		btnSelOrigen.setBounds(469, 288, 159, 31);
		pane.add(btnSelOrigen);
		
		FieldDestino = new JTextField();
		FieldDestino.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		FieldDestino.setBackground(Color.WHITE);
		FieldDestino.setEditable(false);
		FieldDestino.setColumns(10);
		FieldDestino.setBounds(228, 330, 238, 30);
		pane.add(FieldDestino);
		
		btnSelDestino = new JButton("Seleccionar");
		btnSelDestino.setForeground(new Color(0, 51, 102));
		btnSelDestino.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		btnSelDestino.setBackground(Color.WHITE);
		btnSelDestino.setEnabled(false);
		btnSelDestino.setBounds(469, 330, 159, 30);
		pane.add(btnSelDestino);
		
		chckbxVuelta = new JCheckBox("Viaje de vuelta");
		chckbxVuelta.setBackground(Color.WHITE);
		chckbxVuelta.setForeground(new Color(204, 0, 0));
		chckbxVuelta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		chckbxVuelta.setBounds(480, 385, 159, 25);
		pane.add(chckbxVuelta);
		
		lbllogoPeke = new JLabel("");
		lbllogoPeke.setIcon(new ImageIcon(PaneSelTrayecto.class.getResource("/ImagenesVista/logo-termibus.png")));
		lbllogoPeke.setBounds(489, 8, 301, 117);
		pane.add(lbllogoPeke);
		
		lbllogoGrande = new JLabel("");
		lbllogoGrande.setIcon(new ImageIcon(PaneSelTrayecto.class.getResource("/ImagenesVista/termiLOGOpeke.png")));
		lbllogoGrande.setBounds(10, 505, 70, 64);
		pane.add(lbllogoGrande);
		
		lblNoHayBuses = new JLabel("*No hay buses disponbibles para esa fecha");
		lblNoHayBuses.setVisible(false);
		lblNoHayBuses.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNoHayBuses.setForeground(Color.RED);
		lblNoHayBuses.setBounds(151, 446, 325, 25);
		pane.add(lblNoHayBuses);
		
		lblCamposSinCompletar = new JLabel("*Hay campos sin completar");
		lblCamposSinCompletar.setVisible(false);
		lblCamposSinCompletar.setForeground(Color.RED);
		lblCamposSinCompletar.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCamposSinCompletar.setBounds(151, 473, 329, 25);
		pane.add(lblCamposSinCompletar);
		
		imgTrayecto = new JLabel("");
		imgTrayecto.setIcon(new ImageIcon(PaneSelTrayecto.class.getResource("/ImagenesVista/Trayecto.png")));
		imgTrayecto.setBounds(10, 63, 467, 93);
		pane.add(imgTrayecto);
		
		btnPlanoLineas = new JButton("");
		
		btnPlanoLineas.setFont(new Font("Dialog", Font.BOLD, 13));
		btnPlanoLineas.setBackground(Color.WHITE);
		btnPlanoLineas.setBounds(478, 476, 76, 73);
		btnPlanoLineas.setIcon(new ImageIcon(PaneLogin.class.getResource("/ImagenesVista/mapalogo.png")));
		pane.add(btnPlanoLineas);
		
		JLabel lblVerPlanoDe = new JLabel("Ver plano de lineas:");
		lblVerPlanoDe.setForeground(new Color(0, 51, 102));
		lblVerPlanoDe.setBackground(Color.WHITE);
		lblVerPlanoDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVerPlanoDe.setFont(new Font("Dialog", Font.BOLD, 16));
		lblVerPlanoDe.setBounds(231, 514, 234, 25);
		pane.add(lblVerPlanoDe);
		
		btnCerrarSesion = new JButton("Cerrar sesion");
		btnCerrarSesion.setForeground(new Color(0, 51, 102));
		btnCerrarSesion.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnCerrarSesion.setBackground(Color.WHITE);
		btnCerrarSesion.setBounds(82, 505, 186, 44);
		pane.add(btnCerrarSesion);
		
		btnMiCuenta = new JButton("Mi cuenta");
		btnMiCuenta.setBackground(Color.WHITE);
		btnMiCuenta.setBounds(209, 10, 153, 25);
		pane.add(btnMiCuenta);
		
		imgL1 = new JLabel("L1");
		imgL1.setBounds(129, 121, 522, 127);
		imgL1.setIcon(new ImageIcon(PaneSelTrayecto.class.getResource("/ImagenesVista/L1Plano.png")));
		imgL1.setVisible(false);
		pane.add(imgL1);
		
		imgL2 = new JLabel("L2");
		imgL2.setBounds(129, 121, 522, 127);
		imgL2.setIcon(new ImageIcon(PaneSelTrayecto.class.getResource("/ImagenesVista/L2Plano.png")));
		imgL2.setVisible(false);
		pane.add(imgL2);
		
		imgL3 = new JLabel("L3");
		imgL3.setBounds(129, 121, 522, 127);
		imgL3.setIcon(new ImageIcon(PaneSelTrayecto.class.getResource("/ImagenesVista/L3Plano.png")));
		imgL3.setVisible(false);
		pane.add(imgL3);
		
		imgL4 = new JLabel("L4");
		imgL4.setBounds(129, 121, 522, 127);
		imgL4.setIcon(new ImageIcon(PaneSelTrayecto.class.getResource("/ImagenesVista/L4Plano.png")));
		imgL4.setVisible(false);
		pane.add(imgL4);
		
		pane.setVisible(false);
	}
	
	public void reset()
	{
		FieldOrigen.setText("");
		FieldDestino.setText("");
		FieldLinea.setText("");
		chckbxVuelta.setSelected(false);
		dateChooserIda.setDate(new Date());
		dateChooserVuelta.setDate(new Date());
	}
}
