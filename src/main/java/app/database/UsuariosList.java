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
    public static boolean createFuncionario(Funcionario f){

        AtomicBoolean isExist = new AtomicBoolean(false);

        funcionarios.forEach(funcionario -> {
            if(funcionario.getCode().equalsIgnoreCase(f.getCode())){
                isExist.set(true);
                addFuncionario(f);
            }
        });

        return isExist.get();
    }

    public static void deleteArray(){
        funcionarios.clear();
    }

}
