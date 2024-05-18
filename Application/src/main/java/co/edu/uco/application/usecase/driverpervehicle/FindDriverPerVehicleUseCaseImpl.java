package co.edu.uco.application.usecase.driverpervehicle;


import co.edu.uco.application.dto.DriverPerVehicleDTO;
import co.edu.uco.application.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.entity.DriverEntity;
import co.edu.uco.port.input.bussiness.driverpervehicle.FindDriverPerVehicleUseCase;
import co.edu.uco.entity.DriverPerVehicleEntity;
import co.edu.uco.port.output.repository.DriverPerVehicleRepository;
import co.edu.uco.util.exception.CarpoolingCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
public class FindDriverPerVehicleUseCaseImpl implements FindDriverPerVehicleUseCase {
    @Autowired
    private DriverPerVehicleRepository driverPerVehicleRepository;

    @Override
    public DriverPerVehicleEntity execute(UUID id) {
        Optional<DriverPerVehicleEntity> response = driverPerVehicleRepository.findDriverPerVehicleEntityById(id);
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The driver per vehicle with the sent id does not exist");
        }
        return response.get();
    }
}