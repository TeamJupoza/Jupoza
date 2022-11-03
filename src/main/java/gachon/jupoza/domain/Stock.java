package gachon.jupoza.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "stock")
public class Stock {

    @Id
    @Column(name = "StockID")
    private int stockId;

    @Column(name = "Name")
    private String name;

    @Column(name = "price")
    private int price;

    private float per;
    private float roe;
    private float dividend;
    private float rate;
    private float net;
    private float bis;
    private float current;
    private float quick;
    private float debt;
    private float score;
    private float sale;
    private float std;




}
