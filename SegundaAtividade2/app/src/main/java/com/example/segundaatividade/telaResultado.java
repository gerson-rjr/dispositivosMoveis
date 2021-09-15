package com.example.segundaatividade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class telaResultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_resultado);
        Button button = findViewById(R.id.voltar);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String peso = intent.getStringExtra("peso");
        String altura = intent.getStringExtra("altura");
        String imc = intent.getStringExtra("imc");
        String basal = intent.getStringExtra("basal");
        String idade = intent.getStringExtra("idade");

        TextView tv = findViewById(R.id.saudacao);
        tv.setText(nome);
        TextView tv2 = findViewById(R.id.resultados);
        tv2.setText("Idade | " + idade  + " anos\n" + "Peso | " + peso + "kg\n" +
                "Altura | " + altura + "m\n" +
                "IMC | " + imc + " \n" +
                "TMB | " + basal +"Kcal\n");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltar();
            }
        });
    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}