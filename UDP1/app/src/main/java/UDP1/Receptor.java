/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author walla
 */
public class Receptor {
    
    public static void main(String args[]){
        String sRet = "";
        try{
            DatagramSocket socketUdp = new DatagramSocket(5555);
            byte[] msg = new byte[256];
            DatagramPacket datagrama = new DatagramPacket(msg, msg.length);
            socketUdp.receive(datagrama);
            sRet = new String(datagrama.getData()).trim();
            System.out.println("Recebido: " + sRet);
 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
