package service;

import com.kurdestan.Vehicleparking.model.Transit;
import com.kurdestan.Vehicleparking.model.Vehicle;

import java.util.List;

public interface ITransitService {



    Transit save (Transit  transit);
    void delete (Long id);
    Transit getById(Long id);
    List<Transit> getAll();
    List<Transit> getAllByVehicle(Long vehId); // تمامی تردد هارو براساس ماشین ها به من برگردان.


}
