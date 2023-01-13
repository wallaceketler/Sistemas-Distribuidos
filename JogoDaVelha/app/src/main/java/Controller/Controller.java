/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.console;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author walla
 */
public class Controller {
    public static void main(String args[]){
        try{
            //define serverSockets para ouvir tanto o playerX quanto o playerO
            ServerSocket reading_controller_playerX = new ServerSocket(3030);
            ServerSocket reading_controller_playerO  = new ServerSocket(4040);
            
            //define variável para fim de jogo
            boolean end_of_game = false;
           
            //define turno inicial
            Random random = new Random();
            String turn;
            if(random.nextInt(2) == 0){
                turn = "X";
            }
            else{
                turn = "O";
            }
            JOptionPane.showMessageDialog(null, "O Primeiro a jogar é: " + turn);
            
            //define como os dados dos usuários vão ser recebidos
            String playerX_data;
            String playerO_data;
            ObjectInputStream data_receiving;
            
            //define matriz de como o jogo está atualmente
            String[][] state = new String[3][3];
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    state[i][j] = "vazio";
                }
            }
            
            //define sockets para enviar o turno inicial
            Socket send_initial_turn_toX = new Socket("127.0.0.1", 7070);
            Socket send_initial_turn_toO = new Socket("127.0.0.1", 8080);
            ObjectOutputStream initial_turn_data_toX = new ObjectOutputStream(send_initial_turn_toX.getOutputStream());
            ObjectOutputStream initial_turn_data_toO = new ObjectOutputStream(send_initial_turn_toO.getOutputStream());
            initial_turn_data_toX.flush();
            initial_turn_data_toO.flush();
            initial_turn_data_toX.writeUTF(turn);
            initial_turn_data_toO.writeUTF(turn);
            
            initial_turn_data_toX.close();
            initial_turn_data_toO.close();
            send_initial_turn_toX.close();
            send_initial_turn_toO.close();
            
