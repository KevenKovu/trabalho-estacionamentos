import java.time.Duration;
import java.time.LocalDateTime;

public class Estacionamento {
    private Vaga[] vagas;
    private String nome;

    public Estacionamento(String nome, int quantidadeVagas) {
        this.nome = nome;
        this.vagas = new Vaga[quantidadeVagas];
        for (int i = 0; i < quantidadeVagas; i++) {
            vagas[i] = new Vaga(i);
        }
    }

    public boolean estacionar(Veiculo veiculo, int numeroVaga) {
        if (numeroVaga < 0 || numeroVaga >= vagas.length) {
            System.out.println("Número de vaga inválido.");
            return false;
        }
        if (!vagas[numeroVaga].estaLivre()) {
            System.out.println("Erro: Vaga já está ocupada.");
            return false;
        }
        return vagas[numeroVaga].ocupar(veiculo);
    }

    public void liberarVeiculo(String placa) {
        for (Vaga vaga : vagas) {
            if (!vaga.estaLivre() && vaga.getVeiculo().getPlaca().equalsIgnoreCase(placa)) {
                LocalDateTime entrada = vaga.getHorarioEntrada();
                LocalDateTime saida = LocalDateTime.now();
                long horas = Duration.between(entrada, saida).toHours();
                if (horas == 0) horas = 1;

                String tipo = vaga.getVeiculo().getTipo();
                double preco = switch (tipo) {
                    case "moto" -> 8.0;
                    case "grande" -> 25.0;
                    default -> 16.0;
                };

                double total = preco * horas;
                System.out.println("Veículo removido. Tempo: " + horas + " hora(s). Total a pagar: R$ " + total);
                vaga.liberar();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void listarVagasOcupadas() {
        System.out.println("Vagas Ocupadas:");
        for (Vaga vaga : vagas) {
            if (!vaga.estaLivre()) {
                System.out.println("Vaga " + vaga.getNumero() + ": " + vaga.getVeiculo());
            }
        }
    }

    public void listarVagasLivres() {
        System.out.println("Vagas Livres:");
        for (Vaga vaga : vagas) {
            if (vaga.estaLivre()) {
                System.out.println("Vaga " + vaga.getNumero());
            }
        }
    }

    public int totalCarros() {
        int total = 0;
        for (Vaga vaga : vagas) {
            if (!vaga.estaLivre()) {
                total++;
            }
        }
        return total;
    }
}
