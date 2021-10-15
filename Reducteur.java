public class Reducteur extends Thread {
 Lecture_Reducteur reducteur;    

  public Reducteur(Lecture_Reducteur reducteur){
   this.reducteur=reducteur;
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
                      reducteur.startWright();
                      reducteur.affich();
                      reducteur.startWright();
                      reducteur.affich();
                     }catch(InterruptedException e){
                       System.out.print(e);
                     }   
                     
             }
            
 }
 
}
