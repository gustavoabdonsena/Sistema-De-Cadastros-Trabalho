package app.database;

import app.client.Funcionario;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class CodeValidation {

    public static boolean isFuncionarioExists(Funcionario funcionarios)
    {
        AtomicBoolean isExist = new AtomicBoolean(false);

        UsuariosList.funcionarios.forEach(funcionario -> {
            if(funcionario.getCode().equalsIgnoreCase(funcionarios.getCode())){
                isExist.set(true);
            }
        });

        return isExist.get();
    }

    public static boolean validate(String code){

        AtomicBoolean isExist = new AtomicBoolean(false);

        UsuariosList.funcionarios.forEach(funcionario -> {
            if(funcionario.getCode().equalsIgnoreCase(code)){
                isExist.set(true);
            }
        });

        return isExist.get();

    }

}
