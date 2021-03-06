package Controlador;


import BBDD.SelectorBBDD;
import ControladoresPaneles.ControladorBienvenida;
import ControladoresPaneles.ControladorCambioFinal;
import ControladoresPaneles.ControladorLogin;
import ControladoresPaneles.ControladorMostrarCompra;
import ControladoresPaneles.ControladorPago;
import ControladoresPaneles.ControladorPaneUsuario;
import ControladoresPaneles.ControladorRegister;
import ControladoresPaneles.ControladorSelTrayecto;
import Modelo.ManejoBilletes;
import Modelo.Modelo;
import Vista.DebugMode;
import Vista.Vista;

public class Controlador {
	
	public ControladorLogin controladorLogin;
	public ControladorSelTrayecto controladorSelTrayecto;
	public ControladorMostrarCompra controladorMostrarCompra;
	public ControladorPago controladorPago;
	public ControladorRegister controladorRegister;
	public ControladorCambioFinal controladorCambioFinal;
	public ControladorBienvenida controladorBienvenida;
	public ControladorPaneUsuario controladorPaneUsuario;
	
	
	public ManejoBilletes manejoBilletes;
	

	public Controlador(Vista vista, Modelo modelo)
	{
		
		manejoBilletes = new ManejoBilletes(vista, modelo);
		
		
		controladorMostrarCompra = new ControladorMostrarCompra(vista, modelo);
		controladorSelTrayecto = new ControladorSelTrayecto(vista, modelo, this);
		controladorLogin = new ControladorLogin(vista, modelo);
		controladorPago = new ControladorPago(vista, modelo, this, modelo.pagar);
		controladorRegister = new ControladorRegister(vista, modelo);
		controladorCambioFinal = new ControladorCambioFinal(vista, modelo);
		controladorBienvenida = new ControladorBienvenida(vista, modelo);
		controladorPaneUsuario = new ControladorPaneUsuario(vista, modelo);
		
		
		new SelectorBBDD(vista);
		
		if(false)
		{
			new DebugMode(vista, modelo);
		}
	}
}
