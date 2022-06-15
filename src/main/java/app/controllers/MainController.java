package app.controllers;

import app.Main;
import app.client.Dependente;
import app.client.Funcionario;
import app.database.CodeValidation;
import app.database.FileJSONRead;
import app.database.FileJSONWrite;
import app.database.UsuariosList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class MainController {
    @FXML
    private Label prompt;
    @FXML
    private TextField inputName;

    @FXML
    private TextField inputCode;

    @FXML
    private TextField inputCargo;

    @FXML
    private TextField inputSalario;
    @FXML
    private TextField inputQtdDependentes;

    private Stage stage;
    private Scene scene;

    @FXML
    void signIn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("sign-in.fxml"));
        scene = new Scene(fxmlLoader.load(), 800 , 450);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logIn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("log-in.fxml"));
        scene = new Scene(fxmlLoader.load(), 800 , 450);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backToFirst(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("first-scene.fxml"));
        scene = new Scene(fxmlLoader.load(), 800 , 450);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void createFuncionario(ActionEvent event) throws IOException
    {
        try{
            if(CodeValidation.validate(inputCode.getText())){
                prompt.setText("Funcionário Já Existe!");
            }else {
                UsuariosList.createFuncionario(new Funcionario(
                        inputName.getText()
                        ,inputCode.getText()
                        ,inputCargo.getText()
                        ,Integer.parseInt(inputQtdDependentes.getText())
                        ,Float.parseFloat(inputSalario.getText())
                ));

                FileJSONWrite.createJSON();
                prompt.setText("Funcionário adicionado!");

                //Switch to "add dependents" page
                /*FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("next-sign-in.fxml"));
                scene = new Scene(fxmlLoader.load(), 800 , 450);
                //Add text fields to input the dependents' names
                VBox vbox = (VBox) scene.lookup("#vbox");
                for (int i = 0; i < Integer.parseInt(inputQtdDependentes.getText()); i++)
                {
                    TextField dependentName = new TextField();
                    dependentName.setId("#inputDependente" + i);
                    dependentName.setPromptText("DEPENDENT NAME");
                    vbox.getChildren().add(dependentName);
                }*/

                //Switch to employee's info page
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("funcionarios.fxml"));
                scene = new Scene(fxmlLoader.load(), 800 , 450);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setTitle("Sistemas de Funcionários");
                stage.setScene(scene);
                stage.show();

                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setTitle("Sistemas de Funcionários");
                stage.setScene(scene);
                stage.show();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.toString());
            alert.show();
            }
    }

    /*@FXML
    void addDependentes(ActionEvent event) throws IOException
    {
        ArrayList<Dependente> dependentes = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(inputQtdDependentes.getText()); i++)
        {
            TextField inputDependente = (TextField) scene.lookup("#inputDependente" + i);
            Dependente dependente = new Dependente(inputDependente.getText());
            dependentes.add(dependente);
        }
        UsuariosList.getFuncionarios().get(-1).setDependentesList(dependentes);

        //Switch to employee's info page
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("funcionarios.fxml"));
        scene = new Scene(fxmlLoader.load(), 800 , 450);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }*/

    @FXML
    void deleteFuncionario(ActionEvent event) throws IOException {
        //Switch to "delete employee" page
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("delete.fxml"));
        scene = new Scene(fxmlLoader.load(), 800 , 450);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void removeFuncionario(ActionEvent event) throws IOException {
        //Delete employee from database
        if(CodeValidation.validate(inputCode.getText())){

            for (Funcionario funcionario:UsuariosList.getFuncionarios())
            {
                if (Objects.equals(funcionario.getCode(), inputCode.getText()))
                {
                    UsuariosList.funcionarios.remove(funcionario);
                    FileJSONWrite.createJSON();
                }
            }
            prompt.setText("Funcionário removido!");
        }else{
            prompt.setText("Funcionário Inexistente!");
        }

        //Switch to employee's info page
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("funcionarios.fxml"));
        scene = new Scene(fxmlLoader.load(), 800 , 450);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loginFuncionario(ActionEvent event) throws IOException {

        if(CodeValidation.validate(inputCode.getText())){
            prompt.setText("Entrada bem Sucedida");
        }else{
            prompt.setText("Usuário não encontrado!");
        }

        //Switch to employee's info page
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("funcionarios.fxml"));
        scene = new Scene(fxmlLoader.load(), 800 , 450);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Sistemas de Funcionários");
        stage.setScene(scene);
        stage.show();
    }
}