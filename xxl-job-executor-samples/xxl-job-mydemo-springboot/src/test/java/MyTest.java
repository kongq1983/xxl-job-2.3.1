import java.math.BigInteger;

/**
 * @author: kq
 * @date: 2023-05-10 10:55:56
 * @since: 1.0.0
 * @description:
 */
public class MyTest {

    public static void main(String[] args) {

//        String str = "abc";
        String str = "aA";

        String tokenHex = new BigInteger(str.getBytes()).toString(16); // 转成16进制
        System.out.println("tokenHex=" + tokenHex);

        String original = new String(new BigInteger(tokenHex, 16).toByteArray());
        System.out.println("original=" + original);

        test();

    }

    public static void test() {

        int A = 42;
//        String  A = "12345";
//        BigInteger f = BigInteger.valueOf(A);
        BigInteger f = BigInteger.valueOf(A);
        System.out.println("f=" + f); //输出的f将会等于BigInteger型的42


    }

}
