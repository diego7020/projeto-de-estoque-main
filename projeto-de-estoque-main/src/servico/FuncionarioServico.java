package servico;

import java.util.ArrayList;

import dominio.Funcionario;
import repositorio.FuncionarioRepositorio;

public class FuncionarioServico extends BaseServico<Funcionario> {

    private FuncionarioRepositorio repositorio;
    
    public FuncionarioServico(){
        this.repositorio = new FuncionarioRepositorio();
    }
    
    @Override
    public ArrayList<Funcionario> Navegar() {
        return this.repositorio.Browse();
    }

    @Override
    public Funcionario Ler(int chave) {
        return this.repositorio.Read(chave);
    }

    @Override
    public Funcionario Editar(Funcionario obj) {
        return this.repositorio.Edit(obj);
    }

    @Override
    public Funcionario Adicionar(Funcionario obj) {
        return this.repositorio.Add(obj);
    }

    @Override
    public Funcionario Deletar(int chave) {
        return this.repositorio.Delete(chave);
    }
    
}
