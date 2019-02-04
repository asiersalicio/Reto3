package ControladoresPaneles;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.security.auth.login.LoginContext;

import Controlador.ControlInterfaz;
import Controlador.ControlModelo;
import Controlador.ControladorContrasena;
import Modelo.Llamadas;
import Vista.PaneLogin;
import Vista.PaneSelTrayecto;
/**
 * Clase: ControladorLogin: contiene btnRegister y btnLogin
 * en el btnRegister, cuando se pulsa dirige al usuario al paneRegister
 * en el btnLogin, cuando se pulsa, valida el DNI y la contrase�a y dirige al usuario al paneLogin
 * @author IN1DM3B_18
 *
 */
public class ControladorLogin {
	
	public ControladorLogin(PaneLogin paneLogin)
	{
		paneLogin.btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ControlInterfaz.setPanel(ControlInterfaz.paneRegister.paneRegister);
			}
		});
		
		paneLogin.btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean dniValido = false;
				boolean contrasenaValida = false;
				String dni = paneLogin.textfieldUsername.getText();
				dniValido=Llamadas.validarDNI(dni);
				System.out.println("El dni es valido? " + dniValido);
				String contrasena=String.valueOf(paneLogin.fieldPassword.getPassword());
				contrasenaValida=ControladorContrasena.combrobarContrasena(ControladorContrasena.encriptarContrasena(contrasena), dni);
				
				if(dniValido && contrasenaValida)
				{
					System.out.println("El dni es valido " + paneLogin.textfieldUsername.getText());
					ControlModelo.EstablecerClienteActual(paneLogin.textfieldUsername.getText());
					ControlInterfaz.setPanel(ControlInterfaz.paneSelTrayecto.pane);
				}
				else
				{
					System.out.println("El dni o la contrase�a no es valida " + paneLogin.textfieldUsername.getText());
					paneLogin.lblUsConNoValido.setVisible(true);
				}
				
				
			}
		});
	}
}
