package com.pattern.design.structuralDesignPatterns.facade.some_complex_media_library;

/**
 * 복잡한 하위 시스템
 * - 수십 개의 다양한 객체들로 구성
 * - 모든 객체가 의미 있는 작업을 수행하도록 하려면, 하위 시스템의 세부적인 구현 정보를 깊이 있게 살펴야 함
 * - ex. 올바른 순서로 객체들을 초기화, 적절한 형식의 데이터 제공 등..
 *
 * - 하위 시스템 클래스들은 퍼사드의 존재를 인식하지 못함.(시스템 내에서 작동하며, 매개체 없이 직접 서로와 작업)
 */
public class CodecFactory {
    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        }
        else {
            System.out.println("CodecFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}
