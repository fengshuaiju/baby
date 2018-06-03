package com.feng.baby.controller;

import com.feng.baby.representation.OrderRepresentation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by fengshuaiju on 2018-06-03.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/list")
    public List<OrderRepresentation> orders(){

        List<OrderRepresentation> list = new ArrayList<>();

        for(int i=0; i<5; i++){
            OrderRepresentation build = OrderRepresentation.builder()
                    .orderId("ID-" + UUID.randomUUID().toString())
                    .customerName("feng")
                    .customerSex("man")
                    .customerPhone("18012345678")
                    .build();

            list.add(build);
        }

        return list;
    }

}
