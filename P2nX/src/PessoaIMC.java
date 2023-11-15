import java.text.SimpleDateFormat;

public abstract class PessoaIMC extends Pessoa {
    protected float peso;
    protected float altura;
    private String genero;

    public PessoaIMC(String nome, String sobrenome, int dia, int mes, int ano, float peso, float altura, String genero) {
        super(nome, sobrenome, dia, mes, ano);
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
    }

    public PessoaIMC(String nome, String sobrenome, int dia, int mes, int ano, long numCPF, float peso, float altura,
                     String genero) {
        super(nome, sobrenome, dia, mes, ano, numCPF);
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        format.setCalendar(this.getDataNasc());
        String datef = format.format(this.getDataNasc().getTime());

        return "Nome: " + this.getNome() + " " + this.getSobrenome() +
                "\nData de Nascimento: " + datef+
                "\nPeso: " + String.format("%.2f", this.getPeso()) +
                "\nAltura: " +String.format("%.2f",this.getAltura())+
                "\nIMC: " + String.format("%.2f",this.calculaIMC())+ " " + this.resultIMC() +
                "\nGenero: " + this.getGenero();
    }

    public float calculaIMC(){
        return getPeso()/(getAltura()*getAltura());
    }

    public abstract String resultIMC();
    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }
}
