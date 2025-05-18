public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String tipo; // "pequeno", "grande", "moto"

    public Veiculo(String placa, String marca, String modelo, String tipo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo.toLowerCase();
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo.toUpperCase() + " | Placa: " + placa + ", Marca: " + marca + ", Modelo: " + modelo;
    }
}
