package com.shika.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.Ploy.cipherTextAuto;
import com.Ploy.cipherTextRepeating;

public class VignereTest {

	String mainPlain = "wearediscoveredsaveyourself";
    String mainCipherRep = "zicvtwqngrzgvtwavzhcqyglmgj";
    String mainCipherAuto = "zicvtwqngkzeiigasxstslvvwla";
    String mainKey = "deceptive";

    @Test
    public void RepVignereTestEnc1() throws IOException
    {
    	cipherTextRepeating algorithm = new cipherTextRepeating(mainPlain, mainKey);
        String cipher = algorithm.findCipher();
        assertTrue(cipher.equals(mainCipherRep));
    }

    @Test
    public void RepVignereTestDec1()
    {
    	cipherTextRepeating algorithm = new cipherTextRepeating(mainCipherRep, mainKey);
        String plain = algorithm.findPlainText(mainCipherRep, mainKey);
        assertTrue(plain.equals(mainPlain));
    }

    @Test
    public void RepVignereTestAnalysis1()
    {
    	cipherTextRepeating algorithm = new cipherTextRepeating(mainCipherRep, mainPlain);
        String key = algorithm.findKeyWord(mainCipherRep, mainPlain);
        assertTrue(key.equals(mainKey));
    }

    @Test
    public void AutoVignereTestEnc1() throws IOException
    {
    	cipherTextAuto algorithm = new cipherTextAuto(mainPlain, mainKey);
        String cipher = algorithm.findCipher();
        assertTrue(cipher.equals(mainCipherAuto));
    }

    @Test
    public void AutoVignereTestDec1() throws IOException
    {
    	cipherTextAuto algorithm = new cipherTextAuto(mainCipherAuto, mainKey);
        String plain = algorithm.findPlainText(mainCipherAuto, mainKey);
        assertTrue(plain.equals(mainPlain));
    }

    @Test
    public void AutoVignereTestAnalysis1()
    {
    	cipherTextAuto algorithm = new cipherTextAuto(mainPlain, mainCipherAuto);
        String key = algorithm.findKeyWord(mainCipherAuto, mainPlain);
        assertTrue(key.equals(mainKey));
    }





}
