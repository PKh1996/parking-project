package mapper;
import DTO.TransitDTO;
import com.kurdestan.Vehicleparking.model.Transit;
import org.mapstruct.Mapper;
import java.util.List;
@Mapper(componentModel = "spring",uses = {VehicleMapper.class})


public interface TransitMapper {

    //هر transit به یه ماشین تعلق داره توی dto فرزند dto پدر هم هست پس میگیم از mapper پدر هم استفاده کن .


    Transit toTransit(TransitDTO transitDTO);                        //تبدیل dto به entity
    TransitDTO toTransitDTo(Transit transit);                        //تبدیل entity به DTO

    List<Transit> toTransitList(List<TransitDTO> TransitListDTOS );
    List<TransitDTO> toTransitDTOs(List<Transit> transitList);      //لیستی از تردد هارو بگیر و وارد dto کن.






}
