package com.example.fragmentwithnavdrawer;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragmentwithnavdrawer.Fragment.DuaFragment;
import com.example.fragmentwithnavdrawer.Fragment.SatuFragment;

public class HomeActivity extends AppCompatActivity {

    TextView txtShow;

//    Key Dari PutExtra nya
    public static String TAMPUNG = "1";
    Button btn1;
    Button btn2;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtShow = findViewById(R.id.txt_show);
        btn1 = findViewById(R.id.btn_fragment1);
        btn2 = findViewById(R.id.btn_fragment2);
        fm = getSupportFragmentManager();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction()
                        .add(R.id.relative_container, new SatuFragment())
                        .commit();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction()
                        .add(R.id.relative_container, new DuaFragment())
                        .commit();
            }
        });

//     Menangkap Intent Dari MainActivity
        String tampung = getIntent().getStringExtra(TAMPUNG);
        txtShow.setText(tampung);
    }
}
