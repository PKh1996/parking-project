package DTO;


import lombok.Data;

import java.util.Date;
@Data
     public class TransitDTO {

    @ApiModelProprty(required = false,hidden = true)
    private long id;

    @ApiModelProprty(required = true,hidden = false)
    private Date entryTime;


    @ApiModelProprty(required = true,hidden = false)
    private Date exitTime;

    @ApiModelProprty(required = true,hidden = false)
    private Long finalPrice;

    @ApiModelProprty(required = true,hidden = false)
    private VehicleDTO vehicle;                       //اسم ش باید با entity یکی باشه          ///



}
