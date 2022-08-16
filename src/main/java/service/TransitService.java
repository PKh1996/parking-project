package service;

import com.kurdestan.Vehicleparking.model.Transit;
import com.kurdestan.Vehicleparking.model.Vehicle;
import lombok.AllArgsConstructor;
import repository.TransitRepository;
import repository.VehicleRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class TransitService implements ITransitService{
    private final TransitRepository repository;                               ///// 111 اینجوری میشه     ,,,  111 , 222 با همدیگه لایه repository رو inject میکنن.    constructorbase

    //میتوان توی controller هم به همین صورت Service رو انجکت کنیم.

   //توی سرویس فرزند ، سرویس پدر را هم لازم داریم.
    private final  IVehicleService vehicleService;


    @Override
    public Transit save(Transit transit) {

        //باید پدر transit رو مشخص کنیم و روی transit ستش کنیم.
        Long vehId=transit.getVehicle().getId();
        Vehicle vehicle= vehicleService.getById(vehId);
        transit.setVehicle(vehicle);//حتما اینکارو باید انجام بدیم تا save بشه .

        return repository.save(transit);
    }



    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public Transit getById(Long id) {
        Optional<Transit> optionalTransit=repository.findById(id);

        if(!optionalTransit.isPresent()){
            throw new RuntimeException("Not Found");
        }
        return optionalTransit.get();
    }

    @Override
    public List<Transit> getAll() {

        return (List<Transit>) repository.findAll();
    }

    @Override
    public List<Transit> getAllByVehicle(Long vehId) {
        Vehicle vehicle=vehicleService.getById(vehId);
        List<Transit> transit=repository.findAllByVehicle(vehicle);

        return transit;
    }
}
