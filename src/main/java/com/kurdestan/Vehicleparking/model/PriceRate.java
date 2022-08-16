package com.kurdestan.Vehicleparking.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl-pricerate")
@Data
public class PriceRate {

    @Id                           //بهش گفتیم این آی دی کلید اصلیه
    @GeneratedValue(strategy = GenerationType.IDENTITY)              //چگونگی تولید آی دی
    private long id;

    @NotNull
    @Column(name = "hourly_rate")
    private Long hourlyRate;

    @NotNull
    @Column(name = "daily_rate")
    private Long dailyRate;

    @NotNull
    @Column(name = "monthly_rate")
    private Long monthlyRate;

    @ManyToOne
    @JoinColumn(name = "parking_id")
    private Parking parking;
}
