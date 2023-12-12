package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import model.Treinamento;

public class FuncionarioDAO {
	
	public void cadastrarFuncionario(Funcionario funcionario) throws ExceptionDAO {
        String sql = "INSERT INTO Funcionario (nome, email, endereco, fone, cargo, salario, usuario, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        // Código para inserir treinamentos, empregos e feedbacks se necessário
        // Adicione aqui o código para inserir treinamentos, empregos e feedbacks se necessário

        PreparedStatement stmt = null;
        Connection connection = null;

        try {
            connection = new ConexaoBD().getConnection();
            stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getEndereco());
            stmt.setString(4, funcionario.getTelefone());
            stmt.setString(5, funcionario.getCargo());
            stmt.setDouble(6, funcionario.getSalario());
            stmt.setString(7, funcionario.getUsuario());
            stmt.setString(8, funcionario.getSenha());

            stmt.executeUpdate();

            // Obtendo o ID gerado para o funcionário recém-inserido
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            int codFuncionario = -1;
            if (generatedKeys.next()) {
                codFuncionario = generatedKeys.getInt(1);
            }

            // Inserindo treinamentos, empregos e feedbacks
            cadastrarTreinamentos(codFuncionario, funcionario.getTreinamentos());
            cadastrarEmpregos(codFuncionario, funcionario.getEmpregos());
            cadastrarFeedbacks(codFuncionario, funcionario.getFeedbacks());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao cadastrar funcionário: " + e);
        } finally {
            // Fechar recursos (stmt, connection) no bloco finally
        }
    }
	
	private void cadastrarTreinamentos(int codFuncionario, List<Treinamento> list) throws SQLException {
        if (list != null && !list.isEmpty()) {
            String sql = "INSERT INTO Treinamentos (treinamento, codFuncionario) VALUES (?, ?)";
            try (Connection connection = new ConexaoBD().getConnection();
                 PreparedStatement stmt = connection.prepareStatement(sql)) {

                for (Treinamento treinamento : list) {
                    stmt.setString(1, treinamento.getTitulo());
                    stmt.setInt(2, codFuncionario);
                    stmt.executeUpdate();
                }
            }
        }
    }

    private void cadastrarEmpregos(int codFuncionario, List<String> empregos) throws SQLException {
        if (empregos != null && !empregos.isEmpty()) {
            String sql = "INSERT INTO Empregos (emprego, codFuncionario) VALUES (?, ?)";
            try (Connection connection = new ConexaoBD().getConnection();
                 PreparedStatement stmt = connection.prepareStatement(sql)) {

                for (String emprego : empregos) {
                    stmt.setString(1, emprego);
                    stmt.setInt(2, codFuncionario);
                    stmt.executeUpdate();
                }
            }
        }
    }

    private void cadastrarFeedbacks(int codFuncionario, List<String> feedbacks) throws SQLException {
        if (feedbacks != null && !feedbacks.isEmpty()) {
            String sql = "INSERT INTO Feedbacks (feedback, codFuncionario) VALUES (?, ?)";
            try (Connection connection = new ConexaoBD().getConnection();
                 PreparedStatement stmt = connection.prepareStatement(sql)) {

                for (String feedback : feedbacks) {
                    stmt.setString(1, feedback);
                    stmt.setInt(2, codFuncionario);
                    stmt.executeUpdate();
                }
            }
        }
    }
    
    public void alterarFuncionario(Funcionario funcionario) throws ExceptionDAO {
        String sql = "UPDATE Funcionario SET nome=?, email=?, endereco=?, fone=?, cargo=?, salario=?, usuario=?, senha=? WHERE codFuncionario=?";
        // Adicione aqui o código para alterar treinamentos, empregos e feedbacks se necessário

        PreparedStatement stmt = null;
        Connection connection = null;

        try {
            connection = new ConexaoBD().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getEndereco());
            stmt.setString(4, funcionario.getTelefone());
            stmt.setString(5, funcionario.getCargo());
            stmt.setDouble(6, funcionario.getSalario());
            stmt.setString(7, funcionario.getUsuario());
            stmt.setString(8, funcionario.getSenha());
            stmt.setInt(9, funcionario.getCodFuncionario());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao alterar funcionário: " + e);
        } finally {
            // Fechar recursos (stmt, connection) no bloco finally
        }
    }

    public void excluirFuncionario(int codFuncionario) throws ExceptionDAO {
        String sql = "DELETE FROM Funcionario WHERE codFuncionario=?";
        // Adicione aqui o código para excluir treinamentos, empregos e feedbacks se necessário

        // Adicione aqui o código para excluir treinamentos, empregos e feedbacks se necessário

        PreparedStatement stmt = null;
        Connection connection = null;

        try {
            connection = new ConexaoBD().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codFuncionario);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao excluir funcionário: " + e);
        } finally {
            // Fechar recursos (stmt, connection) no bloco finally
        }
    }

    public List<Funcionario> listarFuncionarios(String nome) throws ExceptionDAO {
        String sql = "SELECT * FROM Funcionario WHERE nome LIKE '%" + nome + "%' ORDER BY nome";
        List<Funcionario> listaDeFuncionarios = new ArrayList<>();
        // Adicione aqui o código para obter treinamentos, empregos e feedbacks se necessário

        PreparedStatement stmt = null;
        Connection connection = null;
        ResultSet rs = null;

        try {
            connection = new ConexaoBD().getConnection();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodFuncionario(rs.getInt("codFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setTelefone(rs.getString("fone"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
                // Adicione aqui o código para obter treinamentos, empregos e feedbacks se necessário

                listaDeFuncionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao listar funcionários: " + e);
        } finally {
            // Fechar recursos (rs, stmt, connection) no bloco finally
        }

        return listaDeFuncionarios;
    }
	
}
