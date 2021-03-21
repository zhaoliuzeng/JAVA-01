package com;

import com.alibaba.dubbo.common.serialize.ObjectInput;

import java.io.*;
import java.lang.reflect.Type;

public class TextObjectInput implements ObjectInput {

    private final BufferedReader reader;

    public TextObjectInput(InputStream in) {
        this(new InputStreamReader(in));
    }

    public TextObjectInput(Reader reader) {
        this.reader = new BufferedReader(reader);
    }
    @Override
    public Object readObject() throws IOException, ClassNotFoundException {
        return readLine();
    }

    @Override
    public <T> T readObject(Class<T> aClass) throws IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public <T> T readObject(Class<T> aClass, Type type) throws IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean readBool() throws IOException {
        return false;
    }

    @Override
    public byte readByte() throws IOException {
        String str = readLine();
        System.out.println(str + "readByte");
        return str.getBytes()[0];
    }

    @Override
    public short readShort() throws IOException {
        return Short.parseShort(readLine());
    }

    @Override
    public int readInt() throws IOException {
        return Integer.parseInt(readLine());
    }

    @Override
    public long readLong() throws IOException {
        return Long.parseLong(readLine());
    }

    @Override
    public float readFloat() throws IOException {
        return Float.parseFloat(readLine());
    }

    @Override
    public double readDouble() throws IOException {
        return Double.parseDouble(readLine());
    }

    @Override
    public String readUTF() throws IOException {
            return readLine();
    }

    private String readLine() throws IOException, EOFException {
        String line = reader.readLine();
        if (line == null || line.trim().length() == 0) {
            throw new EOFException();
        }
        return line;
    }

    @Override
    public byte[] readBytes() throws IOException {
        return readLine().getBytes();
    }
}