package ControladoresPaneles;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import Modelo.Modelo;
import Vista.PaneCambioFinal;
import Vista.PanePago;
import Vista.Vista;

/**
 * Clase: ControladorCambioFinal
 * @author IN1DM3B_18
 *
 */
public class ControladorCambioFinal {
		public PaneCambioFinal paneCambioFinal;
		public ControladorCambioFinal controladorCambioFinal;
	
	/**
	 * M�todo: ControladorCambioFinal
	 * @param modelo 
	 * @param paneCambioFinal
	 * @param panePago
	 */
	public ControladorCambioFinal(Vista vista, Modelo modelo)
	{
		controladorCambioFinal=this;
		this.paneCambioFinal=vista.paneCambioFinal;
		
		paneCambioFinal.btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Main.ResetAll();
			}
		});
	}
	
	
}
