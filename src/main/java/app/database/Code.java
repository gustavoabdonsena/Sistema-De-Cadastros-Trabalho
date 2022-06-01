package app.database;

import app.client.Funcionario;

import java.util.ArrayList;

public class Code {

    private String code;
    private static ArrayList<Funcionario> funcionarios = UsuariosList.getFuncionarios();

    public Code(String code)
    {
        this.code = code;
    }

    public static boolean codeValidation(String code)
    {
        for (int i = 0; i < funcionarios.size(); i++)
        {
            if (funcionarios.get(i).getCode() == code)
            {
                return false;
            }
        }
        return true;
    }
}
