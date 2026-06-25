package model;

public class Cliente {

    private int    idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String dataNascimento;

    public Cliente() {}

    public Cliente(int idCliente, String nome, String cpf, String email, String dataNascimento) {
        this.idCliente      = idCliente;
        this.nome           = nome;
        this.cpf            = cpf;
        this.email          = email;
        this.dataNascimento = dataNascimento;
    }

    public int    getIdCliente()              { return idCliente; }
    public void   setIdCliente(int i)         { this.idCliente = i; }
    public String getNome()                   { return nome; }
    public void   setNome(String n)           { this.nome = n; }
    public String getCpf()                    { return cpf; }
    public void   setCpf(String c)            { this.cpf = c; }
    public String getEmail()                  { return email; }
    public void   setEmail(String e)          { this.email = e; }
    public String getDataNascimento()         { return dataNascimento; }
    public void   setDataNascimento(String d) { this.dataNascimento = d; }

    @Override
    public String toString() {
        return "Cliente{id=" + idCliente + ", nome='" + nome + "', cpf='"
                + cpf + "', email='" + email + "', nascimento='" + dataNascimento + "'}";

    }
}