package model;

// representa um cliente do sistema de passagens
public class Cliente {

    private int    idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String dataNascimento;

    // construtor vazio, sem daddos
    public Cliente() {}

    // construtor completo usado ao buscar dados do banco
    public Cliente(int idCliente, String nome, String cpf, String email, String dataNascimento) {
        this.idCliente      = idCliente;
        this.nome           = nome;
        this.cpf            = cpf;
        this.email          = email;
        this.dataNascimento = dataNascimento;
    }

    // getters e setters para acessar e modificar os atributos

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

    // exibe os dados do cliente
    @Override
    public String toString() {
        return "Cliente{id=" + idCliente + ", nome='" + nome + "', cpf='"
                + cpf + "', email='" + email + "', nascimento='" + dataNascimento + "'}";

    }
}