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
public class Car {
    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final TripComputer tripComputer;
    private final GPSNavigator gpsNavigator;
    private double fuel = 0;

    public Car(CarType carType, int seats, Engine engine, Transmission transmission,
               TripComputer tripComputer, GPSNavigator gpsNavigator) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.tripComputer = tripComputer;
        if (this.tripComputer != null) {
            this.tripComputer.setCar(this);
        }
        this.gpsNavigator = gpsNavigator;
    }

    public CarType getCarType() {
        return carType;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getSeats() {
        return seats;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public TripComputer getTripComputer() {
        return tripComputer;
    }

    public GPSNavigator getGpsNavigator() {
        return gpsNavigator;
    }
}