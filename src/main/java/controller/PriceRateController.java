package controller;

import DTO.PriceRateDTO;
import com.kurdestan.Vehicleparking.model.PriceRate;
import lombok.AllArgsConstructor;
import mapper.PriceRateMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IPriceRateService;

import java.util.List;

@AllArgsConstructor
public class PriceRateController {
    private final IPriceRateService service;
    private PriceRateMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody PriceRateDTO priceRateDTO) {
        PriceRate priceRate= mapper.toPriceRate(priceRateDTO);
        service.save(priceRate);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<PriceRateDTO> getById(@PathVariable Long id) {

        PriceRate priceRate = service.getById(id);
        PriceRateDTO priceRateDTO = mapper.toPriceRateDTo(priceRate);
        return ResponseEntity.ok(priceRateDTO);
    }

    @GetMapping("/V1")
    public ResponseEntity<List<PriceRateDTO>> getAll() {
        List<PriceRate> priceRateList = service.getAll();
        List<PriceRateDTO> priceRateDTOS =mapper.toPriceRateDTOs(priceRateList);
        return ResponseEntity.ok(priceRateDTOS);
    }


    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/get-by-parking/{parkId}")
    public ResponseEntity <List<PriceRateDTO>>getByPriceRateId(@PathVariable Long parkId) {

        List<PriceRate> priceRates = service.getAllByParking(parkId);
        List<PriceRateDTO> transitDTOs =mapper.toPriceRateDTOs(priceRates) ;
        return ResponseEntity.ok(transitDTOs);
    }



}
