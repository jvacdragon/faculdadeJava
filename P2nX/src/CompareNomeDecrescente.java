import java.util.Comparator;

public class CompareNomeDecrescente implements Comparator<PessoaIMC> {

    public int compare(PessoaIMC p1, PessoaIMC p2){
        if((p1.getNome() + " " + p1.getSobrenome()).compareTo(p2.getNome() + " " + p2.getSobrenome()) > 0){
            return -1;
        }
        return 1;
    }
}
