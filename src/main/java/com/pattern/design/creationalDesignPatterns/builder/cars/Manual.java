package com.pattern.design.creationalDesignPatterns.builder.cars;

import com.pattern.design.creationalDesignPatterns.builder.components.Engine;
import com.pattern.design.creationalDesignPatterns.builder.components.GPSNavigator;
import com.pattern.design.creationalDesignPatterns.builder.components.Transmission;
import com.pattern.design.creationalDesignPatterns.builder.components.TripComputer;

/**
 * Product
 * - 제품들은 빌더 결과로 나온 객체
 * - 다른 빌더들에 의해 생성된 제품들은 같은 클래스 계층구조 또는 인터페이스에 속할 필요가 없음
 */
public class Manual {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;

    public Manual(CarType carType, int seats, Engine engine, Transmission transmission,
                  TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        this.gpsNavigator = gpsNavigator;
    }

    public String print() {
        String info = "";
        info += "Type of car: " + carType + "\n";
        info += "Count of seats: " + seats + "\n";
        info += "Engine: volume - " + engine.getVolume() + "; mileage - " + engine.getMileage() + "\n";
        info += "Transmission: " + transmission + "\n";
        if (this.tripComputer != null) {
            info += "Trip Computer: Functional" + "\n";
        } else {
            info += "Trip Computer: N/A" + "\n";
        }
        if (this.gpsNavigator != null) {
            info += "GPS Navigator: Functional" + "\n";
        } else {
            info += "GPS Navigator: N/A" + "\n";
        }
        return info;
    }
}