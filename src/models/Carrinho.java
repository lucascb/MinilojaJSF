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
public class Carrinho {
    private String cliente;
    private List<ItemCarrinho> itens = new ArrayList<>();
    private int count = 0;

    public Carrinho() {}
    
    public Carrinho(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void addProduto(Produto p) {
        this.itens.add(new ItemCarrinho(count, p));
        count++;
    }
    
    public boolean removeProduto(int id) {
        return itens.removeIf(item -> item.getId() == id);
    }
    
    public Produto getProduto(int id) {
        for (ItemCarrinho p : this.itens) {
            if (p.getId() == id)
                return p.getProduto();
        }
        return null;
    }
    
    public List<ItemCarrinho> getItens() {
        return this.itens;
    }
    
    public double getPrecoTotal() {
        double total = 0;
        
        for (ItemCarrinho i : this.itens) {
            total += i.getProduto().getPrice();
        }
        return total;
    }
    
    @Override
    public String toString() {
        return "carrinho(" + this.cliente + ")";
    }
}
