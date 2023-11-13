import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private Date nascimento;
    private double peso;
    private double altura;
    private boolean genero;
    private Pessoa pai;
    private Pessoa mae;
    public static int pessoas;

    public Pessoa() throws ParseException {
        contPessoas();
        if(nascimento == null) this.nascimento = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");

    }
    public Pessoa(String name) throws ParseException {
        contPessoas();
        this.nome = name;
        if(nascimento == null) this.nascimento = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");

    }

    public Pessoa(String nome, String sobrenome, Date nascimento, double peso, double altura, boolean genero, Pessoa pai,
                  Pessoa mae) throws ParseException {
        contPessoas();
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.nascimento = nascimento;
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
        this.pai = pai;
        this.mae = mae;
        if(nascimento == null) this.nascimento = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");

    }

    @Override
    public String toString() {
        String generoLiteral;
        if(genero == true) {
            generoLiteral = "Masculino";
        } else generoLiteral = "Feminino";

        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", nascimento=" + nascimento.toString() +
                ", peso=" + peso +
                ", altura=" + altura +
                ", genero=" + generoLiteral +
                ", pai=" + pai +
                ", mae=" + mae +
                ", idade=" + idade() +
                '}';
    }

    private int idade(){
        Calendar dataNascimento = new GregorianCalendar();
        dataNascimento.setTime(nascimento);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
        dataNascimento.add(Calendar.YEAR,age);
        if(today.before(dataNascimento)){
            age--;
        }
        return age;
    }
    private static int contPessoas(){
        pessoas++;
        return pessoas;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setPeso(double peso) {
        if(peso<30d) {
            this.peso = 30d;
            System.out.println("Favor inserir peso válido(maior que 30). Será inserido peso de 30kg enquanto não for " +
                    "corrigido");
        } else this.peso = peso;
    }

    public void setAltura(double altura) {
        if(altura<1d) {
            this.altura = 1d;
            System.out.println("Favor inserir uma altura válida (maior que 1 metro). Será inserida altura de 1 metro " +
                    "enquanto não for corrigido");
        } else this.altura = altura;

    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }

    public void setMae(Pessoa mae) {
        this.mae = mae;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public boolean isGenero() {
        return genero;
    }

    public Pessoa getPai() {
        return pai;
    }

    public Pessoa getMae() {
        return mae;
    }
}
