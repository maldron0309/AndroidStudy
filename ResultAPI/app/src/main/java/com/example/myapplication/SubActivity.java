package com.example.myapplication;

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
        Button button_ok = findViewById(R.id.button_ok);
        Button button_cancel = findViewById(R.id.button_cancel);

        button_ok.setOnClickListener(v->{
            // 성공
            String sendData = edit.getText().toString().trim().replaceAll(" ","");
            Log.i("checkData","checkData"+sendData);
            if (sendData.length() == 0){
                Toast.makeText(getApplicationContext(),"공백은 전송 불가",Toast.LENGTH_SHORT).show();
                return;
            }
            Intent sendIntent = new Intent();
            sendIntent.putExtra("INPUT_TEXT",sendData);
            sendResult(RESULT_OK,sendIntent);
            finish();
        });

        button_cancel.setOnClickListener(v->{
            setResult(RESULT_CANCELED);
            finish();
        });



    }

    private void sendResult(int resultOk, Intent sendIntent) {
    }
}