package com.example.snackbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    LinearLayout main_layout;
    CheckBox check1, check2, check3;
    Button next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        this.initialize();

        next_btn.setOnClickListener(v -> {
            Intent joinActivity = new Intent(MainActivity.this, SubActivity.class);

            if (check1.isChecked() && check2.isChecked()) {
                Toast.makeText(getApplicationContext(), "광고 수신 동의, 회원가입 페이지로 이동", Toast.LENGTH_SHORT).show();
                startActivity(joinActivity);
            } else if (!check1.isChecked() || !check2.isChecked()) {
                Snackbar snackbar = Snackbar.make(main_layout, "필수 약관 모두 동의해야 합니다.", Snackbar.LENGTH_LONG);
                snackbar.show();
            } else {
                Snackbar snackbar = Snackbar.make(main_layout, "선택 약관 동의 없이 진행됩니다.", Snackbar.LENGTH_LONG);
                snackbar.setAction("확인", view2 -> {

                });
                snackbar.show();
            }
        });
    }

    public void initialize() {
        main_layout = findViewById(R.id.main_layout);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        next_btn = findViewById(R.id.nextBtn);
    }
}
