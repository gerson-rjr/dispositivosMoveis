package com.example.trabalho2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabalho2.Controller.DiscCTRL;
import com.example.trabalho2.MainActivity;
import com.example.trabalho2.R;
import com.example.trabalho2.db.ConexSQlite;
import com.example.trabalho2.model.Disciplina;

public class ActivityInsertData extends AppCompatActivity {


    private EditText editTextNomeA; //NomeAluno
    private EditText editTextNomeD; //NomeDisciplina
    private EditText editTextN1;    //Nota1
    private EditText editTextN2;    //Nota2

    private Button buttonSalvar;

    private Disciplina disciplina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        editTextNomeA = (EditText) findViewById(R.id.editTextNomeA);
        editTextNomeD = (EditText) findViewById(R.id.editTextNomeD);
        editTextN1    = (EditText) findViewById(R.id.editTextN1);
        editTextN2    = (EditText) findViewById(R.id.editTextN2);

        buttonSalvar = (Button) findViewById(R.id.buttonSalvar);

        this.clickBtnSalvarListiner();
    }

    public void clickBtnSalvarListiner(){
        this.buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Disciplina disciplinaNew = saveDataDisc();
               if(disciplinaNew != null){
                    DiscCTRL discCTRL =  new DiscCTRL(ConexSQlite.getInstance(ActivityInsertData.this));
                    long idDisc = discCTRL.saveDiscCtrl(disciplinaNew);
                    if(idDisc >0){
                        Toast.makeText(ActivityInsertData.this, "Disciplina Inserida com sucesso",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ActivityInsertData.this, ActivityPrintData.class);
                        startActivity(intent);
                    }
               }
               else{
                   Toast.makeText(ActivityInsertData.this, "Todos os campos necessitam de dados", Toast.LENGTH_LONG).show();
               }
            }
        });
    }


    private Disciplina saveDataDisc(){
        this.disciplina = new Disciplina();
        if(this.editTextNomeD.getText().toString().isEmpty() == false){
            this.disciplina.setNomeD(this.editTextNomeD.getText().toString());
        }
        else{
            return null;
        }
        if(this.editTextNomeA.getText().toString().isEmpty() == false){
            this.disciplina.setNomeA(this.editTextNomeA.getText().toString());
        }
        else{
            return null;
        }
        if(this.editTextN1.getText().toString().isEmpty() == false){
            double n1 = Double.parseDouble(this.editTextN1.getText().toString());
            this.disciplina.setNota1(n1);
        }
        else{
            return null;
        }
        if(this.editTextN2.getText().toString().isEmpty() == false){
            double n2 = Double.parseDouble(this.editTextN2.getText().toString());
            this.disciplina.setNota2(n2);
        }
        else{
            return null;
        }




        return disciplina;
    }

}