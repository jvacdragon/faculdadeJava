import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExP1Teste {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa pai = new Pessoa("Arlindo", "Costa", formato.parse("27/07/1960"), 70.5d,
                1.72d, true, null, null);
        Pessoa mae = new Pessoa("Inacia", "Aguiar", formato.parse("07/02/1970"), 50.5d,
                1.55d, false, null, null);
        Pessoa joao = new Pessoa("João Vitor", "Aguiar Costa", formato.parse("25/05/2003"), 
                76.5d, 1.76d,true, pai, mae);
        Pessoa a = new Pessoa();
        Pessoa b = new Pessoa("Nome aleatório");
        
        pessoas.add(pai);
        pessoas.add(mae);
        pessoas.add(joao);
        pessoas.add(a);
        pessoas.add(b);
        
        for(Pessoa pessoa : pessoas){
            System.out.println(pessoa.toString());
            System.out.println("\n\n");
        }
        System.out.println(Pessoa.pessoas);
    }
}
