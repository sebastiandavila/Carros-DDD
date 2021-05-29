package co.com.sofka.Carros.domain.car.events;

import co.com.sofka.domain.generic.DomainEvent;

public class timeTravelCalculated extends DomainEvent {
    private final int time;

    public timeTravelCalculated(int time) {
        super("Carros.car.timeTravelCalculated");
        this.time = time;
    }

    public int Time() {
        return time;
    }
}
