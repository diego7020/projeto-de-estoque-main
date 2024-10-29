package servico;

import java.util.ArrayList;

import dominio.ClasseProduto;
import repositorio.ClasseProdutoRepo;

public class ClasseProdutoServico extends BaseServico<ClasseProduto> {

    private ClasseProdutoRepo repositorio;

    public ClasseProdutoServico(){
        this.repositorio = new ClasseProdutoRepo();
    }

    @Override
    public ArrayList<ClasseProduto> Navegar() {
        return this.repositorio.Browse();
    }

    @Override
    public ClasseProduto Ler(int chave) {
        return this.repositorio.Read(chave);
    }

    @Override
    public ClasseProduto Editar(ClasseProduto obj) {
        return this.repositorio.Edit(obj);
    }

    @Override
    public ClasseProduto Adicionar(ClasseProduto obj) {
        return this.repositorio.Add(obj);
    }

    @Override
    public ClasseProduto Deletar(int chave) {
        return this.repositorio.Delete(chave);
    }
    

}
