package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {

    private EditText ggender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        ggender = findViewById(R.id.nickgender);
    }

    public void tohome (View view) {
        SharedPreferences pref = getSharedPreferences("test", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        String gender = ggender.getText().toString();
        editor.putString("gender", gender)
                .commit();
        Log.d("Gender", "tohome: "+gender);
        GenderActivity.this.setResult(RESULT_OK);
        Intent intent = new Intent(GenderActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}