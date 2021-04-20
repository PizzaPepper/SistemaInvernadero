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
    private ArrayList<Sensor> sensores;

    public Cliente(String HOST, int PORT, ArrayList<Sensor> sensores) {
        this.HOST = HOST;
        this.PORT = PORT;
        this.sensores = sensores;
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
            //sensor.close();
            //output.close();
            oos.close();
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
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
