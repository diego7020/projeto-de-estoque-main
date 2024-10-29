package dominio;

import java.time.LocalDate;

public class SubClasseProduto extends BaseParametro {
    private int codigoClasse;

    public int getCodigoClasse() {
        return codigoClasse;
    }

    public void setCodigoClasse(int codigoClasse) {
        this.codigoClasse = codigoClasse;
    }

    public SubClasseProduto() {
        super();
    }

    public SubClasseProduto(int codigo, String descricao, LocalDate dataDeInclusao, int codigoClasse) {
        super(codigo, descricao, dataDeInclusao);
        this.codigoClasse = codigoClasse;
    }

}
