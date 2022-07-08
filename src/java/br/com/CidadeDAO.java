/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com;

import com.ufpr.web2.beans.Cidade;
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
public class CidadeDAO {
    
    public List<Cidade> buscarCidades(String idEstado) throws Exception {
        List<Cidade> lista = new ArrayList<>();
        try (Connection conexao = ConnectionFactory.getConnection()) {
   
            String sql;
            sql = "SELECT id_cidade, nome_cidade, id_estado FROM tb_cidade where id_estado=(?)";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, idEstado);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setIdCidade(rs.getInt(1));
                cidade.setNomeCidade(rs.getString(2));
                cidade.setIdEstado(rs.getInt(3));            
                
                lista.add(cidade);
            }
            ConnectionFactory.closeConnection(conexao, statement);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lista;
    }
    
    
    public static Cidade buscarCidade(int id) throws Exception {
        Cidade cidade = null;
        try (Connection conexao = ConnectionFactory.getConnection()) {


            String num = Integer.toString(id);

            cidade = new Cidade();



            String sql = "select * from tb_cidade where id_cidade=(?)";

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, num);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                cidade.setNomeCidade(resultSet.getString(2));           
                cidade.setIdCidade(resultSet.getInt(1));
                cidade.setIdEstado(resultSet.getInt(3));
            }
            ConnectionFactory.closeConnection(conexao, preparedStatement);

        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("nao buscou cliente");
        }
        return cidade;
    }
    
}
