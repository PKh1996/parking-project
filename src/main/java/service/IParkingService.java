package service;

import com.kurdestan.Vehicleparking.model.Parking;
import com.kurdestan.Vehicleparking.model.Vehicle;

import java.util.List;

public interface IParkingService {


    Parking save (Parking parking);
    Parking update (Parking parking);
    void delete (Long id);
    Parking getById(Long id);
    List<Parking> getAll();

}
