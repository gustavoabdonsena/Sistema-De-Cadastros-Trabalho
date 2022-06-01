package app.database;

import app.client.Funcionario;

import java.util.ArrayList;

public class UsuariosList {

    public static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    //this method will add new Employees to the array
    public static void addFuncionario(Funcionario funcionario){
       // funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
        funcionarios.add(funcionario);
        //call method to reload the txt file with new clients

    }

    public static ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    //este método receberá os funcionários da lista
    public static boolean loadFuncionariosList(){

        return true;
    }

    public static boolean codeValidation(){
        return false;
    }

}
