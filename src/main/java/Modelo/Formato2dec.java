package Modelo;
import java.text.DecimalFormat;
import java.text.ParseException;
/**
 * Clase Formato2dec: contiene el m�todo formateador mediante el cual se formatea el formato num�rico float a un formato decimal con dos decimales. 
 * @author IN1DM3B_18
 *
 */
public class Formato2dec {

	static DecimalFormat formateador=new DecimalFormat("###0.##"); 
	/**
	 * M�todo: formateador
	 * @param numero
	 * @return
	 */
	public static double formateador(double numero)
	{
		try {
			numero=formateador.parse(formateador.format(numero)).doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numero;
	}
}
