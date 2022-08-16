package service;

import com.kurdestan.Vehicleparking.model.Transit;
import com.kurdestan.Vehicleparking.model.Vehicle;

import java.util.List;


//لایه business interface
public interface IVehicleService {

    Vehicle save (Vehicle vehicle);
    Vehicle save2 (Vehicle vehicle);
    Vehicle update (Vehicle vehicle);
    void delete (Long id);
    Vehicle getById(Long id);
    List<Vehicle> getAll();

    List<Vehicle> getAllByParking(Long parkId); // تمامی ماشین هارو براساس پارکینگ ها به من برگردان.








}
