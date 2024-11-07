package fakedb;

import java.util.ArrayList;

import dominio.Funcionario;

public class FuncionarioFakeDB extends BaseFakeDB<Funcionario>{

    @Override
    public void preencherDados() {
        this.tabela = new ArrayList<>();
        if(this.tabela == null){
            this.tabela = new ArrayList<>();
        }

        this.tabela.add(new Funcionario(1, "Diego", "Gerente", 10000, "diego@gmail.com", "67999055818"));
        this.tabela.add(new Funcionario(2, "Pedro", "Auxiliar", 2000, "pedro@hotmail.com", "67990535581"));

    }
    public FuncionarioFakeDB(){
        super();
    }
    
}
