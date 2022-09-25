package br.com.alura.forum.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Cripto {

    @Value("${cripto.tipo")
    private String tipo;

    @Value("${cripto.bytes")
    private String bytes;

    public String criptografar(String string){

        string = Base64.encodeBase64String(string.getBytes());

        return string;
    }

    public String descriptografar(String string){
        byte[] decript = Base64.decodeBase64(string.getBytes());

        string = new String(decript);

        return string;
    }

}
