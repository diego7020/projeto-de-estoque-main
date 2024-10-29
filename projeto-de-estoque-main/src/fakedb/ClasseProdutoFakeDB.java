package fakedb;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.ClasseProduto;

public class ClasseProdutoFakeDB extends BaseFakeDB<ClasseProduto>{

    @Override
    public void preencherDados() {
        if(this.tabela == null){
            this.tabela = new ArrayList<>();
        }
        this.tabela.add(new ClasseProduto(1, "Carne", LocalDate.now()));
        this.tabela.add(new ClasseProduto(2, "Bebidas", LocalDate.now()));
        this.tabela.add(new ClasseProduto(3, "Laticinios", LocalDate.now()));
        this.tabela.add(new ClasseProduto(4, "Frutas", LocalDate.now()));
        this.tabela.add(new ClasseProduto(5, "Verduras", LocalDate.now()));
    }
    
    //construtor opcional, pois com ou sem ele, rodará o código da maneira correta. Coloquei ele para visualizar e entender mais facilmente o funcionamento do codigo
    //toda vez que rodarmos uma instancia de ClasseProdutoFakeDB, esse construtor chamará o construtor do preencherdados, la do BaseFakeDB
    public ClasseProdutoFakeDB(){
        super();
    }
    
}
