package fakedb;
import java.time.LocalDate;
import java.util.ArrayList;

import dominio.SubClasseProduto;

public class SubClasseProdutoFakeDB extends BaseFakeDB<SubClasseProduto>{

    @Override
    public void preencherDados(){
        if(this.tabela == null){
            this.tabela = new ArrayList<>();
        }
        this.tabela.add(new SubClasseProduto(1, "Suíno", LocalDate.now(), 1));
        this.tabela.add(new SubClasseProduto(2, "Bovino", LocalDate.now(), 1));
        this.tabela.add(new SubClasseProduto(3, "Refrigerante", LocalDate.now(), 2));
        this.tabela.add(new SubClasseProduto(4, "Água", LocalDate.now(), 2));
    }

    public SubClasseProdutoFakeDB(){
        super();
    }

}
