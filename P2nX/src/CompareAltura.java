import java.util.Comparator;

public class CompareAltura implements Comparator<PessoaIMC> {
    public int compare(PessoaIMC p1, PessoaIMC p2){
        return Float.compare(p1.getAltura(), p2.getAltura());
    }
}
