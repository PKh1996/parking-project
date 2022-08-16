package controller;

import DTO.ParkingDTO;
import com.kurdestan.Vehicleparking.model.Parking;
import lombok.AllArgsConstructor;
import mapper.ParkingMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IParkingService;


import java.util.List;


@RestController
@RequestMapping(value = "/parking/")   //برای خوانایی بیشتر اول آدرس parking در شود.
@AllArgsConstructor
public class ParkingController {


    private final IParkingService service;

    private ParkingMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody ParkingDTO parkingDTO) {
        Parking parking = mapper.toParking(parkingDTO);
        service.save(parking);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody ParkingDTO parkingDTO) {
        Parking parking = mapper.toParking(parkingDTO);
        service.save(parking);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<ParkingDTO> getById(@PathVariable Long id) {

        Parking parking = service.getById(id);
        ParkingDTO parkingDTO = mapper.toParkingDTO(parking);
        return ResponseEntity.ok(parkingDTO);
    }

    @GetMapping("/V1")
    public ResponseEntity<List<ParkingDTO>> getAll() {
        List<Parking> parkingList = service.getAll();
        List<ParkingDTO> parkingDTOS=mapper.toParkingDTOs(parkingList);
        return ResponseEntity.ok(parkingDTOS);
    }


    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }





}