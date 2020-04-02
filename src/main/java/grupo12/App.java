package grupo12;

import java.io.IOException;
import java.util.List;

public class App {
  public static void main(String[] args) {
    try {
      PersistenciaVeiculos pv = new PersistenciaVeiculos();
      List<Veiculo> veiculos = pv.carregaVeiculos();

      if (pv.persisteVeiculos(veiculos)) {
        System.out.println("Veiculos salvos com sucesso.");
      }
    } catch (IOException exception) {
      System.err.format("Erro de E/S: %s%n", exception);
    }
  }
}

