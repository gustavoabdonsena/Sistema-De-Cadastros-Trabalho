package app.database;

import app.client.Dependente;
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

            if(database.createNewFile()) {
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

    private static void deleteFile(){

        File database = new File("database.txt");

        if(database.delete()) {
            System.out.println("Arquivo criado");
        }
    }
    public static void loadList(){


    }

    private static void verificaCodigo(){

    }

    public static void saveList(){
        createFile();
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt"));

            UsuariosList.funcionarios.forEach(functionary -> {

                try {
                    //responsavel por receber o array de nomes de dependentes
                    StringBuilder dependentes = new StringBuilder();

                    dependentes.append('[');

                   functionary.getDependentesList().forEach(dependente -> {
                       dependentes.append(dependente.getName());
                   });

                    dependentes.append(']');

                    //debug para dependentes
                    System.out.println(dependentes);


                    //gera a estrutura do arquivo TXT
                    String str = functionary.getCode() + "{ "
                            + " nome: " + functionary.getName() + ","
                            + " cargo: " + functionary.getCargo() + ","
                            + " salario: " + functionary.getSalary() + ","
                            + " dependentes: " + dependentes
                            + " }";

                    writer.write(str);
                    writer.newLine();
                }
                catch (IOException e){
                    e.printStackTrace();
                }

            });

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
