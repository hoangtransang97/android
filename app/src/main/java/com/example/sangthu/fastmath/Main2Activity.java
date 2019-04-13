package com.example.sangthu.fastmath;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.sql.Time;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    String FONT_NAME="fonts/UVNBanhMi.TTF";
    TextView tvSo1, tvSo2, tvDau, tvKQ1, tvKQ2, tvKQ3, tvDiem, tvTime, tvThuTu, tvBangg,tvHoiCham;
    int viTriKQ, diem, thuTuBaiKT = 1, kiemSoatTime, kiemSoatVongLap = 0, soThuTuCauHoi = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ganPhim();
        khoiTaoSo();
        khoiTaoKetQua();
        batSuKienPhim();
        khoiTaoThoiGian();
        kieuchu();
    }

    private void kieuchu() {
        Typeface typeface =Typeface.createFromAsset(getAssets(),FONT_NAME);
        tvSo1.setTypeface(typeface);
        tvSo2.setTypeface(typeface);
        tvDau.setTypeface(typeface);
        tvKQ1.setTypeface(typeface);
        tvKQ2.setTypeface(typeface);
        tvKQ3.setTypeface(typeface);
        tvTime.setTypeface(typeface);
        tvDiem.setTypeface(typeface);
        tvThuTu.setTypeface(typeface);
        tvBangg.setTypeface(typeface);
        tvHoiCham.setTypeface(typeface);
    }

    private void khoiTaoThoiGian(){
        kiemSoatTime = 0;

        CountDownTimer count;
        count = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                kiemSoatTime++;
                int temp = 30 - kiemSoatTime;
                tvTime.setText(temp+"");
                kiemSoatVongLap = 0;
            }

            @Override
            public void onFinish() {
                kiemSoatVongLap = 1;
                tvTime.setText(0+"");
                new AlertDialog.Builder(Main2Activity.this)
                        .setTitle("Hết thời gian")
                        .setMessage("Hết thời gian\nBạn làm bài rât tốt: " + diem)
                        .setPositiveButton("Chơi lại", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(Main2Activity.this, Main2Activity.class);
                                startActivityForResult(i, 123);
                                finish();
                            }
                        })
                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent();
                                setResult(Activity.RESULT_OK, i);
                                finish();
                            }
                        }).show();
            }
        };
        count.start();
    }

    private void goiLaiBaiToan(){
        khoiTaoSo();
        khoiTaoKetQua();
        batSuKienPhim();
    }

    private void batSuKienPhim(){
        tvKQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++thuTuBaiKT;
                if(kiemSoatTime < 30){
                    if (viTriKQ == 0) {
                        diem++;
                        tvDiem.setText(diem + "/" + thuTuBaiKT);
                        goiLaiBaiToan();
                    } else {
                        goiLaiBaiToan();
                        tvDiem.setText("Bạn làm sai.");
                    }
                }
                else{
                    new AlertDialog.Builder(Main2Activity.this)
                            .setTitle("Hết thời gian")
                            .setMessage("Hết thời gian\nBạn làm bài rât tốt: " + diem)
                            .setPositiveButton("Chơi lại", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(Main2Activity.this, Main2Activity.class);
                                    startActivityForResult(i, 123);
                                    finish();
                                }
                            })
                            .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent();
                                    setResult(Activity.RESULT_OK, i);
                                    finish();
                                }
                            }).show();
                }
            }
        });
        tvKQ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++thuTuBaiKT;
                if(kiemSoatTime < 30){
                    if (viTriKQ == 1) {
                        diem++;
                        tvDiem.setText(diem + "/" + thuTuBaiKT);
                        goiLaiBaiToan();
                    } else {
                        goiLaiBaiToan();
                        tvDiem.setText("Bạn làm sai.");
                    }
                }
                else{
                    new AlertDialog.Builder(Main2Activity.this)
                            .setTitle("Hết thời gian")
                            .setMessage("Hết thời gian\nBạn làm bài rât tốt: " + diem)
                            .setPositiveButton("Chơi lại", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(Main2Activity.this, Main2Activity.class);
                                    startActivityForResult(i, 123);
                                    finish();
                                }
                            })
                            .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent();
                                    setResult(Activity.RESULT_OK, i);
                                    finish();
                                }
                            }).show();
                }
            }
        });
        tvKQ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++thuTuBaiKT;
                if(kiemSoatTime < 30){
                    if (viTriKQ == 2) {
                        diem++;
                        tvDiem.setText(diem + "/" + thuTuBaiKT);
                        goiLaiBaiToan();
                    } else {
                        goiLaiBaiToan();
                        tvDiem.setText("Bạn làm sai.");
                    }
                }
                else{
                    new AlertDialog.Builder(Main2Activity.this)
                            .setTitle("Hết thời gian")
                            .setMessage("Hết thời gian\nBạn làm bài rât tốt: " + diem)
                            .setPositiveButton("Chơi lại", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(Main2Activity.this, Main2Activity.class);
                                    startActivityForResult(i, 123);
                                    finish();
                                }
                            })
                            .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent();
                                    setResult(Activity.RESULT_OK, i);
                                    finish();
                                }
                            }).show();
                }
            }
        });
    }

    private void ganPhim(){
        tvThuTu = findViewById(R.id.tvThuTuCauHoi);
        tvSo1 = findViewById(R.id.tvSo1);
        tvSo2 = findViewById(R.id.tvSo2);
        tvDau = findViewById(R.id.tvDau);
        tvKQ1 = findViewById(R.id.tvKetQua1);
        tvKQ2 = findViewById(R.id.tvKetQua2);
        tvKQ3 = findViewById(R.id.tvKetQua3);
        tvDiem = findViewById(R.id.tvDiem);
        tvTime = findViewById(R.id.tvTime);
        tvBangg=findViewById(R.id.tvBangg);
        tvHoiCham=findViewById(R.id.tvHoicham);
    }

    private void khoiTaoSo(){
        Random r = new Random();
        int so1, so2, dau;
        so1 = r.nextInt(10);
        so2 = r.nextInt(10);
        dau = r.nextInt(3);
        if(dau == 0){
            tvDau.setText("+");
        }
        if(dau == 1){
            tvDau.setText("-");
        }
        if(dau == 2){
            tvDau.setText("x");
        }
        if(dau == 3){
            tvDau.setText(":");
        }
        tvSo1.setText(so1+"");
        tvSo2.setText(so2+"");
    }

    private void khoiTaoKetQua(){
        tvThuTu.setText("Câu hỏi số: " + thuTuBaiKT);
        Random r = new Random();
        int temp1, temp2;
        Integer kq, so1, so2;
        String ketQua = "";
        String tempDau = tvDau.getText().toString();
        so1 = Integer.parseInt(tvSo1.getText().toString());
        so2 = Integer.parseInt(tvSo2.getText().toString());
        if(tempDau == "+"){
            kq = so1 + so2;
            ketQua = kq+"";
        }
        else if(tempDau == "-") {
            kq = so1 - so2;
            ketQua = kq+"";
        }
        else if(tempDau == "x") {
            kq = so1 * so2;
            ketQua = kq+"";
        }
        else if(tempDau == ":") {
            if(so2 == 0)
                ketQua = "Không chia được cho 0";
            else{
                kq = so1/so2;
                ketQua = kq.toString();
            }
        }
        viTriKQ = r.nextInt(3);
        temp1 = r.nextInt(100);
        temp2 = r.nextInt(100);
        if(viTriKQ == 0){
            tvKQ1.setText(ketQua);
            tvKQ2.setText(temp1+"");
            tvKQ3.setText(temp2+"");
        }
        else if(viTriKQ == 1){
            tvKQ2.setText(ketQua);
            tvKQ1.setText(temp1+"");
            tvKQ3.setText(temp2+"");
        }
        else if(viTriKQ == 2){
            tvKQ3.setText(ketQua);
            tvKQ1.setText(temp1+"");
            tvKQ2.setText(temp2+"");
        }
    }
}