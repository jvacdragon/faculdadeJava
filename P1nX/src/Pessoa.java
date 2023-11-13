import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private GregorianCalendar dataNasc;
    private long numCPF;
    private float peso;
    private float altura;
    private static int contP;
    public Pessoa(String nome, String sobrenome, int dia, int mes, int ano){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = new GregorianCalendar(ano,mes,dia);
        contP++;
    }

    public Pessoa(String nome, String sobrenome, int dia, int mes, int ano, long numCPF, float peso, float altura) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = new GregorianCalendar(ano,mes-1,dia);
        this.numCPF = numCPF;
        this.peso = peso;
        this.altura = altura;
        contP++;
    }

    public static int numPessoas(){
        return contP;
    }

    public int getIdade() {

        // Data de hoje.
        GregorianCalendar agora = new GregorianCalendar();
        int ano = 0, mes = 0, dia = 0;

        // Data do nascimento.
        GregorianCalendar nascimento = new GregorianCalendar();
        int anoNasc = 0, mesNasc = 0, diaNasc = 0;

        // Idade.
        int idade = 0;

        if(this.dataNasc != null){
            nascimento.setTime(this.dataNasc.getTime());

            ano = agora.get(Calendar.YEAR);
            mes = agora.get(Calendar.MONTH) + 1;
            dia = agora.get(Calendar.DAY_OF_MONTH);

            anoNasc = nascimento.get(Calendar.YEAR);
            mesNasc = nascimento.get(Calendar.MONTH) + 1;
            diaNasc = nascimento.get(Calendar.DAY_OF_MONTH);

            idade = ano - anoNasc;

            // Calculando diferencas de mes e dia.
            if(mes < mesNasc || dia < diaNasc) {
                idade--;
            }

            // Ultimo teste, idade "negativa".
            if(idade < 0) {
                idade = 0;
            }

        }

        return (idade);

    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
        format.setCalendar(dataNasc);
        String datef = format.format(dataNasc.getTime());

        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNasc=" + datef  +
                ", numCPF=" + new ValidaCPF().cpfFormat("" + numCPF) +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setDataNasc(GregorianCalendar dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setNumCPF(long numCPF) {
        this.numCPF = numCPF;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public GregorianCalendar getDataNasc() {
        return dataNasc;
    }

    public long getNumCPF() {
        return numCPF;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }
}
