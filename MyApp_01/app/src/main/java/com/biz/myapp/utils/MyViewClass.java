package com.biz.myapp.utils;


import android.view.View;
import android.widget.TextView;

import com.biz.myapp.R;
import com.google.android.material.snackbar.Snackbar;

public class MyViewClass implements View.OnClickListener {

    /*
        View class 이야기
            안드로이드에서 눈에보이는 모든 것(Layout, button, textview, Textedit....)은 모두 View Class를 상속받아서 만들어진 component 들이다.
            어떤 이벤트나 액션 등을 지정할 때 기존의 Class나 Interface를 extend 또는 implements 해야 하는데
            그때 자기 자신의 클래스를 사용하지 않고 View 클래스의 요소들을 상속받아서 클래스를 작성하는 것이 원칙이다.
     */

    @Override
    public void onClick(View v) {

        /*
            현재 onClick method는 bnt1 Button을 클릭했을 때 호출되는 methoh인데,
            btn1을 클릭하면 클릭된 Button의 모든 요소가 View인 v 객체 변수에 담겨 onClick method로 전달된다.
         */

        /*
            이벤트가 발생하면 onclick() method가 실행(호출) 될 것이고 누가, 호출했는가를 알고 싶을때, v.getId() method를 사용하면 호출한 view(Component)의 id 값을 얻어 올 수 있다.
         */

        String msg = "반갑습니다.";
        if(v.getId() == R.id.btn1){
            msg += "\n 나는 버튼입니다.";
        }else if(v.getId() == R.id.txt1){

            /*
                이벤트가 발생한 view(comp)로 부터 어떤 값을 얻어 오고자 하면 해당 view로 형 변환(type cast)를 한번 수행하여 객체를 만들고
                만든 객체에서 각 view의 고유한 method를 호출 할 수 있다.
             */

            TextView t = (TextView)v;
            msg += "\n" + t.getText();
        }else if(v.getId() == R.id.txt2){
            TextView t = (TextView)v;
            msg += "\n" + t.getText();
        }

        Snackbar.make(v, msg, Snackbar.LENGTH_SHORT).show();

    }


}
