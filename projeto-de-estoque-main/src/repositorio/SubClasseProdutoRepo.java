package repositorio;
import dominio.SubClasseProduto;
import fakedb.SubClasseProdutoFakeDB;

public class SubClasseProdutoRepo extends BaseRepositorio<SubClasseProduto> {

    private SubClasseProdutoFakeDB db;

    public SubClasseProdutoRepo(){
        this.db = new SubClasseProdutoFakeDB();
        this.dados = this.db.getTabela();
    }

    @Override
    public SubClasseProduto Read(int chave) {
        for (SubClasseProduto iteravel : dados) {
            if(chave == iteravel.getCodigo()){
                return iteravel;
            }
        }
        return null;
    }

    @Override
    public SubClasseProduto Edit(SubClasseProduto instancia) {
        SubClasseProduto ler = this.Read(instancia.getCodigo());
        if(ler != null){
            ler.setDescricao(instancia.getDescricao());
            return ler;
        }
        return null;
    }

    @Override
    public SubClasseProduto Add(SubClasseProduto instancia) {
        SubClasseProduto adicionar = this.dados.getLast();
        int proximo = adicionar.getCodigo() + 1;
        instancia.setCodigo(proximo);
        this.dados.add(instancia);

        return instancia;
    }

    @Override
    public SubClasseProduto Delete(int chave) {
        SubClasseProduto ler = this.Read(chave);
        if(ler != null){
            this.dados.remove(ler);
            return ler;
        }

        return null;
    }

}
