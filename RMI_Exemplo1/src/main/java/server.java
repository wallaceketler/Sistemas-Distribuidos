import java.awt.HeadlessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wallace
 */

//skeletons

//como temos a classe calc que é interface, devemos implementar os métodos dela ao herdar dela
public class server extends UnicastRemoteObject implements calc{

    public server() throws RemoteException{
        super();
    }

    @Override
    public int soma(int n1, int n2) throws RemoteException {
        return n1+n2;
    }
    
    public static void main(String args[]){
        try{
            Registry reg = LocateRegistry.createRegistry(4444); //1024 para cima, antes é exclusivo TCP/IP 
            reg.rebind("servidor", new server());
            JOptionPane.showMessageDialog(null, "Servidor rodando");

        }
        catch(RemoteException e){
            JOptionPane.showMessageDialog(null, "Exceção main: " + e.getMessage());
        }
    }
}
