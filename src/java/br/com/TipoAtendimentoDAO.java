/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com;
import com.ufpr.web2.beans.TipoAtendimento;
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
public class TipoAtendimentoDAO {
    public List<TipoAtendimento> buscarTodos() throws Exception {
        List<TipoAtendimento> lista = new ArrayList<>();
        try (Connection conexao = ConnectionFactory.getConnection()) {

            String sql;
            sql = "SELECT id_tipo_atendimento, nome_tipo_atendimento FROM tb_tipo_atendimento";
            
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                TipoAtendimento tipo = new TipoAtendimento();
                tipo.setIdTipoAtendimento(rs.getInt(1));
                tipo.setNomeTipoAtendimento(rs.getString(2));
  
                lista.add(tipo);
            }
            ConnectionFactory.closeConnection(conexao, statement);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lista;
    }
     
     public static TipoAtendimento buscarAtendimento(int id) throws Exception {
        TipoAtendimento tipo = null;
        try (Connection conexao = ConnectionFactory.getConnection()) {

            System.out.println("buscou tipo");

            String num = Integer.toString(id);

            tipo = new TipoAtendimento();

            tipo.setIdTipoAtendimento(id);

            String sql = "select * from tb_tipo_atendimento where id_tipo_atendimento=(?)";

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, num);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                tipo.setNomeTipoAtendimento(resultSet.getString(2));           
                tipo.setIdTipoAtendimento(resultSet.getInt(1));
            }
            ConnectionFactory.closeConnection(conexao, preparedStatement);

        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("nao buscou tipo");
        }
        return tipo;
    }
    
}
