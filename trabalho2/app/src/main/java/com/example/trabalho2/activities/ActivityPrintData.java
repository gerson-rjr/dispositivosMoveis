package com.example.trabalho2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

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


    }
    public String CalcMedia(){
        String result = new String("Prezado " + editTextNomeA + " sua media na disciplina " + editTextNomeD + " é: ");
        Double n1 = Double.parseDouble(this.editTextN1.getText().toString());
        Double n2 = Double.parseDouble(this.editTextN2.getText().toString());
        Double result1 = ((n1*2) + (n2*3))/5;
        result += result1.toString();

        return result;

    }



}