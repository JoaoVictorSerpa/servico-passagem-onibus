package model;

public class Pagamento {

    private int    idPagamento;
    private double valor;
    private String formaPagamento;
    private String status;
    private String dataPagamento;
    private int    idPassagem;

    public Pagamento() {}

    public Pagamento(int idPagamento, double valor, String formaPagamento,
                     String status, String dataPagamento, int idPassagem) {
        this.idPagamento    = idPagamento;
        this.valor          = valor;
        this.formaPagamento = formaPagamento;
        this.status         = status;
        this.dataPagamento  = dataPagamento;
        this.idPassagem     = idPassagem;
    }

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

    @Override
    public String toString() {
        return "Pagamento{id=" + idPagamento + ", valor=" + valor +
                ", forma='" + formaPagamento + "', status='" + status + "', data='" + dataPagamento + "', passagem=" + idPassagem + "}";
    }
}