/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servidorItau;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author walla
 */
public interface itauInterface extends Remote{
    public float taxa(int valorTotal, int parcelas) throws RemoteException;
}
