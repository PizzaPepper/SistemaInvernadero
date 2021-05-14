/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrarsensores;

import Dominio.Sensor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorRest implements ISensor {

    private RequestSensor rest;

    @Override
    public ArrayList<Sensor> listar() {
        ArrayList<Sensor> sensores = new ArrayList<Sensor>();
        rest = new RequestSensor();
        String response = rest.getSensores(String.class);
        try {
            JSONArray json = new JSONArray(response);

            JSONObject object;
            
            //System.out.println(json);
            for (int i = 0; i < json.length(); i++) {
                object = json.getJSONObject(i);
                int id = object.getInt("id");
                String nombre = object.getString("nombre");
                String compania = object.getString("compania");
                float tmp = (float) object.getDouble("temperatura");
                float hum =  (float) object.getDouble("humedad");
                String fecha =  object.getString("fecha");
                int anio =Integer.parseInt(fecha.substring(0,4)) ;
                int mes = Integer.parseInt(fecha.substring(5,7)) ;
                int dia = Integer.parseInt(fecha.substring(8,10));
                GregorianCalendar c = new GregorianCalendar();
                c.clear();
                //Como siempre, Java quiere hacernos la vida dificil en poner UNA FECHA, por lo que dejo una solucion chafa para las fechas.
                c.set(anio, mes-1, dia+1);
                sensores.add(new Sensor(id, nombre, compania, tmp, hum, c));
            }
            rest.close();
        } catch (JSONException ex) {
            Logger.getLogger(SensorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sensores;
    }

    @Override
    public Sensor getId(int id) {
        Sensor sensor=null;
        rest = new RequestSensor();
        String response = rest.getSensores(String.class);
        try {

            JSONObject object = new JSONObject(response);
            
                int idd = object.getInt("id");
                String nombre = object.getString("nombre");
                String compania = object.getString("compania");
                float tmp = (float) object.getDouble("temperatura");
                float hum =  (float) object.getDouble("humedad");
                String fecha =  object.getString("fecha");
                int anio =Integer.parseInt(fecha.substring(0,4)) ;
                int mes = Integer.parseInt(fecha.substring(5,7)) ;
                int dia = Integer.parseInt(fecha.substring(8,10));
                GregorianCalendar c = new GregorianCalendar();
                c.clear();
                //Como siempre, Java quiere hacernos la vida dificil en poner UNA FECHA, por lo que dejo una solucion chafa para las fechas.
                c.set(anio, mes-1, dia+1);
                sensor = new Sensor(id, nombre, compania, hum, tmp, c);
            rest.close();
        } catch (JSONException ex) {
            Logger.getLogger(SensorRest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sensor;
    }
    
    
    @Override
    public void Agregar(Sensor s) {
        System.out.println(s);
        rest = new RequestSensor();
        rest.addSensor(s);
        rest.close();
    }

    @Override
    public void Actualizar(Sensor s) {
        rest = new RequestSensor();
        rest.uptdateSensor(s);
        rest.close();
    }

    @Override
    public void Eliminar(Sensor s) {
        rest = new RequestSensor();
        rest.deleteSensor(String.valueOf(s.getId()));
        rest.close();
    }

}
