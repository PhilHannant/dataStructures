package questions;

public class ThreadTest {

    public static void main(String[] args){
        Threader t = new Threader("threader1");
        t.run();
        Threader t2 = new Threader("threader2");
        t2.run();
    }
}
