package reagodjj.example.com.threedialog;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import reagodjj.example.com.threedialog.Dialog.HobbyDialog;
import reagodjj.example.com.threedialog.Dialog.SexDialog;
import reagodjj.example.com.threedialog.Dialog.TimeDialog;

public class MainActivity extends AppCompatActivity implements HobbyDialog.OnHobbyClickListener {
    @SuppressLint("StaticFieldLeak")
    private TextView tvShowHobby;
    private HobbyDialog hobbyDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tvShowHobby = findViewById(R.id.tv_show_hobby);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.b_time_picker:
                showDatePickerDialog();
                break;

            case R.id.b_single_choice:
                showSingleChoiceDialog();
                break;

            case R.id.b_multi_choice:
                showMultiChoiceDialog();
                break;
        }
    }

    private void showMultiChoiceDialog() {
        hobbyDialog = new HobbyDialog(MainActivity.this, R.style.SexDialog);
        hobbyDialog.show();
        hobbyDialog.setOnHobbyClickListener(this);
    }

    private void showSingleChoiceDialog() {
        SexDialog sexDialog = new SexDialog(MainActivity.this, R.style.SexDialog);
        sexDialog.show();
    }

    private void showDatePickerDialog() {
        TimeDialog timeDialog = new TimeDialog(MainActivity.this, R.style.TimeDialog);
        timeDialog.show();
    }

    @Override
    public void onClick(String message) {
        tvShowHobby.setText(message);
    }
}
