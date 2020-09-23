package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {
    private CakeView controlView;
    private CakeModel controlModel;

    public CakeController(CakeView view){
        this.controlView = view;
        this.controlModel = view.getCakeModel();
        controlModel.candlesNum = 2;
    }

    @Override
    public void onClick(View view) {
        Log.d("blowout_text", "You've blown out the candles");
        controlView.getCakeModel().candlesLit = false;
        controlView.invalidate();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean switch_bool) {
        if(switch_bool){
            controlView.getCakeModel().candlesOn = true;
            Log.d("candles on", "You've added the candles");
        }
        else{
            controlView.getCakeModel().candlesOn = false;
            Log.d("candles off", "You've removed the candles");
        }
        controlView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean seek_bool) {

        if (i >= 0 && i <= 5) {
            controlView.getCakeModel().candlesNum = i;
            Log.d("Seek_bar_success", "You successfully changed the value on the seek bar :)");
        } else {
            Log.d("Out of bounds error", "There was an error in your seekbar selection");
        }

        controlView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Haha do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Haha do nothing
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        Log.d("onTouch check", "The touch was detected on the view");

        controlView.getCakeModel().touchPosX = motionEvent.getX();
        controlView.getCakeModel().touchPosY = motionEvent.getY();
        controlView.invalidate();

        return false;
    }
}

