package ControladoresPaneles;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Controlador.ControlInterfaz;
import Controlador.ControlModelo;
import Vista.PaneLogin;
import Vista.PaneRegister;
/**
 * Clase ControladorRegister: Mediante esta clase se controlan los botones de la clase Register:  btnVolverALogin y btnRegistarse.
 * @author IN1DM3B_18
 *
 */
public class ControladorRegister {
	
	public ControladorRegister(PaneRegister paneRegister, PaneLogin paneLogin)
	{
		//Bot�n VolverALogin en paneRegister: cuando se clica en el bot�n "Volver", aparece la ventana: paneLogin
		paneRegister.btnVolverALogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ControlInterfaz.setPanel(paneLogin.paneLogin);
			}
		});
		
		
		//Bot�n Registrarse en paneLogin: Cuando se clica en el bot�n "Registrarse", aparece la ventana paneRegister
		paneRegister.btnRegistarse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ControlModelo.RegistrarCliente(paneRegister);
				ControlInterfaz.setPanel(ControlInterfaz.paneLogin.paneLogin);
			} 
		});

	}
	
}
