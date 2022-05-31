package app.client;

import java.util.ArrayList;
public class Funcionario {

    String name;
    String code;
    String cargo;
    int dependentes;
    double salary;
    double bonus;

    //lista de dependentes para o funcionário
    ArrayList<Dependente> dependentesList = new ArrayList<>();

    public Funcionario(String name, String code, String cargo, int dependentes, double salary) {
        this.name = name;
        this.cargo = cargo;

        //setando codigo + verificação
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
    }

    public Funcionario(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }
    //codigo deve ser único, implementar verificação
    public void setCode(String code) {
        if(code != code){

        }
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

    public int getDependentes() {
        return dependentes;
    }

    public void calcBonus(double bonus) {
        this.bonus = 1 + 0.02 * this.dependentes;
    }

    public double showBonus(){
        return this.bonus;
    }

}