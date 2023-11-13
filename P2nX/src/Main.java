import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<PessoaIMC> listaPessoas;
        Homem h1 = new Homem("joao", "vitor", 25,5,2003,18233437751l, 75f,
                1.73f);
        Homem h2 = new Homem("joao", "Aguiar", 19,7,2000,18233437751l, 70f,
                1.76f);
        Homem h3 = new Homem("joao", "costa", 4,7,1996,18233437751l, 77f,
                1.68f);
        Homem h4 = new Homem("joao", "pedro", 7,2,2006,18233437751l, 69f,
                1.69f);
        Homem h5 = new Homem("joao", "guilherme", 3,2,2010,18233437751l, 58f,
                1.65f);
        Mulher m1 = new Mulher("maria", "eduarda", 2,5,2003,18233437751l, 65f,
                1.73f);
        Mulher m2 = new Mulher("maria", "vitoria", 3,5,2006,18233437751l, 63f,
                1.65f);
        Mulher m3 = new Mulher("maria", "luisa", 5,5,2003,18233437751l, 58f,
                1.59f);
        Mulher m4 = new Mulher("maria", "ana", 7,5,1999,18233437751l, 55f,
                1.61f);
        Mulher m5 = new Mulher("maria", "sem criatividade", 25,5,2000,18233437751l, 57f,
                1.60f);
        listaPessoas = new ArrayList<>(Arrays.asList(h1,h2,h3,h4,h5,m1,m2,m3,m4,m5));
        MinhaListaOrdenavel minhaListaOrdenavel = new MinhaListaOrdenavel();

        for(PessoaIMC p : listaPessoas){
            minhaListaOrdenavel.add(p);
        }

        for(PessoaIMC p : minhaListaOrdenavel.getLista()){
            System.out.println(p.getNome() + " " + p.getSobrenome());
        }

        int opcaoInicio = -1;
        int opcaoMeio;
        String opcao1 = """
                0. Para sair do programa
                1. Imprimir lista
                """;
        String opcao2 = """
                Escolha seu modo de ordenacao
                1.Alfabetica (A-Z)
                2.Alfabetica (Z-A)
                3.Peso crescente
                4.Altura crescente
                5.IMC crescente
                6.Data de nascimento crescente
                7.Genero
                
                Digite sua opção: 
                """;
        String layoutPessoa = """
                -------------------------------
                Nome: %s %s
                Data de Nascimento: %s
                Peso: %.2f
                Altura: %.2f
                IMC: %.2f %s
                --------------------------------
                """;
        while(opcaoInicio != 0){
            System.out.println(opcao1);
            Scanner scan = new Scanner(System.in);
            opcaoInicio = Integer.parseInt(scan.next());

            if(opcaoInicio == 1){
                System.out.println(opcao2);
                opcaoMeio = Integer.parseInt(scan.next());
                minhaListaOrdenavel.ordena(opcaoMeio);
                for(PessoaIMC p : minhaListaOrdenavel.getLista()){
                    System.out.println("-".repeat(40));
                    System.out.println(p.toString());
                    System.out.println("-".repeat(40));
                }
            }
        }
    }
}
