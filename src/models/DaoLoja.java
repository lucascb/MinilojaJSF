/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

/**
 *
 * @author lucas
 */
public class DaoLoja {
    private final Path file = Paths.get("/home/lucas/IdeaProjects/MinilojaJSF/loja.txt");
    private Loja shop;
    private int count = 0;

    public DaoLoja() throws IOException {
        this.shop = parseFile(Files.lines(file));
    }

    public Loja getLoja() {
        return shop;
    }

    public void setLoja(Loja shop) {
        this.shop = shop;
    }
    
    public void addProduto(String desc, double preco) {
        this.shop.addProduto(new Produto(count, desc, preco));
        count++;
        save();
    }
    
    public void removeProduto(int id) {
        for (Produto prod : this.shop.getProdutos()) {
            if (prod.getId() == id) {
                this.shop.removeProduto(prod);
                save();
                return;
            }
        }
    }
    
    // Parseia uma string e devolve uma loja
    private Loja parseFile(Stream<String> file) {
        Loja loja = new Loja();
        count = 0;
        
        file.forEach(line -> {
            String[] values = line.split(" ");
            Produto p = new Produto(count, values[0], Double.parseDouble(values[1]));
            loja.addProduto(p);
            count++;
        });
        
        return loja;
    }
    
    // Persiste a loja no arquivo
    private void save() {
        try (BufferedWriter bw = Files.newBufferedWriter(
                file, 
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {
            
            this.shop.getProdutos().forEach(prod -> {
                try {
                    bw.write(prod.getDescription() + " " 
                            + prod.getPrice() + "\n");    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
