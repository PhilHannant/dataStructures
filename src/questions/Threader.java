package questions;

public class Threader implements Runnable{

    private Thread t;
    private String name;


    public Threader(String name){
        this.name = name;
    }



    @Override
    public void run() {
        System.out.println("Threading");
        try{
            for(int i = 4; i > 0; i--){
                System.out.println("name="+name + "-" +i);
                Thread.sleep(50);

            }

        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }


    public void start(){
        System.out.println("Starting");
        if(t == null){
            t = new Thread(this, name);
            t.start();
        }
    }

}