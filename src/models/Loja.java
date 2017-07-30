/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Loja {
    private List<Produto> produtos = new ArrayList<>();
    
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public void addProduto(Produto p) {
        this.produtos.add(p);
    }
    
    public Produto getProduto(int id) {
        Produto p = null;
        for (Produto produto : this.produtos) {
            if (produto.getId() == id)
                p = produto;
        }
        return p;
    }
    
    public void removeProduto(Produto p) {
        this.produtos.remove(p);
    }
    
}
