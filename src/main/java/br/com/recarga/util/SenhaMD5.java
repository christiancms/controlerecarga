/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recarga.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author christian
 */
public class SenhaMD5 {

    public static String hashmd5(String snh) {
        String md5 = null;
        if (null == snh) {
            return null;
        }

        try {
            //Cria hash do objeto para MD5
            MessageDigest snhdigest = MessageDigest.getInstance("MD5");

            //Atualiza a String 'snh' para Hash
            snhdigest.update(snh.getBytes(), 0, snh.length());

            //Converte o Hash para um valor de base 16 (hex)
            md5 = new BigInteger(1, snhdigest.digest()).toString(16);

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
        return md5;
    }
}
