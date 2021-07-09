
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConexaoBD.ConnectionFactory;
import Objetos.Funcionario;


public class FuncionarioDAO {
        private Connection connection;

	public FuncionarioDAO() {
		try{
                    this.connection = ConnectionFactory.getConnection();
		}
		catch(Exception e)
		{
			System.out.println("Erro na abertura do banco de dados: " + e.getMessage());
		}
	}
    
   public List<Funcionario> getListar(){
       try{
           PreparedStatement stmt = this.connection.prepareStatement("SELECT *  FROM FUNCIONARIO");
           ResultSet rs = stmt.executeQuery();

           List <Funcionario> funcionarios = new ArrayList<Funcionario>();
          
           while (rs.next()){
           
           Funcionario funcionario = new Funcionario();
           funcionario.setMatricula(rs.getLong("matricula"));
           funcionario.setNome(rs.getString("nome"));
           funcionario.setData_nasc(rs.getString("data_nasc"));
           funcionario.setEndereco(rs.getString("endereco"));
           funcionario.setTelefone(rs.getString("telefone"));
           funcionario.setEmail(rs.getString("email"));
           
           funcionarios.add(funcionario);
           }
           rs.close();
           stmt.close();
           return funcionarios;
       
        }  catch (SQLException e) {
            throw new RuntimeException(e);
		}
   
   
   
   }
   public void adiciona(Funcionario funcionario) {
		String sql = "INSERT INTO FUNCIONARIO (nome, data_nasc, endereco, telefone, email) values (?,?,?,?,?)";
		try {
			// prepared statement para insercao
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1,funcionario.getNome());
			stmt.setString(2,funcionario.getData_nasc());
			stmt.setString(3,funcionario.getEndereco());
			stmt.setString(4, funcionario.getTelefone());
                        stmt.setString(5, funcionario.getEmail());

			// executa
			stmt.execute();
			stmt.close();

		} 	catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
   public List<Funcionario> getPesquisar(String nome){
		String sql = "select * from FUNCIONARIO where nome like ?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, '%' + nome + '%');
			ResultSet rs = stmt.executeQuery();

			List<Funcionario> funcionarios = new ArrayList<Funcionario>();

			while (rs.next()) {
				// criando o objeto Contato
				Funcionario funcionario = new Funcionario();
                                funcionario.setMatricula(rs.getLong("matricula"));
                                funcionario.setNome(rs.getString("nome"));
                                funcionario.setData_nasc(rs.getString("data_nasc"));
                                funcionario.setEndereco(rs.getString("endereco"));
                                funcionario.setTelefone(rs.getString("telefone"));
                                funcionario.setEmail(rs.getString("email"));
                                funcionarios.add(funcionario);
                         }
                        rs.close();
                        stmt.close();
                        return funcionarios;
                    } catch (SQLException e) {
			throw new RuntimeException(e);
                    }
	}
	
	public void altera(Funcionario funcionario) {
		String sql = "update FUNCIONARIO set nome=?, data_nasc=?, endereco=?," +
				"telefone=?, email= ? where matricula=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,funcionario.getNome());
			stmt.setString(2,funcionario.getData_nasc());
			stmt.setString(3,funcionario.getEndereco());
			stmt.setString(4, funcionario.getTelefone());
                        stmt.setString(5, funcionario.getEmail());
                        stmt.setLong(6, funcionario.getMatricula());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(int matricula) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from FUNCIONARIO where matricula=?");
			stmt.setLong(1, matricula);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
