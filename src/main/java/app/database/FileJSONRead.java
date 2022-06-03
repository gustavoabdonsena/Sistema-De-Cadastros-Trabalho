package app.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.function.IntFunction;


public class FileJSONRead {


    public static void loadJSON(){

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("database.json")) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray userList = (JSONArray) obj;

            // Iterate over employee array
            userList.forEach(user -> parseUserObject((JSONObject) user));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    private static void parseUserObject(JSONObject jsonObject) {

        ArrayList<String> dependentes = new ArrayList<>();
        String name = (String) jsonObject.get("name");
        String code = (String) jsonObject.get("code");
        String cargo = (String) jsonObject.get("cargo");
        double salario = (double) jsonObject.get("salary");

        JSONArray jsonArray = (JSONArray) jsonObject.get("dependentes");


        // Funcionario funcionario = new Funcionario(name,code,cargo,dependentes,salario);

    }


}
