package multithreading;

public class Main {
    public static void main(String[] args) {
      Thread downloader1=new Downloader();
      Thread downloader2=new Downloader();



       downloader1.setName("downloader1");
       downloader2.setName("downloader2");
       // downloader2.setPriority(Thread.MAX_PRIORITY);
      // downloader1.setPriority(Thread.MIN_PRIORITY);

        downloader1.start();
        downloader2.start();


//        Runnable runnable=new DownloaderWithRunnable();
//        Thread downloader1=new Thread(runnable);
//        Thread downloader2=new Thread(runnable);

//        Downloader task=new Downloader();
//        Thread downloader1=new Thread(()->task.download()); //no need to write run method or extends/implements thread/runnable
//        Thread downloader2=new Thread(task::download);

//        downloader1.setName("downloader1");
//        downloader2.setName("downloader2");
//        downloader2.setPriority(Thread.MAX_PRIORITY);
//        downloader1.setPriority(Thread.MIN_PRIORITY);
//
//        downloader1.start();
//        downloader2.start();



    }
}
