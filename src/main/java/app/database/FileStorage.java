package app.database;

import app.client.Funcionario;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//This class will be designated to load TXT as database
public class FileStorage {

    private static void createFile(){
        try{
            File database = new File("database.txt");
            if(database.createNewFile()){
              System.out.println("Arquivo criado");
            }
        }
        catch (IOException e){
            System.out.println("Ocorreu um erro na criação do arquivo! ");
            e.printStackTrace();

            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setContentText("Teste");
            alert.showAndWait();
        }
    }

    public static void loadList(){


    }

    public static void saveList(){

        createFile();

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt"));

            for (Funcionario funcionario: UsuariosList.funcionarios) {
                System.out.println("Entrou");
                String str = "fc.getCode() + - + fc.getName() +  -  + fc.getCargo() +  - ";
                writer.write(str);
                writer.newLine();
            }


            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
