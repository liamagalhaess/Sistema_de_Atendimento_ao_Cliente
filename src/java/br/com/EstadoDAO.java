/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com;
import com.ufpr.web2.beans.Estado;
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
public class EstadoDAO {
    public List<Estado> buscarTodos() throws Exception {
        List<Estado> lista = new ArrayList<>();
        try (Connection conexao = ConnectionFactory.getConnection()) {

            String sql;
            sql = "SELECT id_estado, sigla_estado, nome_estado FROM tb_estado";

            
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Estado estado = new Estado();
                estado.setIdEstado(rs.getInt(1));
                estado.setSiglaEstado(rs.getString(2));
                estado.setNomeEstado(rs.getString(3));            
                
                lista.add(estado);
            }
            ConnectionFactory.closeConnection(conexao, statement);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lista;
    }
    
        public static Estado buscarEstado(int id) throws Exception {
        Estado estado = null;
        try (Connection conexao = ConnectionFactory.getConnection()) {



            String num = Integer.toString(id);

            estado = new Estado();



            String sql = "select * from tb_estado where id_estado=(?)";

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, num);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                estado.setNomeEstado(resultSet.getString(2));           
                estado.setIdEstado(resultSet.getInt(1));
     
            }
            ConnectionFactory.closeConnection(conexao, preparedStatement);

        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("nao buscou cliente");
        }
        return estado;
    }
    
}
