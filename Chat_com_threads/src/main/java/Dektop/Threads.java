/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dektop;

import javax.swing.JOptionPane;
import servidor.fileManager;

/**
 *
 * @author walla
 */
public class Threads implements Runnable {

    fileManager Manager;
    String Dados;
    
    public Threads(){
        super();
    }
    
    public void setParameters(fileManager manager, String dados){
        Manager = manager;
        Dados = dados;
    }
    
    @Override
    public void run() {
        try{
            Manager.save(Dados);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
        }
    }
    
}
