package visao;

import java.util.ArrayList;
import java.time.LocalDate;
import servico.ClasseProdutoServico;
import dominio.ClasseProduto;

public class ClasseProdutoMenu extends BaseMenu {

    private ClasseProdutoServico srv;

    public ClasseProdutoMenu(){
        super();
        this.srv = new ClasseProdutoServico();
    }

    @Override
    public void ExibirMenu() {

        int opcao = 0;

        while (opcao != 9) {
            Util.LimparConsole();
            System.out.println("CADASTRO DE CLASSES DE PRODUTO");
            System.out.println("""
                1 - Listar
                2 - Localizar
                3 - Adicionar
                4 - Atualizar
                5 - Remover
                9 - Sair
                """);
                System.out.print("Selecione uma opção: ");
            opcao = this.scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.Listar();
                    break;

                case 2:
                    this.Localizar();
                    break;

                case 3:
                    this.Adicionar();
                    break;

                case 4:
                    this.Atualizar();
                    break;

                case 5:
                    this.Remover();
                    break;

                case 9:
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    @Override
    public void Listar() {
        Util.LimparConsole();
        System.out.println("Listando");  

        ArrayList<ClasseProduto> lista = this.srv.Navegar();
        for (ClasseProduto produto : lista) {
            this.Imprimir(produto);
        }
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.LimparConsole();
        System.out.println("Localizando");

        System.out.printf("Informe o codigo da classe do produto: ");
        int cod = this.scanner.nextInt();

        ClasseProduto cp = this.srv.Ler(cod);

        if (cp != null) {
            this.Imprimir(cp);
        }
        else{
            System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                     não encontrada!!
                    ==================
                    """);
        }

        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();
        System.out.println("Adicionando");

        System.out.printf("Informe a descrição: ");
        String descricao = this.scanner.next();

        ClasseProduto cp = new ClasseProduto();
        cp.setDescricao(descricao);
        cp.setDataDeInclusao(LocalDate.now());

        if(this.srv.Adicionar(cp) != null){
            System.out.println("Classe de Produto adicionada com sucesso!");
        }
        else{
            System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                     não adicionada!!
                    ==================
                    """);
        }

        System.out.println("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();
        System.out.println("Atualizando");

        System.out.printf("Informe o codigo da classe do produto: ");
        int cod = this.scanner.nextInt();

        ClasseProduto cp = this.srv.Ler(cod);

        if (cp != null) {
            System.out.println("Informe a nova descrição: ");
            String descricao = this.scanner.next();
            cp.setDescricao(descricao);

            if(this.srv.Editar(cp) != null){//se devolveu diferente de nulo é pq deu certo
                System.out.println("Alteração realizada com sucesso!");
            }
            else{
                System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                       não alterada!!
                    ==================
                    """);
            }
        }else{
            System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                     não encontrada!!
                    ==================
                    """);
        }

        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
}

    @Override
    public void Remover() {
        Util.LimparConsole();
        System.out.println("Removendo"); 
        
        System.out.printf("Informe o codigo da classe do produto: ");
        int cod = this.scanner.nextInt();

        ClasseProduto cp = this.srv.Ler(cod);

        if(cp != null){
            if(this.srv.Deletar(cod) != null){
                System.out.println("Removido com sucesso!");
            }
            else{
                System.out.println("""
                    =======ERRO=======
                     Classe de Produto
                     não encontrada!!
                    ==================
                    """);
            }
        }
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }
    
    private void Imprimir(ClasseProduto objeto){
        String mensagem = "";
        mensagem += "Codigo do Produto: " + objeto.getCodigo() + " | ";
        mensagem += "Descricao: " + objeto.getDescricao() + " | ";
        mensagem += "Data de inclusão: " + objeto.getDataDeInclusao() + " | ";
        System.out.println(mensagem);
        System.out.println("=========================================================================================");
        System.out.println();
    }

}
