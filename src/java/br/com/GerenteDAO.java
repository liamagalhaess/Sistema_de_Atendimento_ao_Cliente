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
import com.ufpr.web2.beans.Gerente;
import com.ufpr.web2.servlets.LoginServlet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jussarasimoesdecarvalho
 */
public class GerenteDAO {
        public List<Gerente> buscarTodos() throws Exception {
        List<Gerente> lista = new ArrayList<>();
        try (Connection conexao = ConnectionFactory.getConnection()) {
            String sql;
            sql = "SELECT id_gerente, email_gerente, senha_gerente FROM tb_gerente";

            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Gerente gerente = new Gerente();
                gerente.setIdGerente(rs.getInt(1));
                gerente.setEmailGerente(rs.getString(2));
                gerente.setSenhaGerente(rs.getString(3));
                lista.add(gerente);
            }
             ConnectionFactory.closeConnection(conexao, statement);
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
