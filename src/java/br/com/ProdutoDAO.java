/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com;
import com.ufpr.web2.beans.Produto;
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
public class ProdutoDAO {
    public List<Produto> buscarTodos() throws Exception {
        List<Produto> lista = new ArrayList<>();
        try (Connection conexao = ConnectionFactory.getConnection()) {

            String sql;
            sql = "SELECT id_produto, nome_produto, desc_produto, peso_produto, id_categoria FROM tb_produto";
            
            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt(1));
                produto.setNomeProduto(rs.getString(2));
                produto.setDescProduto(rs.getString(3));
                produto.setPesoProduto(rs.getInt(4));
                produto.setIdCategoria(rs.getInt(5));
  
                lista.add(produto);
            }
            ConnectionFactory.closeConnection(conexao, statement);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lista;
    }
     
     public static Produto buscarProduto(int id) throws Exception {
        Produto produto = null;
        try (Connection conexao = ConnectionFactory.getConnection()) {



            String num = Integer.toString(id);

            produto = new Produto();

            produto.setIdProduto(id);

            String sql = "select * from tb_produto where id_produto=(?)";

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, num);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                produto.setIdProduto(resultSet.getInt(1));
                produto.setNomeProduto(resultSet.getString(2));
                produto.setDescProduto(resultSet.getString(3));
                produto.setPesoProduto(resultSet.getInt(4));
                produto.setIdCategoria(resultSet.getInt(5));
            }
            ConnectionFactory.closeConnection(conexao, preparedStatement);

        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("nao buscou cliente");
        }
        return produto;
    }
}
