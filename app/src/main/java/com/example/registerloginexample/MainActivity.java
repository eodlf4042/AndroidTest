package com.example.registerloginexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private TextView tv_id, tv_pass;
    private Button btn_logout;
    private BottomNavigationView bottomNavigationView; // 바텀 네비게이션 뷰
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;

    private FragmentManager fm;
    private FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv_id = findViewById(R.id.tv_id);
        tv_pass = findViewById(R.id.tv_pass);
        btn_logout = findViewById(R.id.btn_logout);



        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPass = intent.getStringExtra("userPass");

        tv_id.setText(userID);
        tv_pass.setText(userPass);



        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.action_airplane) {
                    setFrag(0);
                } else if (itemId == R.id.action_bus) {
                    setFrag(1);
                } else if (itemId == R.id.action_bt) {
                    setFrag(2);
                } else if (itemId == R.id.action_call) {
                    setFrag(3);
                } else if (itemId == R.id.action_run) {
                    setFrag(4);
                } else {
                    // 항목이 선택되지 않은 경우, 아무것도 하지 않음.
                    return false;
                }

                return true;
            }
        });

        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();
        setFrag(0); //첫 Fragment 화면을 무엇으로 지정해줄 것인지 선택
    }

    //Fragment 교체가 일어나는 실행문이다!
    private  void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction(); //실제적인 Fragment 교체를 이루어질때
        switch (n){
            case 0 :
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;
            case 1 :
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 2 :
                ft.replace(R.id.main_frame, frag3);
                ft.commit();
                break;
            case 3 :
                ft.replace(R.id.main_frame, frag4);
                ft.commit();
                break;
            case 4 :
                ft.replace(R.id.main_frame, frag5);
                ft.commit();
                break;

        }
    }




}