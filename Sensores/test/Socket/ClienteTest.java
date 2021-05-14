/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import Dominio.Sensor;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Eliu
 */
public class ClienteTest {
    public final static String HOST ="localhost";
    public final static int PORT = 4444;
    
    public static final float MIN=0f;
    public static final float MAX=100f;
    
    public static ArrayList<Sensor> sensores;
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        inicializarLista();
        
        while(true){
            loop();
            
            TimeUnit.SECONDS.sleep(1);
            
        }
        
        
    }
    
    public static void loop() throws IOException{
        //Init
        int randomIndex= new Random().nextInt(2);
        Socket sensor = null;
        ObjectOutputStream oos= null;
        float Tem= MIN + new Random().nextFloat() * (MAX-MIN);
        float Hum= MIN + new Random().nextFloat() * (MAX-MIN);
        //Conf Sensor
        Sensor s=sensores.get(randomIndex);
        s.setTemperatura(Tem);
        s.setHumedad(Hum);
        //Config
        sensor = new Socket(HOST, PORT);
        oos = new ObjectOutputStream(new BufferedOutputStream(sensor.getOutputStream()));
        //Send
        oos.writeObject(s);
        
        //Close Connections
        //sensor.close();
        //output.close();
        oos.close();
    }
    
    public static void inicializarLista(){
        sensores=new ArrayList<>();
        sensores.add(new Sensor("Sensor Generico 1", "Compañia x"));
        sensores.add(new Sensor("Sensor Generico 2", "Compañia y"));
    }
}
