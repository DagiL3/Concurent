
public class Lecture_Reducteur  {
 int  waitToRead;
 int  no_Thread_Reading;

 int  waitToWright;
 int  no_Thread_writing;

public Lecture_Reducteur(){
    no_Thread_writing=0;
    waitToWright=0;
    waitToRead=0;
    no_Thread_Reading=0;
}

 public synchronized void startWright(){
     waitToWright++;
     try{
        if(no_Thread_writing>0 ||no_Thread_Reading>0 ||waitToRead>0)wait();
     }catch(InterruptedException e){
        throw new RuntimeException(e);
     }
      waitToWright--;
      no_Thread_writing++;
   
 }
    public synchronized void stopWright(){
      no_Thread_writing--;
   
    if(no_Thread_writing==0 &&(waitToRead>0 || waitToWright>0))
             notify();
            
}

public synchronized  void startReading(){
    waitToRead++;
    try{
       if(no_Thread_writing>0)wait();
    }catch(InterruptedException e){
        throw new RuntimeException(e);
    }
    waitToRead--;
    no_Thread_Reading++;
}

public synchronized void stopReading(){
    no_Thread_Reading--;
    if(no_Thread_Reading==0&&waitToWright>0)
    notify();
}

public void affich(){
  
    System.out.println("|attent_R: "+waitToRead+" |acceder_R: "+
     no_Thread_Reading+" |attent_W: "+waitToWright+" |acceder_w: "
     + no_Thread_writing);
}

}
