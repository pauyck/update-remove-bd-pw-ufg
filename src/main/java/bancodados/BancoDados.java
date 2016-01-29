package bancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDados {
  public static void main(String[] args) throws SQLException {
    // Derby em memória.
    // jdbc:derby:memory:banco-de-dados;create=true

    // MySQL
    // jdbc:mysql://localhost/banco-de-dados

    //Obter uma conexão com o banco de dados.
    //URL de conexão com o banco de dados Derby local.
    String url = "jdbc:derby:C:\\banco-de-teste;create=true";
    Connection conn = DriverManager.getConnection(url);

//    conn.setAutoCommit(false);
//    try {
      //Opera��o de d�bito.
      //Opera��ocommit();
//    } catch (Throwable e) {
//      conn.rollback();
//    }
    
    

    //listarAlunos(conn);
    //apagarAluno(conn);
    //alterarAluno(conn);
    //incluirAluno(conn);
    //criarTabelaAluno(conn);

    conn.close();
  }

  private static void listarAlunos(Connection conn) throws SQLException {
    String sql = "select * from aluno order by matricula";
    //Obtém referência para uma sentença SQL.
    PreparedStatement prepareStatement = conn.prepareStatement(sql);
    //Executa a instrução SQL.
    ResultSet rs = prepareStatement.executeQuery();
    while (rs.next()) {
      int matricula = rs.getInt("matricula");
      String nome = rs.getString("nome");

      System.out.println("Matrícula: " + matricula);
      System.out.println("Nome: " + nome);
      System.out.println();
    }
    rs.close();
    prepareStatement.close();
  }

  private static void apagarAluno(Connection conn) throws SQLException {
    String sql = "delete from aluno where matricula=?";
    //Obtém referência para uma sentença SQL.
    PreparedStatement prepareStatement = conn.prepareStatement(sql);
    prepareStatement.setInt(1, 1);
    //Executa a instrução SQL.
    prepareStatement.executeUpdate();
    prepareStatement.close();
  }

  private static void alterarAluno(Connection conn) throws SQLException {
    String sql = "update aluno set nome=? where matricula=?";
    //Obtém referência para uma sentença SQL.
    PreparedStatement prepareStatement = conn.prepareStatement(sql);
    prepareStatement.setString(1, "Marcantônio");
    prepareStatement.setInt(2, 1);
    //Executa a instrução SQL.
    prepareStatement.executeUpdate();
    prepareStatement.close();
  }

  private static void incluirAluno(Connection conn) throws SQLException {
    String sql = "insert into aluno (matricula, nome) values (?, ?)";
    //Obtém referência para uma sentença SQL.
    PreparedStatement prepareStatement = conn.prepareStatement(sql);
    prepareStatement.setInt(1, 2);
    prepareStatement.setString(2, "Maria");
    //Executa a instrução SQL.
    prepareStatement.executeUpdate();
    prepareStatement.close();
  }

  private static void criarTabelaAluno(Connection conn) throws SQLException {
    String sql = "create table aluno (";
    sql += "matricula int, ";
    sql += "nome varchar(255) ";
    sql += ")";

    //Obtém referência para uma sentença SQL.
    PreparedStatement prepareStatement = conn.prepareStatement(sql);
    //Executa a instrução SQL.
    prepareStatement.executeUpdate();
    prepareStatement.close();
  }
}
