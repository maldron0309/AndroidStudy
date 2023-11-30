package com.example.dialog;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnArray[] = new Button[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");

        for (int i=0; i<btnArray.length; i++){
            String btnId = "btn"+(i+1);
            // getResources().getIdenfier(리소스 이름, 리소스 타입, 패키지명)
            btnArray[i] = (Button) findViewById(getResources().getIdentifier(btnId,"id",getPackageName()));
        }

        for (Button btnId : btnArray){
            btnId.setOnClickListener(v->{
                Button res = findViewById(v.getId());
                Toast.makeText(getApplicationContext(), "클릭:"+res.getText().toString(), Toast.LENGTH_SHORT).show();
                if (res.getId() == R.id.btn1) {
                    basic();
                } else if (res.getId() == R.id.btn2) {

                } else if (res.getId() == R.id.btn3) {

                }

            });
        }

        }
    public void basic(){
        AlertDialog.Builder basicDialog = new AlertDialog.Builder(this);
        basicDialog.setTitle("제목");
        basicDialog.setMessage("내용을 적어주세요.");

        
        basicDialog.setNeutralButton("다음에", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"다음에 클릭", Toast.LENGTH_LONG).show();
            }
        });
        
        basicDialog.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"취소 클릭",Toast.LENGTH_LONG).show();
            }
        });

        basicDialog.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"확인 클릭",Toast.LENGTH_LONG).show();
            }
        });
        
        AlertDialog alertDialog = basicDialog.create();
        alertDialog.show();
    }

}