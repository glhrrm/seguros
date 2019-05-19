package seguros;

import java.time.LocalDate;

public class Apolice {

    private static long contadorApolices;
    private LocalDate data, dataValidade;
    private int situacao;
    private String seguradora;
    private SituacaoApolice situacaoApolice;

    public Apolice(String seguradora, SituacaoApolice situacaoApolice) {
        Apolice.contadorApolices++;
        this.data = LocalDate.now();
        this.dataValidade = LocalDate.now().plusYears(1);
        this.situacao = situacaoApolice.getValor();
        this.seguradora = seguradora;
        this.situacaoApolice = situacaoApolice;
    }

    public Apolice() {
    }

    public static long getContadorApolices() {
        return contadorApolices;
    }

    public static void setContadorApolices(long contadorApolices) {
        Apolice.contadorApolices = contadorApolices;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public String getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(String seguradora) {
        this.seguradora = seguradora;
    }

    public SituacaoApolice getSituacaoApolice() {
        return situacaoApolice;
    }

    public void setSituacaoApolice(SituacaoApolice situacaoApolice) {
        this.situacaoApolice = situacaoApolice;
    }

    @Override
    public String toString() {
        return "" + getContadorApolices();
    }
    
    
}
