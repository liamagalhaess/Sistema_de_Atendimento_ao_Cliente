/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.web2.beans;
import java.io.Serializable;
/**
 *
 * @author jussarasimoesdecarvalho
 */
public class Pessoa implements Serializable{
    private int idPessoa;
    private String nomePessoa;
    private String cpfPessoa;
    private String ruaPessoa;
    private int nrPessoa;
    private String complementoPessoa;
    private String bairroPessoa;
    private String cepPessoa;
    private String telPessoa;
    private int idCidade;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public String getRuaPessoa() {
        return ruaPessoa;
    }

    public void setRuaPessoa(String ruaPessoa) {
        this.ruaPessoa = ruaPessoa;
    }

    public int getNrPessoa() {
        return nrPessoa;
    }

    public void setNrPessoa(int nrPessoa) {
        this.nrPessoa = nrPessoa;
    }

    public String getComplementoPessoa() {
        return complementoPessoa;
    }

    public void setComplementoPessoa(String complementoPessoa) {
        this.complementoPessoa = complementoPessoa;
    }

    public String getBairroPessoa() {
        return bairroPessoa;
    }

    public void setBairroPessoa(String bairroPessoa) {
        this.bairroPessoa = bairroPessoa;
    }

    public String getCepPessoa() {
        return cepPessoa;
    }

    public void setCepPessoa(String cepPessoa) {
        this.cepPessoa = cepPessoa;
    }

    public String getTelPessoa() {
        return telPessoa;
    }

    public void setTelPessoa(String telPessoa) {
        this.telPessoa = telPessoa;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }
    
}
