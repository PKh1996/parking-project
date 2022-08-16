package com.kurdestan.Vehicleparking.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity                          //به این صورت بهش میگیم باید تو دیتابیس ذخیره و بازیابی بشه
@Table(name = "tbl_Transit")     //اسم جدولش داخل دیتابیس چی باشه
@Data                            //بجای ستر و گتر
public class Transit {

    @Id                           //بهش گفتیم این آی دی کلید اصلیه
    @GeneratedValue(strategy = GenerationType.IDENTITY)              //چگونگی تولید آی دی
    private long id;

    @NotNull
    @Column(name = "entry_time")
    private Date entryTime;

    @NotNull
    @Column(name = "exit_time")
    private Date exitTime;

    @NotNull
    @Column(name = "final_price")
    private Long finalPrice;

    @ManyToOne
    @JoinColumn(name = "vehicle-id")              //کلید
    private Vehicle vehicle;                      //      این تردد برای چه ماشینی هست؟

}
