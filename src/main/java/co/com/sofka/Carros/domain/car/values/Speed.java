package co.com.sofka.Carros.domain.car.values;

import co.com.sofka.domain.generic.ValueObject;

public class Speed implements ValueObject<String> {
    private final String value;

    public Speed(String value)
    {
        this.value = value;
    }

    @Override
    public String value(){
        return value;
    }
}
