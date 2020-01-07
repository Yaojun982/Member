package com.fju.member;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_REQUIST = 110;
    private static final String TAG =  MainActivity.class.getSimpleName();
    private EditText edname;
    private EditText edage;
    private EditText edgender;
    private String string_name;
    private String string_age;
    private String string_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edname = findViewById(R.id.name);
        edage = findViewById(R.id.age);
        edgender = findViewById(R.id.gender);
        string_name = edname.getText().toString();
        string_age = edage.getText().toString();
        string_gender = edgender.getText().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_REQUIST){
            if (resultCode == RESULT_OK){
                SharedPreferences pref = getSharedPreferences("test", Context.MODE_PRIVATE);
                String s = pref.getString("name","");
                String a = pref.getString("age","");
                String p = pref.getString("gender","");
                Log.d(TAG, "onActivityResult: "+s+","+a+","+p);
                edname.setText(s+"");
                edage.setText(a+"");
                edgender.setText(p+"");
            }
        }
    }

    public void start (View view){
        if (string_name.equals("")&&string_age.equals("")&&string_gender.equals("") ){
            Intent intent = new Intent(MainActivity.this,NicknameActivity.class);
            startActivityForResult(intent,REQUEST_CODE_REQUIST);
        }
    }
}
