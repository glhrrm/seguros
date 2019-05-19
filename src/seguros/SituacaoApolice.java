package seguros;

public enum SituacaoApolice {
    
    EM_NEGOCIAÇÃO(1, "Em negociação"),
    CANCELADA(2, "Cancelada"),
    QUITADA(3, "Quitada"),
    PARCELADA(4, "Parcelada");
    
    private final int valor;
    private final String nome;

    private SituacaoApolice(int valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }
}