package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity {

    private EditText nage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        nage = findViewById(R.id.age);
    }

    public void togender(View view) {
        SharedPreferences pref = getSharedPreferences("test", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        String age = nage.getText().toString();
        editor.putString("age", age)
                .commit();
        Log.d("Age", "togender: "+age);
        AgeActivity.this.setResult(RESULT_OK);
        Intent intent = new Intent(AgeActivity.this, GenderActivity.class);
        startActivity(intent);
        finish();
    }
}