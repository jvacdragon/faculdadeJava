import java.util.Comparator;

public class CompareDataNacimento implements Comparator<PessoaIMC> {
    public int compare(PessoaIMC p1, PessoaIMC p2){
        if(p1.getDataNasc().compareTo(p2.getDataNasc())>0){
            return 1;
        }else{
            return -1;
        }
    }
}
