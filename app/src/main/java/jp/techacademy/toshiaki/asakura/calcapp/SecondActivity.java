package jp.techacademy.toshiaki.asakura.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();

        double value1 = intent.getDoubleExtra("VALUE1", 0);
        double value2 = intent.getDoubleExtra("VALUE2", 0);
        int value3 = intent.getIntExtra("VALUE3", 0);

        TextView textView = (TextView) findViewById(R.id.textView_S);

        if (value3 == 1) {
            textView.setText(String.valueOf(value1 + value2));
        } else if (value3 == 2) {
            textView.setText(String.valueOf(value1 - value2));
        } else if (value3 == 3) {
            textView.setText(String.valueOf(value1 * value2));
        } else if (value3 == 4) {
            if (value2 == 0) {
                textView.setText("0で除算しました");
            } else
                textView.setText(String.valueOf(value1 / value2));
        }
    }
}
