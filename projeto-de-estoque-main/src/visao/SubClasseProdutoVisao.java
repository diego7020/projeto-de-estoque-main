package visao;
import servico.SubClasseProdutoServico;

import java.util.ArrayList;

import dominio.SubClasseProduto;

public class SubClasseProdutoVisao {

    private SubClasseProdutoServico servico;

    public SubClasseProdutoVisao(){
        this.servico = new SubClasseProdutoServico();
    }

    public void Adicionar(SubClasseProduto add){
        this.servico.Adicionar(add);
    }

    public void Exibir(){
        ArrayList<SubClasseProduto> lista = this.servico.Navegar();
        for (SubClasseProduto imprimir : lista) {
            this.ImprimirPorLinha(imprimir);
        }
    }

    private void ImprimirPorLinha(SubClasseProduto imprimir){
        String mensagem = "";
        mensagem += "Codigo da Classe Pai: " + imprimir.getCodigoClasse() + " | ";
        mensagem += "Codigo da Sub Classe: " + imprimir.getCodigo() + " | ";
        mensagem += "Descricao: " + imprimir.getDescricao() + " | ";
        mensagem+= "Data de inclusão: " + imprimir.getDataDeInclusao();
        System.out.println(mensagem);
        System.out.println("=========================================================================================");
        System.out.println();
    }

}
