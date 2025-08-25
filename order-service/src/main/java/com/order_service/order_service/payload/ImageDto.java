package com.order_service.order_service.payload;

import lombok.Data;

@Data
public class ImageDto {

    private Long imageId;
    private String imageName;
    private String downloadUrl;

}
