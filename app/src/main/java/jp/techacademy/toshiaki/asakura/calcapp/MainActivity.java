package jp.techacademy.toshiaki.asakura.calcapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText mEditText1, mEditText2;
    Button button1, button2, button3, button4;
    String str1, str2;
    double db1, db2;
    int sa_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText) findViewById(R.id.edittext1);
        mEditText2 = (EditText) findViewById(R.id.edittext2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try {

             if (v.getId() == R.id.button1) {
                     sa_tv = 1;
            } else if (v.getId() == R.id.button2) {
                    sa_tv = 2;
            } else if (v.getId() == R.id.button3) {
                    sa_tv = 3;
            } else if (v.getId() == R.id.button4) {
                    sa_tv = 4;
            }

            str1 = mEditText1.getText().toString();
            str2 = mEditText2.getText().toString();

            db1 = Double.parseDouble(str1);
            db2 = Double.parseDouble(str2);

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("VALUE1", db1);
            intent.putExtra("VALUE2", db2);
            intent.putExtra("VALUE3", sa_tv);
            startActivity(intent);
        }
        catch(Exception e) {
            showAlertDialog();
        }
    }

    private void showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("四則計算の問題点");
        alertDialogBuilder.setMessage("入力欄が\n【空白】または【数値以外】\nになっています");

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("ＯＫ！",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

        // AlertDialogを作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}