            while(end_of_game != true){
                
                //define sockets para enviar jogadas para os players
                Socket controller_sending_playerX = new Socket("127.0.0.1", 5050);
                Socket controller_sending_playerO = new Socket("127.0.0.1", 6060);
                ObjectOutputStream controller_data_playerX = new ObjectOutputStream(controller_sending_playerX.getOutputStream());
                ObjectOutputStream controller_data_playerO = new ObjectOutputStream(controller_sending_playerO.getOutputStream());
                
                if(turn.equals("X")){
                    System.out.println("TURNO X");
                    Socket playerX_sending = reading_controller_playerX.accept();
                    ObjectInputStream data_receiving_playerX = new ObjectInputStream(playerX_sending.getInputStream());
                    playerX_data = data_receiving_playerX.readUTF();
                    
                    //insere jogada no estado atual
                    switch (playerX_data) {
                        case "upLeft-X":
                            state[0][0] = "X";
                            break;
                        case "upMid-X":
                            state[0][1] = "X";
                            break;
                        case "upRight-X":
                            state[0][2] = "X";
                            break;
                        case "centerLeft-X":
                            state[1][0] = "X";
                            break;
                        case "centerMid-X":
                            state[1][1] = "X";
                            break;
                        case "centerRight-X":
                            state[1][2] = "X";
                            break;
                        case "downLeft-X":
                            state[2][0] = "X";
                            break;
                        case "downMid-X":
                            state[2][1] = "X";
                            break;
                        case "downRight-X":
                            state[2][2] = "X";
                            break;
                        default:
                            break;
                    }
                    
                    //troca turno
                    turn = "O";
                    
                    controller_data_playerX.flush();
                    controller_data_playerO.flush();
                    
                    controller_data_playerX.writeUTF(turn);
                    controller_data_playerX.writeUTF(playerX_data);
                    controller_data_playerO.writeUTF(turn);
                    controller_data_playerO.writeUTF(playerX_data);
                    
        
                    //Termina ObjectInputStream e Sockets
                    data_receiving_playerX.close();
                    playerX_sending.close();
                  
                }
                else if(turn.equals("O")){
                    System.out.println("TURNO O");
                    Socket playerO_sending = reading_controller_playerO.accept();
                    ObjectInputStream data_receiving_playerO = new ObjectInputStream(playerO_sending.getInputStream());
                    playerO_data = data_receiving_playerO.readUTF();
                    
                    //insere jogada no estado atual
                    switch (playerO_data) {
                        case "upLeft-O":
                            state[0][0] = "O";
                            break;
                        case "upMid-O":
                            state[0][1] = "O";
                            break;
                        case "upRight-O":
                            state[0][2] = "O";
                            break;
                        case "centerLeft-O":
                            state[1][0] = "O";
                            break;
                        case "centerMid-O":
                            state[1][1] = "O";
                            break;
                        case "centerRight-O":
                            state[1][2] = "O";
                            break;
                        case "downLeft-O":
                            state[2][0] = "O";
                            break;
                        case "downMid-O":
                            state[2][1] = "O";
                            break;
                        case "downRight-O":
                            state[2][2] = "O";
                            break;
                        default:
                            break;
                    }
                    
                    
                    //troca turno
                    turn = "X";
                    controller_data_playerX.flush();
                    controller_data_playerO.flush();
                    
                    controller_data_playerX.writeUTF(turn);
                    controller_data_playerX.writeUTF(playerO_data);
                    controller_data_playerO.writeUTF(turn);
                    controller_data_playerO.writeUTF(playerO_data);
                    
                    
                    //Termina ObjectInputStrem e Sockets
                    data_receiving_playerO.close();
                    playerO_sending.close();
               
                }
                
                //verifica se alguém ganhou
                //verifica X
                if(state[0][0].equals("X") && state[0][1].equals("X") && state[0][2].equals("X")){
                    JOptionPane.showMessageDialog(null, "JOGADOR X GANHOU!");
                    end_of_game = true;
                }
                if(state[1][0].equals("X") && state[1][1].equals("X") && state[1][2].equals("X")){
                    JOptionPane.showMessageDialog(null, "JOGADOR X GANHOU!");
                    end_of_game = true;
                }
                if(state[2][0].equals("X") && state[2][1].equals("X") && state[2][2].equals("X")){
                    JOptionPane.showMessageDialog(null, "JOGADOR X GANHOU!");
                    end_of_game = true;
                }
                if(state[0][0].equals("X") && state[1][0].equals("X") && state[2][0].equals("X")){
                    JOptionPane.showMessageDialog(null, "JOGADOR X GANHOU!");
                    end_of_game = true;
                }
                if(state[0][1].equals("X") && state[1][1].equals("X") && state[2][1].equals("X")){
                    JOptionPane.showMessageDialog(null, "JOGADOR X GANHOU!");
                    end_of_game = true;
                }
                if(state[0][2].equals("X") && state[1][2].equals("X") && state[2][2].equals("X")){
                    JOptionPane.showMessageDialog(null, "JOGADOR X GANHOU!");
                    end_of_game = true;
                }
                if(state[0][0].equals("X") && state[1][1].equals("X") && state[2][2].equals("X")){
                    JOptionPane.showMessageDialog(null, "JOGADOR X GANHOU!");
                    end_of_game = true;
                }
                if(state[0][2].equals("X") && state[1][1].equals("X") && state[2][0].equals("X")){
                    JOptionPane.showMessageDialog(null, "JOGADOR X GANHOU!");
                    end_of_game = true;
                }
                //verifica O
                if(state[0][0].equals("O") && state[0][1].equals("O") && state[0][2].equals("O")){
                    JOptionPane.showMessageDialog(null, "JOGADOR O GANHOU!");
                    end_of_game = true;
                }
                if(state[1][0].equals("O") && state[1][1].equals("O") && state[1][2].equals("O")){
                    JOptionPane.showMessageDialog(null, "JOGADOR O GANHOU!");
                    end_of_game = true;
                }
                if(state[2][0].equals("O") && state[2][1].equals("O") && state[2][2].equals("O")){
                    JOptionPane.showMessageDialog(null, "JOGADOR O GANHOU!");
                    end_of_game = true;
                }
                if(state[0][0].equals("O") && state[1][0].equals("O") && state[2][0].equals("O")){
                    JOptionPane.showMessageDialog(null, "JOGADOR O GANHOU!");
                    end_of_game = true;
                }
                if(state[0][1].equals("O") && state[1][1].equals("O") && state[2][1].equals("O")){
                    JOptionPane.showMessageDialog(null, "JOGADOR O GANHOU!");
                    end_of_game = true;
                }
                if(state[0][2].equals("O") && state[1][2].equals("O") && state[2][2].equals("O")){
                    JOptionPane.showMessageDialog(null, "JOGADOR O GANHOU!");
                    end_of_game = true;
                }
                if(state[0][0].equals("O") && state[1][1].equals("O") && state[2][2].equals("O")){
                    JOptionPane.showMessageDialog(null, "JOGADOR O GANHOU!");
                    end_of_game = true;
                }
                if(state[0][2].equals("O") && state[1][1].equals("O") && state[2][0].equals("O")){
                    JOptionPane.showMessageDialog(null, "JOGADOR O GANHOU!");
                    end_of_game = true;
                }
                
                //finaliza os envios do controller
                controller_data_playerX.close();
                controller_data_playerO.close();
                controller_sending_playerX.close();
                controller_sending_playerO.close();
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
}
