/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Dominio.Sensor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private final int PORT;
    private ServerSocket server;
    private ArrayList<Sensor> sensores;
    
    public Server(int PORT,ArrayList<Sensor> sensores) throws IOException {
        this.PORT = PORT;
        this.server = new ServerSocket(PORT);
        this.sensores = sensores;
    }
    
    public void conn(){
        Socket cliente=null;
        ObjectInputStream dis=null;
        
        System.out.println("Inicia el servidor");
        
        while(true){
            try {
            cliente =server.accept();
            dis=new ObjectInputStream(cliente.getInputStream());
            
            Sensor s=(Sensor) dis.readObject();
            CambiarValoresSensor(sensores, s);    
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            
            //System.out.println("\033[H\033[2J");
            //System.out.flush();
            //System.out.println(sensores);
            
        }
        
    }
        
    
    private static void CambiarValoresSensor(ArrayList<Sensor> sensores,Sensor sensorI){
        for (Sensor sensor : sensores) {
            if(sensor.getNombre().equals(sensorI.getNombre())){
            sensor.setHumedad(sensorI.getHumedad());
            sensor.setTemperatura(sensorI.getTemperatura());
            }    
        }
    }
    
}
