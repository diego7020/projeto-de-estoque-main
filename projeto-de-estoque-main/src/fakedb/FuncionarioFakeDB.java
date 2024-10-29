package fakedb;

import java.util.ArrayList;

import dominio.Funcionario;

public class FuncionarioFakeDB extends BaseFuncionarioFakeDB<Funcionario>{

    @Override
    public void preencherDados() {
        this.tabelaFuncionario = new ArrayList<>();
        if(this.tabelaFuncionario == null){
            this.tabelaFuncionario = new ArrayList<>();
        }

        this.tabelaFuncionario.add(new Funcionario(1, "Diego", "Gerente", 10000, "diego@gmail.com", "67999055818"));
        this.tabelaFuncionario.add(new Funcionario(2, "Pedro", "Auxiliar", 2000, "pedro@hotmail.com", "67990535581"));

    }
    public FuncionarioFakeDB(){
        super();
    }
    
}
