package com.example.trabalho2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexSQlite extends SQLiteOpenHelper {

    private static ConexSQlite INSTANCIA_CONNECT;
    private static final int VERSAO_DB = 1;
    private static final String NOME_DB= "bd_To_Passado";

    public ConexSQlite( Context context) {
        super(context, NOME_DB, null, VERSAO_DB);

    }

    public static ConexSQlite getInstance(Context context){
        if(INSTANCIA_CONNECT == null){
            INSTANCIA_CONNECT = new ConexSQlite(context);
        }
        return INSTANCIA_CONNECT;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTabelaDisciplina =
                "CREATE TABLE IF NOT EXISTS disc" +
                        "(" +
                        "id INTEGER PRIMARY KEY," +
                        "nomeA TEXT," +
                        "nomeD TEXT," +
                        "nota1 REAL," +
                        "nota2 REAL," +
                        "media REAL" +
                        ")";
        db.execSQL(sqlTabelaDisciplina);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
