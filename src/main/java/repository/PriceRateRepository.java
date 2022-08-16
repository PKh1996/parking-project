package repository;

import com.kurdestan.Vehicleparking.model.Parking;
import com.kurdestan.Vehicleparking.model.PriceRate;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PriceRateRepository extends PagingAndSortingRepository<PriceRate, Long> {


    List<PriceRate> findAllByParking(Parking parking); //وقتی ماشین رو داد تردد هارو برگردون


}
