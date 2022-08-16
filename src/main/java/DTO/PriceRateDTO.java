package DTO;

import lombok.Data;


@Data
public class PriceRateDTO {



    @ApiModelProprty(required = false,hidden = true)
    private long id;

    @ApiModelProprty(required = true,hidden = false)
    private Long hourlyRate;

    @ApiModelProprty(required = true,hidden = false)
    private Long dailyRate;

    @ApiModelProprty(required = true,hidden = false)
    private Long monthlyRate;


    @ApiModelProprty(required = true,hidden = false)
    private ParkingDTO parking;


}
