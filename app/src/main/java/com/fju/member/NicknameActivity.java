package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class NicknameActivity extends AppCompatActivity {

    private EditText ednickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        ednickname = findViewById(R.id.nickname);
    }
    public void toage (View view){
        SharedPreferences pref = getSharedPreferences("test", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        String name = ednickname.getText().toString();
        editor.putString("name", name)
                .commit();
        Log.d("Name", "toage: "+name);
        NicknameActivity.this.setResult(RESULT_OK);
        Intent intent = new Intent(NicknameActivity.this,AgeActivity.class);
        startActivity(intent);
        finish();
    }
}
