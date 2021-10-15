
public class App {
    
    public static void main(String[] args){
        Lecture_Reducteur lc = new Lecture_Reducteur();
          for(int i=0;i<10;i++){
            new Reducteur(lc).start();
            new Lecture(lc).start();
        }
      
}
    }
         
