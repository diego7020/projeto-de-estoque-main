package visao;

import java.util.ArrayList;
import dominio.Funcionario;
import servico.FuncionarioServico;
import java.util.InputMismatchException;

public class FuncionarioMenu extends BaseMenu {

    private FuncionarioServico srv;

    public FuncionarioMenu(){
        super();
        this.srv = new FuncionarioServico();
    }

    @Override
    public void ExibirMenu() {
        
        String opcao = "0";

        while (!opcao.equals("9")) {
            Util.LimparConsole();
            System.out.println("Cadastro de funcionarios: ");
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
                    System.out.println("\nSaindo...");
                    break;
                
                default:
                    Util.LimparConsole();
                    System.out.println("Opção inválida.");
                    System.out.print("\nClique ENTER para continuar... ");
                    this.scanner.nextLine();
                    this.scanner.nextLine();
                    break;
            }
        }
        
    }

    @Override
    public void Listar() {
        Util.LimparConsole();
        System.out.println("Listando funcionarios...\n");

        ArrayList<Funcionario> lista = this.srv.Navegar();
        if (lista.size() == 0) {
            System.out.println("Lista vaiza.");
        }else{
            for (Funcionario funcionario: lista){
                this.Imprimir(funcionario);
            }
        }
        System.out.print("\nClique ENTER para continuar... ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.LimparConsole();
        ArrayList<Funcionario> lista = this.srv.Navegar();
        if (lista.size() == 0) {
            System.out.println("Lista vaiza.");
        }else{
            System.out.println("Localizando funcionario.");
            
            int cod = 0;
            boolean codigoValido = false;
            
            while (!codigoValido) {
                try {
                    System.out.printf("Informe o codigo do funcionario: ");
                    cod = this.scanner.nextInt();
                    codigoValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("\nErro! Formato não aceito. Entrada esperada: 000\n");
                    this.scanner.next();
                }
            }

            Funcionario cp = this.srv.Ler(cod);

            if (cp != null) {
                this.Imprimir(cp);            
            }else{
                System.out.println("Erro: Funcionário não encontrado.");
            }
        }
        System.out.println("Clique ENTER para continuar.");
        this.scanner.nextLine();
        this.scanner.nextLine();
        
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();
        System.out.println("Adicionando novo funcionario.");

        System.out.printf("Informe o nome: ");
        this.scanner.nextLine();
        String nome = this.scanner.nextLine();

        System.out.printf("Informe o Cargo: ");
        String cargo = this.scanner.nextLine();
        
        double salario = 0;
        boolean salarioValido = false;

        while (!salarioValido) {
            try {
                System.out.print("Informe o salario: ");
                salario = this.scanner.nextDouble();
                salarioValido = true;
            } catch (InputMismatchException e) {
                System.out.println("\nErro! Formato não aceito. Entrada esperada: 000,00\n");
                this.scanner.next();
            }
        }

        System.out.printf("Informe o email: ");
        this.scanner.nextLine();
        String email = this.scanner.nextLine();

        System.out.printf("Informe o telefone: ");
        String telefone = this.scanner.nextLine();

        Funcionario cp = new Funcionario();
        cp.setNome(nome);
        cp.setCargo(cargo);
        cp.setSalario(salario);
        cp.setEmail(email);
        cp.setTelefone(telefone);

        if (this.srv.Adicionar(cp) != null) {
            System.out.println("\nFuncionario adicionado com sucesso.");
        }else{
            System.out.println("\nErro: Funcionario não foi adcionado.");
        }
        System.out.println("\nClique ENTER para continuar..");
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();
        ArrayList<Funcionario> lista = this.srv.Navegar();
        if (lista.size() == 0) {
            System.out.println("Lista vaiza.");
            this.scanner.nextLine();
        }else{
            System.out.println("Atualizando cadastro.");

            System.out.printf("Informe o código do funcionario: ");
            int cod = this.scanner.nextInt();

            Funcionario cp = this.srv.Ler(cod);
            if (cp != null) {
                
                System.out.print("Informe o novo cargo: ");
                this.scanner.nextLine();
                String cargo = this.scanner.nextLine();
                cp.setCargo(cargo);

                double salario = 0;
                boolean salarioValido = false;
                while (!salarioValido) {
                    try {
                        System.out.printf("Informe o novo salario: ");
                        salario = this.scanner.nextDouble();
                        cp.setSalario(salario);
                        salarioValido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("\nErro! Formato não aceito. Entrada esperada: 000,00\n");
                        this.scanner.next();
                    }
                }

                System.out.printf("Informe o novo email: ");
                this.scanner.nextLine();
                String email = this.scanner.nextLine();
                cp.setEmail(email);

                System.out.printf("Informe o novo telefone: ");
                String telefone = this.scanner.nextLine();
                cp.setTelefone(telefone);

                if (this.srv.Editar(cp) != null) {
                    System.out.println("\nAlteração realizada com sucesso.");                
                }
                else{
                    System.out.println("\nErro: Alteração não realizada.");
                }            
            }
            else{
                System.out.println("\nErro: Funcionario não encontrado.");
            }
        }
        System.out.print("\nClique ENTER para continuar.");
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.LimparConsole();
        ArrayList<Funcionario> lista = this.srv.Navegar();
        if (lista.size() == 0) {
            System.out.println("Lista vaiza.");
        }else{
            System.out.println("Removendo.");
            
            int cod = 0;
            boolean codigoValido = false;
            
            while (!codigoValido) {
                try {
                    System.out.printf("Informe o codigo do funcionario a ser removido: ");
                    cod = this.scanner.nextInt();
                    codigoValido = true;
                } catch (InputMismatchException e) {
                    System.out.printf("\nErro! Formato não aceito. Entrada esperada: 000\n");
                    this.scanner.next();
                }
            }

            Funcionario cp = this.srv.Ler(cod); 
            
            if (cp != null) {
                this.srv.Deletar(cod);
                System.out.println("\nFuncinario removido com sucesso.");                
            }else{
                System.out.println("\nErro: Funcionario não encontrado.");
            }
        }
        System.out.print("\nClique ENTER para continuar. ");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    private void Imprimir(Funcionario objeto){
        String mensagem = "";
        mensagem += "Codigo do Funcionario: " + objeto.getCodigo() + " | ";
        mensagem += "Nome: " + objeto.getNome() + " | ";
        mensagem += "Cargo: " + objeto.getCargo() + " | ";
        mensagem += "salario: " + objeto.getSalario() + " | ";
        mensagem += "email: " + objeto.getEmail() + " | ";
        mensagem += "telefone: " + objeto.getTelefone() + " | ";
        System.out.println(mensagem);
        System.out.println("=========================================================================================");
        System.out.println();
    }
    
}
