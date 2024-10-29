package visao;

import java.util.ArrayList;

import dominio.Produto;
import servico.ProdutoServico;

public class ProdutoVisao {

    private ProdutoServico servico;

    public ProdutoVisao(){
        this.servico = new ProdutoServico();
    }

    public void Exibir(){
        ArrayList<Produto> lista = this.servico.Navegar();
        for (Produto produto : lista) {
            this.Imprimir(produto);
        }
    }

    private void Imprimir(Produto objeto){
        String mensagem = "";
        mensagem += "Codigo da Sub Classe: " + objeto.getCodigoSubclasse() + " | ";
        mensagem += "Codigo do Produto: " + objeto.getCodigo() + " | ";
        mensagem += "Descricao: " + objeto.getDescricao() + " | ";
        mensagem += "Data de inclusão: " + objeto.getDataDeInclusao() + " | ";
        System.out.println(mensagem);
        System.out.println("=========================================================================================");
        System.out.println();
    }

}
