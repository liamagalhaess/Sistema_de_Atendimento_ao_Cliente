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
public class Produto implements Serializable{
    private int idProduto;
    private String nomeProduto;
    private String descProduto;
    private int pesoProduto;
    private int idCategoria;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public int getPesoProduto() {
        return pesoProduto;
    }

    public void setPesoProduto(int pesoProduto) {
        this.pesoProduto = pesoProduto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    
}
