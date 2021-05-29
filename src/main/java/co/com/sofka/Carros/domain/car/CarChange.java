package co.com.sofka.Carros.domain.car;

import co.com.sofka.Carros.domain.car.events.CarCreated;
import co.com.sofka.domain.generic.EventChange;

public class CarChange extends EventChange {
    public CarChange(Car car){

        apply((CarCreated event)->{
            car.speed = event.Speed();
            car.brand = event.Brand();
            car.model = event.Model();
            car.distance = event.Distance();
        });
    }
}
