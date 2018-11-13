package reagodjj.example.com.threedialog.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import reagodjj.example.com.threedialog.R;

public class SexDialog extends Dialog {
    private RadioGroup rgSex;
    private RadioButton rbFemale, rbMale, rbSexUnkown, rbGuess;

    public SexDialog(@NonNull final Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.sex_choice);

        rgSex = findViewById(R.id.rg_sex);
        rbFemale = findViewById(R.id.rb_female);
        rbMale = findViewById(R.id.rb_male);
        rbSexUnkown = findViewById(R.id.rb_sex_unknown);
        rbGuess = findViewById(R.id.rb_guess);

        rgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_female:
                        Toast.makeText(context,
                                String.format(context.getResources().getString(R.string.sex_choice),
                                        rbFemale.getText().toString()), Toast.LENGTH_SHORT).show();
                        dismiss();
                        break;

                    case R.id.rb_male:
                        Toast.makeText(context,
                                String.format(context.getResources().getString(R.string.sex_choice),
                                        rbMale.getText().toString()), Toast.LENGTH_SHORT).show();
                        dismiss();
                        break;

                    case R.id.rb_sex_unknown:
                        Toast.makeText(context,
                                String.format(context.getResources().getString(R.string.sex_choice),
                                        rbSexUnkown.getText().toString()), Toast.LENGTH_SHORT).show();
                        dismiss();
                        break;

                    case R.id.rb_guess:
                        Toast.makeText(context,
                                String.format(context.getResources().getString(R.string.sex_choice),
                                        rbGuess.getText().toString()), Toast.LENGTH_SHORT).show();
                        dismiss();
                        break;
                }
            }
        });
    }
}
