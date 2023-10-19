package com.example.implicitintnent;

import android.Manifest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button dialBtn, callBtn;
    EditText editText;
    String number; // edit에 입력한 전화번호를 저장할 변수
    static final int PERMISSION_CALL_PHONE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editText = (EditText) findViewById(R.id.editText);
        dialBtn = (Button) findViewById(R.id.btn1);
        callBtn = (Button) findViewById(R.id.btn2);
        
        dialBtn.setOnClickListener(v->{
            // editText에 입력한 내용이 전달 => number 변수
            // 인텐트 객체 생성 => 암시적 인텐트(이동할 액티비티X)
            // Intent intent = new Intent(현재 화면의 뷰, 전달할 데이터)
            // Uri(Uniform resource Identifier) : 리소스를 구분하는 식별자로 리소스에 접근할 수 있는 식별자 역할
            // Uri.parse() : String 문자열을 Uri 객체로 변환
            // 전화번호 : "tel:"+데이터
            // editText에 입력한 값을 String형태로 number변수에 저장
            number = editText.getText().toString();
            // 문자열 타입의 텍스트를 가져오는 메소드: getText().toString()
            Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
            startActivity(callIntent);
        });

        callBtn.setOnClickListener(v->{
            number = editText.getText().toString();

            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                // 권한 X
                // 권한 요청
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, PERMISSION_CALL_PHONE);
//                Toast.makeText(getApplicationContext(), "권한이 거부되어 실행할 수 없습니다.",
//                        Toast.LENGTH_LONG).show();
            }else{
                // 권한 O
                Intent callIntent2 = new Intent(Intent.ACTION_CALL);
                callIntent2.setData(Uri.parse("tel:"+number));
                startActivity(callIntent2);
            }

            // ACTION_CALL일 경우에는 따로 권한 설정이 필요함
            // 권한을 가지고 있는지 체크하는 메소드
            // ActivituCompat.checkSelfPermission(Context, String)

            // 권한을 요청하는 메소드
            // ActivityCompat.requestPermissions(Activity,String[],int);

            // 권한 요청 결과를 확인받는 콜백 메소드
            // ActivityCompat.OnRequestPermissionsResultCallback


        });
    }
}