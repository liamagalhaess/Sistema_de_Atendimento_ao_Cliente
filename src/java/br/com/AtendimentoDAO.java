/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com;
import com.ufpr.web2.beans.Atendimento;
import com.ufpr.web2.servlets.LoginServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jussarasimoesdecarvalho
 */
public class AtendimentoDAO {
    public List<Atendimento> buscarTodos() throws Exception {
        List<Atendimento> lista = new ArrayList<>();
        try (Connection conexao = ConnectionFactory.getConnection()) {

            String sql;
            sql = "SELECT id_atendimento, dt_hr_atendimento, dsc_atendimento, id_produto, id_tipo_atendimento, id_cliente, sit_atendimento, solucao_atendimento FROM tb_atendimento";
            
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento.setIdAtendimento(rs.getInt(1));
                atendimento.setDtHoraAtendimento(rs.getTimestamp(2));
                atendimento.setDescAtendimento(rs.getString(3));
                atendimento.setIdProduto(rs.getInt(4));
                atendimento.setIdTipoAtendimento(rs.getInt(5));
                atendimento.setIdCliente(rs.getInt(6));
                atendimento.setSitAtendimento(rs.getString(7));
                atendimento.setSolucaoAtendimento(rs.getString(8));
  
                lista.add(atendimento);
            }
            ConnectionFactory.closeConnection(conexao, statement);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lista;
    }
     
     public Atendimento buscarAtendimento(int id) throws Exception {
        Atendimento atendimento = null;
        try (Connection conexao = ConnectionFactory.getConnection()) {


            String num = Integer.toString(id);

            atendimento = new Atendimento();

            String sql = "select * from tb_atendimento where id_atendimento=(?)";

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, num);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                         
                atendimento.setIdAtendimento(resultSet.getInt(1));
                atendimento.setDtHoraAtendimento(resultSet.getTimestamp(2));
                atendimento.setDescAtendimento(resultSet.getString(3));
                atendimento.setIdProduto(resultSet.getInt(4));
                atendimento.setIdTipoAtendimento(resultSet.getInt(5));
                atendimento.setIdCliente(resultSet.getInt(6));
                atendimento.setSitAtendimento(resultSet.getString(7));
                atendimento.setSolucaoAtendimento(resultSet.getString(8));
            }
            ConnectionFactory.closeConnection(conexao, preparedStatement);

        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("nao buscou atendimento");
        }
        return atendimento;
    }
     
     public void inserirAtendimento(Atendimento atendimento) throws Exception {

        try (Connection conexao = ConnectionFactory.getConnection()) {

            
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
           
            
            PreparedStatement preparedStatement;

            preparedStatement = conexao.prepareStatement("INSERT INTO tb_atendimento (dt_hr_atendimento, dsc_atendimento, id_produto, id_tipo_atendimento, id_cliente, sit_atendimento,solucao_atendimento) VALUES ( ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setTimestamp(1, atendimento.getDtHoraAtendimento());
            preparedStatement.setString(2, atendimento.getDescAtendimento());
            preparedStatement.setInt(3, atendimento.getIdProduto());
            preparedStatement.setInt(4, atendimento.getIdTipoAtendimento());
            preparedStatement.setInt(5, atendimento.getIdCliente());
            preparedStatement.setString(6, atendimento.getSitAtendimento());
            preparedStatement.setString(7, atendimento.getSolucaoAtendimento());


           
            
        
            preparedStatement.executeUpdate();

            ConnectionFactory.closeConnection(conexao, preparedStatement);

        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("nao inseriu atendimento");
        }

    }
    
}
