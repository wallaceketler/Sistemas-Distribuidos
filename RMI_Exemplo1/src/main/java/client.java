
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wallace
 */

//stub

public class client {
    
    public void conexaoRemota() throws RemoteException, NotBoundException{
        try{
            Registry reg = LocateRegistry.getRegistry("localhost",4444);
            calc obj = (calc) reg.lookup("servidor");

            int v1 = Integer.parseInt(JOptionPane.showInputDialog("Valor 1:"));
            int v2 = Integer.parseInt(JOptionPane.showInputDialog("Valor 2:"));

            JOptionPane.showMessageDialog(null, "A soma remota é: " + obj.soma(v1,v2));
        }catch(RemoteException e){
            JOptionPane.showMessageDialog(null, "Exceção: " + e.getMessage());
        }
    }
    
    public static void main(String args[]) throws RemoteException, NotBoundException{
        client cli = new client();
        cli.conexaoRemota();
    }
}
