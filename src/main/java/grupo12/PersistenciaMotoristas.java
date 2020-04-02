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


public class PersistenciaMotoristas {
  private static final String SAMPLE_CSV_FILE_PATH = "motoristas.dat";

  public List<Motorista> carregaMotoristas() throws IOException {
    List<Motorista> lista = new ArrayList<Motorista>();
    Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
    for (CSVRecord csvRecord : csvParser) {
      String CPF = csvRecord.get(0);
      String Nome = csvRecord.get(1);

      Motorista Motorista = new Motorista(CPF, Nome);
      
      lista.add(Motorista);
    }

    csvParser.close();

    return lista;
  }

  public boolean persisteMotoristas(List<Motorista> lista) throws IOException {
    String currDir = Paths.get("").toAbsolutePath().toString();
    String completePath = currDir+"/"+SAMPLE_CSV_FILE_PATH;
    Path path = Paths.get(completePath);
    PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8));
    for (Motorista Motorista : lista) {
      String linha = Motorista.getCPF() + "," + Motorista.getNome() + "," + Motorista.getVeiculo() + "," + Motorista.getFormaPgto();
      writer.println(linha);
    }
    return true;
  }
}