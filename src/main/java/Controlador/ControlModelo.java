package Controlador;

import java.sql.SQLException;
import java.util.Date;

import Modelo.Autobus;
import Modelo.BBDD;
import Modelo.Billete;
import Modelo.Cliente;
import Modelo.Linea;
import Modelo.LineaParada;
import Modelo.Llamadas;
import Modelo.Parada;
import Vista.PaneRegister;
/**
 * Clase: ControlModelo: contiene las instancias del modelo, incluye las instancias de los objetos as� como m�todos relacionados con estas funciones.
 * @author IN1DM3B_18
 *
 */
public class ControlModelo {
	
	public static Cliente cliente;
	public static Linea linea;
	public static Parada paradaOrigen;
	public static Parada paradaDestino;
	public static LineaParada lineaParada;
	public static Billete billeteIda;
	public static Billete billeteVuelta;
	public static Autobus autobus;
	public static float precio;
	public static Date fechaIda;
	public static Date fechaVuelta;
	public static boolean viajeDeVuelta;
	
	//EstablecerClienteActual: rellena el objeto cliente con el cliente al que pertenece el dni que se pasa por par�metro. 
	public static void EstablecerClienteActual(String dni)
	{
		cliente = new Cliente();
		Llamadas.RellenarCliente(BBDD.connection, cliente, dni);
	}
	
	//RegistrarCliente: Introduce los datos introducidos por el usuario en el paneRegister en la BBDD.
	public static void RegistrarCliente(PaneRegister paneRegister)
	{
		String DNI=paneRegister.fieldDNI.getText();
		String nombreCliente=paneRegister.fieldNombre.getText();
		String apellidos=paneRegister.fieldApellidos.getText();
		//Date fechaNac=paneRegister.fechaNac.getDate();
		//String sexo=(String) paneRegister.comboBoxSexo.getSelectedItem();
		String contrasena=ControladorContrasena.encriptarContrasena(String.valueOf(paneRegister.fieldPassword.getPassword()));
		System.out.println("Registrando usuario: " + DNI + "/" + contrasena);
		try {
				Llamadas.insertarCliente(BBDD.connection, DNI, nombreCliente, apellidos, contrasena);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//EstablecerLinea: se realiza la llamada al m�todo RellenarLinea de la clase Llamadas en el paquete Modelo y se rellena el atributo linea del objeto Linea. 
	public static void EstablecerLinea(String codLinea)
	{
		linea = new Linea();
		Llamadas.RellenarLinea(BBDD.connection, linea, codLinea);
	}
	
	//EstablecerParadaOrigen: se realiza la llamada al m�todo RellenarParada de la clase Llamadas en el paquete Modelo y se rellena el atributo paradaOrigen del objeto Parada. 
	public static void EstablecerParadaOrigen(String codParadaOrigen)
	{
		paradaOrigen = new Parada();
		paradaOrigen=Llamadas.RellenarParada(BBDD.connection, paradaOrigen, codParadaOrigen);
		System.out.println("Parada origen: " + paradaOrigen.getNombreParada());
	}
	
	//EstablecerParadaDestino: se realiza la llamada al m�todo RellenarParada de la clase Llamadas en el paquete Modelo y se rellena el atributo paradaDestino del objeto Parada. 
	public static void EstablecerParadaDestino(String codParadaDestino)
	{
		paradaDestino = new Parada();
		paradaDestino=Llamadas.RellenarParada(BBDD.connection, paradaDestino, codParadaDestino);
		System.out.println("Parada destino: " + paradaDestino.getNombreParada());
	}

	//clase CalcularDatosCompra: se calcula el c�digo autob�s y el precio del Billete
	public static void CalcularDatosCompra() {
		int codBus;
		codBus=Llamadas.SeleccionarAutobus(BBDD.connection);
		autobus = new Autobus();
		autobus=Llamadas.RellenarAutobus(BBDD.connection, codBus, autobus);
		System.out.println("Calulando distancia entre " + paradaOrigen.getNombreParada() + " y " + paradaDestino.getNombreParada() + "...");
		precio=Llamadas.CalcularPrecioBillete(BBDD.connection);
	}
	
	//Clase GenerarBillete: se actualiza el codBillete mediante el m�todo CalcularCodBillete de la clase Llamadas en el paquete Modelo
	public static void GenerarBilletes()
	{
		int codBillete;
		codBillete=Llamadas.CalcularCodBillete(BBDD.connection);
		billeteIda = new Billete(codBillete, 0, linea.getCodLinea(), autobus, paradaOrigen, paradaDestino, fechaIda, cliente, precio);
		Llamadas.insertarBillete(BBDD.connection, billeteIda, viajeDeVuelta);
		
		if(ControlModelo.viajeDeVuelta) {
		codBillete=Llamadas.CalcularCodBillete(BBDD.connection);
		billeteVuelta = new Billete(codBillete, 1, linea.getCodLinea(), autobus, paradaOrigen, paradaDestino, fechaIda, cliente, precio);
		Llamadas.insertarBillete(BBDD.connection, billeteVuelta, viajeDeVuelta);
		}
}
}
