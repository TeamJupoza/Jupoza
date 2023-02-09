package gachon.jupoza.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStock is a Querydsl query type for Stock
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStock extends EntityPathBase<Stock> {

    private static final long serialVersionUID = -1870164519L;

    public static final QStock stock = new QStock("stock");

    public final NumberPath<Float> bis = createNumber("bis", Float.class);

    public final NumberPath<Float> current = createNumber("current", Float.class);

    public final NumberPath<Float> debt = createNumber("debt", Float.class);

    public final NumberPath<Float> dividend = createNumber("dividend", Float.class);

    public final StringPath img = createString("img");

    public final StringPath name = createString("name");

    public final NumberPath<Float> net = createNumber("net", Float.class);

    public final NumberPath<Float> per = createNumber("per", Float.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Float> quick = createNumber("quick", Float.class);

    public final NumberPath<Float> rate = createNumber("rate", Float.class);

    public final NumberPath<Float> roe = createNumber("roe", Float.class);

    public final NumberPath<Float> sale = createNumber("sale", Float.class);

    public final NumberPath<Float> score = createNumber("score", Float.class);

    public final NumberPath<Float> std = createNumber("std", Float.class);

    public final NumberPath<Integer> stockId = createNumber("stockId", Integer.class);

    public QStock(String variable) {
        super(Stock.class, forVariable(variable));
    }

    public QStock(Path<? extends Stock> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStock(PathMetadata metadata) {
        super(Stock.class, metadata);
    }

}

