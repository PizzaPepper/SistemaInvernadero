/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Random;

/**
 *
 * @author Eliu
 */
public class Cliente {
    public final static String HOST ="localhost";
    public final static int PORT = 4444;
    
    public static final float MIN=0f;
    public static final float MAX=100f;
    
    public static void main(String[] args) throws IOException {
        //Init
        Socket sensor = null;
        OutputStream output = null;
        ObjectOutputStream oos= null;
        float Tem= MIN + new Random().nextFloat() * (MAX-MIN);
        //float Hum= MIN + new Random().nextFloat() * (MAX-MIN);
        
        //Config
        sensor = new Socket(HOST, PORT);
        output = sensor.getOutputStream();
        oos = new ObjectOutputStream(output);
        
        //Send
        oos.writeFloat(Tem);
        
        //Close Connections
        sensor.close();
        output.close();
        oos.close();
        
        
        
    }
}
