package app.database;

import app.client.Funcionario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class FileJSON {

        public static void createJSON(){

            FileWriter wF = null;

            JSONArray jsonArray = new JSONArray();

            for(Funcionario funcionario : UsuariosList.getFuncionarios()) {
                JSONObject data = new JSONObject();
                data.put("name", funcionario.getName());
                data.put("code", funcionario.getCode());
                jsonArray.add(data);
            }
            try {
                wF = new FileWriter("database.json");
                wF.write(jsonArray.toJSONString());
                wF.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}