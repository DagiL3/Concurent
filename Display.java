
public class Display  extends Thread{
    Lecture_Reducteur display;
 
    @Override
    public void run(){
        long start=System.currentTimeMillis();
        long end=start+30000;
            while(end>System.currentTimeMillis()){
              
     try{
        Thread.sleep(1000);
    }catch(InterruptedException e){
        System.out.print(e);
    }
         display.affich();
        
     }
    
   }
}

