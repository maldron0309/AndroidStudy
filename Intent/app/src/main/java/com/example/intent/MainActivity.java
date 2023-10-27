package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.ActionBar;

import android.Manifest;
import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.internal.ManufacturerUtils;

import java.sql.Connection;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button name_btn, web_btn;
    EditText name, web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        name_btn = (Button) findViewById(R.id.name_btn);
        web_btn = (Button) findViewById(R.id.web_btn);
        name = (EditText) findViewById(R.id.name);
        web = (EditText) findViewById(R.id.web);

        name_btn.setOnClickListener(view -> {
            String nameText = name.getText().toString().trim().replaceAll(" ", "");

            if (nameText.length()==0) {
                Toast.makeText(MainActivity.this, "텍스트를 입력해주세요.", Toast.LENGTH_SHORT).show();
            } else {
                Intent nameIntent = new Intent(MainActivity.this, SubActivity.class);
                nameIntent.putExtra("name", nameText);
                startActivity(nameIntent);
                name.setText(null);
            }
        });

        web_btn.setOnClickListener(view -> {
            String webText = web.getText().toString().trim().replaceAll(" ", "");
            if(webText.length() == 0){
                Toast.makeText(MainActivity.this, "텍스트를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }else if (!(URLUtil.isValidUrl(webText))) {
//                if(!webText.startsWith("http://") || !webText.startsWith("https://"))
                if(Patterns.WEB_URL.matcher(webText).matches()) {
                    goToWeb(URLUtil.guessUrl(webText));
                }else{
                    Toast.makeText(MainActivity.this, "올바른 URL주소가 아닙니다.", Toast.LENGTH_SHORT).show();
                }
            }else{
                goToWeb(URLUtil.guessUrl(webText));
                web.setText(null);
            }
        });
    }
    public void goToWeb(String webText){
        Intent web_Intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webText));
        startActivity(web_Intent);
    }
}