package servidor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
public class serverDesktop extends UnicastRemoteObject implements fileManager, Runnable{

        
    public serverDesktop() throws RemoteException{
        super();    //chama construtor da superclasse UnicastRemoteObject
    }
    
    @Override
    public void save(String msg) throws RemoteException {

        try{
            FileWriter gravador = new FileWriter("C:/Users/walla/Documents/arquivoDesktop",true);
            gravador.write(msg);
            gravador.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Exceção: " + e.getMessage());
        }
    }

    @Override
    public String retrieve() throws RemoteException {
        String retorno = "";
        try{
            FileReader leitor = new FileReader("C:/Users/walla/Documents/arquivoDesktop");
            BufferedReader buffer = new BufferedReader(leitor);
            while(buffer.ready()){
                retorno += buffer.readLine();
            }
            leitor.close();
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "Exceção: " + e.getMessage());
        }
        return retorno;
    }

    
    public static void main(String args[]){
        
        
    }

    @Override
    public void run() {
        
        try{
            Registry reg = LocateRegistry.createRegistry(4444);
            reg.rebind("manager", new serverDesktop());
            JOptionPane.showMessageDialog(null,"Servidor rodando");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Exceção: " + e.getMessage());
       
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }
    
    
}
