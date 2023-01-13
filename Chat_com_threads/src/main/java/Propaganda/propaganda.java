/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Propaganda;

import static java.lang.System.out;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.util.Random;

/**
 *
 * @author walla
 */
public class propaganda implements Runnable {

    public propaganda() throws RemoteException{
        super();
    }
    
    @Override
    public void run() {
        while(true){
            
            Random random = new Random();
            int valor = random.nextInt(3);
            String escolha = "";
        
            try{
                switch (valor) {
                    case 0:
                        escolha = "1";
                        break;
                    case 1:
                        escolha = "2";
                        break;
                    case 2:
                        escolha = "3";
                        break;
                    default:
                        break;
                }
                byte[] propaganda = escolha.getBytes();
                InetAddress hostMulticast = InetAddress.getByName("239.0.0.1");
                DatagramSocket SocketMulticast = new DatagramSocket();
                DatagramPacket datagrama = new DatagramPacket(propaganda, propaganda.length, hostMulticast, 4444);
                SocketMulticast.send(datagrama);
                SocketMulticast.close();
                Thread.sleep(2000);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
    }
    
    
    public static void main(String args[]){
        
    }
}
