/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.web2.facade;
import br.com.ClienteDAO;
import br.com.FuncionarioDAO;
import br.com.GerenteDAO;
import com.ufpr.web2.beans.Cliente;
import com.ufpr.web2.beans.Funcionario;
import com.ufpr.web2.beans.Gerente;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jussarasimoesdecarvalho
 */
public class LoginsFacade {
    
    public static List<Cliente> buscarTodosClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();
        
        List<Cliente> lista = new ArrayList<>();
        
        try {
            
            lista = clienteDAO.buscarTodos();
            return lista;
            
            
        } catch (Exception ex) {
            return lista;
        }

    }
    
    public static List<Funcionario> buscarTodosFuncionarios() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        
        List<Funcionario> lista = new ArrayList<>();
        
        try {
            
            lista = funcionarioDAO.buscarTodos();
            return lista;
            
            
        } catch (Exception ex) { 
            return lista;
        }

    }
    
    public static List<Gerente> buscarTodosGerentes() {
        GerenteDAO gerenteDAO = new GerenteDAO();
        
        List<Gerente> lista = new ArrayList<>();
        
        try {
            
            lista = gerenteDAO.buscarTodos();
            return lista;
            
            
        } catch (Exception ex) {
            return lista;
        }

    }
    
}
