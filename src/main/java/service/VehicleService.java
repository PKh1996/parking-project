package service;

import com.kurdestan.Vehicleparking.model.Parking;
import com.kurdestan.Vehicleparking.model.Transit;
import com.kurdestan.Vehicleparking.model.Vehicle;
import com.kurdestan.Vehicleparking.model.VehicleType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.VehicleRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor   //222
public class VehicleService implements IVehicleService {

    private final VehicleRepository repository;                               ///// 111 اینجوری میشه     ,,,  111 , 222 با همدیگه لایه repository رو inject میکنن.    constructorbase
    //میتوان توی contriller هم به همین صورت Servce رو انجکت کنیم.

    private final IParkingService parkingService;


    @Override
    public Vehicle save(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    @Override
    public Vehicle save2(Vehicle vehicle) {


        Long parkId = vehicle.getParking().getId();
        Parking parking = parkingService.getById(parkId);
        vehicle.setParking(parking);//حتما اینکارو باید انجام بدیم تا save بشه .

        return repository.save(vehicle);

       }



    @Override
    public Vehicle update(Vehicle vehicle) { //اون مقداری که کاربر وارد میکنه رو با مقدار قبلی جایگزین کن


        Vehicle LastSavedVehicle = getById(vehicle.getId());

        LastSavedVehicle.setVehicleType(vehicle.getVehicleType());
        LastSavedVehicle.setPlate(vehicle.getPlate());


        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Vehicle getById(Long id) {
        Optional<Vehicle> optionalVehicle = repository.findById(id);

        if (!optionalVehicle.isPresent()) {
            throw new RuntimeException("Not Found");
        }
        return optionalVehicle.get();
    }

    @Override
    public List<Vehicle> getAll() {

        return (List<Vehicle>) repository.findAll();
    }

    @Override
    public List<Vehicle> getAllByParking(Long parkId) {
        Parking parking =parkingService.getById(parkId);
        List<Vehicle> vehicle=repository.findAllByParking(parking);

        return vehicle;
    }
}
