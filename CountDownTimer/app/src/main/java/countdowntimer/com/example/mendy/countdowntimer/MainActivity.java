package countdowntimer.com.example.mendy.countdowntimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView show;
    CountDownT timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = (TextView) findViewById(R.id.textView2);

        timer = new CountDownT(10000,1000); //count down timer will run for 10 seconds. Time gap is 1 second
        show.setText("10");

    }

    public void start (View view) {
        timer.start();

    }

    public void stop (View view) {
        timer.cancel();

    }

    public class CountDownT extends CountDownTimer {

        public CountDownT (long InMilliseconds , long TimeGap) {
            super(InMilliseconds, TimeGap);
        }

        @Override
        public void onTick(long l){
            show.setText(l/1000 + "");
            //run timer

        }

        @Override
        public void onFinish() {
         //put your code here for what you want to do after 10 seconds
            show.setText("Timer Ended After 10 Seconds");
        }
    }
} //ready to run
