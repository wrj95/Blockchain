package blockchain;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Block {

    private String index;
    private String timeStamp;
    private String dado;
    private String prevHash;
    private String hash;

    /*
    index = index of Block in list
    timeStamp = date when was create that Block
    Dado = Data that will be input in Block
    prevHash = previous Hash
    */
    Block(String index, String timeStamp, String dado, String prevHash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.index = index;
        this.timeStamp = timeStamp;
        this.dado = dado;
        this.prevHash = prevHash;
        
        //Calculate to hash code in hex
        this.hash = calcularHash();
    }

    public String calcularHash() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //Data that will be coded
        String hash = index + timeStamp + dado + prevHash;

        //Coded at format MD5
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algorithm.digest(hash.getBytes("UTF-8"));
        
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhahex = hexString.toString();
        //Return all information encrypt
        return senhahex;
    }

    public String getIndex() {
        return index;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getDado() {
        return dado;
    }

    public String getPrevHash() {
        return prevHash;
    }

    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}
