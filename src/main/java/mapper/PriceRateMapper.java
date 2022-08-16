package mapper;

import DTO.PriceRateDTO;
import DTO.TransitDTO;
import com.kurdestan.Vehicleparking.model.PriceRate;
import com.kurdestan.Vehicleparking.model.Transit;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" , uses = ParkingMapper.class)


public interface PriceRateMapper {


    PriceRate toPriceRate(PriceRateDTO priceRateDTO);                        //تبدیل dto به entity
    PriceRateDTO toPriceRateDTo(PriceRate priceRate);                        //تبدیل entity به DTO

    List<PriceRate> toPriceRateList(List<PriceRateDTO> PriceRateListDTOS );
    List<PriceRateDTO> toPriceRateDTOs(List<PriceRate> priceRateList);      //لیستی از تردد هارو بگیر و وارد dto کن.



}
