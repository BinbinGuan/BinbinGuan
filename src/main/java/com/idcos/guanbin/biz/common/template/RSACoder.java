package com.idcos.guanbin.biz.common.template;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSACoder {

    public static final String KEY_ALGORITHM = "RSA";
    public static final String split = " ";//分隔符
    public static final int max = 117;//加密分段长度//不可超过117
    public static final String PUBLIC_KEY = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAw8aCs4qoiW6c1Mfc5xvp"
            + "2kDt/ow+oNrCToO6B68XsCDse2V123HGHxMDxQd5Hyj6wEJcnuFV/PRlKfyxjEhJ"
            + "HtgLBAxRXSE3RzP4SnIKv6kg0Qs2yep/hh3I3F/f5xI6jNEUkbO5tixQbXqYzAcp"
            + "IHOqoVDN5q4zxd0jwIYa9Bgs4V2tOVPOH7ZI1tq9Y954pEoCxnC5AR/xKdNE7xMr"
            + "pKgMn80N4z6qOeqXjeSut3awiY7rZah86EQwx/atqO8xLFy6nx9J5u7Qot6qxnJp"
            + "FoqHDpx81ZZt0EdAVezH9Kw/mYp8rN3cTa4+Z9EIDaQZ7YFWKrrrR/lJSyJkG6MP"
            + "YeQUgzkWRwb3Gzs3junKOQ4hPlzgGL8I2QFhZSUqfPgl1v48XELL7MqsH8E6QntR"
            + "SJcU/tf89xjjieKDWawojBLcAUvRkDRlr/51GwpRzAUfa0YuQcLRGUTc3PMJ2nfA"
            + "A82oSEoVzRLGPb3i16tryeFtrlFZ2l333w1rdhE4tHvvlGal25TiRLsFg+uGGWof"
            + "evcLEgsz2JGwa6Fqf2U/0c/k9pMyqnXAKABEwPvswZoSmedM/hKKXVaXNnNtqaZ0"
            + "bQugfoLDzCX9A2hbNwGKjLmIuUmdhITXIksIHnizByfozpFhzxvwZaxNSabpQsm2"
            + "4vvmC+kltB7MaZ3KNt3s3j0CAwEAAQ==";

    public static BASE64Decoder base64Decoder = new BASE64Decoder();
    public static BASE64Encoder base64Encoder = new BASE64Encoder();

    private static RSACoder me;
    private RSACoder(){}//单例
    public static RSACoder create(){
        if (me==null) {
            me = new RSACoder();
        }
        //生成公钥、私钥
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance(KEY_ALGORITHM);
            kpg.initialize(1024);
            KeyPair kp = kpg.generateKeyPair();
            me.publicKey = (RSAPublicKey) kp.getPublic();
            me.privateKey = (RSAPrivateCrtKey) kp.getPrivate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return me;
    }

    private RSAPublicKey publicKey;
    private RSAPrivateCrtKey privateKey;

    /**获取公钥*/
    public String getPublicKey(){
        return base64Encoder.encode(publicKey.getEncoded());
    }

    /**获取私钥*/
    public String getPrivateKey(){
        return base64Encoder.encode(privateKey.getEncoded());
    }

    /**加密-公钥*/
    public String encodeByPublicKey(String res,String key) throws IOException {
        byte[] resBytes = res.getBytes();
        byte[] keyBytes = base64Decoder.decodeBuffer(key);//先把公钥转为2进制
        StringBuffer result = new StringBuffer();//结果
        //如果超过了100个字节就分段
        if (keyBytes.length<=max) {//不超过直接返回即可
            return encodePub(resBytes, keyBytes);
        }else {
            int size = resBytes.length/max + (resBytes.length%max>0?1:0);
            for (int i = 0; i < size; i++) {
                int len = i==size-1?resBytes.length%max:max;
                byte[] bs = new byte[len];//临时数组
                System.arraycopy(resBytes, i*max, bs, 0, len);
                result.append(encodePub(bs, keyBytes));
                if(i!=size-1)result.append(split);
            }
            return result.toString();
        }
    }
    /**加密-私钥*/
    public String encodeByPrivateKey(String res,String key) throws IOException {
        byte[] resBytes = res.getBytes();
        byte[] keyBytes = base64Decoder.decodeBuffer(key);
        StringBuffer result = new StringBuffer();
        //如果超过了100个字节就分段
        if (keyBytes.length<=max) {//不超过直接返回即可
            return encodePri(resBytes, keyBytes);
        }else {
            int size = resBytes.length/max + (resBytes.length%max>0?1:0);
            for (int i = 0; i < size; i++) {
                int len = i==size-1?resBytes.length%max:max;
                byte[] bs = new byte[len];//临时数组
                System.arraycopy(resBytes, i*max, bs, 0, len);
                result.append(encodePri(bs, keyBytes));
                if(i!=size-1)result.append(split);
            }
            return result.toString();
        }
    }
    /**解密-公钥*/
    public static String decodeByPublicKey(String res,String key) throws IOException {
        if(key == null) key = PUBLIC_KEY;
        byte[] keyBytes = new BASE64Decoder().decodeBuffer(key);
        //先分段
        String[] rs = res.split("\\"+split);
        //分段解密
        if(rs!=null){
            int len = 0;
            //组合byte[]
            byte[] result = new byte[rs.length*max];
            for (int i = 0; i < rs.length; i++) {
                byte[] bs = decodePub(new BASE64Decoder().decodeBuffer(rs[i]), keyBytes);
                System.arraycopy(bs, 0, result, i*max, bs.length);
                len+=bs.length;
            }
            byte[] newResult = new byte[len];
            System.arraycopy(result, 0, newResult, 0, len);
            //还原字符串
            return new String(newResult);
        }
        return null;
    }
    /**解密-私钥*/
    public String decodeByPrivateKey(String res,String key) throws IOException {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] keyBytes = base64Decoder.decodeBuffer(key);
        //先分段
        String[] rs = res.split("\\"+split);
        //分段解密
        if(rs!=null){
            int len = 0;
            //组合byte[]
            byte[] result = new byte[rs.length*max];
            for (int i = 0; i < rs.length; i++) {
                byte[] bs = decodePri(base64Decoder.decodeBuffer(rs[i]), keyBytes);
                System.arraycopy(bs, 0, result, i*max, bs.length);
                len+=bs.length;
            }
            byte[] newResult = new byte[len];
            System.arraycopy(result, 0, newResult, 0, len);
            //还原字符串
            return new String(newResult);
        }
        return null;
    }


    /**加密-公钥-无分段*/
    private String encodePub(byte[] res,byte[] keyBytes){
        X509EncodedKeySpec x5 = new X509EncodedKeySpec(keyBytes);//用2进制的公钥生成x509
        try {
            KeyFactory kf = KeyFactory.getInstance(KEY_ALGORITHM);
            Key pubKey = kf.generatePublic(x5);//用KeyFactory把x509生成公钥pubKey
            Cipher cp = Cipher.getInstance(kf.getAlgorithm());//生成相应的Cipher
            cp.init(Cipher.ENCRYPT_MODE, pubKey);//给cipher初始化为加密模式，以及传入公钥pubKey
            return base64Encoder.encode(cp.doFinal(res));//以16进制的字符串返回
        } catch (Exception e) {
            System.out.println("公钥加密失败");
            e.printStackTrace();
        }
        return null;
    }
    /**加密-私钥-无分段*/
    private String encodePri(byte[] res,byte[] keyBytes){
        PKCS8EncodedKeySpec pk8 = new PKCS8EncodedKeySpec(keyBytes);
        try {
            KeyFactory kf = KeyFactory.getInstance(KEY_ALGORITHM);
            Key priKey = kf.generatePrivate(pk8);
            Cipher cp = Cipher.getInstance(kf.getAlgorithm());
            cp.init(Cipher.ENCRYPT_MODE, priKey);
            return base64Encoder.encode(cp.doFinal(res));
        } catch (Exception e) {
            System.out.println("私钥加密失败");
            e.printStackTrace();
        }
        return null;
    }
    /**解密-公钥-无分段*/
    private static byte[] decodePub(byte[] res,byte[] keyBytes){
        X509EncodedKeySpec x5 = new X509EncodedKeySpec(keyBytes);
        try {
            KeyFactory kf = KeyFactory.getInstance(KEY_ALGORITHM);
            Key pubKey = kf.generatePublic(x5);
            Cipher cp = Cipher.getInstance(kf.getAlgorithm());
            cp.init(Cipher.DECRYPT_MODE, pubKey);
            return cp.doFinal(res);
        } catch (Exception e) {
            System.out.println("公钥解密失败");
            e.printStackTrace();
        }
        return null;
    }
    /**解密-私钥-无分段*/
    private byte[] decodePri(byte[] res,byte[] keyBytes){
        PKCS8EncodedKeySpec pk8 = new PKCS8EncodedKeySpec(keyBytes);
        try {
            KeyFactory kf = KeyFactory.getInstance(KEY_ALGORITHM);
            Key priKey = kf.generatePrivate(pk8);
            Cipher cp = Cipher.getInstance(kf.getAlgorithm());
            cp.init(Cipher.DECRYPT_MODE, priKey);
            return cp.doFinal(res);
        } catch (Exception e) {
            System.out.println("私钥解密失败");
            e.printStackTrace();
        }
        return null;
    }

}