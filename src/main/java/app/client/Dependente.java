package app.client;

public class Dependente {
    private String name;
    private String funcionario;

    public Dependente(String name, String funcionario)
    {
        this.name = name;
        this.funcionario = funcionario;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFuncionario()
    {
        return funcionario;
    }

    public void setFuncionario(String funcionario)
    {
        this.funcionario = funcionario;
    }

}
