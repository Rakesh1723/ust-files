package multithreading;

public class Downloader extends Thread {

    @Override
    public void run() {
       download();
    }

    public void download(){
        for(int i=0;i<=100;i+=10)
        {
            System.out.println("From : "+Thread.currentThread().getName()+" Downloaded : "+i+"%");
            if(Thread.currentThread().getName().equalsIgnoreCase("Downloader1") && i==50) {
                // Thread.yield(); // sleep and yield are static methods , it is a request to allow other threads to execute.
                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
//            try{
//                Thread.sleep(1000);
//            }catch(InterruptedException ex){
//                System.err.println(ex.getMessage());
//            }
        }
        System.out.println("Download complete");

    }
}
