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
public class Produto {
    private int id;
    private String description;
    private double price;

    public Produto(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (o instanceof Produto) {
            return ((Produto) o).getId() == this.getId();
        }
        return super.equals(o);
    }
    //*/

    @Override
    public String toString() {
        return "produto(" + id + ", " + description + ", " + price + ")";
    }
    
    
    
}
