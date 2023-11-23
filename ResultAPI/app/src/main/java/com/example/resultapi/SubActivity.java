package com.example.resultapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    EditText edit;
    Button button_ok,button_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        edit = findViewById(R.id.edit);
        button_ok = findViewById(R.id.button_ok);
        button_cancel  = findViewById(R.id.button_cancel);
//        RESULT_OK -> 작업 성공
//        RESULT_CANCELED -> 작업 실패
//        RESULT_FIRST_USER -> 사용자 정의 코드
        button_ok.setOnClickListener(v-> {
            String sendData = edit.getText().toString().trim().replace(" ","");
            Log.i("checkData","checkData"+sendData);
            if (sendData.length() == 0) {
                Toast.makeText(getApplicationContext(), "공백은 전송이 불가능 합니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent sendIntent = new Intent();
            sendIntent.putExtra("INPUT_TEXT",sendData);
            setResult(RESULT_OK,sendIntent);
            finish();
        });

        button_cancel.setOnClickListener(v-> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}