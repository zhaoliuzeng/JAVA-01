package com;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.serialize.ObjectInput;
import com.alibaba.dubbo.common.serialize.ObjectOutput;
import com.alibaba.dubbo.common.serialize.Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TextSerialization implements Serialization {
    @Override
    public byte getContentTypeId() {
        return 10;
    }

    @Override
    public String getContentType() {
        System.out.println("自定义。。。");
        return "text";
    }

    @Override
    public ObjectOutput serialize(URL url, OutputStream outputStream) throws IOException {
        System.out.println("自定义。。serialize。ObjectOutput");
        return new TextObjectOutput(outputStream);
    }

    @Override
    public ObjectInput deserialize(URL url, InputStream inputStream) throws IOException {
        System.out.println("自定义。。deserialize。ObjectOutput");
        return new TextObjectInput(inputStream);
    }
}
