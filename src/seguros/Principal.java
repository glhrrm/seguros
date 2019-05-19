package seguros;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        LinkedList<Usuario> listaUsuarios = new LinkedList<>();
        LinkedList<Cliente> listaClientes = new LinkedList<>();
        LinkedList<VeiculoSegurado> listaVeiculos = new LinkedList<>();

        int opcao;

        do {
            String menuInput = JOptionPane.showInputDialog(null,
                    "1) Cadastrar usuário\n"
                    + "2) Cadastrar veículo segurado\n"
                    + "3) Cadastrar cliente\n"
                    + "4) Listar clientes\n"
                    + "5) Listar veículos\n"
                    + "6) Listar usuários\n"
                    + "0) Sair"
            );

            opcao = Integer.valueOf(menuInput);

            switch (opcao) {
                case 1:
                    String nome = JOptionPane.showInputDialog(null, "Nome");

                    String senha = JOptionPane.showInputDialog(null, "Senha");

                    String dataNascimentoInput = JOptionPane.showInputDialog(null, "Data de nascimento (dd/mm/aaaa)");
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataNascimento = LocalDate.parse(dataNascimentoInput, dtf);

                    String identificador = null;
                    boolean identificadorUnico;
                    do {
                        identificadorUnico = true;
                        identificador = JOptionPane.showInputDialog(null, "Identificador");
                        for (Usuario u : listaUsuarios) {
                            if (u.getIdentificador().equals(identificador)) {
                                identificadorUnico = false;
                            }
                        }
                        if (identificadorUnico == false) {
                            JOptionPane.showMessageDialog(null, "O identificador já existe!");
                        }
                    } while (identificadorUnico == false);

                    Usuario usuario = new Usuario(identificador, senha, nome, dataNascimento);
                    listaUsuarios.add(usuario);

                    JOptionPane.showMessageDialog(null, usuario.getNome() + " cadastrado com sucesso!");
                    break;
                case 2:
                    Cliente cliente = null;
                    do {
                        String clienteInput = JOptionPane.showInputDialog(null, "Cliente");
                        for (Cliente c : listaClientes) {
                            if (c.getNome().equals(clienteInput)) {
                                cliente = c;
                            }
                        }
                        if (cliente == null) {
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
                        }
                    } while (cliente == null);

                    String modeloInput = JOptionPane.showInputDialog(null, "Modelo");
                    Modelo modelo = new Modelo(modeloInput);

                    String placa = JOptionPane.showInputDialog(null, "Placa (ABC-1234)");

                    String quilometragemInput = JOptionPane.showInputDialog(null, "Quilometragem");
                    double quilometragem = Double.valueOf(quilometragemInput);

                    String seguradora = JOptionPane.showInputDialog(null, "Seguradora");

                    String[] opcoesApolice = {"Em negociação", "Cancelada", "Quitada", "Parcelada"};
                    int situacao = JOptionPane.showOptionDialog(
                            null,
                            "Qual a situação da apólice?",
                            "",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            opcoesApolice,
                            opcoesApolice[0]);
                    SituacaoApolice situacaoApolice = null;
                    switch (situacao) {
                        case 0:
                            situacaoApolice = SituacaoApolice.EM_NEGOCIAÇÃO;
                            break;
                        case 1:
                            situacaoApolice = SituacaoApolice.CANCELADA;
                            break;
                        case 2:
                            situacaoApolice = SituacaoApolice.QUITADA;
                            break;
                        case 3:
                            situacaoApolice = SituacaoApolice.PARCELADA;
                            break;
                    }
                    Apolice apolice = new Apolice(seguradora, situacaoApolice);

                    VeiculoSegurado veiculoSegurado = new VeiculoSegurado(quilometragem, placa, cliente, apolice, modelo);
                    listaVeiculos.add(veiculoSegurado);

                    JOptionPane.showMessageDialog(null, veiculoSegurado.getModelo() + " " + veiculoSegurado.getPlaca() + " cadastrado com sucesso!");
                    break;
                case 3:
                    nome = JOptionPane.showInputDialog(null, "Nome");

                    String endereco = JOptionPane.showInputDialog(null, "Endereço");

                    String telefone = JOptionPane.showInputDialog(null, "Telefone");

                    dataNascimentoInput = JOptionPane.showInputDialog(null, "Data de nascimento (dd/mm/aaaa)");
                    dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    dataNascimento = LocalDate.parse(dataNascimentoInput, dtf);

                    cliente = new Cliente(endereco, telefone, nome, dataNascimento);
                    listaClientes.add(cliente);

                    JOptionPane.showMessageDialog(null, cliente.getNome() + " cadastrado com sucesso!");
                    break;
                case 4:
                    String clientes[] = new String[listaClientes.size()];
                    for (int i = 0; i < listaClientes.size(); i++) {
                        clientes[i] = listaClientes.get(i).getNome();
                    }

                    JOptionPane.showMessageDialog(null, clientes);
                    break;
                case 5:
                    String veiculos[] = new String[listaVeiculos.size()];
                    for (int i = 0; i < listaVeiculos.size(); i++) {
                        veiculos[i] = listaVeiculos.get(i).getModelo().getDescricao() + " " + listaVeiculos.get(i).getPlaca();
                    }

                    JOptionPane.showMessageDialog(null, Arrays.toString(veiculos) + "\nTotal: " + VeiculoSegurado.getContadorVeiculos());
                    break;
                case 6:
                    String usuarios[] = new String[listaUsuarios.size()];
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        usuarios[i] = listaUsuarios.get(i).getNome();
                    }

                    JOptionPane.showMessageDialog(null, usuarios);
                    break;
                case 0:
                default:
                    System.exit(0);
            }
        } while (opcao != 0);
    }
}
