
public class Lecture extends Thread {

  Lecture_Reducteur lecteur;

public Lecture(Lecture_Reducteur lecteur){
    this.lecteur=lecteur;
  }
public static int random_int(int Min, int Max)
    {
         return (int) (Math.random()*(Max-Min))+Min;
    }
    

    public void run(){
    
       long start=System.currentTimeMillis();
        long end=start+30000;
            while(end>System.currentTimeMillis()){
              
                  long r=random_int(500,2000);
                   try{
                     Thread.sleep(r);
                    lecteur.startReading();    
                    lecteur.affich();  
                    lecteur.stopReading();
                    lecteur.affich();
                    }catch(InterruptedException e){
                        System.out.print(e);
                    } 
                                
            }
    }
}
