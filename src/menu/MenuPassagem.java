package menu;

import dao.PassagemDAO;
import model.Passagem;

import java.util.List;
import java.util.Scanner;

// menu de opções para gerenciar passagens no console
public class MenuPassagem {

    private final PassagemDAO dao = new PassagemDAO();
    private final Scanner sc;

    public MenuPassagem(Scanner sc) {
        this.sc = sc;
    }

    public void exibir() {
        int opcao;
        do {
            System.out.println("\n===== MENU PASSAGEM =====");
            System.out.println("1. Comprar passagem");
            System.out.println("2. Listar passagens");
            System.out.println("3. Buscar passagem por ID");
            System.out.println("4. Atualizar passagem");
            System.out.println("5. Cancelar passagem");
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

    private void cadastrar() {
        System.out.println("\n--- Comprar Passagem ---");
        System.out.print("Numero do assento: ");
        int assento = sc.nextInt();
        sc.nextLine();
        System.out.print("Data da compra (AAAA-MM-DD HH:MM:SS): ");
        String dataCompra = sc.nextLine();
        System.out.print("Status (ativa/cancelada/utilizada): ");
        String status = sc.nextLine();
        System.out.print("ID do cliente: ");
        int idCliente = sc.nextInt();
        System.out.print("ID da viagem: ");
        int idViagem = sc.nextInt();
        sc.nextLine();

        Passagem p = new Passagem(0, assento, dataCompra, status, idCliente, idViagem);
        dao.inserir(p);
        pausar();
    }

    private void listar() {
        System.out.println("\n--- Lista de Passagens ---");
        List<Passagem> lista = dao.listar();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma passagem encontrada.");
        } else {
            lista.forEach(System.out::println);
        }
        pausar();
    }

    private void buscar() {
        System.out.print("\nID da passagem: ");
        int id = sc.nextInt();
        sc.nextLine();
        Passagem p = dao.buscarPorId(id);
        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Passagem nao encontrada.");
        }
        pausar();
    }

    private void atualizar() {
        System.out.print("\nID da passagem a atualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        Passagem p = dao.buscarPorId(id);
        if (p == null) {
            System.out.println("Passagem nao encontrada.");
            pausar();
            return;
        }
        System.out.print("Novo status (" + p.getStatus() + "): ");
        String status = sc.nextLine();
        if (!status.isEmpty()) p.setStatus(status);
        dao.atualizar(p);
        pausar();
    }

    private void remover() {
        System.out.print("\nID da passagem a cancelar: ");
        int id = sc.nextInt();
        sc.nextLine();
        dao.deletar(id);
        pausar();
    }
}