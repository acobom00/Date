
import java.util.*;

public class Date {
private int dia;
private int mes;
private int year;

public Date (int dia, int mes) throws ExceptionDate{
	StringBuffer mens =new StringBuffer();
	if(dia<32 && dia>0 &&mes<13){
		this.dia=dia;
		this.mes=mes;
	}
	else{
		mens.append("Fecha no valida");
		System.out.println(mens);
	}
}
public Date (int dia, int mes,int year) throws ExceptionDate{
	StringBuffer mens =new StringBuffer();
	if(fechaCorrecta(dia,mes,year)){
		this.dia=dia;
		this.mes=mes;
		this.year=year;
	}
	else{
		mens.append("Fecha no valida");
		System.out.println(mens);
		
	}
	if(mens.length()!=0){
		throw new ExceptionDate(mens.toString());
	}
}
public String pasarMes(int unMes){
	String mesString;
	switch(unMes){
	case 1:mesString="Enero";break;
	case 2:mesString="Febrero";break;
	case 3:mesString="Marzo";break;
	case 4:mesString="Abril";break;
	case 5:mesString="Mayo";break;
	case 6:mesString="Junio";break;
	case 7:mesString="Julio";break;
	case 8:mesString="Agosto";break;
	case 9:mesString="Septiembre";break;
	case 10:mesString="Octubre";break;
	case 11:mesString="Noviembre";break;
	case 12:mesString="Diciembre";break;
	default:mesString="";break;
	}
	return mesString;
}

public boolean mismoDia (int unDia){
	if(dia==unDia){
		return true;
	}
	else
		return false;
}

public boolean mismoMes(int unMes){
	if(mes==unMes){
		return true;
	}
	else
		return false;
}
public boolean mismoYear(int unYear){
	if(mes==unYear){
		return true;
	}
	else
		return false;
}


public boolean isSame(Date unaFecha){
	if(dia==unaFecha.dia && mes==unaFecha.mes && year==unaFecha.year){
		return true;
	}
	return false;
	
}
public boolean fechaCorrecta (int dia, int mes, int year){
	if(dia<=0 || dia>31 || year<0 || mes<=0 || mes>12){
		return false;
	}
	if(dia<31 && mes==1 ||mes==3||mes==5|| mes==7||mes==8|| mes==10||mes==12){
		return true;
	}
	else if((dia<=30)&&(mes==4||mes==6||mes==9||mes==11)){
		return true;
	}
	else if((dia<=29)&&mes==2){
		return true;
	}
	else{
		return false;
	}
}
public void imprimirFecha (Date fecha){
	String mesString=pasarMes(fecha.mes);
		System.out.println(fecha.dia+" de "+ mesString+" de "+ fecha.year);
	
}
public int intentosAcertarFecha() throws ExceptionDate{
	int intentos=0;
	Random randomNumer =new Random();
	randomNumer.setSeed(System.currentTimeMillis());//tiempo ordenador
	Date fechaAleatoria=null;
	do{
		int diaAleatorio=randomNumer.nextInt(31)+1;//0 a 30 por eso lo incremento
		int mesAleatorio=randomNumer.nextInt(12)+1;
		if(fechaCorrecta(diaAleatorio,mesAleatorio,year)){
			fechaAleatoria=new Date(diaAleatorio,mesAleatorio,year);
			intentos++;
		}
		
	}while(!isSame(fechaAleatoria));
	System.out.println("numero intentos: "+intentos);
	return intentos;
}
public int intentosAcertarFecha2() throws ExceptionDate{
	int intentos=0;
	Random randomNumer =new Random();
	randomNumer.setSeed(System.currentTimeMillis());//tiempo ordenador
	Date fechaAleatoria= new Date(1,1,4600);
	while(!isSame(fechaAleatoria)){
		int diaAleatorio=randomNumer.nextInt(31)+1;//0 a 30 por eso lo incremento
		int mesAleatorio=randomNumer.nextInt(12)+1;
		if(fechaCorrecta(diaAleatorio,mesAleatorio,year)){
			fechaAleatoria=new Date(diaAleatorio,mesAleatorio,year);
			intentos++;
		}
		
	}
	System.out.println("numero intentos: "+intentos);
	return intentos;
}
public void diasTranscurridos(Date fecha,int diaSemana){
	String[] dias ={"domingo","sabado","lunes","martes","miercoles","jueves","viernes"};
	int diasTranscurridos=diasTranscurridosYear(fecha);
	int resto=diasTranscurridos%7;
	//if(isBisiesto){
	int diaBuscado=(diaSemana+resto)%7;
	
	/*else{
		int diaBuscado=(diaSemana+resto-1)%7;
	}*/
	
	System.out.println("el dia buscado es:"+ diaBuscado);
}

public int diasTranscurridosYear(Date fecha){
	int diasTotales=0;
	switch(fecha.mes){
		case 1:diasTotales=0;break;
		case 2:diasTotales=31;break;
		case 3:diasTotales=59;break;
		case 4:diasTotales=90;break;
		case 5:diasTotales=120;break;
		case 6:diasTotales=151;break;
		case 7:diasTotales=181;break;
		case 8:diasTotales=212;break;
		case 9:diasTotales=243;break;
		case 10:diasTotales=273;break;
		case 11:diasTotales=304;break;
		case 12:diasTotales=334;break;
		
	}
diasTotales+=fecha.dia;
System.out.println("Han pasado "+diasTotales+ " desde principio de año");
return diasTotales;
}
public int mesesRestantes(Date fecha){
	int i;
	int transcurridos=1;
	int restantes=0;

		transcurridos+=fecha.mes-1;
		restantes=12-transcurridos;
		
		System.out.println("Quedan "+restantes+" meses");
		return restantes;
}
public void diasFinMes(Date fecha){
	
	if(mes==1 || mes==3 || mes==5 || mes ==7 || mes ==8 || mes==10 || mes==12)
		System.out.println("Los dias restantes son: "+ (31-fecha.dia));
	else if(mes==4 || mes==6 || mes==9 || mes==11)
		System.out.println("Los dias restantes son: "+(30-fecha.dia));
	else
		System.out.println("Los dias restantes son: "+(28-fecha.dia));
	
}
public void season(int unMes){
	String mesString;
	if(unMes==11 || unMes==12 || unMes==1 || unMes==2)
		System.out.println("Invierno");
	else if(unMes==3||unMes==4|| unMes==5)
		System.out.println("Primavera");
	else if(unMes==6||unMes==7||unMes==8)
		System.out.println("Verano");
	else
		System.out.println("Otoño");
}
public void mismosDias(int unMes){
	if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12){
		System.out.println("Tienen los mismos dias los siguientes meses: Enero,Marzo,Mayo,Julio,Agosto,Octumbre y Diciembre");
	}
	else if(mes==4||mes==6||mes==9||mes==11){
		System.out.println("Tienen los mismos dias los siguientes meses: Abril,Junio,Septiembre y Noviembre");
	}
	else{
		System.out.println("Febrero es el unico mes con 29 dias");
	}
}




}
