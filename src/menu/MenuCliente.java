/**
 * Sistema de Passagens de Ônibus - Catarinense
 * Disciplina: Banco de Dados II - UNIVALI
 * Autores: Salomão Patrick França Alves Panas, João Vitor
 */
package menu;

import dao.ClienteDAO;
import model.Cliente;

import java.util.List;
import java.util.Scanner;

// menu de opções para gerenciar clientes no console
public class MenuCliente {

    private final ClienteDAO dao = new ClienteDAO();
    private final Scanner sc;

    public MenuCliente(Scanner sc) {
        this.sc = sc;
    }

    // exibe o menu e aguarda a escolha do usuário
    public void exibir() {
        int opcao;
        do {
            System.out.println("\n===== MENU CLIENTE =====");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente por ID");
            System.out.println("4. Atualizar cliente");
            System.out.println("5. Remover cliente");
            System.out.println("0. Voltar");
            System.out.print("Opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> buscar();
                case 4 -> atualizar();
                case 5 -> remover();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    // aguarda o usuário pressionar Enter para continuar
    private void pausar() {
        System.out.print("\nPressione Enter para continuar...");
        sc.nextLine();
    }

    // lê os dados do novo cliente e chama o DAO para inserir
    private void cadastrar() {
        System.out.println("\n--- Cadastrar Cliente ---");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Data de nascimento (AAAA-MM-DD): ");
        String dataNascimento = sc.nextLine();

        Cliente c = new Cliente(0, nome, cpf, email, dataNascimento);
        dao.inserir(c);
        pausar();
    }

    // busca todos os clientes e exibe no console
    private void listar() {
        System.out.println("\n--- Lista de Clientes ---");
        List<Cliente> lista = dao.listar();
        if (lista.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            lista.forEach(System.out::println);
        }
        pausar();
    }

    // busca um cliente pelo id informado
    private void buscar() {
        System.out.print("\nID do cliente: ");
        int id = sc.nextInt();
        sc.nextLine();
        Cliente c = dao.buscarPorId(id);
        if (c != null) {
            System.out.println(c);
        } else {
            System.out.println("Cliente nao encontrado.");
        }
        pausar();
    }

    // busca o cliente pelo id e permite alterar os dados
    private void atualizar() {
        System.out.print("\nID do cliente a atualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        Cliente c = dao.buscarPorId(id);
        if (c == null) {
            System.out.println("Cliente nao encontrado.");
            pausar();
            return;
        }
        System.out.print("Novo nome (" + c.getNome() + "): ");
        String nome = sc.nextLine();
        System.out.print("Novo CPF (" + c.getCpf() + "): ");
        String cpf = sc.nextLine();
        System.out.print("Novo email (" + c.getEmail() + "): ");
        String email = sc.nextLine();
        System.out.print("Nova data nascimento (" + c.getDataNascimento() + "): ");
        String data = sc.nextLine();

        if (!nome.isEmpty())  c.setNome(nome);
        if (!cpf.isEmpty())   c.setCpf(cpf);
        if (!email.isEmpty()) c.setEmail(email);
        if (!data.isEmpty())  c.setDataNascimento(data);

        dao.atualizar(c);
        pausar();
    }

    // remove o cliente com o id informado
    private void remover() {
        System.out.print("\nID do cliente a remover: ");
        int id = sc.nextInt();
        sc.nextLine();
        dao.deletar(id);
        pausar();
    }
}