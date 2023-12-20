package com.pattern.design.structuralDesignPatterns.facade.facade;

import com.pattern.design.structuralDesignPatterns.facade.some_complex_media_library.*;

import java.io.File;

/**
 * 퍼사드
 * - 하위 시스템 기능들의 특정 부분에 편리하게 접근 가능
 * - 클라이언트의 요청을 어디로 보내야 하는지와 움직이는 모든 부품을 어떻게 작동해야 하는지를 알고 있음
 *
 * 추가적인 퍼사드 클래스
 * - 하나의 퍼사드를 관련 없는 기능들로 오염시켜 복잡한 구조로 만드는 것을 방지
 * - 클라이언트들과 다른 퍼사드들 모두에 사용 가능
 */
public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}