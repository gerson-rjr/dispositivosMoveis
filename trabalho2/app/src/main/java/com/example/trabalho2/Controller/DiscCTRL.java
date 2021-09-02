package com.example.trabalho2.Controller;

import com.example.trabalho2.DAO.DiscDAO;
import com.example.trabalho2.db.ConexSQlite;
import com.example.trabalho2.model.Disciplina;

public class DiscCTRL {
    private final DiscDAO discDAO;

    public DiscCTRL(ConexSQlite conexSQlite) {
        discDAO = new DiscDAO(conexSQlite);
    }
    public long saveDiscCtrl(Disciplina dDisciplina){
        return this.discDAO.saveDiscDAO(dDisciplina);
    }
}
