import java.util.Comparator;

public class CompareGenero implements Comparator<PessoaIMC> {
    public int compare(PessoaIMC p1, PessoaIMC p2){
        if((p1.getGenero()).compareTo(p2.getGenero()) > 0){
            return 1;
        }
        return -1;
    }
}
