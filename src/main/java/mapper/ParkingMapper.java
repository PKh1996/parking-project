package mapper;


import DTO.ParkingDTO;
import com.kurdestan.Vehicleparking.model.Parking;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")              //توی کدوم تکنولوژی استفاده ش میکنی؟

public interface ParkingMapper {



    Parking toParking (ParkingDTO parkingDTO);             //تبدیل dto به entity
    ParkingDTO toParkingDTO (Parking parking);               //تبدیل entity به DTO



    List<ParkingDTO> toParkingDTOs(List<Parking> parkingList);
    List<Parking> toParking(List<ParkingDTO> parkingDTOS);



}
