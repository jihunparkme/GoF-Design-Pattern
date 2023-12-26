package com.pattern.design.behavioralDesignPatterns.iterator.iterators;

import com.pattern.design.behavioralDesignPatterns.iterator.profile.Profile;
import com.pattern.design.behavioralDesignPatterns.iterator.social_networks.LinkedIn;

import java.util.ArrayList;
import java.util.List;

/**
 * 구상 반복자
 * - 컬렉션 순회를 위한 특정 알고리즘들 구현
 * - 반복자 객체는 순회의 진행 상황을 자체적으로 추적 필요(여러 반복자가 같은 컬렉션을 서로 독립적으로 순회할 수 있도록)
 */
public class LinkedInIterator implements ProfileIterator {
    private LinkedIn linkedIn;
    private String type;
    private String email;
    private int currentPosition = 0;
    private List<String> emails = new ArrayList<>();
    private List<Profile> contacts = new ArrayList<>();

    public LinkedInIterator(LinkedIn linkedIn, String type, String email) {
        this.linkedIn = linkedIn;
        this.type = type;
        this.email = email;
    }

    private void lazyLoad() {
        if (emails.size() == 0) {
            List<String> profiles = linkedIn.requestRelatedContactsFromLinkedInAPI(this.email, this.type);
            for (String profile : profiles) {
                this.emails.add(profile);
                this.contacts.add(null);
            }
        }
    }

    @Override
    public boolean hasNext() {
        lazyLoad();
        return currentPosition < emails.size();
    }

    @Override
    public Profile getNext() {
        if (!hasNext()) {
            return null;
        }

        String friendEmail = emails.get(currentPosition);
        Profile friendContact = contacts.get(currentPosition);
        if (friendContact == null) {
            friendContact = linkedIn.requestContactInfoFromLinkedInAPI(friendEmail);
            contacts.set(currentPosition, friendContact);
        }
        currentPosition++;
        return friendContact;
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}