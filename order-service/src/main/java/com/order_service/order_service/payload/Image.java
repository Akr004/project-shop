package com.order_service.order_service.payload;

import com.shopingcart.payload.ProductDto;

import java.sql.Blob;

public class Image {
    private Long id;
    private String fileName;
    private String fileType;

    private Blob image;
    private String downloadUrl;

    private ProductDto productDto;
}
