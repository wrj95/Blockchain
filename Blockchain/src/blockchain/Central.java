package blockchain;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Central {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Blockchain teste = new Blockchain();

        teste.adicionar(new Block("1", "12/01/2017", "Welinton", "5"));
        teste.adicionar(new Block("2", "24/05/1955", "Mariana Feliciano", "6"));
        teste.adicionar(new Block("3", "16/08/2007", "Tiger", "5"));

        teste.imprimir();
    }

}
