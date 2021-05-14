/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Dominio.Sensor;
import administrarsensores.SensorRest;
import java.util.Calendar;
import org.json.JSONException;

/**
 *
 * @author eliu
 */
public class DemoRest {
    public static void main(String[] args) throws JSONException {
        SensorRest rest =new SensorRest();
        
        Sensor s = new Sensor(0, "XD", "MisaMisa", 34, 34, Calendar.getInstance());
        
        System.out.println(s.myTime());
        
        rest.Agregar(s);
        
        
        
        
        
        
        
    }
}
