package com.kurdestan.Vehicleparking.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity                          //به این صورت بهش میگیم باید تو دیتابیس ذخیره و بازیابی بشه
@Table(name = "tbl_vehicle")     //اسم جدولش داخل دیتابیس چی باشه
@Data                            //بجای ستر و گتر

//میخواهیم این کلاس داخل دیتابیس ذخیره و بازیابی بشه
public class Vehicle {

    @Id                           //بهش گفتیم این آی دی کلید اصلیه
    @GeneratedValue(strategy = GenerationType.IDENTITY)              //چگونگی تولید آی دی
    private long id;              //شناسه منحصر بفرد

    @NotNull
    private VehicleType vehicleType;

    @NotNull
    @Column(name = "plate",unique = true)
    private String plate;

    @ManyToOne             //هر ماشین متعلق به یک پارکینگه
    @JoinColumn(name = "parking-id")
    private Parking parking;                  // این ماشین برای کئدام پارکینگه

    //ارتباط دادن  vehicle , transit با mappedby و اسمش دقیقا با entity کلاس فرزند باید یکی باشه,   تعیین کردن فچ ، تعیین کردن cascade یعنی هروقت پدر ذخیره آپدیت و حذف شد فرزند هم تغییر کند.
    @OneToMany(fetch=FetchType.LAZY,mappedBy ="vehicle" ,cascade = CascadeType.ALL  )
    private List<Transit> transit;                                                     //     هر ماشین لیستی از تردد هارو داره،،،،،،،، لیستی از تردد هاش


}
