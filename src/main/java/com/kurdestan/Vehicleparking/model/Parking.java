package com.kurdestan.Vehicleparking.model;


import lombok.Data;
import org.hibernate.type.StringNVarcharType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "tbl-parking")
@Data
public class Parking {

    @Id                           //بهش گفتیم این آی دی کلید اصلیه
    @GeneratedValue(strategy = GenerationType.IDENTITY)              //چگونگی تولید آی دی
    private long id;


    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "bace_price")
    private Long basePrice;


    //ارتباط دادن  parking , vehicle با mappedby و اسمش دقیقا با entity کلاس فرزند باید یکی باشه,   تعیین کردن فچ ، تعیین کردن cascade یعنی هروقت پدر ذخیره آپدیت و حذف شد فرزند هم تغییر کند.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parking" , cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;          //هر پارکینگی لیستی از ماشین داره.



    @OneToMany(fetch = FetchType.LAZY,mappedBy = "parking",cascade = CascadeType.ALL)           //توی chiled اسم این entity چی ذخیره کردیم همونو مینویسیم برای mappedBy
    private List<PriceRate> priceRates;



}
