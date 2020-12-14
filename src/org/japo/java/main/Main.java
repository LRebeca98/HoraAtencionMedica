/* 
 * Copyright 2020 Rebeca Del Amo Cano - rebeca.delamo.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



// Este programa es para la atención médica, con inicio a las 9:30 y fin a las 13:45.
// El usuario tiene que meter por consola la hora y los minutos, si está dentro del
//horario, mostrar mensaje de SI disponible sino NO disponible.
// Hacer hora aleatoria con mensaje SI disponible o NO disponible.
// Hora del sistema con mensaje SI disponible o NO disponible.

package org.japo.java.main;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Rebeca Del Amo Cano - rebeca.delamo.alum@iescamp.es
 */
public class Main {
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    //Objeto Random
    public static final Random RND = new Random();
    //Objeto calenar
    public static final Calendar CAL = Calendar.getInstance();
     
    public static void main (String[] arg){
        
       //Constantes para horario atencion
       final int Hora_AT_I = 9;
       final int Min_AT_I = 30;
       final int Hora_AT_F = 13;
       final int Min_AT_F = 45;
       final int T_INI = Hora_AT_I * 60 + Min_AT_I; //Hora inicial pasada a segundos
       final int T_FIN = Hora_AT_F * 60 + Min_AT_F; // Hora final pasada a segundos 
      
       //Variables dato aleatorio
       int Hora_USR = 0;
       int Min_USR = 0;
      
        //PASO TIEMPO A MINUTOS
        int tAct = Hora_USR * 60 + Min_USR;
       
                
            //Hora Aleatoria
            //Variables y Constantes de Hora aleatoria
            final int Hora_max = 23; //Hora maxima del dia
            final int Min_max = 59; //Minutos maximos del dia
            final int Hora_Min = 0; //Hora minima del dia
            final int Min_Min = 0; //Minuto minimo del dia
            final int T_MIN = 0;
            final int T_MAX = Hora_max * 60 + Min_max;
           
            int T_RND = RND.nextInt(T_MAX - T_MIN +1) + T_MIN;
            int H_RND = T_RND / 60;
            int M_RND = T_RND % 60;
           
            //Salida por consola Hora atencion
            System.out.printf("Hora de Inicio Atencion ....: %02d:%02dH%n",
                    Hora_AT_I, Min_AT_I);
            System.out.printf("Hora de Final Atencion .....: %02d:%02dH%n",
                    Hora_AT_F, Min_AT_F);
          System.out.println("-----");
           //Hora sistema
        int hC1k = CAL.get(Calendar.HOUR_OF_DAY);
        int mC1k = CAL.get(Calendar.MINUTE);
        int tC1k = hC1k* 60 + mC1k;
        
        System.out.printf("Hora sistema ....: %02d:%02dH%n", hC1k, mC1k);
        System.out.printf("Hora sistema ....: %s%n", 
                tC1k >= T_INI && tC1k <= T_FIN
                ? "Atencion SI Disponible"
                : "Atencion NO Disponible");
        System.out.println("-----");
          //Salida por consola Hora Aleatoria
          System.out.printf("Hora Random ....: %02d:%02dH%n",
                    H_RND, M_RND);
         System.out.printf("Hora Random  ....: %s%n", 
                T_RND >= T_INI && T_RND <= T_FIN
                ? "Atencion SI Disponible"
                : "Atencion NO Disponible");
          System.out.println("-- Insertar Datos --");
          //Salida por consola Hora Manual
           //Entrada Hora por consola
        try {
           System.out.print("Hora Usuario ....: ");
            Hora_USR = SCN.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada incorrecta, reinicie el proceso");
            System.out.println("---------------------------------------");
            System.exit(0); // Salida esperada por fallo.
        } finally {
            SCN.nextLine();
        }
      
       //Entrada Minuto por consola
        try {
            System.out.print("Minuto Usuario ....: ");
            Min_USR = SCN.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada incorrecta, reinicie el proceso");
            System.out.println("---------------------------------------");
            System.exit(0); // Salida esperada por fallo.
        } finally {
            SCN.nextLine();
        }
        System.out.println("----");
        int TiempoUsuario = Hora_USR * 60 + Min_USR;
        
        System.out.printf("Hora Usuario .....:  %02d:%02dH%n", Hora_USR,
                Min_USR);
        System.out.printf("Hora Usuario  ....: %s%n", 
                TiempoUsuario >= T_INI && TiempoUsuario <= T_FIN
                ? "Atencion SI Disponible"
                : "Atencion NO Disponible");
        
    }
}      
