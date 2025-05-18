import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento("EstacFacul", 10);

        while (true) {
            System.out.println("\n--- Menu Estacionamento ---");
            System.out.println("1 - Estacionar Veículo");
            System.out.println("2 - Liberar Veículo");
            System.out.println("3 - Listar Vagas Ocupadas");
            System.out.println("4 - Listar Vagas Livres");
            System.out.println("5 - Total de Carros");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Tipo (pequeno/grande/moto): ");
                    String tipo = sc.nextLine();
                    System.out.print("Número da vaga: ");
                    int numVaga = sc.nextInt();
                    sc.nextLine();

                    Veiculo v = new Veiculo(placa, marca, modelo, tipo);
                    estacionamento.estacionar(v, numVaga);
                }
                case 2 -> {
                    System.out.print("Digite a placa do veículo: ");
                    String placa = sc.nextLine();
                    estacionamento.liberarVeiculo(placa);
                }
                case 3 -> estacionamento.listarVagasOcupadas();
                case 4 -> estacionamento.listarVagasLivres();
                case 5 -> System.out.println("Total de veículos: " + estacionamento.totalCarros());
                case 0 -> {
                    System.out.println("Encerrando...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
