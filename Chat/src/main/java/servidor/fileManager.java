package servidor;



import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author wallace
 */
public interface fileManager extends Remote{
    
    public void save(String msg) throws RemoteException;
    public String retrieve() throws RemoteException;
    
}
