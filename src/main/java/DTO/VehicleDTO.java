package DTO;
import com.kurdestan.Vehicleparking.model.VehicleType;
import lombok.Data;

    @Data                            //بجای ستر و گتر
    public class VehicleDTO {

        @ApiModelProprty(required = false,hidden=true)                     //یعنی وقتی کاربر این فیلدو میفرسته  لازمه پر بشه یا نه
        private long id;              //شناسه منحصر بفرد

        @ApiModelProprty(required = true,hidden=false)                     //یعنی وقتی کاربر این فیلدو میفرسته  لازمه پر بشه یا نه
        private VehicleType vehicleType;

        @ApiModelProprty(required = true,hidden=false)                     //یعنی وقتی کاربر این فیلدو میفرسته  لازمه پر بشه یا نه
        private String plate;


        //این dto که اومده برای کدوم پدره(پارکینگ)
        private ParkingDTO  parking;          //توی entity فرزند هر اسمی داره همونو بهش میدیم


}
