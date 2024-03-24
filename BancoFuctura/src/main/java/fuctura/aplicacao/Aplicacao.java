package fuctura.aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Aplicacao {

	public static void inserir(Connection conexao, String nome, String email, int idade) throws SQLException {
		
		System.out.println("Conectado Com sucesso!");
		
		// 1, 2, 3
		String comandoInsert = "insert into usuario (nome, idade, email) values (?, ?, ?)";

		PreparedStatement pstm = conexao.prepareStatement(comandoInsert);

		pstm.setInt(2, idade);
		pstm.setString(1, nome);
		pstm.setString(3, email);

		pstm.execute();

		System.out.println("Registro Inserido  com sucesso!");

	}

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:postgresql://localhost:5432/FucturaSalaDeAula";
		String username = "postgres";
		String password = "toor";

		var conexao = DriverManager.getConnection(url, username, password);

		// scanner
		System.out.print("Informe o código do usuário: ");
		int codigo = sc.nextInt();
		String nome = "Roberto Dantas";
		String email = "roberto@localhost";
		int idade = 42;

		inserir(conexao, nome, email, idade);

		System.out.println("finalizou o inserir");
	

		consultar(conexao, codigo );
	}

	public static void consultar(Connection conexao, int codigoDoUsuario) throws SQLException {
		// Vamos consultar todos os usuarios

		String comandoDeConsulta = "select * from usuario where codigo = ?";

		PreparedStatement pstm = conexao.prepareStatement(comandoDeConsulta);

		pstm.setInt(1, codigoDoUsuario);

		ResultSet resultadoConsulta = pstm.executeQuery();

		while (resultadoConsulta.next()) {
			// vai entrar no loop se tiver dados
			//
			int codigoUsuario = resultadoConsulta.getInt("codigo");
			String nomeUsuario = resultadoConsulta.getString("nome");

			System.out.println("Cod. Usuário: " + codigoUsuario);
			System.out.println("Nome Usuário: " + nomeUsuario);

		}
	}

}
