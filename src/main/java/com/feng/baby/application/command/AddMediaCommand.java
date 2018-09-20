package com.feng.baby.application.command;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class AddMediaCommand {

    @NonNull
    private List<Media> medias;

    @Data
    public class Media{
        private String url;
        private String type;
    }

}
