/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JOptionPane;

/**
 *
 * @author walla
 */

//UDP = undenifined protocol (diferente do TCP, esse tipo de socket não exige confirmação de entrega)

public class Emissor {
    public static void main(String args[]){
    
        String msg = JOptionPane.showInputDialog("mensagem: ");
        try{
            byte[] b = msg.getBytes();
            InetAddress host = InetAddress.getByName("localhost");
            DatagramPacket datagrama = new DatagramPacket(b, b.length,host,5555);
            DatagramSocket socketUdp = new DatagramSocket();
            socketUdp.send(datagrama);
            socketUdp.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}