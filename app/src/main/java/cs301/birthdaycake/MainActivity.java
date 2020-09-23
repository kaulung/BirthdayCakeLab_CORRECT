package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        //Creating reference to Cakeview and CakeController
        CakeView mainView = findViewById(R.id.cakeview);
        CakeController mainController = new CakeController(mainView);

        //Creating reference to Blow Out button
        Button blowButton = findViewById(R.id.blowout_button);
        blowButton.setOnClickListener(mainController);

        Switch candleSwitch = findViewById(R.id.candle_Switch);
        candleSwitch.setOnCheckedChangeListener(mainController);

        SeekBar candleSeek = findViewById(R.id.candle_seek);
        candleSeek.setOnSeekBarChangeListener(mainController);

        mainView.setOnTouchListener(mainController);

    }

    public void goodbye(View button){
        Log.i("goodbye_button","Goodbye");
    }

}
