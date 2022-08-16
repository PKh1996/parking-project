package mapper;


import DTO.VehicleDTO;
import com.kurdestan.Vehicleparking.model.Vehicle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {ParkingMapper.class} )             ///////به این صورت مپرفرزند از مپر پدر استفاده میکنه .  //توی کدوم تکنولوژی استفاده ش میکنی؟
public interface VehicleMapper {


    Vehicle toVehicle(VehicleDTO vehicleDTO);        //تبدیل dto به entity


    VehicleDTO toVehicleDTO(Vehicle vehicle);        //تبدیل entity به DTO


    List<Vehicle> toVehicleList(List<VehicleDTO> vehicleListDTOS );
    List<VehicleDTO> toVehicleDTOs(List<Vehicle> vehicleList);

}
