package com.example.segundaatividade;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import android.os.Bundle;

import java.text.DecimalFormat;

public class tela2 extends AppCompatActivity {
    private EditText nome;
    private EditText peso;
    private EditText altura;
    private EditText idade;
    private Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        nome = findViewById(R.id.campoNome);
        peso = findViewById(R.id.campoPeso);
        altura = findViewById(R.id.campoAltura);
        idade = findViewById(R.id.campoIdade);
        calc = findViewById(R.id.calcular);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculoTotal(nome.getText().toString(), peso.getText().toString(), altura.getText().toString(), idade.getText().toString());
            }
        });
    }

    @SuppressLint("DefaultLocale")
    public void calculoTotal(String toString, String toString1, String toString2, String toString3) {
        String nome = toString;
        Double peso = Double.parseDouble(toString1);
        Double altura = Double.parseDouble(toString2);
        Integer age = Integer.parseInt(toString3);

        double basal = (66+13.7*peso+5*(altura*100)-6.8*age);
        double dImc = (peso/(altura*altura));

        String mBasal = String.format("%.2f", basal);
        String imc = String.format("%.2f", dImc);
        Intent intent = new Intent("calcular");
        intent.putExtra("idade", toString3);
        intent.putExtra("altura", toString2);
        intent.putExtra("peso", toString1);
        intent.putExtra("nome", nome);
        intent.putExtra("imc", imc);
        intent.putExtra("basal", mBasal);
        startActivity(intent);
    }
}