package com.example.sangthu.fastmath;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BatDauActivity extends AppCompatActivity {

    public  static  final String FONT_NAME="fonts/UVNBanhMi.TTF";
    TextView tv_game_name;
    Button bt_BatDau,bt_Thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bat_dau);

        ganPhim();
        kieuchu();
    }

    private void ganPhim() {
        tv_game_name = (TextView) findViewById(R.id.tv_game_name);
        bt_BatDau = (Button) findViewById(R.id.bt_BatDau);
        bt_BatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyenman();
            }
        });
        bt_Thoat = (Button) findViewById(R.id.bt_thoat);
        bt_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void kieuchu() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), FONT_NAME);
        tv_game_name.setTypeface(typeface);
        bt_BatDau.setTypeface(typeface);
        bt_Thoat.setTypeface(typeface);
    }
    private  void chuyenman(){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivityForResult(intent, 123);
    }
}
