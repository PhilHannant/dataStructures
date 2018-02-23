package questions;

public class General {

    public int clockAngle(int hour, int minute){
        int angle = 0;
        int hourAngle = hour * 30;
        int minuteAngle = minute * 6;
        int extraAngle = (minute/60)*30;
        hourAngle+= extraAngle;
        return angle;
    }
}
