package co.com.sofka.Carros.useCases;

import co.com.sofka.Carros.domain.car.commands.CreateCar;
import co.com.sofka.Carros.domain.car.events.CarCreated;
import co.com.sofka.Carros.domain.car.values.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateCarUseCaseTest {

    @Test
    public void createCarTest(){
        var command = new CreateCar(CarId.of("123"), new Brand(""), new Model(""), new Speed(""), new Distance(""));

        CarCreated carCreated = executedUseCase(command);

        Assertions.assertEquals("123", carCreated.Carid().value());
    }

    private CarCreated executedUseCase(CreateCar command){
        var usecase = new CreateCarUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var carCreated = (CarCreated) events.get(0);
        return carCreated;
    }


}