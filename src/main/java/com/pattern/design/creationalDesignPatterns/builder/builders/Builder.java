package com.pattern.design.creationalDesignPatterns.builder.builders;

import com.pattern.design.creationalDesignPatterns.builder.cars.CarType;
import com.pattern.design.creationalDesignPatterns.builder.components.Engine;
import com.pattern.design.creationalDesignPatterns.builder.components.GPSNavigator;
import com.pattern.design.creationalDesignPatterns.builder.components.Transmission;
import com.pattern.design.creationalDesignPatterns.builder.components.TripComputer;

/**
 * Builder
 * - 빌더 인터페이스는 모든 유형의 빌더들에 공통적인 제품 생성 단계들을 선언
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}