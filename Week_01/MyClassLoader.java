package com.week01;

import org.springframework.util.Assert;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {
    private final String sourcePath;
    private final DecodeStratry decodeStratry;

    public MyClassLoader(String sourcePath) {
        super();
        this.sourcePath = sourcePath;
        decodeStratry = null;
    }

    public MyClassLoader(String sourcePath, DecodeStratry decodeStratry) {
        super();
        this.sourcePath = sourcePath;
        this.decodeStratry = decodeStratry;
    }

    public static void main(String[] args){
        String sourcePath = "D:\\codes\\yunxiao_sat\\DistributedSimulation\\src\\test\\java\\com\\week01\\Hello.xlass";

        MyClassLoader classloader = new MyClassLoader(sourcePath, new SimpleDecode());
        Object result = classloader.invoke("Hello", "hello");
        System.out.println(result);
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] cLassBytes = getBytes(sourcePath, this.decodeStratry);
        Assert.isTrue(cLassBytes != null, "not found any byte data..");
        return defineClass(name, cLassBytes, 0, cLassBytes.length);
    }

    public Object invoke(String className, String methodName) {
        Class findClass = findClass(className);
        try {
            Object obj = findClass.newInstance();
            Method method = findClass.getMethod(methodName);
            return method.invoke(obj);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] getBytes(String filePath, DecodeStratry decodeStratry) {
        byte[] buffer = null;
        File file = new File(filePath);
        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;
        int byteSize = 100;
        try {
            fis = new FileInputStream(file);
            bos = new ByteArrayOutputStream(byteSize);
            byte[] b = new byte[byteSize];
            int n;
            while ((n = fis.read(b)) != -1) {
                if (decodeStratry != null) {
                    bos.write(decodeStratry.decode(b), 0, n);
                } else {
                    bos.write(b, 0, n);
                }
            }
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer;
    }

    private interface DecodeStratry {
        byte[] decode(byte[] bytes);
    }

    public static class SimpleDecode implements DecodeStratry {
        @Override
        public byte[] decode(byte[] b) {
            byte[] decodeBytes = new byte[b.length];
            for (int i = 0; i < decodeBytes.length; i++) {
                decodeBytes[i] = (byte) (255 - b[i]);
            }
            return decodeBytes;
        }
    }
}
