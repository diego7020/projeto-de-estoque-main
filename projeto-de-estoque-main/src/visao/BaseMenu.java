package visao;

import java.util.Scanner;

public abstract class BaseMenu{
    
    protected Scanner scanner;

    public BaseMenu(){
        this.scanner = new Scanner(System.in); //inicializando scanner
    }

    public abstract void ExibirMenu();

    public abstract void Listar();

    public abstract void Localizar();

    public abstract void Adicionar();

    public abstract void Atualizar();

    public abstract void Remover();
}