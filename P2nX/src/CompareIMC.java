import java.util.Comparator;

public class CompareIMC implements Comparator<PessoaIMC> {
    public int compare(PessoaIMC p1, PessoaIMC p2){
        return Float.compare(p1.calculaIMC(), p2.calculaIMC());
    }
}
