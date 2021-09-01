package com.example.trabalho2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.trabalho2.activities.ActivityInsertData;
import com.example.trabalho2.db.ConexSQlite;
import com.example.trabalho2.model.Disciplina;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ConexSQlite conexSQlite = ConexSQlite.getInstance(this);




        this.btnLogin = (Button) findViewById(R.id.btnLogin);

        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityInsertData.class);
                startActivity(intent);
            }
        });
    }
}