import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {

    int startSecond;
    static Timer t;

    public CountdownTimer(int startSecond) {
        this.startSecond = startSecond;
    }

    public boolean start() {
        
        System.out.println(this.startSecond);
        
        t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            public void run() { 
                System.out.println(getSecondsLeft()); 
            }
        }, 1000, 1000);
        
        return true;
    }

    private final int getSecondsLeft() {

        if (this.startSecond == 1) t.cancel();
        return --this.startSecond;
    }
}
