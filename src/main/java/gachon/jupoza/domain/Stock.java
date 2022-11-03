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
    @Column(name = "stockid")
    private int stockId;

    @Column(name = "Name")
    private String name;

    @Column(name = "price")
    private int price;

    private float per;
    private float roe;
    private float dividend;  //매출
    private float rate;  //연간주식상승률
    private float net; //순이익 상승률
    private float bis;  //자기자본비율
    private float current;  //유동비율
    private float quick;  //당좌비율
    private float debt;  //부채비율
    private float score;  //계산점수
    private float sale;  //배당률
    private float std;  //표준편차




}
