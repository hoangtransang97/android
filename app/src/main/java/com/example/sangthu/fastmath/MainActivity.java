package com.example.sangthu.fastmath;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class MainActivity extends AppCompatActivity {
    String FONT_NAME="fonts/UVNBanhMi.TTF";
    Button btnLogin, btn_dangky;
    EditText edtUser, edtPass;
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_dangky = (Button) findViewById(R.id.buttondki);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPass = (EditText) findViewById(R.id.edtPass);
        validator();
        kieuchu();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(awesomeValidation.validate()) {
                    login();
                }

             }

        });

        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(MainActivity.this,Dangky.class);
                startActivity(t);
            }
        });


    }
    public void kieuchu(){
        Typeface typeface =Typeface.createFromAsset(getAssets(),FONT_NAME);
        btn_dangky.setTypeface(typeface);
        btnLogin.setTypeface(typeface);
        edtPass.setTypeface(typeface);
        edtUser.setTypeface(typeface);

    }
    public void validator() {
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(MainActivity.this,R.id.edtUser, "^[A-Za-z0-9]{6,12}+$",R.string.username_reg_err);
        awesomeValidation.addValidation(MainActivity.this,R.id.edtPass, "^([A-Za-z0-9]{6,})+$",R.string.password_reg_err);
    }
    public void login(){
        final String user, pass;
        user = edtUser.getText().toString();
        pass = edtPass.getText().toString();
        String url = "http://192.168.56.1:8080/tinhnhanh/xuly/dangnhap.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getString("error").equals("true")) {
                        Intent intent = new Intent(MainActivity.this,BatDauActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    Toast.makeText(MainActivity.this,jsonObject.getString("message"),Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("name", user);
                params.put("password", pass);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
