package br.cefetmg.inf.util;

public final class CPF {

    private CPF() {

    }

    public static boolean ehValido(long cpf) {
        /*   
        variáveis
  cpf: vetor[0..8] de Inteiro;
  v1, v2: Inteiro;
início
  # popula a variável 'cpf' de forma inversa (o menor índice deve conter o dígito mais à direita do CPF)
  # ...

  para i := 0 até tamanho(cpf)-1 faça
    v1 := v1 + cpf[i] * (9 - (i mod 10));
    v2 := v2 + cpf[i] * (9 - ((i + 1) mod 10));
  fim-para
  v1 := (v1 mod 11) mod 10;
  v2 := v2 + v1 * 9;
  v2 := (v2 mod 11) mod 10;

  escreva(v1);
  escreva(v2);
fim.*/
        //TODO: implementar código de validação do CPF

        /*
        str = str.replace('.',' ');
        str = str.replace('-',' ');
        str = str.trim();
        */
       
//        return Long.toString(cpf).matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}");
        return Long.toString(cpf).matches("[0-9]{11}");
    }
}
