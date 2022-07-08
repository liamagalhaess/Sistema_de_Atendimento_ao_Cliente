/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.web2.beans;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author jussarasimoesdecarvalho
 */
public class Atendimento implements Serializable{
    private int idAtendimento;
    private  Timestamp dtHoraAtendimento;
    private String descAtendimento;
    private int idProduto;
    private int idTipoAtendimento;
    private int idCliente;
    private String sitAtendimento;
    private String solucaoAtendimento;

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public Timestamp getDtHoraAtendimento() {
        return dtHoraAtendimento;
    }

    public void setDtHoraAtendimento(Timestamp dtHoraAtendimento) {
        this.dtHoraAtendimento = dtHoraAtendimento;
    }


    public String getDescAtendimento() {
        return descAtendimento;
    }

    public void setDescAtendimento(String descAtendimento) {
        this.descAtendimento = descAtendimento;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdTipoAtendimento() {
        return idTipoAtendimento;
    }

    public void setIdTipoAtendimento(int idTipoAtendimento) {
        this.idTipoAtendimento = idTipoAtendimento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getSitAtendimento() {
        return sitAtendimento;
    }

    public void setSitAtendimento(String sitAtendimento) {
        this.sitAtendimento = sitAtendimento;
    }

    public String getSolucaoAtendimento() {
        return solucaoAtendimento;
    }

    public void setSolucaoAtendimento(String solucaoAtendimento) {
        this.solucaoAtendimento = solucaoAtendimento;
    }
    
    
}
