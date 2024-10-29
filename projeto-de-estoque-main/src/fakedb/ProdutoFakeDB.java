package fakedb;
import java.time.LocalDate;
import java.util.ArrayList;

import dominio.Produto;

public class ProdutoFakeDB extends BaseFakeDB<Produto> {

    @Override
    public void preencherDados() {
        if(this.tabelaProduto == null){
            this.tabelaProduto = new ArrayList<>();
        }
        this.tabelaProduto.add(new Produto(1, "Costela de Porco", LocalDate.now(), 1, 23.50));
        this.tabelaProduto.add(new Produto(2, "Patinho Moído Bovino", LocalDate.now(), 2, 32.50));
        this.tabelaProduto.add(new Produto(3, "Coca Cola", LocalDate.now(), 3, 10.00));
    }

    public ProdutoFakeDB(){
        super();
    }

}