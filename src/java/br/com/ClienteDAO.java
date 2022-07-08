/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ufpr.web2.beans.Cliente;
import com.ufpr.web2.servlets.LoginServlet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jussarasimoesdecarvalho
 */
public class ClienteDAO {
    
    public List<Cliente> buscarTodos() throws Exception {
        List<Cliente> lista = new ArrayList<>();
        try (Connection conexao = ConnectionFactory.getConnection()) {
            String sql;
            sql = "SELECT id_cliente, email_cliente, senha_cliente FROM tb_cliente";

            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Cliente usuario = new Cliente();
                usuario.setIdCliente(rs.getInt(1));
                usuario.setEmailCliente(rs.getString(2));
                usuario.setSenhaCliente(rs.getString(3));
                lista.add(usuario);
            }
             ConnectionFactory.closeConnection(conexao, statement);
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }


    
}
