package lab9p1_diegomartinez;

import java.util.ArrayList;
import static lab9p1_diegomartinez.Lab9P1_DiegoMartinez.g;
import static lab9p1_diegomartinez.Lab9P1_DiegoMartinez.random;



public class Game {
    
    public Game(){
        
    }
    
    public ArrayList<String> coords= new ArrayList();
    
    int [][] board;

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
    
    int [][] nxgen;

    public int[][] getNxgen() {
        return nxgen;
    }

    public void setNxgen(int[][] nxgen) {
        this.nxgen = nxgen;
    }
    
    
    int rounds;

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public void print (ArrayList<String> coords){
        int [][] temp = new int [10][10];
        System.out.println("Coordenadas de celdad vivas: ");
        System.out.println(coords);
        for (int i = 0; i < coords.size(); i++) {
            String [] coors = coords.get(i).split(":");
            temp[Integer.parseInt(coors[0])][Integer.parseInt(coors[1])]=1;
        }//End For 1
        for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[i].length; j++) {
                    System.out.print("["+temp[i][j]+"]"+" ");
                }//End For 2
                System.out.println("");
        }//End For 1
    }//End Print
    
    public void nextGen (){
        coords.clear();
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                int c=0;
                if(board[i-1][j-1]==1){
                    c++;
                }if(board[i-1][j]==1){
                    c++;
                }if(board[i-1][j+1]==1){
                    c++;
                }if(board[i][j-1]==1){
                    c++;
                }if(board[i][j+1]==1){
                    c++;
                }if(board[i+1][j-1]==1){
                    c++;
                }if(board[i+1][j]==1){
                    c++;
                }if(board[i+1][j+1]==1){
                    c++;
                }//End if
               // System.out.println(i+" "+j+ " "+c);
                if (board[i][j]==1){
                    if(c<2||c>3){
                        nxgen[i][j]=0;
                    }else if (c==2){
                        nxgen[i][j]=1;
                    }//End Else if
                }else if (board[i][j]==0){
                    if(c==3){
                    nxgen[i][j]=1;
                    }//End if
                }//End Else if
            }//End For 2
        }//End For 1
      //  setBoard(nxgen);
        
        for (int i = 0; i < nxgen.length; i++) {
            for (int j = 0; j < nxgen[i].length; j++) {
               if(nxgen[i][j]==1){
                   coords.add(i+":"+j);
               }//End if
            }//End For 2
        }//End For 1
       /* for (int i = 0; i < nxgen.length; i++) {
            for (int j = 0; j < nxgen[i].length; j++) {
               if(nxgen[i][j]==1){
                   nxgen[i][j]=0;
               }//End if
            }//End For 2
        }//End For 1*/
       int[][]temp = board;
       board = nxgen;
       nxgen=temp;
        //setNxgen(nxgen);
        
    }//End nextGen
 
    public void jugar(int x){
        for (int i = 1; i <= x; i++) {
            System.out.println("Round: "+i);
            nextGen();
            print(coords);   
        }//End For
    }//End Jugar
    
}//End Public Game
