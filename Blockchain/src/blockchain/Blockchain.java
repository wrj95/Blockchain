package blockchain;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Blockchain {
    
    //The ArraList to be the chain
    ArrayList<Block> chain;

    public Blockchain() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.chain = new ArrayList<>();

        //Add InitialBlock
        this.chain.add(createGenesisBlock());

    }

    //Bloco Inicial to init the Blockchain
    private Block createGenesisBlock() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return new Block("0", "0/0/0", "0", "0");
    }

    public Block getLatestBlock() {
        //Get Back one Block to catch the hash the previous Block
        return chain.get(chain.size() - 1);
    }

    public void adicionar(Block addBlock) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //Catch the hash of the previous Block
        addBlock.setPrevHash(getLatestBlock().getHash());
        //Calculate new Hash for this Block
        addBlock.setHash(addBlock.calcularHash());

        if(isValidChain()){
            //Add Block in the chain
            chain.add(addBlock);
             System.out.println("Block aditioned with success");
        }else{ 
            System.out.println("Not was possible add Block");
        }
        
    }

    private boolean isValidChain() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //Valid of error
        int hashErro = 0;
        int prevHashErro = 0;
        
        //Go Throught all Blockchain for see the hash and previus hash are compatible
        for (int i = 1; i < chain.size(); i++) {
            //Get the Hash 
            String hashAtual = chain.get(i).getHash();
            //Get previusHash
            String prevHashAtual = chain.get(i - 1).getHash();

            //var aux for calculate to comparation
            String aux = chain.get(i).calcularHash();
            String aux2 = chain.get(i - 1).calcularHash();
            if (!hashAtual.equals(aux)) {
                //get any difference, hashErro counts the error
                hashErro++;
            }
            if (!prevHashAtual.equals(aux2.intern())) {
                 //get any difference, prevhashErro counts the error
                prevHashErro++;
            }
        }

        //If not have any error, return true...
        if (prevHashErro == 0 && hashErro == 0) {
            return true;
        }
        //...else return false and not valid the operation
        else{
        return false;
        }
    }
    
    public void imprimir() {
        for (int i = 1; i < chain.size(); i++) {
            //Print on the screen the information
            System.out.println("Dado: " + chain.get(i).getDado());

            System.out.println("Hash anterior: " + chain.get(i).getPrevHash());

            System.out.println("HashAtual: " + chain.get(i).getHash());

            System.out.println("\n");

        }

    }
}
