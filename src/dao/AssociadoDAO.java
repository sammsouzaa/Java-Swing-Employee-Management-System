package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class AssociadoDAO {
	
	 public void cadastrarAssociado(Associado associado) throws ExceptionDAO {
	        String sql = "INSERT INTO Associado (nome, email, endereco, fone, dadosPagamentoID) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement stmt = null;
	        Connection connection = null;

	        try {
	            connection = new ConexaoBD().getConnection();
	            stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	            stmt.setString(1, associado.getNome());
	            stmt.setString(2, associado.getEmail());
	            stmt.setString(3, associado.getEndereco());
	            stmt.setString(4, associado.getTelefone());
	            stmt.setInt(5, associado.getDadosPagamento().getCodPagamentos());

	            stmt.executeUpdate();

	            // Obtendo o ID gerado para o associado recém-inserido
	            int codAssociado = -1;
	            try (var generatedKeys = stmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    codAssociado = generatedKeys.getInt(1);
	                }
	            }

	            // Inserindo dependentes e lanches
	            cadastrarDependentes(codAssociado, associado.getDependentes());
	            cadastrarLanches(codAssociado, associado.getLanches());

	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new ExceptionDAO("Erro ao cadastrar associado: " + e);
	        } finally {
	            // Fechar recursos (stmt, connection) no bloco finally
	        }
	    }

	    public void alterarAssociado(Associado associado) throws ExceptionDAO {
	        String sql = "UPDATE Associado SET nome=?, email=?, endereco=?, fone=?, dadosPagamentoID=? WHERE codAssociado=?";
	        PreparedStatement stmt = null;
	        Connection connection = null;

	        try {
	            connection = new ConexaoBD().getConnection();
	            stmt = connection.prepareStatement(sql);
	            stmt.setString(1, associado.getNome());
	            stmt.setString(2, associado.getEmail());
	            stmt.setString(3, associado.getEndereco());
	            stmt.setString(4, associado.getTelefone());
	            stmt.setInt(5, associado.getDadosPagamento().getCodPagamentos());
	            stmt.setInt(6, associado.getCodAssociado());

	            stmt.executeUpdate();

	            // Atualizando dependentes e lanches
	            alterarDependentes(associado.getCodAssociado(), associado.getDependentes());
	            alterarLanches(associado.getCodAssociado(), associado.getLanches());

	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new ExceptionDAO("Erro ao alterar associado: " + e);
	        } finally {
	            // Fechar recursos (stmt, connection) no bloco finally
	        }
	    }

	    public void excluirAssociado(int codAssociado) throws ExceptionDAO {
	        String sql = "DELETE FROM Associado WHERE codAssociado=?";
	        PreparedStatement stmt = null;
	        Connection connection = null;

	        try {
	            connection = new ConexaoBD().getConnection();
	            stmt = connection.prepareStatement(sql);
	            stmt.setInt(1, codAssociado);

	            stmt.executeUpdate();

	            // Excluindo dependentes e lanches
	            excluirDependentes(codAssociado);
	            excluirLanches(codAssociado);

	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new ExceptionDAO("Erro ao excluir associado: " + e);
	        } finally {
	            // Fechar recursos (stmt, connection) no bloco finally
	        }
	    }

	    public List<Associado> listarAssociados(String nome) throws ExceptionDAO {
	        String sql = "SELECT * FROM Associado WHERE nome LIKE '%" + nome + "%' ORDER BY nome";
	        List<Associado> listaDeAssociados = new ArrayList<>();

	        PreparedStatement stmt = null;
	        Connection connection = null;
	        ResultSet rs = null;

	        try {
	            connection = new ConexaoBD().getConnection();
	            stmt = connection.prepareStatement(sql);
	            rs = stmt.executeQuery();

	            while (rs.next()) {
	                Associado associado = new Associado();
	                associado.setCodAssociado(rs.getInt("codAssociado"));
	                associado.setNome(rs.getString("nome"));
	                associado.setEmail(rs.getString("email"));
	                associado.setEndereco(rs.getString("endereco"));
	                associado.setTelefone(rs.getString("fone"));
	                associado.setDadosPagamento(new DadosPagamento(rs.getString("metodoPagamento"), rs.getString("numeroCartao"), rs.getString("validadeCartao")));
	                // Adicione aqui o código para obter dependentes e lanches se necessário

	                listaDeAssociados.add(associado);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new ExceptionDAO("Erro ao listar associados: " + e);
	        } finally {
	            // Fechar recursos (rs, stmt, connection) no bloco finally
	        }

	        return listaDeAssociados;
	    }

	    private void cadastrarDependentes(int codAssociado, List<DadosBasicos> dependentes) throws SQLException {
	        if (dependentes != null && !dependentes.isEmpty()) {
	            String sql = "INSERT INTO Dependentes (codAssociado, nome, email, endereco, fone) VALUES (?, ?, ?, ?, ?)";
	            try (Connection connection = new ConexaoBD().getConnection();
	                 PreparedStatement stmt = connection.prepareStatement(sql)) {

	                for (DadosBasicos dependente : dependentes) {
	                    stmt.setInt(1, codAssociado);
	                    stmt.setString(2, dependente.getNome());
	                    stmt.setString(3, dependente.getEmail());
	                    stmt.setString(4, dependente.getEndereco());
	                    stmt.setString(5, dependente.getTelefone());
	                    stmt.executeUpdate();
	                }
	            }
	        }
	    }

	    private void alterarDependentes(int codAssociado, List<DadosBasicos> dependentes) throws SQLException {
	    	// Primeiro, exclui todos os dependentes existentes
	        excluirDependentes(codAssociado);

	        // Em seguida, cadastra os novos dependentes
	        cadastrarDependentes(codAssociado, dependentes);
	    }

	    private void excluirDependentes(int codAssociado) throws SQLException {
	    	 String sql = "DELETE FROM Dependentes WHERE codAssociado=?";
	    	    try (Connection connection = new ConexaoBD().getConnection();
	    	         PreparedStatement stmt = connection.prepareStatement(sql)) {

	    	        stmt.setInt(1, codAssociado);
	    	        stmt.executeUpdate();
	    	    }
	    }

	    private void cadastrarLanches(int codAssociado, List<String> lanches) throws SQLException {
	        if (lanches != null && !lanches.isEmpty()) {
	            String sql = "INSERT INTO Lanches (codAssociado, lanche) VALUES (?, ?)";
	            try (Connection connection = new ConexaoBD().getConnection();
	                 PreparedStatement stmt = connection.prepareStatement(sql)) {

	                for (String lanche : lanches) {
	                    stmt.setInt(1, codAssociado);
	                    stmt.setString(2, lanche);
	                    stmt.executeUpdate();
	                }
	            }
	        }
	    }

	    private void alterarLanches(int codAssociado, List<String> lanches) throws SQLException {
	    	// Primeiro, exclui todos os lanches existentes
	        excluirLanches(codAssociado);

	        // Em seguida, cadastra os novos lanches
	        cadastrarLanches(codAssociado, lanches);
	    }

	    private void excluirLanches(int codAssociado) throws SQLException {
	    	String sql = "DELETE FROM Lanches WHERE codAssociado=?";
	        try (Connection connection = new ConexaoBD().getConnection();
	             PreparedStatement stmt = connection.prepareStatement(sql)) {

	            stmt.setInt(1, codAssociado);
	            stmt.executeUpdate();
	        }
	    }
}
