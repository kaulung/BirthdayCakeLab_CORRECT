package cs301.birthdaycake;

import android.util.Log;
import android.view.View;

public class CakeController implements View.OnClickListener{
    private CakeView controlView;
    private CakeModel controlModel;


    public CakeController(CakeView view){
        this.controlView = view;
        this.controlModel = view.getCakeModel();
    }

    @Override
    public void onClick(View view) {
        Log.d("blowout_text", "Blow out ;)");
        controlModel.candlesLit = false;
        view.invalidate();
    }
}
