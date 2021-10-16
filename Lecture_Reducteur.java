import java.io.*;
public class Lecture_Reducteur  {
 int  waitToRead;
 int  no_Thread_Reading;
 int  waitToWright;
 int  no_Thread_writing;
 PrintStream printStream;

 public Lecture_Reducteur(PrintStream printStream){
    no_Thread_writing=0;
    waitToWright=0;
    waitToRead=0;
    no_Thread_Reading=0;
    this.printStream=printStream;
}

 public synchronized void startWright(){
     waitToWright++;
     try{
        if(no_Thread_writing>0 ||no_Thread_Reading>0||waitToRead>0)wait();
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

 public synchronized void startReading(){
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

 public synchronized void affich(){
    System.setOut(printStream);
    System.out.print("|nb_de_lecteurs_en_attente: "+","+waitToRead+" |nb_de_lecteurs: "+","+no_Thread_Reading+","+
    " |nb_de_redacteurs_en_attente: "+","+waitToWright+","+" |nb_de_redacteurs: "+"," + no_Thread_writing);
    System.out.println();
  
 }

}
