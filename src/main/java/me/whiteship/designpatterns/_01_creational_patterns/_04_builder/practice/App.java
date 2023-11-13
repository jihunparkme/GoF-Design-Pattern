package me.whiteship.designpatterns._01_creational_patterns._04_builder.practice;

import me.whiteship.designpatterns._01_creational_patterns._04_builder._01_before.TourPlan;

public class App {

    public static void main(String[] args) {
        TourDirector director = new TourDirector(new DefaultTourBuilder());
        TourPlan tourPlan = director.cancunTrip();
        TourPlan tourPlan1 = director.longBeachTrip();
    }
}
