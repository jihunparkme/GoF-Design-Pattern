package com.pattern.design.creationalDesignPatterns.builder.builders;

import com.pattern.design.creationalDesignPatterns.builder.cars.CarType;
import com.pattern.design.creationalDesignPatterns.builder.components.Engine;
import com.pattern.design.creationalDesignPatterns.builder.components.GPSNavigator;
import com.pattern.design.creationalDesignPatterns.builder.components.Transmission;
import com.pattern.design.creationalDesignPatterns.builder.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}