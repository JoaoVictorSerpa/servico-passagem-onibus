package model;

// representa uma viagem específica de ônibus

public class Viagem {

    private int    idViagem;
    private String dataPartida;
    private String dataChegada;
    private String status;
    private int    idOnibus;
    private int    idRota;
    private int    idMotorista;
    // construtor vazio necessário para instanciar objetos sem dados iniciais
    public Viagem() {}

    // construtor completo usado ao buscar dados do banco
    public Viagem(int idViagem, String dataPartida, String dataChegada,
                  String status, int idOnibus, int idRota, int idMotorista) {
        this.idViagem    = idViagem;
        this.dataPartida = dataPartida;
        this.dataChegada = dataChegada;
        this.status      = status;
        this.idOnibus    = idOnibus;
        this.idRota      = idRota;
        this.idMotorista = idMotorista;
    }
    // getters e setters para acessar e modificar os atributos
    public int    getIdViagem()            { return idViagem; }
    public void   setIdViagem(int i)       { this.idViagem = i; }
    public String getDataPartida()         { return dataPartida; }
    public void   setDataPartida(String d) { this.dataPartida = d; }
    public String getDataChegada()         { return dataChegada; }
    public void   setDataChegada(String d) { this.dataChegada = d; }
    public String getStatus()              { return status; }
    public void   setStatus(String s)      { this.status = s; }
    public int    getIdOnibus()            { return idOnibus; }
    public void   setIdOnibus(int i)       { this.idOnibus = i; }
    public int    getIdRota()              { return idRota; }
    public void   setIdRota(int i)         { this.idRota = i; }
    public int    getIdMotorista()         { return idMotorista; }
    public void   setIdMotorista(int i)    { this.idMotorista = i; }


    // exibe os dados da viagem de forma legível
    @Override
    public String toString() {
        return "Viagem{id=" + idViagem + ", partida='" + dataPartida +
                "', chegada='" + dataChegada + "', status='" + status +
                "', onibus=" + idOnibus + ", rota=" + idRota + ", motorista=" + idMotorista + "}";
    }
}