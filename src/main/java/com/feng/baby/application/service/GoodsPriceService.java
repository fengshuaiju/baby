package com.feng.baby.application.service;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static sprout.jooq.generate.Tables.GOODS_PRICE;

@Slf4j
@Service
public class GoodsPriceService {

    private final DSLContext jooq;

    @Autowired
    GoodsPriceService(DSLContext jooq) {
        this.jooq = jooq;
    }


    public Map<String, Double> getPrice(String goodsId, String propertyChildIds) {
        Map<String, Double> prices = new HashMap<>();
        jooq.select(GOODS_PRICE.TYPE, GOODS_PRICE.PRICE)
                .from(GOODS_PRICE)
                .where(GOODS_PRICE.GOODS_ID.eq(goodsId))
                .and(GOODS_PRICE.PROPERTIES_JOINT.eq(propertyChildIds))
                .fetchStream().forEach(price -> prices.put(price.value1(), price.value2()));
        return prices;
    }

    public Map<String, Object> getPriceInfo(String goodsId) {
        Map<String, Object> goodsPrice = new HashMap<>();

        Record2<String, Double>[] record2s = jooq.select(GOODS_PRICE.TYPE, GOODS_PRICE.PRICE).from(GOODS_PRICE).where(GOODS_PRICE.GOODS_ID.eq(goodsId)).fetchArray();
        Map<String, List<Record2<String, Double>>> collect = Stream.of(record2s).collect(Collectors.groupingBy(Record2::value1));

        collect.forEach((key, value) -> {

            switch (key) {//OrderPriceType
                case "CUT_DOWN": {
                    Double min = value.stream().map(Record2::value2).min(Comparator.comparing(Double::doubleValue)).orElseThrow(IllegalArgumentException::new);
                    Double max = value.stream().map(Record2::value2).max(Comparator.comparing(Double::doubleValue)).orElseThrow(IllegalArgumentException::new);

                    goodsPrice.put("CUT_DOWN", min);
                    goodsPrice.put("CUT_DOWN_RANGE", min + "-" + max);
                    break;
                }
                case "NORMAL": {
                    Double min = value.stream().map(Record2::value2).min(Comparator.comparing(Double::doubleValue)).orElseThrow(IllegalArgumentException::new);
                    Double max = value.stream().map(Record2::value2).max(Comparator.comparing(Double::doubleValue)).orElseThrow(IllegalArgumentException::new);

                    goodsPrice.put("NORMAL", min);
                    goodsPrice.put("NORMAL_RANGE", min + "-" + max);
                    break;
                }
                case "GROUP": {
                    Double min = value.stream().map(Record2::value2).min(Comparator.comparing(Double::doubleValue)).orElseThrow(IllegalArgumentException::new);
                    Double max = value.stream().map(Record2::value2).max(Comparator.comparing(Double::doubleValue)).orElseThrow(IllegalArgumentException::new);

                    goodsPrice.put("GROUP", min);
                    goodsPrice.put("GROUP_RANGE", min + "-" + max);
                    break;
                }
                case "CHEAP": {
                    Double min = value.stream().map(Record2::value2).min(Comparator.comparing(Double::doubleValue)).orElseThrow(IllegalArgumentException::new);
                    Double max = value.stream().map(Record2::value2).max(Comparator.comparing(Double::doubleValue)).orElseThrow(IllegalArgumentException::new);

                    goodsPrice.put("CHEAP", min);
                    goodsPrice.put("CHEAP_RANGE", min + "-" + max);
                    break;
                }
                default: {
                    log.error("get price finish");
                }
            }

        });

        return goodsPrice;
    }

}
