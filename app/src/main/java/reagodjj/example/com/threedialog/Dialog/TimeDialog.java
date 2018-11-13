package reagodjj.example.com.threedialog.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import reagodjj.example.com.threedialog.R;

public class TimeDialog extends Dialog {
    private int dayOfWeek, dayOfMonth, monthOfYear, year;
    private int chooseDayOfMonth, chooseMonthOfYear, chooseYear;
    private TextView tvTime;
    private DatePicker dpTime;
    private Button btSure;
    private String weekdays[] = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};

    public TimeDialog(@NonNull final Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.date_picker);
        setCancelable(false);

        tvTime = findViewById(R.id.tv_time);
        dpTime = findViewById(R.id.dp_time);
        btSure = findViewById(R.id.b_sure);

        getCurrentTime();
        tvTime.setText(String.format(context.getResources().getString(R.string.time),
                weekdays[dayOfWeek - 1], monthOfYear + 1, dayOfMonth, year));

        dpTime.init(year, monthOfYear, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth);
                chooseYear = year;
                chooseMonthOfYear = monthOfYear;
                chooseDayOfMonth = dayOfMonth;
                tvTime.setText(String.format(context.getResources().getString(R.string.time),
                        weekdays[calendar.get(Calendar.DAY_OF_WEEK) - 1], monthOfYear + 1, dayOfMonth, year));
            }
        });

        btSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, String.format(context.getResources().getString(R.string.date),
                        chooseYear, chooseMonthOfYear + 1, chooseDayOfMonth), Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
    }

    private void getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        dayOfMonth = calendar.get(Calendar.DATE);
        monthOfYear = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        chooseYear = year;
        chooseMonthOfYear = monthOfYear;
        chooseDayOfMonth = dayOfMonth;
    }
}
