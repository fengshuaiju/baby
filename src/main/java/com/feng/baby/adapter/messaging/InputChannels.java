package com.feng.baby.adapter.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by minggaoxi on 22/08/2017.
 */
public interface InputChannels {

    String INPUT_FROM_SELF = "from-self";
    String INPUT_FROM_UAA = "from-uaa";


    @Input(InputChannels.INPUT_FROM_SELF)
    SubscribableChannel inputFromSelf();

    @Input(InputChannels.INPUT_FROM_UAA)
    SubscribableChannel inputFromUaa();

}
