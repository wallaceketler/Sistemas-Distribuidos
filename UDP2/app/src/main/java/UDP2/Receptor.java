/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP2;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 *
 * @author walla
 */
public class Receptor {
    public static void main(String args[]){
    
        String sRet = "";
        try{
            MulticastSocket SocketMulticast = new MulticastSocket(4444);
            InetAddress grupo = InetAddress.getByName("239.0.0.1");
            SocketMulticast.joinGroup(grupo);
            byte[] b = new byte[256];
            DatagramPacket datagrama = new DatagramPacket(b, b.length);
            SocketMulticast.receive(datagrama);
            sRet = new String(datagrama.getData()).trim();
            System.out.println("Mensagem: " + sRet);
            
        }catch(Exception e){    
            e.printStackTrace();
        }
    
    }
    
}
