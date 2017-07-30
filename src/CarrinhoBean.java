import models.DaoLoja;
import models.ItemCarrinho;
import models.Loja;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 29/07/17.
 */
@SessionScoped
@ManagedBean
public class CarrinhoBean {
    private List<ItemCarrinho> itens = new ArrayList<>();
    private Loja loja;
    private int count = 0;
    private double subtotal = 0;

    public CarrinhoBean() throws IOException {
        this.loja = new DaoLoja().getLoja();
    }

    // ações
    public String comprarProduto() {
        FacesContext fc = FacesContext.getCurrentInstance();
        int id = Integer.parseInt(fc.getExternalContext().getRequestParameterMap().get("itemSelecionado"));
        itens.add(new ItemCarrinho(count++, loja.getProduto(id)));
        return "carrinho";
    }

    public String removerProduto() {
        FacesContext fc = FacesContext.getCurrentInstance();
        int id = Integer.parseInt(fc.getExternalContext().getRequestParameterMap().get("itemSelecionado"));
        itens.removeIf(item -> item.getId() == id);
        return "carrinho";
    }

    public String finalizarCompra() {
        this.itens = new ArrayList<>();
        this.count = 0;
        this.subtotal = 0;
        return "carrinho";
    }

    // getters e setters
    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinho> itens) {
        this.itens = itens;
    }

    public double getSubtotal() {
        subtotal = 0;
        for (ItemCarrinho ic : this.itens) {
            subtotal += ic.getProduto().getPrice();
        }
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
