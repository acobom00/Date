import java.util.Scanner;

public class MainDate {

	public static void main(String[] args) throws ExceptionDate {
		Scanner lee = new Scanner (System.in);
		System.out.println("dime un dia");
		int dia=lee.nextInt();
		System.out.println("dime un mes");
		int mes=lee.nextInt();
		System.out.println("dime un year");
		int year=lee.nextInt();
		
		Date fecha= new Date (dia,mes,year);
		//String mesString=fecha.pasarMes(7);
		//System.out.println(mesString);
		System.out.println("dime una fecha");
		fecha.imprimirFecha(fecha);
		fecha.intentosAcertarFecha();
		fecha.diasTranscurridos(fecha,5);
		fecha.season(mes);
		fecha.mismosDias(mes);
		fecha.mesesRestantes(fecha);
		fecha.diasFinMes(fecha);
	}

}
