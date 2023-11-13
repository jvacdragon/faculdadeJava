public class Mulher extends PessoaIMC {
    public Mulher(String nome, String sobrenome, int dia, int mes, int ano, float peso, float altura) {
        super(nome, sobrenome, dia, mes, ano, peso, altura, "Mulher");
    }

    public Mulher(String nome, String sobrenome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        super(nome, sobrenome, dia, mes, ano, numCPF, peso, altura, "Mulher");
    }

    @Override
    public String resultIMC() {
        if(this.calculaIMC() < 19) return "Abaixo do peso ideal";
        if(this.calculaIMC() < 25.8) return "Peso ideal";

        return "Acima do peso ideal";
    }
}
