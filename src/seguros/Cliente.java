package seguros;

import java.time.LocalDate;
import java.util.LinkedList;

public class Cliente extends Pessoa {

    private String endereco, telefone;
    private LinkedList<VeiculoSegurado> veiculosSegurados;

    public Cliente(String endereco, String telefone, String nome, LocalDate dataNascimento) {
        super(nome, dataNascimento);
        this.endereco = endereco;
        this.telefone = telefone;
        this.veiculosSegurados = new LinkedList<>();
    }

    public Cliente() {
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LinkedList<VeiculoSegurado> getVeiculosSegurados() {
        return veiculosSegurados;
    }

    public void setVeiculosSegurados(LinkedList<VeiculoSegurado> veiculosSegurados) {
        this.veiculosSegurados = veiculosSegurados;
    }

    @Override
    public String toString() {
        return "Nome: " + super.getNome() +
                "\nData de nascimento: " + super.getDataNascimento() +
                "\nEndereço: " + this.getEndereco() +
                "\nTelefone: " + this.getTelefone() +
                "\nVeículos segurados: " + this.getVeiculosSegurados() + "\n";
    }
}
