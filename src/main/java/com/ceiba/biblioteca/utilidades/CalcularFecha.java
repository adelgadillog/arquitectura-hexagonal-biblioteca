package com.ceiba.biblioteca.utilidades;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CalcularFecha {

    public static String calcularFechaDevolucion(Date date, int tipoUsuario){
        Date dateMax = new Date();
        switch(tipoUsuario){
            case 1: dateMax = Date.from(UtilidadesCalendario.addDaysSkippingWeekends(LocalDate.now(),10)
                    .atStartOfDay(ZoneId.systemDefault()).toInstant());
                break;
            case 2: dateMax = Date.from(UtilidadesCalendario.addDaysSkippingWeekends(LocalDate.now(),8)
                    .atStartOfDay(ZoneId.systemDefault()).toInstant());
                break;
            case 3: dateMax = Date.from(UtilidadesCalendario.addDaysSkippingWeekends(LocalDate.now(),7)
                    .atStartOfDay(ZoneId.systemDefault()).toInstant());
                break;
        }

        return new SimpleDateFormat("dd/MM/yyyy").format(dateMax);
    }
}
