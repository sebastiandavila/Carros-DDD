package co.com.sofka.Carros.domain.car.events;

import co.com.sofka.Carros.domain.car.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class CarCreated extends DomainEvent {
    private final CarId carid;
    private final Brand brand;
    private final Model model;
    private final Speed speed;
    private final Distance distance;
    public CarCreated(CarId carid, Brand brand, Model model, Speed speed, Distance distance) {
        super("Carros.car.created");
        this.carid = carid;
        this.brand = brand;
        this.model = model;
        this.speed = speed;
        this.distance = distance;
    }

    public CarId Carid() {
        return carid;
    }

    public Brand Brand() {
        return brand;
    }

    public Model Model() {
        return model;
    }

    public Speed Speed() {
        return speed;
    }

    public Distance Distance() {
        return distance;
    }
}
