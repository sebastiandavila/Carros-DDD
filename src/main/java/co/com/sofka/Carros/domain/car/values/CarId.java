package co.com.sofka.Carros.domain.car.values;

import co.com.sofka.domain.generic.Identity;

public class CarId extends Identity {
    private CarId(String id){
        super(id);
    }

    public static CarId of(String id){
        return new CarId(id);
    }
}
