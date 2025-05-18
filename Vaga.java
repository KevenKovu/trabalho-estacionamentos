import java.time.LocalDateTime;

public class Vaga {
    private Veiculo veiculo;
    private LocalDateTime horarioEntrada;
    private int numero;

    public Vaga(int numero) {
        this.numero = numero;
        this.veiculo = null;
    }

    public boolean estaLivre() {
        return veiculo == null;
    }

    public boolean ocupar(Veiculo veiculo) {
        if (estaLivre()) {
            this.veiculo = veiculo;
            this.horarioEntrada = LocalDateTime.now();
            return true;
        }
        return false;
    }

    public Veiculo liberar() {
        Veiculo v = this.veiculo;
        this.veiculo = null;
        this.horarioEntrada = null;
        return v;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public int getNumero() {
        return numero;
    }
}
