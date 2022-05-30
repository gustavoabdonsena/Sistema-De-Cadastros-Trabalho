package com.example.av3final.database;

import com.example.av3final.gen.Funcionario;

import java.util.ArrayList;

public class UsuariosList {

    static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static void addFuncionario(Funcionario funcionario){
       // funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

}
