import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcao = 9;

        while (opcao != 0) {
            Menu.exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                case 1:
                    agenda.insereOuAltera();
                    break;
                case 2:
                    agenda.removeContato();
                    break;
                case 3:
                    agenda.busca();
                    break;
                case 4:
                    agenda.exibirContatos();
                    break;
                case 5:
                    agenda.save("agenda.ser");
                    break;
                case 6:
                    agenda.reload("agenda.ser");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}

