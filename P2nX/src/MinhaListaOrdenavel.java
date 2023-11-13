import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinhaListaOrdenavel {
    private static ArrayList<PessoaIMC> lista;

    public MinhaListaOrdenavel() {
        this.lista = new ArrayList<PessoaIMC>();
    }

    public PessoaIMC add(PessoaIMC p){
        lista.add(p);
        return p;
    }

    public ArrayList<PessoaIMC> getLista() {
        return lista;
    }

    public PessoaIMC get(int i){
        return lista.get(i);
    }

    public ArrayList<PessoaIMC> ordena(int c){
        switch(c){
            case 1 -> Collections.sort(this.lista, new CompareNomeCrescente());
            case 2 -> Collections.sort(this.lista, new CompareNomeDecrescente());
            case 3 -> Collections.sort(this.lista, new ComparePeso());
            case 4 -> Collections.sort(this.lista, new CompareAltura());
            case 5 -> Collections.sort(this.lista, new CompareIMC());
            case 6 -> Collections.sort(this.lista, new CompareDataNacimento());
            case 7 -> Collections.sort(this.lista, new CompareGenero());
            default -> System.out.println("Por favor, escolha uma opção válida");
        }
        return this.lista;
    }

}
