package fuctura.aplicacao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:postgresql://localhost:5432/FucturaSalaDeAula";
		String username = "postgres";
		String password = "toor";

		var conexao = DriverManager.getConnection(url, username, password);

		// scanner
		String nome = "";
		String email = "";
		int idade = 0;

	}

}
