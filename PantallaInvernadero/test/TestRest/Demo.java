/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestRest;

import Dominio.Sensor;
import administrarsensores.ISensor;
import administrarsensores.SensorRest;
import java.util.Calendar;

/**
 *
 * @author eliu
 */
public class Demo {
    public static void main(String[] args) {
        ISensor rest = new SensorRest();
        
          Sensor s = new Sensor(0, "XD", "MisaMisa", 34, 34, Calendar.getInstance());
        
        rest.Agregar(s);
        
        
    }
}
