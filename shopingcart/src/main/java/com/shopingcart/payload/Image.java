package com.shopingcart.payload;

import java.sql.Blob;

public class Image {
    private Long id;
    private String fileName;
    private String fileType;

    private Blob image;
    private String downloadUrl;

    private ProductDto productDto;
}
