package app.database;

import app.client.Funcionario;

import java.util.ArrayList;

public class UsuariosList {

    static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    //this method will add new Employees to the array
    public static void addFuncionario(Funcionario funcionario){
       // funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
        //call method to reload the txt file with new clients

    }

    //este método receberá os funcionários da lista
    public static boolean loadFuncionariosList(){



        return true;
    }

}
