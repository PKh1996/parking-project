package DTO;

import lombok.Data;

@Data
public class ParkingDTO {


    @ApiModelProprty(required = false,hidden = true)
    private long id;

    @ApiModelProprty(required = true,hidden = false)
    private String name;

    @ApiModelProprty(required = true,hidden = false)
    private String address;

    @ApiModelProprty(required = false,hidden = true)
    private Long basePrice;


}
