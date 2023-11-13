import java.util.Comparator;

public class ComparePeso implements Comparator<PessoaIMC> {
    public int compare(PessoaIMC p1, PessoaIMC p2){
        return Float.compare(p1.getPeso(), p2.getPeso());
    }
}
