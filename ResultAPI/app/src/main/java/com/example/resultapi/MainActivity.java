package com.example.resultapi;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    ActivityResultLauncher<Intent> startActivityForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("");
        }

        edit = findViewById(R.id.edit);

        startActivityForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            String getData = result.getData() != null ? result.getData().getStringExtra("INPUT_TEXT") : "";
                            edit.setText(getData);

                            Toast.makeText(getApplicationContext(), "데이터값을 성공적으로 불러옴", Toast.LENGTH_SHORT).show();
                        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                            Toast.makeText(getApplicationContext(), "데이터값을 불러올 수 없음", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        findViewById(R.id.getTextButton).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            startActivityForResult.launch(intent);
        });
    }
}
