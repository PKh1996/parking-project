package repository;

import com.kurdestan.Vehicleparking.model.Transit;
import com.kurdestan.Vehicleparking.model.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TransitRepository extends PagingAndSortingRepository <Transit,Long> {


List<Transit> findAllByVehicle(Vehicle vehicle); //وقتی ماشین رو داد تردد هارو برگردون





}


