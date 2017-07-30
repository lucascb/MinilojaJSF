import models.DaoLoja;
import models.Produto;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

/**
 * Created by lucas on 05/07/17.
 */
@ManagedBean
public class LojaBean {
    private DaoLoja dao;
    private String descricao;
    private double preco;

    public LojaBean() throws IOException {
        this.dao = new DaoLoja();
    }

    // ações
    public String cadastrarProduto() {
        this.dao.addProduto(descricao, preco);
        return "loja";
    }

    public String removerProduto() {
        FacesContext fc = FacesContext.getCurrentInstance();
        int id = Integer.parseInt(fc.getExternalContext().getRequestParameterMap().get("itemSelecionado"));
        this.dao.removeProduto(id);
        return "loja";
    }

    // getters e setters
    public List<Produto> getProducts() {
        return this.dao.getLoja().getProdutos();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
