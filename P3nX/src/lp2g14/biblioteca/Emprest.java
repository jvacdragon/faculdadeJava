package lp2g14.biblioteca;

import java.util.GregorianCalendar;

public class Emprest {
    private GregorianCalendar dataEmprestimo;
    private GregorianCalendar dataDevolucao;
    private int codigoLivro;
    public Emprest(GregorianCalendar dataEmprestimo, int codigoLivro) {
        this.dataEmprestimo = dataEmprestimo;
        this.codigoLivro = codigoLivro;
    }

    public GregorianCalendar getDataEmprestimo() {
        return dataEmprestimo;
    }

    public GregorianCalendar getDataDevolucao() {
        return dataDevolucao;
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public void setDataEmprestimo(GregorianCalendar dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucao(GregorianCalendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setCodigoLivro(int codigoLivro) {
        this.codigoLivro = codigoLivro;
    }
}
