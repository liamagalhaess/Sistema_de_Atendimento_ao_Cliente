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
import com.ufpr.web2.beans.Funcionario;
import com.ufpr.web2.servlets.LoginServlet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jussarasimoesdecarvalho
 */
public class FuncionarioDAO {
        public List<Funcionario> buscarTodos() throws Exception {
        List<Funcionario> lista = new ArrayList<>();
        try (Connection conexao = ConnectionFactory.getConnection()) {
            String sql;
            sql = "SELECT id_funcionario, email_funcionario, senha_funcionario FROM tb_funcionario";

            PreparedStatement statement = conexao.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt(1));
                funcionario.setEmailFuncionario(rs.getString(2));
                funcionario.setSenhaFuncionario(rs.getString(3));
                lista.add(funcionario);
            }
             ConnectionFactory.closeConnection(conexao, statement);
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
