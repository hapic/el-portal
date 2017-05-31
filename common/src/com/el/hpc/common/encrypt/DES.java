package com.el.hpc.common.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 *
 * @User : Hapic
 * @Date : 2017/5/31 9:21
 *  DES加密介绍
    DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
    后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
    24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现
    。
    注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 * DES加密和解密
 */
public class DES {
    private static String password="1234";
    public DES() {
    }
    //测试
    public static void main(String args[]) throws UnsupportedEncodingException {
        //待加密内容
        String str = "123456";
        String encrypt = DES.encrypt(str);
        System.out.println(encrypt);
        String decrypt = DES.decrypt(encrypt);
        System.out.println(decrypt);



        /*//密码，长度要是8的倍数
        password = "9588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456";

        byte[] result = DES.encrypt(str.getBytes("UTF8"),password.getBytes("UTF8"));
        BASE64Encoder encoder= new BASE64Encoder();
        System.out.println("加密后："+new String(result,"UTF8"));
        String encode = encoder.encode(result);
        System.out.println("加密后："+encode);

        //直接将如上内容解密
        try {
            BASE64Decoder decoder= new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(encode);
            byte[] decryResult = DES.decrypt(bytes, password.getBytes());
            System.out.println("解密后："+new String(decryResult));
        } catch (Exception e1) {
            e1.printStackTrace();
        }*/

    }

    public static void createKey(String path,String password){



    }

    /**
     * 加密
     * @param datasource
     * @return
     */
    public static String encrypt(String datasource){

        byte[] result = encrypt(datasource.getBytes(),password.getBytes());

        BASE64Encoder encoder= new BASE64Encoder();

        return encoder.encode(result);

    }

    /**
     * 解密
     * @param datasource
     * @return
     */
    public static String decrypt(String datasource){

        try {
            BASE64Decoder decoder= new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(datasource);
            byte[] decrypt = decrypt(bytes, password.getBytes());
            return new String(decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 加密
     * @param datasource byte[]
     * @param passwords byte[]
     * @return byte[]
     */
    private static byte[] encrypt(byte[] datasource, byte[] passwords) {
        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(passwords);
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 解密
     * @param src byte[]
     * @param passwords byte[]
     * @return byte[]
     * @throws Exception
     */
    private static byte[] decrypt(byte[] src, byte[] passwords) throws Exception {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(passwords);
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }
}
