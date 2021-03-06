package Modelo;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controlador.Controlador;
import Funciones.FuncionesFecha;
import Funciones.FuncionesFormato;
import Vista.PanePago;
import Vista.Vista;
/**
 * Clase: ManejoBilletes - Controla la impresion de las listas del panel de la devolucion y el ticket .
 * @author IN1DM3B_18
 * @param nombreBillete
 * @param contadorBillete
 */
public class ManejoBilletes {

		public String nombreBillete;
		public int contadorBillete;
		
		public Vista vista;
		public Modelo modelo;
		Controlador controlador;
		
		public ManejoBilletes(Vista vista, Modelo modelo)
		{
			this.vista=vista;
			this.modelo=modelo;
		}
		
		public Dinero InsertarDatos(String nombreBillete,int contadorBillete)
		{
			return new Dinero(nombreBillete, contadorBillete);
		}

		public void InsertarControlador(Controlador controlador) {
			this.controlador=controlador;
		}

		public String getnombreBillete()
		{
			return nombreBillete;
		}
		
		public double getcontadorBillete()
		{
			return contadorBillete;
		}
		
		
		
		/**
		 * M�todo. rellenarLista : LLama a la funcion de de calcular el cambio y una vez obtenido rellena la imprime la lista en el panel.
		 * @param panePago
		 */
		public void rellenarLista(PanePago panePago)
		{
			vista.paneCambioFinal.modelo2.clear();
			Dinero[] listaBilletes=new Dinero[14];
			listaBilletes[0]=InsertarDatos("Billete de 200",0);
			listaBilletes[1]=InsertarDatos("Billete de 100",0);
			listaBilletes[2]=InsertarDatos("Billete de 50",0);
			listaBilletes[3]=InsertarDatos("Billete de 20",0);
			listaBilletes[4]=InsertarDatos("Billete de 10",0);
			listaBilletes[5]=InsertarDatos("Billete de 5",0);
			listaBilletes[6]=InsertarDatos("Moneda de 2",0);
			listaBilletes[7]=InsertarDatos("Moneda de 1",0);
			listaBilletes[8]=InsertarDatos("Moneda de 50c",0);
			listaBilletes[9]=InsertarDatos("Moneda de 20c",0);
			listaBilletes[10]=InsertarDatos("Moneda de 10c",0);
			listaBilletes[11]=InsertarDatos("Moneda de 5c",0);
			listaBilletes[12]=InsertarDatos("Moneda de 2c",0);
			listaBilletes[13]=InsertarDatos("Moneda de 1c",0);
			
			float cambio=Float.parseFloat(panePago.txtCambio2.getText());
			
			Devolucion devolucion = new Devolucion();
			
			devolucion.Dinero(cambio, listaBilletes);
			
			for (int i=0;i<listaBilletes.length;i++)
			{
				if (listaBilletes[i].contadorBillete>0)
				{ 
					vista.paneCambioFinal.modelo2.addElement(listaBilletes[i].contadorBillete+" x "+listaBilletes[i].nombreBillete);
				}
			}
		}
		
		/**
		 * M�todo: RellenarDatosBillete Se utiliza para rellenar el billete virtual que deberia de ser impreso para el cliente.
		 * @param panePago
		 */
		public void RellenarDatosBillete(PanePago panePago) {
			if(modelo.viajeDeVuelta) {
				vista.paneCambioFinal.lblparaFecha.setText(FuncionesFecha.CalendarToString(modelo.fechaIda) + " + " + FuncionesFecha.CalendarToString(modelo.fechaVuelta));
				
			}
			else
			{
				vista.paneCambioFinal.lblparaFecha.setText(FuncionesFecha.CalendarToString(modelo.fechaIda));

				
			}

			vista.paneCambioFinal.lblparaLinea.setText(modelo.linea.getCodLinea() + ": " + modelo.linea.getNombreLinea());
			vista.paneCambioFinal.lblparaTrayecto.setText(modelo.paradaOrigen.getNombreParada() + " -> " + modelo.paradaDestino.getNombreParada());
			vista.paneCambioFinal.lblparaPrecio.setText(FuncionesFormato.Formateado2Dec(modelo.precioIda)+ "�");
			vista.paneCambioFinal.lblCodIda.setText(FuncionesFormato.FormatoBillete(modelo.billeteIda.getCodBillete()) + " -> BUS: " + modelo.autobusIda.getCodBus());
			vista.paneCambioFinal.lbldni.setText(modelo.cliente.getDNI());
			if(modelo.viajeDeVuelta)
				vista.paneCambioFinal.lblCodVuelta.setText(FuncionesFormato.FormatoBillete(modelo.billeteVuelta.getCodBillete()) + " -> BUS: " + modelo.autobusVuelta.getCodBus());
			vista.paneCambioFinal.lblparaPrecio.setText(FuncionesFormato.Formateado2Dec(modelo.precioIda + modelo.precioVuelta)+ "�");
			
			
			
		}
}