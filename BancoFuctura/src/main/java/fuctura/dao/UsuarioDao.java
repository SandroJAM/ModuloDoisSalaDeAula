package fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fuctura.model.Usuario;

public class UsuarioDao {

	public List<Usuario> consultarPorNome(Connection conexao, Usuario usuario) throws SQLException {

		String comandoDeConsulta = "SELECT * FROM usuario WHERE nome LIKE ?";

		PreparedStatement pstm = conexao.prepareStatement(comandoDeConsulta);

		pstm.setString(1, usuario.getNome());

		ResultSet resultadoConsulta = pstm.executeQuery();

		List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();

		while (resultadoConsulta.next()) {
			// vai entra no loop se tive dados
			//
			int codigoUsuario = resultadoConsulta.getInt("codigo");
			String nomeUsuario = resultadoConsulta.getString("nome");

			Usuario resultadoObjeto = new Usuario();
			resultadoObjeto.setCodigo(codigoUsuario);
			resultadoObjeto.setNome(nomeUsuario);

			listaDeUsuarios.add(resultadoObjeto);
		}

		return listaDeUsuarios;

	}

	public static void consultar(Connection conexao, Usuario u) throws SQLException {
		// Vamos consultar todos os usuarios

		String comandoDeConsulta = "select * from usuario where codigo = ?";

		PreparedStatement pstm = conexao.prepareStatement(comandoDeConsulta);

		ResultSet resultadoConsulta = pstm.executeQuery();

		Usuario resultadoObjeto = new Usuario();

		while (resultadoConsulta.next()) {
			// vai entrar no loop se tiver dados
			//
			int codigoUsuario = resultadoConsulta.getInt("codigo");
			String nomeUsuario = resultadoConsulta.getString("nome");

			System.out.println("Cod. Usuário: " + codigoUsuario);
			System.out.println("Nome Usuário: " + nomeUsuario);

			resultadoObjeto.setCodigo(codigoUsuario);
			resultadoObjeto.setNome(nomeUsuario);

		}
	}

	// inserir um usuário
	public static void inserir(Connection conexao, Usuario usuario) throws SQLException {

		// inserir usuarios
		String sqlInsert = "INSERT INTO usuario (nome, email, idade) values (?, ?, ?)";

		PreparedStatement pstm = conexao.prepareStatement(sqlInsert);

		pstm.setString(1, usuario.getNome());
		pstm.setString(2, usuario.getEmail());
		pstm.setInt(3, usuario.getIdade());

		pstm.execute();

		System.out.println("Registro inserido!");
	}

	public static void excluirPorCPF(Connection conexao, String cpf) throws SQLException {

		String comando = "delete from usuario where cpf = ?";

		PreparedStatement pstm = conexao.prepareStatement(comando);
		pstm.setString(1, cpf);

		pstm.execute();
	}

	public static void excluirPorEmail(Connection conexao, String email) throws SQLException {
		String comando = "delete from usuario where email = ?";

		PreparedStatement pstm = conexao.prepareStatement(comando);
		pstm.setString(1, email);

		pstm.execute();
	}

	public static void excluirPorNome(Connection conexao, String nome) throws SQLException {
		String comando = "delete from usuario where cpf = ?";

		PreparedStatement pstm = conexao.prepareStatement(comando);
		pstm.setString(1, nome);

		pstm.execute();
	}

	// delete usuário pelo código
	public static void excluir(Connection conexao, Usuario usuario) throws SQLException {

		String comando = "delete from usuario where codigo = ?";

		PreparedStatement pstm = conexao.prepareStatement(comando);

		pstm.setInt(1, usuario.getCodigo());

		pstm.execute();
	}
}
