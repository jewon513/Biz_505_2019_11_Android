package com.biz.img;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.biz.img.domain.Addresses;
import com.biz.img.utils.InputFieldName;
import com.biz.img.utils.RequestCode;
import com.google.android.material.textfield.TextInputEditText;

public class InputActivity extends AppCompatActivity {

    TextInputEditText txt_name;
    TextInputEditText txt_tel;
    TextInputEditText txt_addr;

    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        txt_name = findViewById(R.id.txt_name);
        txt_tel = findViewById(R.id.txt_tel);
        txt_addr = findViewById(R.id.txt_addr);
        btn_save = findViewById(R.id.btn_save);

        // btn_save 를 클릭하면 현재 화면을 닫고 MainActivity 로 txt_name, txt_tel, txt_addr 를 전달해 주기.

        btn_save.setOnClickListener( (View v) ->{

            String strName= txt_name.getText().toString();
            String strTel = txt_tel.getText().toString();
            String strAddr = txt_addr.getText().toString();

            Addresses addr = Addresses.builder().a_name(strName).a_tel(strTel).a_addr(strAddr).build();



            // 나를 호출한 Activity의 contxt를 가져와서 값을 return 하기 위한 준비
            Intent myIntent = getIntent();

            // model에 "변수", 값 형식으로 Attribute를 설정한 것과 같은 원리로 되돌리는 값 등을 설정
            myIntent.putExtra(InputFieldName.TXT_NAME,  strName);
            myIntent.putExtra(InputFieldName.TXT_TEL,  strTel);
            myIntent.putExtra(InputFieldName.TXT_ADDR, strAddr);

            // VO 클래스에 Serialiable이 설정되어 있는지 확인하자.
            myIntent.putExtra("ADDR", addr);

            // 현재 Activity를 닫고 위에 putExtra로 설정한 값들을 MainActivity로 되돌려 보내라
            // startActivityForResult(myIntent, RequestCode.REQUEST_INPUT_CODE);
            setResult(RequestCode.RESULT_OK,myIntent);
            finish();


        });

    }
}
