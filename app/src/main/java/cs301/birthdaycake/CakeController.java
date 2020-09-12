package cs301.birthdaycake;

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private CakeView controlView;
    private CakeModel controlModel;

    public CakeController(CakeView view){
        this.controlView = view;
        this.controlModel = view.getCakeModel();
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
}

