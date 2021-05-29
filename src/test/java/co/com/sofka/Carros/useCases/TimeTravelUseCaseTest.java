package co.com.sofka.Carros.useCases;

import co.com.sofka.Carros.domain.car.events.CarCreated;
import co.com.sofka.Carros.domain.car.events.timeTravelCalculated;
import co.com.sofka.Carros.domain.car.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TimeTravelUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void TimeTravel(){
        var id = CarId.of("123");
        var event = new CarCreated(id, new Brand(""), new Model(""), new Speed("10"), new Distance("10"));

        event.setAggregateRootId(id.value());

        var useCase = new TimeTravelUseCase();

        Mockito.when(repository.getEventsBy(id.value())).thenReturn(eventStored(id));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(id.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var timetravelcalculated = (timeTravelCalculated) events.get(0);

        Assertions.assertEquals(1, timetravelcalculated.Time());

    }


    private List<DomainEvent> eventStored(CarId id){
        return List.of(new CarCreated(id,
                new Brand(""),
                new Model(""),
                new Speed("10"),
                new Distance("10")));
    }

}