package controller;


import DTO.TransitDTO;
import DTO.VehicleDTO;
import com.kurdestan.Vehicleparking.model.Transit;
import com.kurdestan.Vehicleparking.model.Vehicle;
import lombok.AllArgsConstructor;
import mapper.TransitMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ITransitService;

import java.util.List;

@RestController
@RequestMapping(value = "/transit/")
@AllArgsConstructor
public class TransitController {


    private final ITransitService service;

    private TransitMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody TransitDTO transitDTO) {
        Transit transit = mapper.toTransit(transitDTO);
        service.save(transit);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<TransitDTO> getById(@PathVariable Long id) {

        Transit transit = service.getById(id);
       TransitDTO transitDTO = mapper.toTransitDTo(transit);
        return ResponseEntity.ok(transitDTO);
    }

    @GetMapping("/V1")
    public ResponseEntity<List<TransitDTO>> getAll() {
        List<Transit> transitsList = service.getAll();
        List<TransitDTO> transitDTOS =mapper.toTransitDTOs(transitsList);
        return ResponseEntity.ok(transitDTOS);
    }


    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/get-by-vehicle/{vehId}")
    public ResponseEntity <List<TransitDTO>>getByVehicleId(@PathVariable Long vehId) {

        List<Transit> transits = service.getAllByVehicle(vehId);
        List<TransitDTO> transitDTOs =mapper.toTransitDTOs(transits) ;
        return ResponseEntity.ok(transitDTOs);
    }









}
