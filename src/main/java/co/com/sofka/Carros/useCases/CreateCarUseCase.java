package co.com.sofka.Carros.useCases;

import co.com.sofka.Carros.domain.car.Car;
import co.com.sofka.Carros.domain.car.commands.CreateCar;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CreateCarUseCase extends UseCase<RequestCommand<CreateCar>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateCar> createCarRequestCommand) {
        var command = createCarRequestCommand.getCommand();
        var car = new Car(command.Carid(), command.Model(), command.Brand(), command.Speed(), command.Distance());
        emit().onResponse(new ResponseEvents(car.getUncommittedChanges()));
    }
}
