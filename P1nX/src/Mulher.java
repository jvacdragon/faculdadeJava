public class Mulher extends Pessoa{
    public Mulher(String nome, String sobrenome, int dia, int mes, int ano) {
        super(nome, sobrenome, dia, mes, ano);
    }

    public Mulher(String nome, String sobrenome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        super(nome, sobrenome, dia, mes, ano, numCPF, peso, altura);
    }

    @Override
    public String toString() {
        return "Homem{Sexo: Homem, " +
                "Idade: " + this.getIdade() + "}";
    }
}
