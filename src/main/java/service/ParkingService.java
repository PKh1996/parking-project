package service;

import com.kurdestan.Vehicleparking.model.Parking;
import com.kurdestan.Vehicleparking.model.Vehicle;
import lombok.AllArgsConstructor;
import repository.ParkingRepository;
import repository.VehicleRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ParkingService implements IParkingService{

    private final ParkingRepository repository;                               ///// 111 اینجوری میشه     ,,,  111 , 222 با همدیگه لایه repository رو inject میکنن.    constructorbase
    //میتوان توی contriller هم به همین صورت Servce رو انجکت کنیم.

    @Override
    public Parking save(Parking parking) {
        return repository.save(parking);
    }

    @Override
    public Parking update(Parking parking) { //اون مقداری که کاربر وارد میکنه رو با مقدار قبلی جایگزین کن


        Parking LastSavedParking=getById(parking.getId());

        LastSavedParking.setAddress(parking.getAddress());
        LastSavedParking.setBasePrice(parking.getBasePrice());
        LastSavedParking.setName(parking.getName());


        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Parking getById(Long id) {
        Optional<Parking> optionalParking=repository.findById(id);

        if(!optionalParking.isPresent()){
            throw new RuntimeException("Not Found");
        }
        return optionalParking.get();
    }

    @Override
    public List<Parking> getAll() {

        return (List<Parking>) repository.findAll();
    }
}
