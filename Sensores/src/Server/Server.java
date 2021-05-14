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
import java.util.List;

public class Server implements Runnable {

    private final int PORT;
    private ServerSocket server;
    private ArrayList<Sensor> sensores;

    public Server(int PORT, ArrayList<Sensor> sensores) throws IOException {
        this.PORT = PORT;
        this.server = new ServerSocket(PORT);
        this.sensores = sensores;
    }

    private static void CambiarValoresSensor(ArrayList<Sensor> sensores, Sensor sensorI) {
        for (Sensor sensor : sensores) {
            if (sensor.getNombre().equals(sensorI.getNombre())) {
                sensor.setHumedad(sensorI.getHumedad());
                sensor.setTemperatura(sensorI.getTemperatura());
            }
        }
    }

    public ArrayList<Sensor> RecibirListaDatos() {
        Socket cliente = null;
        ObjectInputStream dis = null;
        ArrayList<Sensor> list = new ArrayList<>();
        System.out.println("Inicia el servidor de un solo recibo");

        try {
            cliente = server.accept();
            dis = new ObjectInputStream(cliente.getInputStream());
            list =  (ArrayList<Sensor>) dis.readObject();
            
            //Close Connections
            dis.close();
            cliente.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Se cierra el servidor de un solo recibo");
        return list;
    }

    @Override
    public void run() {
        Socket cliente = null;
        ObjectInputStream dis = null;

        System.out.println("Inicia el servidor");

        while (true) {
            try {
                cliente = server.accept();
                dis = new ObjectInputStream(cliente.getInputStream());

                Sensor s = (Sensor) dis.readObject();
                CambiarValoresSensor(sensores, s);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        
        
    }

}
