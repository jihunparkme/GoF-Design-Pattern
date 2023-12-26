package com.pattern.design.behavioralDesignPatterns.iterator.social_networks;

import com.pattern.design.behavioralDesignPatterns.iterator.iterators.ProfileIterator;

/**
 * 컬렉션 인터페이스
 * - 컬렉션과 호환되는 반복자들을 가져오기 위한 하나 이상의 메서드 선언
 * - 메서드 반환 유형은 반복자 인터페이스의 유형으로 선언 (구상 컬렉션이 다양한 유형의 반복자를 반환할 수 있도록)
 */
public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}