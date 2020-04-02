package grupo12;

public class Veiculo {
  private String placa;
  private String marca;
  private String cor;
  private CategoriaVeiculo categoria;
  
  public Veiculo(String placa, String marca, String cor) {
    this.placa = placa;
    this.marca = marca;
    this.cor = cor;
    this.categoria = CategoriaVeiculo.NORMAL;
  }

  public String getPlaca() {
    return this.placa;
  }

  public String getMarca() {
    return this.marca;
  }

  public String getCor() {
    return this.cor;
  }

  public CategoriaVeiculo getCategoria() {
    return this.categoria;
  }
}