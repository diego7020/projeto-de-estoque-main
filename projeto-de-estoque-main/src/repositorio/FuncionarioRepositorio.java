package repositorio;

import dominio.Funcionario;
import fakedb.FuncionarioFakeDB;

public class FuncionarioRepositorio extends BaseRepositorio<Funcionario> {

    private FuncionarioFakeDB db;
    

    public FuncionarioRepositorio() {
        this.db = new FuncionarioFakeDB();
        this.dados = db.getTabelaFuncionario();
    }

    @Override
    public Funcionario Read(int chave) {
        for(Funcionario funcionario : dados){
            if (chave == funcionario.getCodigo()) {
                return funcionario;                
            }
        }
        return null;
    }

    @Override
    public Funcionario Edit(Funcionario instancia) {
        Funcionario cp = this.Read(instancia.getCodigo());
        if (cp != null) {
            cp.setCargo(instancia.getCargo());
            cp.setSalario(instancia.getSalario());
            cp.setEmail(instancia.getEmail());
            cp.setTelefone(instancia.getTelefone());
            return cp;
        }else{
            return null;
        }
    }

    @Override
    public Funcionario Add(Funcionario instancia) {
        int proxChave;
        if (this.dados.size() == 0) {
            proxChave = 1;
        }else{
            Funcionario cp = this.dados.getLast();
            proxChave = cp.getCodigo() + 1;
        }
        instancia.setCodigo(proxChave);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public Funcionario Delete(int chave) {
        Funcionario cp = this.Read(chave);
        if (cp != null) {
            this.dados.remove(cp);
            return cp;            
        }else{
            return null;
        }   
    } 
}
