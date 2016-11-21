package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello Big World";
        
        String inpu = "4d6f64756c652032";
        char[] inpus = inpu.toCharArray();
        
        String inp = "Hello World";
        String in = "010203040506";
        char[] i = in.toCharArray();
        
        String inpur = "U29mdHdhcmUgU31zdGVtcw==";

        System.out.println(Hex.encodeHexString(input.getBytes()));
        
        System.out.println(new String(Hex.decodeHex(inpus)));
        
        System.out.println(Base64.encodeBase64String(inp.getBytes()));
        
        System.out.println(Base64.encodeBase64String((new String(Hex.decodeHex(i)).getBytes())));
        
        System.out.println(new String(Base64.decodeBase64(inpur.getBytes())));
        
        System.out.println(Base64.encodeBase64String(("a").getBytes()));
        System.out.println(Base64.encodeBase64String(("aa").getBytes()));
        System.out.println(Base64.encodeBase64String(("aaa").getBytes()));
        System.out.println(Base64.encodeBase64String(("aaaa").getBytes()));
        System.out.println(Base64.encodeBase64String(("aaaaa").getBytes()));
        System.out.println(Base64.encodeBase64String(("aaaaaa").getBytes()));
        System.out.println(Base64.encodeBase64String(("aaaaaaa").getBytes()));
        System.out.println(Base64.encodeBase64String(("aaaaaaaa").getBytes()));
        System.out.println(Base64.encodeBase64String(("aaaaaaaaa").getBytes()));
        System.out.println(Base64.encodeBase64String(("aaaaaaaaaa").getBytes()));
        System.out.println(Base64.encodeBase64String(("aaaaaaaaaaa").getBytes()));
    }
} 