public class Homem extends PessoaIMC {
    public Homem(String nome, String sobrenome, int dia, int mes, int ano, float peso, float altura) {
        super(nome, sobrenome, dia, mes, ano, peso, altura,"Homem");
    }

    public Homem(String nome, String sobrenome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        super(nome, sobrenome, dia, mes, ano, numCPF, peso, altura, "Homem");
    }

    @Override
    public String resultIMC() {
        if(this.calculaIMC() < 20.7) return "Abaixo do peso ideal";
        if(this.calculaIMC() < 26.4) return "Peso ideal";

        return "Acima do peso ideal";
    }
}
