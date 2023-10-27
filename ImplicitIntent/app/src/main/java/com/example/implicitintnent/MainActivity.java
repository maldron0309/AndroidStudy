package com.example.implicitintnent;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.internal.ManufacturerUtils;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {

    Button map, google, message, photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeView();
    }
    public void InitializeView(){
        map = (Button) findViewById(R.id.map);
        google = (Button) findViewById(R.id.google);
        message = (Button) findViewById(R.id.message);
        photo = (Button) findViewById(R.id.photo);
    }

    public void click_btn(View view){
        // 클릭한 버튼의 id값을 case문과 비교
        switch (view.getId()){
            case R.id.map:
                Uri location = Uri.parse("geo:0.0?q=서울디지텍고등학교");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
                break;
            case R.id.google:
                Intent googleIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                googleIntent.putExtra(SecurityManager.QUERY, "서울디지텍고등학교");
                try {
                    startActivity(googleIntent);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(getApplicationContext(), "앱 불러오기에 실패했습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}