package lp2g14.biblioteca;

import java.util.GregorianCalendar;

public class EmprestPara {
    private GregorianCalendar dataDevolucao;
    private GregorianCalendar dataLocacao;
    private int codigoUsuario;

    public EmprestPara(GregorianCalendar dataDevolucao, GregorianCalendar dataLocacao, int codigoUsuario) {
        this.dataDevolucao = dataDevolucao;
        this.dataLocacao = dataLocacao;
        this.codigoUsuario = codigoUsuario;
    }

    public GregorianCalendar getDataLocacao() {
        return dataLocacao;
    }

    public GregorianCalendar getDataDevolucao() {
        return dataDevolucao;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setDataDevolucao(GregorianCalendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setDataLocacao(GregorianCalendar dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
}
