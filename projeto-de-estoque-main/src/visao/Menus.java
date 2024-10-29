package visao;

import java.util.Scanner;

public class Menus{
    private ClasseProdutoMenu classeProduto;
    private SubClasseProdutoMenu subClasseProduto;
    private ProdutoMenu produto;
    private FuncionarioMenu funcionario;
    private Scanner scanner = new Scanner(System.in);

    public Menus() {
        this.classeProduto = new ClasseProdutoMenu();
        this.subClasseProduto = new SubClasseProdutoMenu();
        this.produto = new ProdutoMenu();
        this.funcionario = new FuncionarioMenu();
    }

    public void ExibirMenu(){
        String opcao = "0";

        do{
            Util.LimparConsole();
            System.out.println("Menu Central de Opcoes: ");
            System.out.println("1 - Classe Produto");
            System.out.println("2 - Sub Classe Produto");
            System.out.println("3 - Produto");
            System.out.println("4 - Funcionario");
            System.out.println("9 - Sair");
            System.out.print("Selecione uma opção: ");
            opcao = this.scanner.next();

            switch (opcao) {
                case "1":
                    this.classeProduto.ExibirMenu();
                    break;
                
                case "2":
                    this.subClasseProduto.ExibirMenu();
                    break;

                case "3":
                    this.produto.ExibirMenu();
                    break;    

                case "4":
                    this.funcionario.ExibirMenu();
                    break;
                    
                case "9":
                    System.out.println("saindo..");
                    break;

                default:
                    System.out.println("opcao invalida");
                    System.out.print("Clique ENTER para continuar. ");
                    this.scanner.nextLine();
                    this.scanner.nextLine();
                    break;
            }

        }while(!opcao.equals("9"));
    }
    
    

}