package seguros;

public class VeiculoSegurado {

    private double quilometragem;
    private String placa;
    private static int contadorVeiculos = 0;
    private Cliente cliente;
    private Apolice apolice;
    private Modelo modelo;

    public VeiculoSegurado(double quilometragem, String placa, Cliente cliente, Apolice apolice, Modelo modelo) {
        VeiculoSegurado.contadorVeiculos++;
        this.quilometragem = quilometragem;
        this.placa = placa;
        this.cliente = cliente;
        this.apolice = apolice;
        this.modelo = modelo;
        this.cliente.getVeiculosSegurados().add(this);
    }

    public VeiculoSegurado() {
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public static int getContadorVeiculos() {
        return contadorVeiculos;
    }

    public static void setContador_veiculos(int contadorVeiculos) {
        VeiculoSegurado.contadorVeiculos = contadorVeiculos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Apolice getApolice() {
        return apolice;
    }

    public void setApolice(Apolice apolice) {
        this.apolice = apolice;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Veículo nº " + getContadorVeiculos()
                + "\nModelo: " + this.getModelo()
                + "\nPlaca: " + this.getPlaca()
                + "\nQuilometragem: " + this.getQuilometragem()
                + "\nCliente: " + this.cliente.getNome()
                + "\nNúmero da apólice: " + this.getApolice() + "\n";
    }
}
