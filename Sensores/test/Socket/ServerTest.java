/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import Dominio.Sensor;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ServerTest {
    
    

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = null;
        Socket cliente=null;
        ObjectInputStream dis=null;
        server = new ServerSocket(4444);
        
        ArrayList<Sensor> sensores=new ArrayList<>();
        sensores.add(new Sensor("Sensor Generico 1", "Compañia Generico x"));
        sensores.add(new Sensor("Sensor Generico 2", "Compañia Generico y"));
        
        
        System.out.println("Inicia el servidor");
        while(true){
            cliente =server.accept();
            dis=new ObjectInputStream(cliente.getInputStream());
            
            Sensor s=(Sensor) dis.readObject();
            CambiarValoresSensor(sensores, s);
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println(sensores);
            
        }
        
        
        
        
    }
    
    public static void CambiarValoresSensor(ArrayList<Sensor> sensores,Sensor sensorI){
        for (Sensor sensor : sensores) {
            if(sensor.getNombre().equals(sensorI.getNombre())){
            sensor.setHumedad(sensorI.getHumedad());
            sensor.setTemperatura(sensorI.getTemperatura());
            }    
        }
    }
    
    
    
}
