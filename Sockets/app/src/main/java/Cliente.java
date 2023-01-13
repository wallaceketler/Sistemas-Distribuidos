
import java.io.ObjectInputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author walla
 */
public class Cliente {
    public static void main(String args[]){
        try{
           Socket cliente   = new Socket("127.0.0.1", 8888);
           ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
           JOptionPane.showMessageDialog(null, entrada.readUTF());
           entrada.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage());
        }
    }
}
