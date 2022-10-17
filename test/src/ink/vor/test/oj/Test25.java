package ink.vor.test.oj;

/**
 * @author muquanrui
 * @date 2022/10/12 14:12
 */

public class Test25 {
    public int Decrypt (int encryptedNumber, int decryption, int number) {
        // write code here
        return (int)Math.pow(encryptedNumber, decryption) % number;
    }
}
