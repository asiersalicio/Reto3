package Controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Modelo.Llamadas;
/**
 * Clase: ControladorContrasena
 * Contiene los m�todos: encriptarContrasena y combrobarContrasena
 * 
 * @author IN1DM3B_18
 *
 */
public class ControladorContrasena {  
	
	/**
	 * M�todo: encriptarContrasena. permite encriptar la contrase�a:
	 * @param contrasena
	 * @return
	 */
	public static String encriptarContrasena(String contrasena)
	{
		String contrasenaEncriptada=null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(contrasena.getBytes());
			byte [] arrayByteContrasena = md.digest();
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0;i<arrayByteContrasena.length;i++)
			{
				sb.append(Integer.toString((arrayByteContrasena[i] & 0xff) + 0x100, 16).substring(1));
			}
			contrasenaEncriptada=sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return contrasenaEncriptada;
	}
	
	/**
	 * M�todo: combrobarContrasena: comprueba que la contrase�a introducida es igual a la contrase�a de la BBDD
	 * @param contrasenaEncriptada
	 * @param dni
	 * @return
	 */
	public static boolean combrobarContrasena(String contrasenaEncriptada, String dni)
	{
		if(Llamadas.ObtenerContrasena(dni).equals(contrasenaEncriptada))		
		return true;
		else
		return false;
	}
	
	/**
	 * M�todo: validarFormatoDNI. 
	 * M�todo que valida el formato del DNI: valida el DNI utilizando --> Expresiones Regulares
	 * Explicaci�n:
	 * .matches("") --> 
	 * [0-9]{8}: o lo que es lo mismo:  \d{8} -->  Permite coger 8 d�gitos.
	 * [-]? : permite introducir un gui�n opcional.
	 * [A-Z]{1} : coge la ultima letra, solo puede ser una.
	 * @param dni
	 * @return
	 */
	public static boolean validarFormatoDNI (String dni) {
		if(dni.matches("([0-9]{8})([-]?)([A-Z]{1})"))
		{
			System.out.println("1el formato del dni esta validado");
			return true;	
		}
		else
		return false;
	}
}
