package es.upm.dit.isst.docapp.handlers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class FechasyCitasHandler {
	private static FechasyCitasHandler instance;//Para modelo singleton
	private FechasyCitasHandler() {};
	public static FechasyCitasHandler getInstance() {
		if(null==instance) instance = new FechasyCitasHandler();
		return instance;
	}
	/*
	 * Funcion que se utiliza para sumar a una fecha x minutos
	 */
	public  Date sumarFechasDias(Date fch, int minutos) {
		//Se usa ese formato para luego poder ordenarlas en la base de datos
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.MINUTE, minutos);
        return new Date(cal.getTimeInMillis());
    }
	/*
	 * Funcion que se utiliza para obtener la fecha del lunes anterior a la fecha pasada
	 *  a las 9 que es cuando se empiezan a cargar las consultas de una semana
	 */
	public Date lunesnueve(Date fecha) {	
		Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fecha.getTime());
        cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return new Date(cal.getTimeInMillis());        
	}
	/*
	 * Funcion que devuelve el dia del mes
	 */
	public int diames(Date fecha) {
		Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fecha.getTime());
        return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public String mes(Date fecha) {
		Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fecha.getTime());
        String[] meses = {"ENERO", "FEBRERO", "MARZO", "ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
        return meses[cal.get(Calendar.MONTH)];
	}
	public Boolean ultimacita(Date fecha) {
		Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fecha.getTime());
        if(cal.get(Calendar.HOUR_OF_DAY) == 18 & cal.get(Calendar.MINUTE) == 30) {
        	return true;
        }
        if(cal.get(Calendar.HOUR_OF_DAY) > 18) {
        	return true;
        }
		return false;
	}
	public Date semanatras(Date fecha) {
		Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fecha.getTime());
        int semana = cal.get(Calendar.WEEK_OF_YEAR);
        if(semana -1 < 0) {
        	semana = 43;
        }
        cal.set(Calendar.WEEK_OF_YEAR, semana-1);
        return new Date(cal.getTimeInMillis());
	}
	public Date nueve(Date fecha) {
		Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fecha.getTime());
        cal.set(Calendar.HOUR_OF_DAY, 8);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return new Date(cal.getTimeInMillis()); 
	}

}
