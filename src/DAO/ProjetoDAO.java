
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Objetos.*;
import ConexaoBD.ConnectionFactory;

public class ProjetoDAO {
        private Connection connection;

	public ProjetoDAO() {
		try{
			this.connection = ConnectionFactory.getConnection();
		}
		catch(Exception e)
		{
			System.out.println("Erro na abertura do banco de dados: " + e.getMessage());
		}
	}
        public List<Projeto> getListar(){
		try{
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM PROJETO");
			ResultSet rs = stmt.executeQuery();

			List<Projeto> projetos = new ArrayList<Projeto>();

			while (rs.next()) {
				// criando o objeto Contato
				Projeto projeto = new Projeto();
				projeto.setCd_projeto(rs.getLong("cd_projeto"));
				projeto.setNome_projeto(rs.getString("nome_projeto"));
				projeto.setDesc_projeto(rs.getString("desc_projeto"));
				
				// adicionando o objeto a lista
				projetos.add(projeto);
			}

			rs.close();
			stmt.close();
			return projetos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
                
        }
                public void adiciona(Projeto projeto) {
		String sql = "INSERT INTO PROJETO (nome_projeto, desc_projeto) VALUES (?,?)";
		try {
			// prepared statement para insercao
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1,projeto.getNome_projeto());
			stmt.setString(2,projeto.getDesc_projeto());
			

			// executa
			stmt.execute();
			stmt.close();

		} 	catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
    public List<Projeto> getPesquisar(String nome){
		String sql = "SELECT * FROM PROJETO WHERE nome_projeto LIKE ?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, '%' + nome + '%');
			ResultSet rs = stmt.executeQuery();

			List<Projeto> projetos = new ArrayList<Projeto>();

			while (rs.next()) {
				// criando o objeto Contato
				Projeto projeto = new Projeto();
				projeto.setCd_projeto(rs.getLong("cd_nome"));
				projeto.setNome_projeto(rs.getString("nome_projeto"));
                                projeto.setDesc_projeto(rs.getString("desc_projeto"));
				
				// adicionando o objeto a lista
				projetos.add(projeto);
			}

			rs.close();
			stmt.close();
			return projetos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void altera(Projeto projeto) {
		String sql = "UPDATE PROJETO SET nome_projeto=?, desc_projeto=? WHERE cd_nome=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,projeto.getNome_projeto());
			stmt.setString(2,projeto.getDesc_projeto());
			stmt.setLong(3, projeto.getCd_projeto());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}   
        
	public void remove(int cd_projeto) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM PROJETO WHERE cd_projeto=?");
			stmt.setLong(1, cd_projeto);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
        
	
}
