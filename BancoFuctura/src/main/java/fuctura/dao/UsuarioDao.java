package fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {
	
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
