/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com;
import com.ufpr.web2.beans.Categoria;
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
public class CategoriaDAO {
     public List<Categoria> buscarTodos() throws Exception {
        List<Categoria> lista = new ArrayList<>();
        try (Connection conexao = ConnectionFactory.getConnection()) {

            String sql;
            sql = "SELECT id_categoria, nome FROM tb_categoria";
            
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt(1));
                categoria.setNomeCategoria(rs.getString(2));
  
                lista.add(categoria);
            }
            ConnectionFactory.closeConnection(conexao, statement);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lista;
    }
     
     public static Categoria buscarProduto(int id) throws Exception {
        Categoria categoria = null;
        try (Connection conexao = ConnectionFactory.getConnection()) {



            String num = Integer.toString(id);

            categoria = new Categoria();

            categoria.setIdCategoria(id);

            String sql = "select * from tb_categoria where id_categoria=(?)";

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, num);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                categoria.setNomeCategoria(resultSet.getString(2));           
                categoria.setIdCategoria(resultSet.getInt(1));
            }
            ConnectionFactory.closeConnection(conexao, preparedStatement);

        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("nao buscou cliente");
        }
        return categoria;
    }
}
