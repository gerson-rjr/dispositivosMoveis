package com.example.trabalho2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalho2.R;

public class ActivityPrintData extends AppCompatActivity {

    private EditText editTextNomeA; //NomeAluno
    private EditText editTextNomeD; //NomeDisciplina
    private EditText editTextN1;    //Nota1
    private EditText editTextN2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_data);

        editTextNomeA = (EditText) findViewById(R.id.editTextNomeA);
        editTextNomeD = (EditText) findViewById(R.id.editTextNomeD);
        editTextN1    = (EditText) findViewById(R.id.editTextN1);
        editTextN2    = (EditText) findViewById(R.id.editTextN2);

        this.CalcMedia();

    }
    public String CalcMedia(){
        Double n1 = Double.parseDouble(this.editTextN1.getText().toString());
        Double n2 = Double.parseDouble(this.editTextN2.getText().toString());
        Double result1 = ((n1*2) + (n2*3))/5;


        if(result1 > 6 && result1 <= 10){
            Toast.makeText(ActivityPrintData.this, "Sua media foi: " + result1 + ",você está Aprovado",Toast.LENGTH_LONG).show();
        }
        if(result1 < 6 && result1 > 3 ){
            Toast.makeText(ActivityPrintData.this, "Sua media foi: " + result1 + ",você está em Recuperação",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(ActivityPrintData.this, "Sua media foi: " + result1 + ",você está Reprovado",Toast.LENGTH_LONG).show();
        }

        String result = new String("Prezado " + editTextNomeA + " sua media na disciplina " + editTextNomeD + " é: ");
        result += result1.toString();

        return result;

    }



}