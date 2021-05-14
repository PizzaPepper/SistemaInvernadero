/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import Cliente.Cliente;
import Dominio.Sensor;
import java.util.ArrayList;
import Server.Server;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eliu
 */
public class TestServer {
    static List<Sensor> lista = null;
    public static void main(String[] args) throws InterruptedException {
        
     
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                
                try {
                    lista= new Server(3312, new ArrayList<>()).RecibirListaDatos();
                    
                } catch (IOException ex) {
                    Logger.getLogger(TestServer.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
 
                new Cliente("localhost", 3312).EnviarListaDatos();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(lista);
        
        
    }
}
