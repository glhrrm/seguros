package seguros;

import java.time.LocalDate;

public class Usuario extends Pessoa {

    private String identificador, senha;

    public Usuario(String identificador, String senha, String nome, LocalDate dataNascimento) {
        super(nome, dataNascimento);
        this.identificador = identificador;
        this.senha = senha;
    }

    public Usuario() {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
                return "Nome: " + super.getNome() +
                "\nData de nascimento :" + super.getDataNascimento() +
                "\nIdentificador: " + this.getIdentificador() +
                "\nSenha: " + this.getSenha() + "\n";
    }
}
