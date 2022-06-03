package app.database;

import app.client.Funcionario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class FileJSON {

        public static void createJSON(){

            FileWriter wF = null;

            JSONArray funcionarioArray = new JSONArray();


            for(Funcionario funcionario : UsuariosList.getFuncionarios())
            {
                JSONObject funcionarioOBJ = new JSONObject();
                JSONArray dependentesList = new JSONArray();

                funcionario.getDependentesList().forEach(dependente ->{
                    dependentesList.add(dependente.getName().toLowerCase());
                });

                funcionarioOBJ.put("name", funcionario.getName());
                funcionarioOBJ.put("code", funcionario.getCode());
                funcionarioOBJ.put("cargo", funcionario.getCargo());
                funcionarioOBJ.put("salary", funcionario.getSalary());
                funcionarioOBJ.put("dependentes:",dependentesList);
                funcionarioArray.add(funcionarioOBJ);
            }

            try {
                wF = new FileWriter("database.json");
                wF.write(funcionarioArray.toJSONString());
                wF.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}