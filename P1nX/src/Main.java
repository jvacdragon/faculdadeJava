public class Main {
    public static void main(String[] args) {
        System.out.println("abcdef".substring(0, 2) + "abcdef".substring(3));
        System.out.println(new ValidaCPF("").cpfFormat("748.425.990-06"));
        System.out.println(Pessoa.numPessoas());
        Pessoa a = new Pessoa("joao", "vitor", 25,5,2003,74842599006l, 75f,
                1.73f);
        System.out.println(a.toString());
        Pessoa b = new Pessoa("joao", "vitor", 13,5,2000,18233437751l, 75f,
                1.73f);
        System.out.println(Pessoa.numPessoas());
        System.out.println(b.getIdade());
        Homem c = new Homem("joao", "vitor", 26,7,1960,74842599006l, 75f,
                1.73f);
        System.out.println(c.toString());
    }
}
