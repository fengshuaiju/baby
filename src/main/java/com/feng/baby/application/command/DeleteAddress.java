package com.feng.baby.application.command;

import lombok.Data;
import lombok.NonNull;

@Data
public class DeleteAddress {
    @NonNull
    private String userAddressId;
    @NonNull
    private String username;
}
