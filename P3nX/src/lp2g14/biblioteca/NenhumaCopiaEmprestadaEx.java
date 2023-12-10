package lp2g14.biblioteca;

import java.io.FileNotFoundException;

public class NenhumaCopiaEmprestadaEx extends FileNotFoundException {
    public NenhumaCopiaEmprestadaEx(String s){
        super("Nenhuma cópia desse livro foi emprestada");
    }
}
