/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidorItau;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

/**
 *
 * @author walla
 */
public class servidorItau extends UnicastRemoteObject implements itauInterface{
    
    public servidorItau() throws RemoteException{
        super();
    }
    
    @Override
    public float taxa(int valorTotal, int parcelas) throws RemoteException {
        return (float) ((valorTotal/parcelas)*1.035);
    }
    
    public static void main(String args[]){
        try{
            Registry reg = LocateRegistry.createRegistry(10000); //1024 para cima, antes é exclusivo TCP/IP 
            reg.rebind("servidorItau", new servidorItau());
            JOptionPane.showMessageDialog(null, "Servidor rodando");

        }
        catch(RemoteException e){
            JOptionPane.showMessageDialog(null, "Exceção main: " + e.getMessage());
        }
    }
}
