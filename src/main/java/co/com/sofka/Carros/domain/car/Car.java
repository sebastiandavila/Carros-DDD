package co.com.sofka.Carros.domain.car;

import co.com.sofka.Carros.domain.car.events.CarCreated;
import co.com.sofka.Carros.domain.car.events.timeTravelCalculated;
import co.com.sofka.Carros.domain.car.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Car extends AggregateEvent<CarId> {

    protected Model model;
    protected Brand brand;
    protected Speed speed;
    protected Distance distance;

    private Car(CarId carId){
        super(carId);
        subscribe(new CarChange(this));
    }

    public Car(CarId carId, Model model, Brand brand, Speed speed, Distance distance){
        super(carId);
        this.model= model;
        this.brand=brand;
        this.speed = speed;
        this.distance = distance;

        appendChange(new CarCreated(entityId, brand, model, speed, distance)).apply();
    }

    public static Car from(CarId carId, List<DomainEvent> events){
        var car = new Car(carId);

        events.forEach(car::applyEvent);
        return car;
    }

    public void timeTravel(){
        var time = Integer.parseInt(distance.value())/Integer.parseInt(speed.value());
        appendChange(new timeTravelCalculated(time)).apply();
    }

}
