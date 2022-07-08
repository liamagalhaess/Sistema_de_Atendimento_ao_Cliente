/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com;
import com.ufpr.web2.beans.Pessoa;
import com.ufpr.web2.servlets.LoginServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jussarasimoesdecarvalho
 */
public class PessoaDAO {
    public List<Pessoa> buscarTodos() {
        List<Pessoa> lista = new ArrayList<>();
        try (Connection conexao = ConnectionFactory.getConnection()) {

            String sql;
            sql = "SELECT id_pessoa, nome_pessoa, cpf_pessoa, rua_pessoa, nr_pessoa, complemento_pessoa, bairro_pessoa, cep_pessoa, tel_pessoa, id_cidade FROM tb_pessoa";

            
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt(1));
                pessoa.setNomePessoa(rs.getString(2));
                pessoa.setCpfPessoa(rs.getString(3));
                pessoa.setRuaPessoa(rs.getString(4));
                pessoa.setNrPessoa(rs.getInt(5));
                pessoa.setComplementoPessoa(rs.getString(6));
                pessoa.setBairroPessoa(rs.getString(7));
                pessoa.setCepPessoa(rs.getString(8));
                pessoa.setTelPessoa(rs.getString(9));
                pessoa.setIdCidade(rs.getInt(10));
  
                
                
                lista.add(pessoa);
            }
            ConnectionFactory.closeConnection(conexao, statement);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lista;
    }

    public Pessoa buscarpessoa(int id){
        Pessoa pessoa = null;
        try (Connection conexao = ConnectionFactory.getConnection()) {



            String num = Integer.toString(id);

            pessoa = new Pessoa();

            pessoa.setIdPessoa(id);

            String sql = "select * from tb_pessoa where id_pessoa=(?)";

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, num);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                pessoa.setIdPessoa(resultSet.getInt(1));
                pessoa.setNomePessoa(resultSet.getString(2));
                pessoa.setCpfPessoa(resultSet.getString(3));
                pessoa.setRuaPessoa(resultSet.getString(4));
                pessoa.setNrPessoa(resultSet.getInt(5));
                pessoa.setComplementoPessoa(resultSet.getString(6));
                pessoa.setBairroPessoa(resultSet.getString(7));
                pessoa.setCepPessoa(resultSet.getString(8));
                pessoa.setTelPessoa(resultSet.getString(9));
                pessoa.setIdCidade(resultSet.getInt(10));

            }
            ConnectionFactory.closeConnection(conexao, preparedStatement);

        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("nao buscou pessoa");
        }
        return pessoa;
    }

    public void removerpessoa(int id){

        try (Connection conexao = ConnectionFactory.getConnection()) {

            String num = Integer.toString(id);

            String sql = "DELETE FROM tb_pessoa WHERE id_pessoa=(?)";

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, num);

            preparedStatement.executeUpdate();

            ConnectionFactory.closeConnection(conexao, preparedStatement);

        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("nao removeu pessoa");
        }

    }

    public void alterarpessoa(Pessoa pessoa){

        try (Connection conexao = ConnectionFactory.getConnection()) {

            String num = Integer.toString(pessoa.getIdPessoa());

            String sql = "UPDATE tb_pessoa SET nome_pessoa=(?), cpf_pessoa=(?), rua_pessoa=(?), nr_pessoa=(?), complemento_pessoa=(?), bairro_pessoa=(?), cep_pessoa=(?), tel_pessoa =(?), id_cidade=(?) where id_pessoa=(?)";
           
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, pessoa.getNomePessoa());
            preparedStatement.setString(2, pessoa.getCpfPessoa());
            preparedStatement.setString(3, pessoa.getRuaPessoa());   
            preparedStatement.setInt(4, pessoa.getNrPessoa());
            preparedStatement.setString(5, pessoa.getComplementoPessoa());         
            preparedStatement.setString(6, pessoa.getBairroPessoa());
            preparedStatement.setString(7, pessoa.getCepPessoa());
            preparedStatement.setString(8, pessoa.getTelPessoa());
            preparedStatement.setInt(9, pessoa.getIdCidade());
            preparedStatement.setInt(10, pessoa.getIdPessoa());
            preparedStatement.executeUpdate();
            ConnectionFactory.closeConnection(conexao, preparedStatement);

        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("nao atualizou pessoa");
        }

    }

    public void inserirpessoa(Pessoa pessoa){

        try (Connection conexao = ConnectionFactory.getConnection()) {

            PreparedStatement preparedStatement;

            preparedStatement = conexao.prepareStatement("INSERT INTO tb_pessoa (nome_pessoa, cpf_pessoa, rua_pessoa, nr_pessoa, complemento_pessoa, bairro_pessoa, cep_pessoa, tel_pessoa, id_cidade) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, pessoa.getNomePessoa());
            preparedStatement.setString(2, pessoa.getCpfPessoa());
            preparedStatement.setString(3, pessoa.getRuaPessoa());   
            preparedStatement.setInt(4, pessoa.getNrPessoa());
            preparedStatement.setString(5, pessoa.getComplementoPessoa());         
            preparedStatement.setString(6, pessoa.getBairroPessoa());
            preparedStatement.setString(7, pessoa.getCepPessoa());
            preparedStatement.setString(8, pessoa.getTelPessoa());
            preparedStatement.setInt(9, pessoa.getIdCidade());
        
            preparedStatement.executeUpdate();

            ConnectionFactory.closeConnection(conexao, preparedStatement);

        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("nao atualizou pessoa");
        }

    }
    
}
