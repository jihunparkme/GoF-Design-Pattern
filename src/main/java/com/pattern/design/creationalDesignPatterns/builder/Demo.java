package com.pattern.design.creationalDesignPatterns.builder;

import com.pattern.design.creationalDesignPatterns.builder.builders.CarBuilder;
import com.pattern.design.creationalDesignPatterns.builder.builders.CarManualBuilder;
import com.pattern.design.creationalDesignPatterns.builder.cars.Car;
import com.pattern.design.creationalDesignPatterns.builder.cars.Manual;
import com.pattern.design.creationalDesignPatterns.builder.director.Director;

public class Demo {

    /**
     * Client
     * - 클라이언트는 빌더 객체들 중 하나를 디렉터와 연결해야 함
     * - 일반적으로 연결은 디렉터 생성자의 매개변수들을 통해 한 번만 수행되며, 그 후 디렉터는 모든 추가 생성에 해당 빌더 객체들을 사용
     * - 그러나 클라이언트가 빌더 객체를 디렉터의 프로덕션 메서드에 전달할 때를 위한 대안적 접근 방식이 있음
     * - 이 경우 디렉터와 함께 무언가를 만들 때마다 다른 빌더를 사용 가능
     */
    public static void main(String[] args) {
        Director director = new Director();

        // 디렉터는 클라이언트로부터 구체적인 빌더 개체를 가져온 뒤 연결
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType()); // SPORTS_CAR

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);

        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print()); // Type of car: SPORTS_CAR
    }

}
