package visao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import dominio.Produto;
import servico.ProdutoServico;

public class ProdutoMenu extends BaseMenu{

    private ProdutoServico srv;

    public ProdutoMenu(){
        super();
        this.srv = new ProdutoServico();
    }

    @Override
    public void ExibirMenu() {
        String opcao = "0";
        
        do{
            Util.LimparConsole();
            System.out.println("Produtos: ");
            System.out.println("1 - Listar");
            System.out.println("2 - Localizar");
            System.out.println("3 - Adicionar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("9 - Sair");
            System.out.print("Selecione uma opção: ");
            opcao = this.scanner.next();

            switch (opcao) {
                case "1":
                    this.Listar();
                    break;
                
                case "2":
                    this.Localizar();
                    break;
                        
                case "3":
                    this.Adicionar();
                    break;
                    
                case "4":
                    this.Atualizar();
                    break;
                        
                case "5":
                    this.Remover();
                    break;
                    
                case "9":
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    Util.LimparConsole();
                    System.out.println("Opção inválida.");
                    System.out.print("Clique ENTER para continuar. ");
                    this.scanner.nextLine();
                    this.scanner.nextLine();
                    break;
        }
    }while(!opcao.equals("9"));
    }

    @Override
    public void Listar() {
        Util.LimparConsole();
        ArrayList<Produto> lista = this.srv.Navegar();
        if(lista.size() == 0){
            System.out.println("lista vazia");
        }else{
            System.out.println("Listando");
            for (Produto produto : lista) {
                this.Imprimir(produto);
        }
    }
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.LimparConsole();
        ArrayList<Produto> lista = this.srv.Navegar();
        if(lista.size() == 0){
            System.out.println("lista vazia");
        }else{
            System.out.println("Localizando");
            int cod = 0;
            boolean codigoValido = false;

            while (!codigoValido) {
            try {
                System.out.print("Informe o codigo do produto: ");
                cod = this.scanner.nextInt();
                codigoValido = true; 
        } catch (InputMismatchException e) {
            System.out.println("ERRO!! Digite um número válido.");
            this.scanner.next(); 
        }
    }
        Produto cp = this.srv.Ler(cod);

        if (cp != null) {
            this.Imprimir(cp);
        }
        else{
            System.out.println("ERRO!! Produto não encontrado!");
        }
    }
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();
        System.out.println("Adicionando...");

        int cod = 0;
        boolean codigoValido = false;

        while(!codigoValido){
            try {
                System.out.print("informe o codigo da Subclasse: ");
                cod = this.scanner.nextInt();
                this.scanner.nextLine();
                codigoValido = true;
            } catch (InputMismatchException e) {
                System.out.println("ERRO! Digite um codigo valido.");
                this.scanner.next();
            }
        }

        System.out.printf("Informe a descrição: ");
        String descricao = this.scanner.next();

        Produto cp = new Produto();
        cp.setCodigoSubclasse(cod);
        cp.setDescricao(descricao);
        cp.setDataDeInclusao(LocalDate.now());


        if(this.srv.Adicionar(cp) != null){
            System.out.println("Produto adicionado com sucesso!");
        }
        else{
            System.out.println("ERRO! produto nao adicionado.");
        }

        System.out.println("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();
        ArrayList<Produto> lista = this.srv.Navegar();
        if(lista.size() == 0){
            System.out.println("lista vazia");
            this.scanner.nextLine();
        }else{
        System.out.println("Atualizando");

        int cod = 0;
        boolean codigoValido = false;

        while (!codigoValido) {
            try {
                System.out.print("Informe o codigo do produto: ");
                cod = this.scanner.nextInt();
                codigoValido = true; 
            } catch (InputMismatchException e) {
                System.out.println("ERRO!! Digite um número válido.");
                this.scanner.next(); 
            }
        }

        Produto cp = this.srv.Ler(cod);

        if (cp != null) {
            System.out.println("Informe a nova descrição: ");
            String descricao = this.scanner.next();
            cp.setDescricao(descricao);

            if(this.srv.Editar(cp) != null){
                System.out.println("Alteração realizada com sucesso!");
            }
            else{
                System.out.println("ERRO!! Atualizacao não realizada.");
            }
        }
        else{
            System.out.println("ERRO!! produto não encontrado."); 
    }
}
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.LimparConsole();
        ArrayList<Produto> lista = this.srv.Navegar();
        if(lista.size() == 0){
            System.out.println("lista vazia");
        }else{
        System.out.println("Removendo"); 
        
        int cod = 0;
        boolean codigoValido = false;

        while (!codigoValido) {
        try {
            System.out.print("Informe o codigo do produto a ser removido: ");
            cod = this.scanner.nextInt();
            codigoValido = true; 
        } catch (InputMismatchException e) {
            System.out.println("ERRO!! Digite um número válido.");
            this.scanner.next(); 
        }
    }

        Produto cp = this.srv.Ler(cod);

        if(cp != null){
            if(this.srv.Deletar(cod) != null){
                System.out.println("Removido com sucesso!");
            }
            else{
                System.out.println("ERRO!! Produto não encontrado.");
            }
        }
    }
        System.out.print("Clique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }
    
    private void Imprimir(Produto objeto){
        String mensagem = "";
        mensagem += "Codigo da SubClasse: " + objeto.getCodigoSubclasse() + " | ";
        mensagem += "Codigo do Produto: " + objeto.getCodigo() + " | ";
        mensagem += "Descricao: " + objeto.getDescricao() + " | ";
        mensagem += "Data de inclusão: " + objeto.getDataDeInclusao() + " | ";
        System.out.println(mensagem);
        System.out.println("=========================================================================================");
        System.out.println();
    }

}
