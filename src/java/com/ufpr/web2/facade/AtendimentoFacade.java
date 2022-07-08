/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.web2.facade;
import br.com.AtendimentoDAO;
import com.ufpr.web2.beans.Atendimento;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jussarasimoesdecarvalho
 */
public class AtendimentoFacade {
    
    public static void inserirAtendimento(Atendimento atendimento) {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

        try {
            atendimentoDAO.inserirAtendimento(atendimento);

        } catch (Exception ex) {
            Logger.getLogger(AtendimentoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     *
     * @param id
     * @return
     */
    public static Atendimento buscarAtendimento(int id) {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

        try {
            return atendimentoDAO.buscarAtendimento(id);
        } catch (Exception ex) {

            Atendimento atendimento = new Atendimento();
            return atendimento;
        }

    }
    
    public static List<Atendimento> buscarTodos() {
        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();
        
        List<Atendimento> lista = new ArrayList<>();
        
        try {
            
            lista = atendimentoDAO.buscarTodos();
            return lista;
            
            
        } catch (Exception ex) {
            return lista;
        }

    }
    
}
