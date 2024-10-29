package repositorio;

import java.util.ArrayList;

public abstract class BaseRepositorio<TDominio> {
    
    protected ArrayList<TDominio> dados;

    public ArrayList<TDominio> Browse(){
        return this.dados;
    }

    public abstract TDominio Read(int chave);
    public abstract TDominio Edit(TDominio instancia);
    public abstract TDominio Add(TDominio instancia);
    public abstract TDominio Delete(int chave);

}
