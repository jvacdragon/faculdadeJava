import lp2g14.biblioteca.Biblioteca;
import lp2g14.biblioteca.Livro;
import lp2g14.biblioteca.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        boolean sair = false;
        int opcao;

        while (!sair) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Cadastro");
            System.out.println("2. Empréstimo");
            System.out.println("3. Relatório");
            System.out.println("0. Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("1. Cadastrar Usuário");
                    System.out.println("2. Cadastrar Livro");
                    System.out.println("3. Cadastrar Biblioteca");

                    opcao = scanner.nextInt();
                    cadastro(opcao, biblioteca);
                    break;

                case 2:
                    System.out.println("1. Realizar Empréstimo");
                    System.out.println("2. Realizar Devolução");
                    System.out.println("3. Exibir lista de livros");
                    opcao = scanner.nextInt();
                    emprestimo(opcao, biblioteca);

                    break;

                case 3:
                    System.out.println("1. Listar Cadastro de Usuários");
                    System.out.println("2. Detalhes de Usuário");
                    System.out.println("3. Detalhes de Livro");
                    opcao = scanner.nextInt();
                    relatorio(opcao, biblioteca);

                    break;

                case 0:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }

    private static void relatorio(int opcao, Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
        Integer id;
        switch (opcao) {
            case 1:
                System.out.println(biblioteca.getCadastroUsuario());
                break;
            case 2:
                try {
                    System.out.println("Selecione o id do usuario para detalhes:");
                    id = scanner.nextInt();
                    System.out.println(biblioteca.getUsuario(id));
                } catch (Exception e) {
                    System.out.println("Digite um id de usuário válido.");
                }
                break;
            case 3:
                try {
                    System.out.println("Selecione o id do livro para detalhes:");
                    id = scanner.nextInt();
                    System.out.println(biblioteca.getLivro(id));
                } catch (Exception e) {
                    System.out.println("Digite um id de livro válido.");
                }
            default: {
                System.out.println("Digite uma opção válida");
                break;
            }
        }
    }
    private static void emprestimo(int opcao, Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
        Usuario user;
        Livro book;
        int id;

        switch (opcao) {
            case 1:
                try {
                    System.out.println("Digite código do usuário:");
                    user = biblioteca.getUsuario(scanner.nextInt());
                    System.out.println("Digite código do livro:");
                    book = biblioteca.getLivro(scanner.nextInt());
                    biblioteca.emprestaLivro(user, book);
                } catch (Exception e) {
                    System.out.println("Digite uma opção válida.");
                }
                break;
            case 2:
                try {
                    System.out.println("Digite código do usuário:");
                    user = biblioteca.getUsuario(scanner.nextInt());
                    System.out.println("Digite código do livro:");
                    book = biblioteca.getLivro(scanner.nextInt());
                    biblioteca.devolveLivro(user, book);
                } catch (Exception e) {
                    System.out.println("Digite uma opção válida.");
                }
                break;
            case 3:
                System.out.println(biblioteca.getCadastroLivros());
            default: {
                System.out.println("Digite uma opção válida");
                break;
            }
        }
    }
    private static void cadastro(int opcao, Biblioteca biblioteca){
        Scanner scanner = new Scanner(System.in);

        switch (opcao){
            case 1:
                String nome, sobrenome, endereco;
                int dia, mes, ano;
                try{
                    System.out.println("Digite o nome: ");
                    nome = scanner.nextLine();
                    System.out.println("Digite o sobrenome: ");
                    sobrenome = scanner.nextLine();
                    System.out.println("Digite seu endereço: ");
                    endereco = scanner.nextLine();
                    System.out.println("Dia do nascimento:");
                    dia = scanner.nextInt();
                    System.out.println("Mes do nascimento:");
                    mes = scanner.nextInt();
                    System.out.println("Ano do nascimento:");
                    ano = scanner.nextInt();


                    Usuario user = new Usuario(nome, sobrenome, dia,mes,ano, endereco);
                    user.setCodigoUsuario(biblioteca.getCadastroUsuario().size()+1);
                    biblioteca.cadastraUsuario(user);
                    System.out.println("Usuário cadastrado com sucesso");
                }catch(Exception e){
                    System.out.println("Digite uma opção válida.");
                }
                break;
            case 2:
                String tituloLivro, categoria;
                int quantidadeLivro;
                try{
                    System.out.println("Digite o titulo: ");
                    tituloLivro = scanner.nextLine();
                    System.out.println("Digite a categoria: ");
                    categoria = scanner.nextLine();
                    System.out.println("Digite quantidade:");
                    quantidadeLivro = scanner.nextInt();

                    Livro book = new Livro(tituloLivro, categoria, quantidadeLivro, 0);
                    book.setCodigoLivro(biblioteca.getCadastroLivros().size()+1);
                    biblioteca.cadastraLivro(book);
                    System.out.println("Livro cadastrado com sucesso");
                }catch(Exception e){
                    System.out.println("Digite uma opção válida.");
                }
                break;
            case 3:
                try {
                    String caminhoUser, caminhoBook;
                    System.out.println("Digite o caminho o banco de dados de usuario.");
                    caminhoUser = scanner.nextLine();
                    System.out.println("Digite o caminho o banco de dados de livro.");
                    caminhoBook = scanner.nextLine();
                    Biblioteca biblioteca2 = new Biblioteca(caminhoUser, caminhoBook);
                    System.out.println("Biblioteca criada");
                }catch (Exception e){
                    System.out.println("Erro ao criar biblioteca");
                }
            default: {
                System.out.println("Digite uma opção válida");
                break;
            }
        }
    }
}
