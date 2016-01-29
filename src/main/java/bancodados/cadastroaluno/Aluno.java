package bancodados.cadastroaluno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Aluno {
  private String matricula;
  public String getMatricula() {return matricula;}
  public void setMatricula(String matricula) {this.matricula = matricula;}
  
  private String nome;
  public String getNome() {return nome;}
  public void setNome(String nome) {this.nome = nome;}
  
  private String fone;
  public String getFone() {return fone;}
  public void setFone(String fone) {this.fone = fone;}
  
  private String cpf;
  public String getCpf() {return cpf;}
  public void setCpf(String cpf) {this.cpf = cpf;}

  public void incluir() {
    try {
      //Obt�m a conex�o.
      String url = "jdbc:derby:C:\\banco-de-teste;create=true";
      Connection conn = DriverManager.getConnection(url);
      //Cria a senten�a SQL.
      String sql = "insert into aluno (matricula, nome, fone, cpf) values (?, ?, ?, ?)";
      //Obt�m refer�ncia para uma senten�a SQL.
      PreparedStatement prepareStatement = conn.prepareStatement(sql);
      prepareStatement.setString(1, matricula);
      prepareStatement.setString(2, nome);
      prepareStatement.setString(3, fone);
      prepareStatement.setString(4, cpf);
      //Executa a instru��o SQL.
      prepareStatement.executeUpdate();
      //Fecha a sentença.
      prepareStatement.close();
      //Fecha a conex�o.
      conn.close();
    } catch(Throwable e) {
      //Para repassar a exce��o para o container tratar.
      throw new RuntimeException(e);
    }
  }
}
