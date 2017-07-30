/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author lucas
 */
public class ItemCarrinho {
    private int id;
    private Produto produto;
    
    public ItemCarrinho(int id, Produto p) {
        this.id = id;
        this.produto = p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto prod) {
        this.produto = prod;
    }    
    
}
