import static java.lang.Integer.parseInt;

public class ValidaCPF {
    private String cpf;
    public ValidaCPF(String cpf){

    }
    public ValidaCPF(){};
    public String cpfFormat(String cpf){
        if(cpf.length() == 11) return cpf;
        else{
            cpf = cpf.trim();
            char digit;
            for(int i = 3 ; i<12; i+=4){
                digit = cpf.charAt(i);
                if(!Character.isDigit(digit)){
                    cpf = cpf.substring(0, i) + cpf.substring(i+1);
                    i--;
                }
            }
            return cpf;
        }
    }
    public boolean isCpf(String CPF){
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        //1 digito verificador
        sm = 0;
        peso = 10;
        for (i=0; i<9; i++) {
            // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig10 = '0';
        else dig10 = (char)(r + 48);

        //2 digito verificador
        sm = 0;
        peso = 11;
        for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11))
            dig11 = '0';
        else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
        if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
            return(true);
        else return(false);
    }

    public long toLong(String cpf){
        if(isCpf(cpf)){
            return Long.parseLong(cpf);
        } else{
            return -1;
        }
    }
}
