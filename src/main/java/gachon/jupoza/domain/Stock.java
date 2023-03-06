package gachon.jupoza.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "stock")
public class Stock {

    @Id
    @Column(name = "stockid")
    private int stockId;
    private String name;
    private int price;

    private float per;
    private float roe;
    private float dividend;  //배당률
    private float rate;  //연간주식상승률
    private float net; //순이익 상승률
    private float bis;  //자기자본비율
    private float current;  //유동비율
    private float quick;  //당좌비율
    private float debt;  //부채비율
    private float score;  //계산점수
    private float sale;  //매출
    private float std;  //표준편차
    private String img;


    @Builder
    public Stock (int stockId, String name, int price, float per, float roe, float dividend, float bis, float current, float quick, float debt, float score, float sale, float std, float rate, float net, String img){
        this.stockId = stockId;
        this.name = name;
        this.price = price;
        this.per = per;
        this.roe = roe;
        this.dividend = dividend;
        this.rate = rate;
        this.net = net;
        this.bis = bis;
        this.current = current;
        this.quick = quick;
        this.debt = debt;
        this.score = score;
        this.sale = sale;
        this.std = std;
        this.img = img;
    }

    public void update(String img){
        this.img = img;
    }

}
