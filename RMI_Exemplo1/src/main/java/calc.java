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

//interfaces são usadas apenas para possuir assinatura de métodos
public interface calc extends Remote{
    
    public int soma(int n1, int n2) throws RemoteException;
    
}
