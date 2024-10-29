package visao;

import java.util.ArrayList;

import dominio.ClasseProduto;
import servico.ClasseProdutoServico;

public class ClasseProdutoVisao {

    private ClasseProdutoServico srv;

    public ClasseProdutoVisao(){
        this.srv = new ClasseProdutoServico();
    }

    public void Exibir(){
        ArrayList<ClasseProduto> lista = this.srv.Navegar();
        for (ClasseProduto cp : lista) {
            this.Imprimir(cp);
        }
    }

    public void ExibirPorLinha(){
        ArrayList<ClasseProduto> lista = this.srv.Navegar();
        for (ClasseProduto cp : lista) {
            this.ImprimirPorLinha(cp);
        }
    }

    public void Criar(ClasseProduto cp){
        this.srv.Adicionar(cp);
    }

    public void Editar(int chave, ClasseProduto alt){
        ClasseProduto cp = this.srv.Ler(chave);
        if(cp != null){
            cp.setDescricao(alt.getDescricao());
            
        }else{
            System.out.println("Item não localizado.");
        }
        
    }


    public void Remover(int chave){
        ClasseProduto cp = this.srv.Ler(chave);
        if(cp != null){
            this.srv.Deletar(chave);
        }else{
            System.out.println("Item não localizado.");
        }
    }

    private void ImprimirPorLinha(ClasseProduto cp) {
        String mensagem = "";
        mensagem += "Classe de Produto: ";
        mensagem += "Código: " + cp.getCodigo() + " | ";
        mensagem += "Descrição: " + cp.getDescricao() + " | ";
        mensagem += "Data de inclusão: " + cp.getDataDeInclusao();
        System.out.println(mensagem);
        System.out.println("=========================================================================================");
        System.out.println();
    }

    private void Imprimir(ClasseProduto alvo){
        System.out.println("Codigo: " + alvo.getCodigo());
        System.out.println("Descricao: " + alvo.getDescricao());
        System.out.println("Data de inclusao: " + alvo.getDataDeInclusao());
        System.out.println("=================================================================");
        System.out.println();
    }
}
