package lp2g14.biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Hashtable;

public class Biblioteca {
    private static int diasEmprestimo = 3;
    private static int maxLivrosEmprest = 3;
    private static float valorMulta = 2f;
    private Hashtable<Integer, Usuario> cadastroUsuario;
    private Hashtable<Integer, Livro> cadastroLivros;

    public Biblioteca() {
        this.cadastroLivros = new Hashtable<Integer, Livro>();
        this.cadastroUsuario = new Hashtable<Integer, Usuario>();
        this.cadastroUsuario.clear();
        this.cadastroLivros.clear();
    }

    public Biblioteca(String db_users, String db_books){
        try{
            leArquivo(db_users);
            leArquivo(db_books);
        }catch(FileNotFoundException err){
            err.printStackTrace();
        }
    }

    public Hashtable<Integer, Usuario> getCadastroUsuario() {
        return cadastroUsuario;
    }

    public Hashtable<Integer, Livro> getCadastroLivros() {
        return cadastroLivros;
    }

    public void cadastraUsuario(Usuario user){
        if(cadastroUsuario.containsKey(user.getCodigoUsuario())){
            System.out.println("Código de Usuário ja cadastrado");
            return;
        }
        cadastroUsuario.put(user.getCodigoUsuario(), user);
    }
    public void cadastraLivro(Livro livro){
        if(cadastroUsuario.containsKey(livro.getCodigoLivro())){
            System.out.println("Código de Usuário ja cadastrado");
            return;
        }
        cadastroLivros.put(livro.getCodigoLivro(), livro);
    }
    public void devolveLivro(Usuario usuario, Livro livro) throws Exception{
        GregorianCalendar current_date = new GregorianCalendar(); //data atual
        ArrayList<Emprest> historicoUsuarios = usuario.getHist(); //historico de livros do usuario
        ArrayList<EmprestPara> historicoLivros = livro.getHist(); //historico de emprestimos do livro
        int locIndexBook = -1;
        int locIndexUser = -1;

        //Achar um objeto onde o codigo do livro bata e tenha a data de devolucao nula
        for(Emprest emprestUsers: historicoUsuarios){
            if(emprestUsers.getCodigoLivro()==(livro.getCodigoLivro())
                    && emprestUsers.getDataDevolucao() == null){
                locIndexUser = historicoUsuarios.indexOf(emprestUsers);
                break;
            }
        }

        for(EmprestPara emprestBooks: historicoLivros){
            if(
                //((Integer) emprestBooks.getCodigoUsuario().equals((Integer) usuario.getCodigoUsuario()))
                    (emprestBooks.getCodigoUsuario() == usuario.getCodigoUsuario())
                            && emprestBooks.getDataDevolucao() == null // Para fazer a devolucao, a data de devolucao precisa ser nula
                            && (emprestBooks.getDataLocacao().compareTo(historicoUsuarios.get(locIndexUser).getDataEmprestimo()) == 0) //Compara a data de emprestimo dentro do historico do livro e do historico do usuario
            ){
                locIndexBook = historicoLivros.indexOf(emprestBooks);
                break;
            }
        }

        // System.out.println(locIndexBook);
        // System.out.println(locIndexUser);

        //Parte de efetivar a operacao de devolucao do livro
        if (locIndexBook == -1 || locIndexUser == -1){
            throw new Exception("Nao ha emprestimos pendentes desse livro para esse usuario!");
        } else{

            GregorianCalendar data_emprest = livro.getHist().get(locIndexBook).getDataLocacao();
            long differenceMilliseconds = current_date.getTimeInMillis() - data_emprest.getTimeInMillis();
            long differenceDays = differenceMilliseconds / (24 * 60 * 60 * 1000);
            try{
                livro.devolve();

                //LIVROS
                EmprestPara modHistoricoLivro = historicoLivros.get(locIndexBook);
                modHistoricoLivro.setDataDevolucao(current_date);
                historicoLivros.set(locIndexBook, modHistoricoLivro);
                livro.setHist(historicoLivros);

                // USUARIOS
                Emprest modHistoricoUsuario = historicoUsuarios.get(locIndexUser);
                modHistoricoUsuario.setDataDevolucao(current_date);
                historicoUsuarios.set(locIndexUser, modHistoricoUsuario);
                usuario.setHist(historicoUsuarios);

                System.out.println("-------- DEVOLUCAO --------");
                System.out.println("O usuario \"" + usuario.getNome() + "\" devolveu com sucesso o livro \"" + livro.getTituloLivro() + "(#" + livro.getCodigoLivro() + ")" + "\"!");
                if(differenceDays == 0){
                    System.out.println("Dias completos de emprestimo: Devolvido no mesmo dia");
                } else{
                    System.out.println("Dias completos de emprestimo: " + differenceDays);
                }
                System.out.println("-------- OBSERVACOES --------");
                if (differenceDays > Biblioteca.diasEmprestimo){
                    System.out.println("Livro devolvido com  atraso! \n" +
                            "Dias de atraso: " + (differenceDays - Biblioteca.diasEmprestimo) + " - Valor da multa: RS " + String.format("%.2f", (Biblioteca.valorMulta * (differenceDays - Biblioteca.diasEmprestimo))) +
                            "\nAplicar multa de descumprimento de prazo ao usuario em questao!"+
                            "\n-------------------------------------");
                } else{
                    System.out.println("Livro devolvido dentro do prazo!\n-------------------------------------");
                }
                System.out.println("=========================================");
            } catch(NenhumaCopiaEmprestadaEx err){
                System.out.println(err.getMessage());
            }
        }
    }

