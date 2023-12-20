package com.pattern.design.structuralDesignPatterns.facade;

import com.pattern.design.structuralDesignPatterns.facade.facade.VideoConversionFacade;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        /**
         * VideoConversionFacade: conversion started.
         * CodecFactory: extracting ogg audio...
         * BitrateReader: reading file...
         * BitrateReader: writing file...
         * AudioMixer: fixing audio...
         * VideoConversionFacade: conversion completed.
         */
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        // ...
    }
}