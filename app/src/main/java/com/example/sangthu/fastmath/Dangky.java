package com.example.sangthu.fastmath;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Dangky extends AppCompatActivity {
    String FONT_NAME="fonts/UVNBanhMi.TTF";
    Button btnDangKy;
    TextView tvDangKy;
    EditText edtTenTaiKhoan, edtMatKhau,edtNhapLaiMatKhau,edtsdt;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        tvDangKy = (TextView) findViewById(R.id.tvDangKy);
        btnDangKy = (Button) findViewById(R.id.buttondki);
        edtTenTaiKhoan = (EditText) findViewById(R.id.edtTenTaiKhoan);
        edtsdt = (EditText) findViewById(R.id.edtsdt);
        edtMatKhau = (EditText) findViewById(R.id.edtMatKhau) ;
        edtNhapLaiMatKhau = (EditText) findViewById(R.id.edtNhapLaiMK);
        kieuchu();
        validator();
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(awesomeValidation.validate()) {
                    if(!edtMatKhau.getText().toString().trim().equals(edtNhapLaiMatKhau.getText().toString().trim())) {
                        edtNhapLaiMatKhau.setError("Xác nhận mật khẩu không khớp");
                    }
                    else {
                        createUser();
                    }
                }
                else {
                    Toast.makeText(Dangky.this,"Error", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public void kieuchu(){
        Typeface typeface =Typeface.createFromAsset(getAssets(),FONT_NAME);
        btnDangKy.setTypeface(typeface);
        tvDangKy.setTypeface(typeface);
        edtTenTaiKhoan.setTypeface(typeface);
        edtMatKhau.setTypeface(typeface);
        edtNhapLaiMatKhau.setTypeface(typeface);
        edtsdt.setTypeface(typeface);
    }
    public void validator() {
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(Dangky.this,R.id.edtTenTaiKhoan, "^[A-Za-z0-9]+$",R.string.username_reg_err);
        awesomeValidation.addValidation(Dangky.this,R.id.edtMatKhau, "^([A-Za-z0-9]{6,})+$",R.string.password_reg_err);
        awesomeValidation.addValidation(Dangky.this,R.id.edtNhapLaiMK, "^([A-Za-z0-9]{6,})+$",R.string.password_reg_err);
        awesomeValidation.addValidation(Dangky.this,R.id.edtsdt, "^0[0-9]{9,}$",R.string.phone_reg_err);
    }


    public void createUser() {
        final String name = edtTenTaiKhoan.getText().toString().trim();
        final String phone = edtsdt.getText().toString().trim();
        final String password = edtMatKhau.getText().toString().trim();

        String url = "http://192.168.56.1:8080/tinhnhanh/xuly/dangky.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_SHORT).show();
                    if(jsonObject.getString("error").equals("false")) {
                        Intent intent = new Intent(Dangky.this,MainActivity.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();

                params.put("name",name);
                params.put("phone",phone);
                params.put("password",password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