    public void leArquivo(String caminhoArquivo) throws FileNotFoundException{
        FileInputStream fileIn = new FileInputStream(caminhoArquivo);
        switch (caminhoArquivo.substring(0, 14)){
            case "databases/usr_":
                try(ObjectInputStream in = new ObjectInputStream(fileIn);){
                    cadastroUsuario = (Hashtable) in.readObject();
                }catch(ClassNotFoundException ex){
                    ex.printStackTrace();
                }
                catch(IOException ex){
                    ex.printStackTrace();
                }
                break;
            case "databases/lvr_":
                try(ObjectInputStream in = new ObjectInputStream(fileIn);){
                    cadastroLivros = (Hashtable) in.readObject();
                }catch(ClassNotFoundException ex){
                    ex.printStackTrace();
                }
                catch(IOException ex){
                    ex.printStackTrace();
                }
                break;
            default:
                System.out.println("Insira um caminho valido para ler arquivos!");
        }
    }

    private void salvarArquivo(String fileName, Hashtable<?, ?> hashtable) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(hashtable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Hashtable<Integer, Usuario> lerArquivoUsuarios(String fileName) {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            return (Hashtable<Integer, Usuario>) objectIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Hashtable<>();
        }
    }
    public void emprestaLivro(Usuario usuario, Livro livro) {
        try {
            livro.empresta();
            livro.addUsuarioHist(new GregorianCalendar(), null, usuario.getCodigoUsuario());
            usuario.addLivroHist(new GregorianCalendar(), livro.getCodigoLivro());
            System.out.println("Livro emprestado");
        } catch (CopiaNaoDisponivelEx e) {
            System.out.println(e.getMessage());
        }
    }

    public String imprimeLivros() {
        ArrayList<Livro> livros = new ArrayList<>(cadastroLivros.values());
        livros.sort(Comparator.comparing(Livro::getTituloLivro));

        StringBuilder listaLivros = new StringBuilder("Lista de Livros:\n");
        for (Livro livro : livros) {
            listaLivros.append(livro.toString()).append("\n");
        }

        return listaLivros.toString();
    }

    public String imprimeUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>(cadastroUsuario.values());
        usuarios.sort(Comparator.comparing(Usuario::getNome));

        StringBuilder listaUsuarios = new StringBuilder("Lista de Usuários:\n");
        for (Usuario usuario : usuarios) {
            listaUsuarios.append(usuario.toString()).append("\n");
        }

        return listaUsuarios.toString();
    }

    public Livro getLivro(Integer codigoLivro) throws Exception {
        Livro livro = cadastroLivros.get(codigoLivro);
        if (livro == null) {
            throw new Exception("Livro não cadastrado.");
        }
        return livro;
    }

    public Usuario getUsuario(int codigoUsuario) throws Exception {
        Usuario usuario = cadastroUsuario.get(codigoUsuario);
        if (usuario == null) {
            throw new Exception("Usuário não cadastrado.");
        }
        return usuario;
    }

    @Override
    public String toString(){
        return "\nDIAS MAXIMO DE EMPRESTIMO: " + Biblioteca.diasEmprestimo + " dias" +
                "\nNUMERO MAXIMO DE LIVROS POR USUARIO: " + Biblioteca.maxLivrosEmprest + " livros" +
                "\nVALOR DA MULTA POR ATRASO: RS " + String.format("%.2f", Biblioteca.valorMulta) + "\n";
    }
}
