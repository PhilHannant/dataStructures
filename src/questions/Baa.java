package questions;

public class Baa extends Foo{

    private String str;

    public Baa(String str){
        super(str);
    }

    @Override
    public void foos(){
        System.out.println(str);
    }
}
