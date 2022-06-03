package app.database;

import app.client.Funcionario;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class UsuariosList {

    public static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    //this method will add new Employees to the array
    public static void addFuncionario(Funcionario funcionario){
       // funcionarios.add(funcionario);
        funcionarios.add(funcionario);
        //call method to reload the txt file with new clients

    }

    //este método receberá os funcionários da lista
    public static void createFuncionario(Funcionario funcionario) {
        if(CodeValidation.isFuncionarioExists(funcionario)){
            System.out.println("Colocar Warning de nao pode criar");
        }else {
            System.out.println("Funcionário criado com sucesso");
            addFuncionario(funcionario);
        }
    }

    public static void deleteArray(){
        funcionarios.clear();
    }

}
