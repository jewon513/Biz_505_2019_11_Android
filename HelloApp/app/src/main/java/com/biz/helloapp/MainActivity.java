package com.biz.helloapp;

import android.content.Intent;
import android.os.Bundle;

import com.biz.helloapp.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//      setContentView(R.layout.activity_main);

        setContentView(R.layout.my_layout);

        // layout xml에서 선언한 객체 component를 사용하기 위해 객체로 만든다.
        txtInput = findViewById(R.id.txtInput);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);

        // btn1 이 터치나 클릭이 됐을때 발생되는 이벤트를 설정
        // 매개변수로 익명 Class를 생성하여 클릭 이벤트를 설정했다.S
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt = txtInput.getText().toString();

                // 토스트 기계처럼 alert창이 떴다 사라짐. Toast 박스
                // Android에서는 context를 현재 지금 보여지는 화면이라고 생각하면 편하다.
                Toast.makeText(MainActivity.this,
                        txt,
                        Toast.LENGTH_SHORT).show();
            }
        });


        //TODO 화면 하단 Snackbar 보여주기
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // button의 child임
                Snackbar.make(v, "안녕하세요", Snackbar.LENGTH_LONG).show();
            }
        });


        //TODO 새로운 창(Activity)를 화면에 띄우고 싶을때
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 현재 보이고 있는 화면 MainActivity.this 에서 새로운 Activity가 보이도록 Intent를 생성하라.
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);

                // 생성된 새로운 Intent가 보이도록 하라
                startActivity(loginIntent);

            }
        });

        //TODO 전화걸기
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent PIntent = new Intent(Intent.ACTION_CALL_BUTTON);
                startActivity(PIntent);
            }
        });

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
