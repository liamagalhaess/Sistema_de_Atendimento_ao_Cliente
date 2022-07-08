/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.web2.facade;
import br.com.PessoaDAO;
import com.ufpr.web2.beans.Pessoa;
/**
 *
 * @author jussarasimoesdecarvalho
 */
public class PessoaFacade {
  

    public static void inserirPessoa(Pessoa pessoa) {
        PessoaDAO pessoaDAO = new PessoaDAO();

        try {
            pessoaDAO.inserirpessoa(pessoa);

        } catch (Exception ex) {

            System.out.println("erro inserir");
        }
    }

    public static void removerPessoa(int id) {
        PessoaDAO pessoaDAO = new PessoaDAO();

        try {
            pessoaDAO.removerpessoa(id);

        } catch (Exception ex) {

            System.out.println("erro remover");
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public static Pessoa buscarPessoa(int id) {
        PessoaDAO pessoaDAO = new PessoaDAO();

        try {
            return pessoaDAO.buscarpessoa(id);
        } catch (Exception ex) {

            Pessoa pessoa = new Pessoa();
            return pessoa;
        }

    }

    public static void alterarpessoa(Pessoa pessoa) {
        PessoaDAO pessoaDAO = new PessoaDAO();

        try {
            pessoaDAO.alterarpessoa(pessoa);

        } catch (Exception ex) {

            System.out.println("erro alterar");
        }
    }
    
}
