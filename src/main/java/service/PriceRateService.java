package service;

import com.kurdestan.Vehicleparking.model.Parking;
import com.kurdestan.Vehicleparking.model.PriceRate;
import com.kurdestan.Vehicleparking.model.Transit;
import com.kurdestan.Vehicleparking.model.Vehicle;
import lombok.AllArgsConstructor;
import repository.PriceRateRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class PriceRateService implements IPriceRateService{


    private final PriceRateRepository repository;


    private final  IParkingService parkingService;


    @Override
    public PriceRate save(PriceRate priceRate) {
        Long parkId=priceRate.getParking().getId();
        Parking parking=parkingService.getById(parkId);
        priceRate.setParking(parking);//حتما اینکارو باید انجام بدیم تا save بشه .

        return repository.save(priceRate);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public PriceRate getById(Long id) {

            Optional<PriceRate> optionalPriceRate=repository.findById(id);

            if(!optionalPriceRate.isPresent()){
                throw new RuntimeException("Not Found");
            }
            return optionalPriceRate.get();
        }


    @Override
    public List<PriceRate> getAll() {

            return (List<PriceRate>) repository.findAll();
        }



    @Override
    public List<PriceRate> getAllByParking(Long parkId) {
         Parking parking=parkingService.getById(parkId);
            List<PriceRate> priceRate=repository.findAllByParking(parking);

            return priceRate;
        }
    }

