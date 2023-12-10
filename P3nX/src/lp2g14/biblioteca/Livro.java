package lp2g14.biblioteca;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Livro {
    private Integer codigoLivro;
    private String tituloLivro;
    private String categoria;
    private int quantidade;
    private int emprestados;
    private ArrayList<EmprestPara> hist;

    public Livro(String tituloLivro, String categoria, int quantidade, int emprestados) {
        this.tituloLivro = tituloLivro;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.emprestados = emprestados;
    }

    public void empresta() throws CopiaNaoDisponivelEx {
        if (emprestados < quantidade) {
            emprestados++;
        } else {
            throw new CopiaNaoDisponivelEx("Todas as cópias estão emprestadas.");
        }
    }
    public void devolve() throws NenhumaCopiaEmprestadaEx {
        if (emprestados > 0) {
            emprestados--;
        } else {
            throw new NenhumaCopiaEmprestadaEx("Nenhuma cópia foi emprestada.");
        }
    }

    public void setCodigoLivro(Integer codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    public void addUsuarioHist(GregorianCalendar dataDevolucao, GregorianCalendar dataLocacao, int codigoUsuario){
        EmprestPara p = new EmprestPara(dataLocacao, dataDevolucao, codigoUsuario);
        hist.add(p);
    }

    public Integer getCodigoLivro() {
        return codigoLivro;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getEmprestados() {
        return emprestados;
    }

    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setEmprestados(int emprestados) {
        this.emprestados = emprestados;
    }

    public void setHist(ArrayList<EmprestPara> hist) {
        this.hist = hist;
    }

    public ArrayList<EmprestPara> getHist() {
        return hist;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Código do Livro: ").append(codigoLivro).append(", Título do Livro: ").append(tituloLivro).append(", Categoria: ").append(categoria).append("\n");
        stringBuilder.append("Quantidade: ").append(quantidade).append(", Emprestados: ").append(emprestados).append("\n");
        stringBuilder.append("Histórico de Empréstimos: \n");
        if(this.hist!=null){
            for (EmprestPara emprestPara : hist) {
                stringBuilder.append("Data Empréstimo: ").append(emprestPara.getDataLocacao()).append(", Data Devolução: ").append(emprestPara.getDataDevolucao()).append(", Código do Usuário: ").append(emprestPara.getCodigoUsuario()).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
