
import java.io.IOException;
import java.io.*;
import java.util.*;
public class App {
    
    public static void main(String[] args)throws FileNotFoundException{
      PrintStream printStream = new PrintStream(new FileOutputStream(new File("AshenafiExo2.csv")));
        Lecture_Reducteur lc = new Lecture_Reducteur(printStream);
        // new Display(lc).start(); // new Display(lc).start();
          for(int i=0;i<10;i++){
            new Reducteur(lc).start();
            new Lecture(lc).start();
           
        }
     
}
    }
         
