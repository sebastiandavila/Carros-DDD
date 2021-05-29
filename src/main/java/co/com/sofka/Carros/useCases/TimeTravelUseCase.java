package co.com.sofka.Carros.useCases;

import co.com.sofka.Carros.domain.car.Car;
import co.com.sofka.Carros.domain.car.events.CarCreated;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class TimeTravelUseCase extends UseCase<TriggeredEvent<CarCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CarCreated> carCreatedTriggeredEvent) {
        var event = carCreatedTriggeredEvent.getDomainEvent();
        var car = Car.from(event.Carid(), retrieveEvents());

        car.timeTravel();
        emit().onResponse(new ResponseEvents(car.getUncommittedChanges()));

    }
}
