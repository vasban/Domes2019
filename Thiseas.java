import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Thiseas{
    public static void main (String [] args){

       File f = new File("lavirinthos.txt");
       String line;
       int x ; int y; //diastaseis pinaka
       int entrancex; int entrancey;
    //    Scanner scanner = new Scanner(System.in);
       BufferedReader buffreader = null;
       char labyrinth[][];
       try{
           FileReader reader = new FileReader(f);
           buffreader = new BufferedReader(reader);

       }catch(FileNotFoundException fnfex){
            System.out.print(fnfex.getMessage()+" The file was not found");
            System.exit(0);
       }

       try{
           line = buffreader.readLine();
           StringTokenizer st = new StringTokenizer(line);
           x = Integer.parseInt(st.nextToken());
           y = Integer.parseInt(st.nextToken());
           System.out.println(x + "<---this is x\n"+y+"<----this is y");
           labyrinth = new char [x][y];
           line = buffreader.readLine();
           st = new StringTokenizer(line);
           entrancex = Integer.parseInt(st.nextToken());
           entrancey = Integer.parseInt(st.nextToken());
           System.out.println(entrancex+"<--- this is Ex\n"+entrancey+"<---- this is Ey");
           int i=0;
           int j=0;
           while((line = buffreader.readLine()) != null){
               j=0;
                // System.out.println(line);
                 st = new StringTokenizer(line);
                while(st.hasMoreTokens()){
                    labyrinth[i][j]= st.nextToken().charAt(0);
                   j++;  
                //    if(j>y && st.hasMoreTokens()){
                //         System.out.println("Invalid labyrinth dimesions");
                //         System.out.println("The program is closing...");
                //         System.exit(0);
                //    }
                }
               i++;
            //    if(i>x && st.hasMoreTokens()){
            //        System.out.println("Invalid labyrinth dimensions");
            //        System.out.println("The program is closing...");
            //        System.exit(0);
            //    } 
           }
           System.out.println("-----------------------------------------");
           
           for(i=0;i<x;i++){
            
            for(j=0;j<y;j++){
                    System.out.print(labyrinth[i][j]);

             }
             System.out.println("\n"); 
           }
            // Checking the entrance
           if(labyrinth[entrancex][entrancey]!='E'||labyrinth[entrancex][entrancey]!='e'){
               System.out.println("wrong entrance");
               System.out.println("The program is closing...");
               System.exit(0);
           }

           
           
       }catch(IOException ex){
           System.out.println(ex.getMessage()+" IOException");
           System.exit(0);
       }

       
    }
}