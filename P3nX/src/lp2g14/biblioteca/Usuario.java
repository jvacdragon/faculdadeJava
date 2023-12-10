package lp2g14.biblioteca;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Usuario extends Pessoa {

    private String endereco;
    private int codigoUsuario;
    private ArrayList<Emprest> hist;

    public Usuario(String nome, String sobrenome, int dia, int mes, int ano, String endereco) {
        super(nome, sobrenome, dia, mes, ano);
        this.endereco = endereco;
    }

    public Usuario(String nome, String sobrenome, int dia, int mes, int ano, long numCPF) {
        super(nome, sobrenome, dia, mes, ano, numCPF);
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public void addLivroHist(GregorianCalendar date, int cod){
        Emprest obj = new Emprest(date, cod);
        hist.add(obj);
    }


    public void setHist(ArrayList<Emprest> hist) {
        this.hist = hist;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public ArrayList<Emprest> getHist() {
        return hist;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString()).append(", Endereço: ").append(endereco).append(", Código do Usuário: ").append(codigoUsuario).append("\n");
        if(this.hist != null){
            stringBuilder.append("Histórico de Empréstimos: \n");
            for (Emprest emprest : hist) {
                stringBuilder.append("Data Empréstimo: ").append(emprest.getDataEmprestimo()).append(", Data Devolução: ").append(emprest.getDataDevolucao()).append(", Código do Livro: ").append(emprest.getCodigoLivro()).append("\n");
            }
        }

        return stringBuilder.toString();
    }
}
