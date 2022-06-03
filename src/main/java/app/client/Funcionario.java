package app.client;

import app.database.CodeValidation;

import java.util.ArrayList;
public class Funcionario {

    private String name;
    private String code;
    private String cargo;
    private int dependentes;
    private double salary;
    private double bonus;

    private int getQtdDependentes;

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
            calcBonus(dependentes);
        }
        else
        {
            throw new IllegalArgumentException("A quantidade de dependentes deve ser >= 0");
        }

        //setando salario
        if(salary >=0) {
            this.salary = salary;
        }
        else {
            throw new IllegalArgumentException("O valor do salário deve ser >= 0.0");
        }
        calcBonus(dependentes);

        dependentesList.add(new Dependente("Joao"));
        dependentesList.add(new Dependente("Maria"));
        dependentesList.add(new Dependente("Bruxa"));
    }

    public Funcionario() {

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
        this.code = code;
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
            throw new IllegalArgumentException("O valor do salário deve ser >= 0.0");
        }

    }

    public void setDependentes(int dependentes) {

        if(dependentes >= 0)
        {
            this.dependentes = dependentes;
            calcBonus(dependentes);
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

    public void setCodigo()
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
    public String getCodigo()
    {
        return code;
    }

    public void calcBonus(double bonus)
    {
        this.bonus = 1 + 0.02 * this.dependentes;
    }

    public double showBonus()
    {
        return this.bonus;
    }

    public ArrayList<Dependente> getDependentesList() {
        return dependentesList;
    }

    public void setDependentesList(ArrayList<Dependente> dependentesList) {
        this.dependentesList = dependentesList;
    }

    public int getGetQtdDependentes() {
        return getQtdDependentes;
    }

    public void setGetQtdDependentes(int getQtdDependentes) {
        this.getQtdDependentes = getQtdDependentes;
    }
}
