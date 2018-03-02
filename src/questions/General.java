package questions;

public class General {

    public int clockAngle(int hour, int minute){
        int angle = ((hour * 30) - (minute*6) + ((minute*30)/60));
        if (angle < 0) angle = angle * -1;
        return angle;
    }

    public void bits(int[] arr){
        int T = arr[0];
        for(int i = 0; i < arr.length; i++){

        }
        
    }

    public void printBits(int N){

    }
}
