package grupo12;

public class Motorista {
    private String CPF;
    private String Nome;
    private Veiculo veiculo;
    private FormaPagamento[] FormaPagto;
    
    public Motorista(String CPF, String Nome) {
      this.CPF = CPF;
      this.Nome = Nome;
      this.veiculo = new Veiculo("ABC0123", "HYUNDAI", "PRATA");
    }
  
    public String getCPF() {
      return this.CPF;
    }
  
    public String getNome() {
      return this.Nome;
    }
  
    public Veiculo getVeiculo() {
      return this.veiculo;
    }
  
    public FormaPagamento[] getFormaPgto() {
      return this.FormaPagto;
    }
  }