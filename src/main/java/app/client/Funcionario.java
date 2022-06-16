package app.client;

import app.database.CodeValidation;
import javafx.scene.control.Alert;

import java.util.ArrayList;
public class Funcionario {

    private String name;
    private String code;
    private String cargo;
    private int dependentes;
    private double salary;
    private double bonus;

    //lista de dependentes para o funcionário
    private ArrayList<Dependente> dependentesList = new ArrayList<>();

    public Funcionario(String name, String code, String cargo, int dependentes, double salary) {
        this.name = name;
        this.cargo = cargo;
        this.code = code;

        //setando dependentes
        if(dependentes >= 0)
        {
            this.dependentes = dependentes;
            setBonus(dependentes);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("A quantidade de dependentes deve ser >= 0");
            alert.show();
            throw new IllegalArgumentException("A quantidade de dependentes deve ser >= 0");
        }

        //setando salario
        if(salary >=0) {
            this.salary = salary;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("O valor do salário deve ser >= 0.0");
            alert.show();
            throw new IllegalArgumentException("O valor do salário deve ser >= 0.0");
        }
        setBonus(dependentes);
    }

    //Construtor responsavel por receber um array de dependentes e chamar outro construtor para terminar a contrução
    public Funcionario(String name,String code,String cargo,ArrayList<Dependente> dependentes,double salary){
        this(name,code,cargo,dependentes.size(),salary);
        this.dependentesList = dependentes;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCode()
    {
        return code;
    }

    //codigo deve ser único, implementar verificação
    public void setCode(String code)
    {
        if(CodeValidation.validate(code))
        {
            this.code = code;
        }
        else
        {
            throw new IllegalArgumentException("Código já existente");
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {

        if(salary >=0)
        {
            this.salary = salary;
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("O valor do salário deve ser >= 0.0");
            alert.show();
            throw new IllegalArgumentException("O valor do salário deve ser >= 0.0");
        }

    }

    public void setDependentes(int dependentes) {

        if(dependentes >= 0)
        {
            this.dependentes = dependentes;
            setBonus(dependentes);
        }
        else
        {
            throw new IllegalArgumentException("A quantidade de dependentes deve ser >= 0");
        }

    }

    public int getDependentes()
    {
        return dependentes;
    }

    public void setBonus(int dependentes)
    {
        this.bonus = 2 * dependentes;
    }

    public double getBonus()
    {
        return this.bonus;
    }

    public ArrayList<Dependente> getDependentesList() {
        return dependentesList;
    }

    public void setDependentesList(ArrayList<Dependente> dependentesList) {
        this.dependentesList = dependentesList;
    }

}
