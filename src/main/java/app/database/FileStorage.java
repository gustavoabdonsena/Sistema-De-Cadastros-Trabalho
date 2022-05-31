package app.database;

import java.io.File;
import java.io.IOException;

//This class will be designated to load TXT as database
public class FileStorage {



    private static void createFile(){
        try{
            File database = new File("database.txt");
            if(database.createNewFile()){
              System.out.println("Arquivo criado");
            }else {
                System.out.println("erro");
            }
        }
        catch (IOException e){
            System.out.println("Ocorreu um erro na criação do arquivo! ");
            e.printStackTrace();
        }
    }

    public static void loadList(){
    }

    public static void unloadList(){

    }

}
