package reagodjj.example.com.threedialog.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import reagodjj.example.com.threedialog.MainActivity;
import reagodjj.example.com.threedialog.R;

public class HobbyDialog extends Dialog implements CompoundButton.OnCheckedChangeListener {
    private CheckBox cbProgram, cbLol, cbTravel, cbBasketball;
    private Button bSure;
    private boolean isProgram, isLol, isTravel, isBasketball;
    public String msg = "个人爱好：\n";

    public HobbyDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.hobby_choice);

        cbProgram = findViewById(R.id.cb_program);
        cbLol = findViewById(R.id.cb_lol);
        cbTravel = findViewById(R.id.cb_travel);
        cbBasketball = findViewById(R.id.cb_basketball);
        bSure = findViewById(R.id.b_sure);

        cbProgram.setOnCheckedChangeListener(this);
        cbLol.setOnCheckedChangeListener(this);
        cbTravel.setOnCheckedChangeListener(this);
        cbBasketball.setOnCheckedChangeListener(this);

        bSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isProgram)
                    msg += cbProgram.getText().toString() + "\n";
                if (isLol)
                    msg += cbLol.getText().toString() + "\n";
                if (isTravel)
                    msg += cbTravel.getText().toString() + "\n";
                if (isBasketball)
                    msg += cbBasketball.getText().toString() + "\n";
//                ShowMessage(tvShow);
                if (mOnHobbyClickListener!= null) {
                    mOnHobbyClickListener.onClick(msg);
                }
                msg = "个人爱好：\n";
                dismiss();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        CheckBox checkBox = (CheckBox) buttonView;
        switch (checkBox.getId()) {
            case R.id.cb_program:
                isProgram = isChecked;
                break;

            case R.id.cb_lol:
                isLol = isChecked;
                break;

            case R.id.cb_travel:
                isTravel = isChecked;
                break;

            case R.id.cb_basketball:
                isBasketball = isChecked;
                break;
        }
    }

    private OnHobbyClickListener mOnHobbyClickListener;

    public void setOnHobbyClickListener(OnHobbyClickListener onHobbyClickListener) {
        mOnHobbyClickListener = onHobbyClickListener;
    }

    public interface OnHobbyClickListener {
        void onClick(String message);
    }
}
