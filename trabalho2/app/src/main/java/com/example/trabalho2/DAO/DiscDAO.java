package com.example.trabalho2.DAO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.trabalho2.db.ConexSQlite;
import com.example.trabalho2.model.Disciplina;

public class DiscDAO {
    private  final ConexSQlite conexSQlite;
    public DiscDAO(ConexSQlite conexSQlite) {
         this.conexSQlite = conexSQlite;
    }

    public long saveDiscDAO(Disciplina dDisciplina){
        SQLiteDatabase db = conexSQlite.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("id", dDisciplina.getId());
            values.put("nomeA", dDisciplina.getNomeA());
            values.put("nomeD", dDisciplina.getNomeD());
            values.put("nota1", dDisciplina.getNota1());
            values.put("nota2", dDisciplina.getNota2());
            values.put("media", dDisciplina.getMedia());

            Long idDisciInsert =  db.insert("disc",null,values);
            return idDisciInsert;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
