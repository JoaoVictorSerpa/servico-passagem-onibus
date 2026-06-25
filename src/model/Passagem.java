package model;

public class Passagem {

    private int    idPassagem;
    private int    numeroAssento;
    private String dataCompra;
    private String status;
    private int    idCliente;
    private int    idViagem;

    public Passagem() {}

    public Passagem(int idPassagem, int numeroAssento, String dataCompra,
                    String status, int idCliente, int idViagem) {
        this.idPassagem    = idPassagem;
        this.numeroAssento = numeroAssento;
        this.dataCompra    = dataCompra;
        this.status        = status;
        this.idCliente     = idCliente;
        this.idViagem      = idViagem;
    }

    public int    getIdPassagem()          { return idPassagem; }
    public void   setIdPassagem(int i)     { this.idPassagem = i; }
    public int    getNumeroAssento()       { return numeroAssento; }
    public void   setNumeroAssento(int n)  { this.numeroAssento = n; }
    public String getDataCompra()          { return dataCompra; }
    public void   setDataCompra(String d)  { this.dataCompra = d; }
    public String getStatus()              { return status; }
    public void   setStatus(String s)      { this.status = s; }
    public int    getIdCliente()           { return idCliente; }
    public void   setIdCliente(int i)      { this.idCliente = i; }
    public int    getIdViagem()            { return idViagem; }
    public void   setIdViagem(int i)       { this.idViagem = i; }

    @Override
    public String toString() {
        return "Passagem{id=" + idPassagem + ", assento=" + numeroAssento +
                ", compra='" + dataCompra + "', status='" + status + "', cliente=" + idCliente + ", viagem=" + idViagem + "}";
    }
}