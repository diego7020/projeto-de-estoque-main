package repositorio;
import dominio.Produto;
import fakedb.ProdutoFakeDB;

public class ProdutoRepo extends BaseRepositorio<Produto>{

    private ProdutoFakeDB db;

    public ProdutoRepo(){
        this.db = new ProdutoFakeDB();
        this.dados = db.getTabela();
    }

    @Override
    public Produto Read(int chave) {
        for (Produto produto : dados) {
            if(chave == produto.getCodigo()){
                return produto;
            }
        }
        return null;
    }

    @Override
    public Produto Edit(Produto instancia) {
        Produto ler = this.Read(instancia.getCodigo());
        if(ler != null){
            ler.setDescricao(instancia.getDescricao());
            return ler;
        }
        return null;
    }

    @Override
    public Produto Add(Produto instancia) {
        Produto codigo = this.dados.getLast();
        int proximo = codigo.getCodigo() + 1;
        instancia.setCodigo(proximo);
        this.dados.add(instancia);

        return instancia;
    }

    @Override
    public Produto Delete(int chave) {
        Produto ler = this.Read(chave);
        if(ler != null){
            this.dados.remove(ler);
            return ler;
        }
        return null;
    }

}
