package com.han.demo9;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public final class CharsetHelper {
    private static final String UTF_8 = "UTF-8";
    /**
     * 1. forName(String charsetName)方法 返回命名字符集的字符集对象 （在Charset对象中）
     * 2. newEncoder()方法 为此字符集构造一个新的编码器（在Charset对象中）
     * 3. newDecoder()方法 为此字符集构造一个新的解码器（在Charset对象中）
     * 4. encode(CharBuffer in)方法 将单个输入字符缓冲区的剩余内容编码为新分配的字节缓冲区的便捷方法（在CharsetEncoder对象中)
     * 5. decode(ByteBuffer in)方法 将单个输入字节缓冲区的剩余内容解码为新分配的字符缓冲区的便捷方法（在CharsetDecoder对象中)
     */
    private static CharsetEncoder encoder = Charset.forName(UTF_8).newEncoder();
    private static CharsetDecoder decoder = Charset.forName(UTF_8).newDecoder();
    private CharsetHelper(){}
    public static ByteBuffer encode(CharBuffer in) throws CharacterCodingException {
        return encoder.encode(in);
    }
    public static CharBuffer decode(ByteBuffer in) throws CharacterCodingException {
        return decoder.decode(in);
    }
}
