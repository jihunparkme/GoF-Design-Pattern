package com.pattern.design.structuralDesignPatterns.decorator;

import com.pattern.design.structuralDesignPatterns.decorator.decorators.*;

public class Demo {
    /**
     * 클라이언트
     * - 데코레이터들이 컴포넌트 인터페이스를 통해 모든 객체와 작동하는 한 컴포넌트들을 여러 계층의 데코레이터들로 래핑
     */
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";

        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("out/OutputDemo.txt")));

        /**
         * 1. CompressionDecorator -> super.writeData(compress(data)); 압축
         * 2. EncryptionDecorator -> super.writeData(encode(data)); 인코딩
         * 3. FileDataSource -> writeData(String data);
         */
        encoded.writeData(salaryRecords);

        DataSource plain = new FileDataSource("out/OutputDemo.txt");

        /**
         * - Input ----------------
         * Name,Salary
         * John Smith,100000
         * Steven Jobs,912000
         *
         * - Encoded --------------
         * Zkt7e1Q5eU8yUm1Qe0ZsdHJ2VXp6dDBKVnhrUHtUe0sxRUYxQkJIdjVLTVZ0dVI5Q2IwOXFISmVUMU5rcENCQmdxRlByaD4+
         *
         * - Decoded --------------
         * Name,Salary
         * John Smith,100000
         * Steven Jobs,912000
         */
        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");

        /**
         * 1. CompressionDecorator -> decompress(super.readData());
         * 2. EncryptionDecorator -> decode(super.readData());
         * 3. FileDataSource -> readData()
         */
        System.out.println(encoded.readData());
    }
}