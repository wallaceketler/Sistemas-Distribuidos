    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JOptionPane;

/**
 *
 * @author walla
 */

//UDP multicast 224.0.0.0 a 239.255.255.255 são ip's multicast

public class Emissor {
    public static void main(String args[]){
    
        String msg = JOptionPane.showInputDialog("Mensagem: ");
        try{
            byte[] b = msg.getBytes();
            InetAddress hostMulticast = InetAddress.getByName("239.0.0.1");
            DatagramSocket SocketMulticast = new DatagramSocket();
            DatagramPacket datagrama = new DatagramPacket(b, b.length, hostMulticast, 4444);
            SocketMulticast.send(datagrama);
            SocketMulticast.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    
    
    }
    
}
