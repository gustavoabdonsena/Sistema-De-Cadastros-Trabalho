package app.client;

import java.util.ArrayList;
public class Funcionario {

    String name;
    String code;
    String cargo;
    int qtdDependentes;
    double salary;
    double bonus;

    //Array de funcionários
    Dependente[] dependentes;

    public Funcionario(String name, String code, String cargo, int qtdDependentes, double salary) {

        this.name = name;
        this.cargo = cargo;

        //setando codigo + verificação
        this.code = code;

        //setando dependentes
        if(qtdDependentes >= 0)
        {
            this.qtdDependentes = qtdDependentes;
            calcBonus(qtdDependentes);

            //Método para adicionar os dependentes
            dependentes = new Dependente[qtdDependentes];
            for (int i = 0;i < dependentes.length;i++){
                System.out.println("pedir nome dependente numero: " + i);
            }

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
        calcBonus(qtdDependentes);
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

    public void setQtdDependentes(int qtdDependentes) {

        if(qtdDependentes >= 0)
        {
            this.qtdDependentes = qtdDependentes;
            calcBonus(qtdDependentes);
        }
        else
        {
            throw new IllegalArgumentException("A quantidade de dependentes deve ser >= 0");
        }

    }

    public int getQtdDependentes() {
        return qtdDependentes;
    }

    public void setDependentes(Dependente[] dependentes) {
        this.dependentes = dependentes;
    }

    public Dependente[] getDependentes() {
        return dependentes;
    }


    public void calcBonus(double bonus) {
        this.bonus = 1 + 0.02 * this.qtdDependentes;
    }

    public double showBonus(){
        return this.bonus;
    }

}
