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

       File f = new File(args[0]);
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
                if(i>=x ){
                   System.out.println("Invalid labyrinth dimensions");
                   System.out.println("The program is closing...");
                   System.exit(0);
               } 


               j=0;
                // System.out.println(line);
                 st = new StringTokenizer(line);
                while(st.hasMoreTokens()){
                    if(j>=y ){
                        System.out.println("Invalid labyrinth dimesions");
                        System.out.println("The program is closing...");
                        System.exit(0);
                   }
                    labyrinth[i][j]= st.nextToken().charAt(0);
                   j++;  
                }
               i++;
           }
           System.out.println("-----------------------------------------");
           
           for(i=0;i<x;i++){
            
            for(j=0;j<y;j++){
                    System.out.print(labyrinth[i][j]);

             }
             System.out.println("\n"); 
           }
            // Checking the entrance
           if(labyrinth[entrancex][entrancey]!='e')labyrinth[entrancex][entrancey]='E';
           if(labyrinth[entrancex][entrancey]!='E'){
               System.out.println("wrong entrance");
               System.out.println("The program is closing...");
               System.exit(0);
           }

        StringStackImpl stack = new StringStackImpl();
        stack.push(String.valueOf(labyrinth[entrancex][entrancey]));
        boolean flag = false;
        int movex = entrancex; int movey=entrancey;
        // boolean b1 ,b2;
        while(!flag){
            if((movex+1)<x && labyrinth[movex+1][movey]=='0'){
                movex+=1;
                stack.push(String.valueOf(labyrinth[movex][movey]));//edw prepei na kanw tsek ama einai staurodromi
                if(labyrinth[movex][movey]!='E')labyrinth[movex][movey] = 'V';
                if(movex+1==x)flag = true;
            }else if((movex-1)>=0 && labyrinth[movex-1][movey]=='0'){
                movex-=1;
                stack.push(String.valueOf(labyrinth[movex][movey]));
                if(labyrinth[movex][movey]!='E')labyrinth[movex][movey] = 'V';
                if(movex==0)flag = true;
            }else if((movey+1)<y && labyrinth[movex][movey+1]=='0'){
                movey+=1;
                stack.push(String.valueOf(labyrinth[movex][movey]));
                if(labyrinth[movex][movey]!='E')labyrinth[movex][movey] = 'V';
                if(movey+1 == y)flag = true;
            }else if((movey-1>=0) && labyrinth[movex][movey-1]=='0'){
                movey-=1;
                stack.push(String.valueOf(labyrinth[movex][movey]));
                if(labyrinth[movex][movey]!='E')labyrinth[movex][movey] = 'V';
                if(movey==0)flag = true;
            }else{
                System.out.println("Backtracking!");
                if(stack.peek().equals("E")){
                    System.out.println("The labyrinth has no exit");
                    flag = true;
                }
                stack.pop();
            }
        }

        System.out.println("--------------------------------");
        for(i=0;i<x;i++){
            
            for(j=0;j<y;j++){
                    System.out.print(labyrinth[i][j]);

             }
             System.out.println("\n"); 
           }
        

       }catch(IOException ex){
           System.out.println(ex.getMessage()+" IOException");
           System.exit(0);
       }
       
       
    }
}