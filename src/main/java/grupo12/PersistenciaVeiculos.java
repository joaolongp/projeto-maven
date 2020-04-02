package grupo12;

import java.util.List;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PersistenciaVeiculos {
  private static final String SAMPLE_CSV_FILE_PATH = "veiculos.dat";

  public List<Veiculo> carregaVeiculos() throws IOException {
    List<Veiculo> lista = new ArrayList<Veiculo>();
    Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
    for (CSVRecord csvRecord : csvParser) {
      String placa = csvRecord.get(0);
      String marca = csvRecord.get(1);
      String cor = csvRecord.get(2);

      Veiculo veiculo = new Veiculo(placa, marca, cor);
      
      lista.add(veiculo);
    }

    csvParser.close();

    return lista;
  }

  public boolean persisteVeiculos(List<Veiculo> lista) throws IOException {
    String currDir = Paths.get("").toAbsolutePath().toString();
    String completePath = currDir+"/"+SAMPLE_CSV_FILE_PATH;
    Path path = Paths.get(completePath);
    PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8));
    for (Veiculo veiculo : lista) {
      String linha = veiculo.getPlaca() + "," + veiculo.getMarca() + "," + veiculo.getCor() + "," + veiculo.getCategoria();
      writer.println(linha);
    }
    return true;
  }
}