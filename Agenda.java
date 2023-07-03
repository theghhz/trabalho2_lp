import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n-- Adicionar contato --");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Contato contato = new Contato(nome, telefone, email);
        contatos.add(contato);

        System.out.println("Contato adicionado com sucesso!");
    }

    public void removerContato() {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n----- Remover contato -----");

        System.out.print("Digite o nome do contato que deseja remover: ");
        String nome = scanner.nextLine();

        Contato contatoRemover = null;

        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatoRemover = contato;
                break;
            }
        }

        if (contatoRemover != null) {
            System.out.println("Confirma a remoção do seguinte contato:");
            System.out.println("---------------------------------------");
            System.out.println("Nome: " + contatoRemover.getNome());
            System.out.println("Telefone: " + contatoRemover.getTelefone());
            System.out.println("Email: " + contatoRemover.getEmail());
            System.out.println("---------------------------------------");
            System.out.print("\nDigite 1 para confirmar ou 2 para cancelar: ");
            int confirmacao = scanner.nextInt();
            scanner.nextLine(); 

            if (confirmacao == 1) {
                contatos.remove(contatoRemover);
                System.out.println("Contato removido com sucesso!");
            } else if (confirmacao == 2) {
                System.out.println("Remoção cancelada.");
            } else {
                System.out.println("Opção inválida. Remoção cancelada.");
            }
        } else {
            System.out.println("Contato não encontrado!");
        }
    }

    public void exibirContatos() {
        System.out.println("\n------ Lista de contatos ------");
        for (Contato contato : contatos) {
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Telefone: " + contato.getTelefone());
            System.out.println("Email: " + contato.getEmail());
            System.out.println();
        }
    }
}
