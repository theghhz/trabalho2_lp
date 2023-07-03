// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.ObjectOutput;
// import java.io.ObjectOutputStream;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

import java.io.*;
import java.util.*;
public class Agenda {

    private List<Contato> contatos;
    private int last;

    private static final long serialVersionUID = 3L; // Controle da serialização dos arquivos 

    public Agenda() {
        contatos = new ArrayList<>();
        last = -1;
    }

    public void insereOuAltera(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-- Adicionar contato --");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Relação: ");
        String relacao = scanner.nextLine();

        Contato contato = new Contato(nome, telefone, endereco, relacao);

        int index = buscarContatoPorNome(contato.getNome());

        if (index == -1){
            contatos.add(contato);
            last++;    
            System.out.println("Contato adicionado com sucesso!");

        } else {
            contatos.set(index,contato);
            System.out.println("Contato alterado com sucesso!");
        }
        
    }

    public void removeContato() {

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
            System.out.println("Endereço: " + contatoRemover.getEndereco());
            System.out.println("Relação: " + contatoRemover.getRelacao());
            System.out.println("---------------------------------------");
            System.out.print("\nDigite 1 para confirmar ou 2 para cancelar: ");
            int confirmacao = scanner.nextInt();
            scanner.nextLine(); 

            if (confirmacao == 1) {
                contatos.remove(contatoRemover);
                System.out.println("Contato removido com sucesso!");
                last--;
            } else if (confirmacao == 2) {
                System.out.println("Remoção cancelada.");
            } else {
                System.out.println("Opção inválida. Remoção cancelada.");
            }
            
        } else {
            System.out.println("Contato não encontrado!");
        }

    }

    public void busca() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n----- Buscar contato -----");
        System.out.print("Digite o nome do contato que deseja buscar: ");
        String nome = scanner.nextLine();
        int index = buscarContatoPorNome(nome);

        if (index != -1) {
            Contato contatoEncontrado = contatos.get(index);
            System.out.println("Contato encontrado:");
            System.out.println(contatoEncontrado.toString());
        } else {
            System.out.println("Contato não encontrado!");
        }
    }


    // public Contato buscarContato(String nome) {
    //     for (Contato contato : contatos) {
    //         if (contato.getNome().equalsIgnoreCase(nome)) {
    //             return contato;
    //         }
    //     }
    //     return null;
    // }

    private int buscarContatoPorNome(String nome) {
        
        for (int i = 0; i <= last; i++){
            if(contatos.get(i).getNome().equalsIgnoreCase(nome))
                return i;
        }
        return -1;
    }

    public void exibirContatos() {

        System.out.println("\n------ Lista de contatos ------");
        for (Contato contato : contatos) {
            System.out.println(contato.toString());
        }
    }

    public void save(String arquivo) {

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(arquivo))){
            outputStream.writeObject(contatos);
            System.out.println("A agenda foi salva com sucesso!");
        } catch (IOException e){
            System.out.println("Erro ao salvar a agenda");
        }
    }

    public void reload(String arquivo) {

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(arquivo))){
            contatos = (List<Contato>) inputStream.readObject();  // Não afeta o programa
            last = contatos.size() - 1;
            System.out.println("A agenda foi carrega com sucesso!");
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Erro ao carregar o arquivo da Agenda.");
        }
    }
}
