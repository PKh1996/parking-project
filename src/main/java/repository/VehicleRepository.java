package repository;

import com.kurdestan.Vehicleparking.model.Parking;
import com.kurdestan.Vehicleparking.model.Transit;
import com.kurdestan.Vehicleparking.model.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface VehicleRepository extends PagingAndSortingRepository<Vehicle,Long> {

    List<Vehicle> findAllByParking(Parking parking); //وقتی پارکینگ رو داد ماشین هارو برگردون


}
