/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Dominio.Sensor;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable {

    private final String HOST;
    private final int PORT;
    private final float MIN = 0f;
    private final float MAX = 100f;
    private static ArrayList<Sensor> sensores;

    

    public Cliente(String HOST, int PORT, ArrayList<Sensor> sensores) {
        this.HOST = HOST;
        this.PORT = PORT;
        this.sensores = sensores;
    }

    public Cliente(String HOST, int PORT) {
        this.HOST = HOST;
        this.PORT = PORT;
        this.sensores = new ArrayList<>();
        InicializarSensores();
    }
    
    
    public void InicializarSensores() {
        sensores.add(new Sensor("S1", "Compania A"));
        sensores.add(new Sensor("S2", "Compania B"));
        sensores.add(new Sensor("S3", "Compania C"));
        sensores.add(new Sensor("S4", "Compania X"));
        sensores.add(new Sensor("S5", "Compania Y"));
    }
    
    public void EnviarListaDatos() {
        for (Sensor sensor : sensores) {
            float Tem = MIN + new Random().nextFloat() * (MAX - MIN);
            float Hum = MIN + new Random().nextFloat() * (MAX - MIN);
            sensor.setTemperatura(Tem);
            sensor.setHumedad(Hum);
        }
        
        Socket sensor = null;
        ObjectOutputStream oos = null;
        
        try {
            //Config
            sensor = new Socket(HOST, PORT);
            oos = new ObjectOutputStream(new BufferedOutputStream(sensor.getOutputStream()));
            //Send
            oos.writeObject(sensores);
            //Close Connections
            oos.close();
            sensor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void EnviarDatos() {
        int randomIndex = new Random().nextInt(sensores.size());
        Socket sensor = null;
        ObjectOutputStream oos = null;
        float Tem = MIN + new Random().nextFloat() * (MAX - MIN);
        float Hum = MIN + new Random().nextFloat() * (MAX - MIN);
        //Conf Sensor
        Sensor s = sensores.get(randomIndex);
        s.setTemperatura(Tem);
        s.setHumedad(Hum);
        try {
            //Config
            sensor = new Socket(HOST, PORT);
            oos = new ObjectOutputStream(new BufferedOutputStream(sensor.getOutputStream()));
            //Send
            oos.writeObject(s);
            //Close Connections
            oos.close();
            sensor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                EnviarDatos();
                // Configurar el tiempo
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
