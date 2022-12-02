//Diego Martinez
package lab9p1_diegomartinez;

import java.util.Arrays;
import java.util.Random;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Lab9P1_DiegoMartinez {

    static Scanner read = new Scanner(System.in);
    static Random random = new Random();
    static Game g=new Game();
    
    
    public static void main(String[] args) {
        int opcion;
        do{
            System.out.println("Menu");
            System.out.println("Opcion 1: Game of Life");
            System.out.println("Opcion 2: Salir");
            System.out.println("Ingrese la opcion que desea");
            opcion=read.nextInt();
            
            switch(opcion){
                case 1: {
                    System.out.println("Opcion 1: Game of Life");
                    System.out.println("Cuantas Rondas del juego desea?: ");
                    int rounds = read.nextInt();
                    int[][] array = new int[10][10];
                    int[][]nxgen=new int [10][10];
                    ArrayList<String> coords= new ArrayList();
                    array = read(array,nxgen,coords);
                    g.setBoard(array);
                    g.jugar(rounds);
                }break;
            }//End Switch
            
            
        }while(opcion!=2);
    }//End Public Main
    
    public static int[][] read(int[][]array,int[][]nxgen,ArrayList<String> coords){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
               nxgen[i][j]=0;
               if(i==0||j==0||i==array.length-1||j==array[i].length-1){
                    array[i][j]=0;
               }else{
                array[i][j]=random.nextInt(2);
               }//End Else
               if(array[i][j]==1){
                   coords.add(i+":"+j);
               }//End If
            }//End For 2
        }//End For
        g.setNxgen(nxgen);
        g.print(coords);
        return array;
    }//End Read 
    
}//End Class
