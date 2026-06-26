package model;

// representa o pagamento de uma passagem
public class Pagamento {

    private int    idPagamento;
    private double valor;
    private String formaPagamento;
    private String status;
    private String dataPagamento;
    private int    idPassagem;

    // construtor vazio necessário para instanciar sem dados
    public Pagamento() {}
    // construtor completo usado ao buscar dados do banco
    public Pagamento(int idPagamento, double valor, String formaPagamento,
                     String status, String dataPagamento, int idPassagem) {
        this.idPagamento    = idPagamento;
        this.valor          = valor;
        this.formaPagamento = formaPagamento;
        this.status         = status;
        this.dataPagamento  = dataPagamento;
        this.idPassagem     = idPassagem;
    }
    // getters e setters para acessar e modificar os atributos
    public int    getIdPagamento()           { return idPagamento; }
    public void   setIdPagamento(int i)      { this.idPagamento = i; }
    public double getValor()                 { return valor; }
    public void   setValor(double v)         { this.valor = v; }
    public String getFormaPagamento()        { return formaPagamento; }
    public void   setFormaPagamento(String f){ this.formaPagamento = f; }
    public String getStatus()                { return status; }
    public void   setStatus(String s)        { this.status = s; }
    public String getDataPagamento()         { return dataPagamento; }
    public void   setDataPagamento(String d) { this.dataPagamento = d; }
    public int    getIdPassagem()            { return idPassagem; }
    public void   setIdPassagem(int i)       { this.idPassagem = i; }

    // exibe os dados do pagamento de forma legível no console
    @Override
    public String toString() {
        return "Pagamento{id=" + idPagamento + ", valor=" + valor +
                ", forma='" + formaPagamento + "', status='" + status + "', data='"
                + dataPagamento + "', passagem=" + idPassagem + "}";
    }
}