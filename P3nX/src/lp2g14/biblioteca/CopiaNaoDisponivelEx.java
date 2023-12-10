package lp2g14.biblioteca;

import java.io.FileNotFoundException;

public class CopiaNaoDisponivelEx extends FileNotFoundException {
    public CopiaNaoDisponivelEx(String s){
        super("Cópia de livro não disponível");
    }
}
