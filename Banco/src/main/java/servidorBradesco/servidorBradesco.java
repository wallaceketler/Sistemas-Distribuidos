/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidorBradesco;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;





/**
 *
 * @author walla
 */
public class servidorBradesco extends UnicastRemoteObject implements bradescoInterface{
    
    public servidorBradesco() throws RemoteException{
        super();
    }
    
    @Override
    public float taxa(int valorTotal, int parcelas) throws RemoteException {
        return (float)((valorTotal/parcelas)*1.025);
    }
    
    public static void main(String args[]){
        try{
            Registry reg = LocateRegistry.createRegistry(10001); //1024 para cima, antes é exclusivo TCP/IP 
            reg.rebind("servidorBradesco", new servidorBradesco());
            JOptionPane.showMessageDialog(null, "Servidor rodando");
        }
        catch(RemoteException e){
            JOptionPane.showMessageDialog(null, "Exceção main: " + e.getMessage());
        }
    }
}
