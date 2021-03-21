package com;

import com.alibaba.dubbo.common.serialize.ObjectOutput;

import java.io.IOException;
import java.io.OutputStream;

public class TextObjectOutput implements ObjectOutput {
    private OutputStream outputStream;

    public TextObjectOutput(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void writeObject(Object o) throws IOException {
        outputStream.write((o.toString().getBytes()));
    }

    @Override
    public void writeBool(boolean b) throws IOException {
        outputStream.write((b+"\n").getBytes());
    }

    @Override
    public void writeByte(byte b) throws IOException {
        outputStream.write((b+"\n").getBytes());
    }

    @Override
    public void writeShort(short i) throws IOException {
        outputStream.write((i+"\n").getBytes());
    }

    @Override
    public void writeInt(int i) throws IOException {
        outputStream.write((i+"\n").getBytes());
    }

    @Override
    public void writeLong(long l) throws IOException {
        outputStream.write((l+"\n").getBytes());
    }

    @Override
    public void writeFloat(float v) throws IOException {
        outputStream.write((v+"\n").getBytes());
    }

    @Override
    public void writeDouble(double v) throws IOException {
        outputStream.write((v+"\n").getBytes());
    }

    @Override
    public void writeUTF(String s) throws IOException {
        outputStream.write((s+"\n").getBytes());
    }

    @Override
    public void writeBytes(byte[] bytes) throws IOException {

    }

    @Override
    public void writeBytes(byte[] bytes, int i, int i1) throws IOException {

    }

    @Override
    public void flushBuffer() throws IOException {

    }
}