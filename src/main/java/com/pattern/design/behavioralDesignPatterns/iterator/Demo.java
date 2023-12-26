package com.pattern.design.behavioralDesignPatterns.iterator;

import com.pattern.design.behavioralDesignPatterns.iterator.profile.Profile;
import com.pattern.design.behavioralDesignPatterns.iterator.social_networks.Facebook;
import com.pattern.design.behavioralDesignPatterns.iterator.social_networks.LinkedIn;
import com.pattern.design.behavioralDesignPatterns.iterator.social_networks.SocialNetwork;
import com.pattern.design.behavioralDesignPatterns.iterator.spammer.SocialSpammer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 클라이언트
 * - 반복자와 컬렉션 인터페이스를 통해 함께 작동
 * - 클라이언트가 구상 클래스들에 결합하지 않으므로 같은 클라이언트 코드로 다양한 컬렉션들과 반복자 사용 가능
 *
 * - 일반적으로 클라이언트는 자체적으로 반복자를 생성하지 않고 컬렉션에서 가져옴.
 * - 그러나 어떤 경우에는(ex. 클라이언트가 자체 특수 반복자를 정의할 경우) 클라이언트가 반복자를 직접 만들 수 있음.
 */
public class Demo {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please specify social network to target spam tool (default:Facebook):");
        System.out.println("1. Facebook");
        System.out.println("2. LinkedIn");
        String choice = scanner.nextLine();

        SocialNetwork network;
        if (choice.equals("2")) {
            network = new LinkedIn(createTestProfiles());
        }
        else {
            network = new Facebook(createTestProfiles());
        }

        SocialSpammer spammer = new SocialSpammer(network);
        spammer.sendSpamToFriends("anna.smith@bing.com",
                "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?");
        spammer.sendSpamToCoworkers("anna.smith@bing.com",
                "Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].");
    }

    public static List<Profile> createTestProfiles() {
        List<Profile> data = new ArrayList<Profile>();
        data.add(new Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"));
        data.add(new Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"));
        data.add(new Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com", "friends:catwoman@yahoo.com"));
        data.add(new Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com"));
        return data;
    }
}