/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package somaSocket2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author walla
 */
public class App2 {

    public static void main(String[] args) {
        try {
            ServerSocket app2ServerSocket = new ServerSocket(3030); //para ler

            while (true) {
                Socket app1Socket = app2ServerSocket.accept();               
                ObjectInputStream entrada1 = new ObjectInputStream(app1Socket.getInputStream());
  
                double soma = entrada1.readDouble() + entrada1.readDouble();
              
                Thread t = new Thread(() -> {
                    try {
                        Socket app2Socket = new Socket("127.0.0.1", 4040);      //para enviar
                        ObjectOutputStream saida = new ObjectOutputStream(app2Socket.getOutputStream());
                        saida.flush();
                        saida.writeDouble(soma);
                        saida.close();
                        app2Socket.close();

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro App2: " + e.getMessage());
                        e.printStackTrace();

                    }
                });
                t.start();
                
                entrada1.close();
                //entrada2.close();
                app1Socket.close();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro main app2 : " + e.getMessage());
            e.printStackTrace();

        }

    }
}
