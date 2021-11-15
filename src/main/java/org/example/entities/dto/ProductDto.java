/**
 * @author deezzex <3
 */


package org.example.entities.dto;

import lombok.Data;
import org.example.entities.Product;
import org.example.entities.User;
import org.example.entities.util.ProductHelper;
import org.springframework.beans.factory.annotation.Autowired;

@Data

public class ProductDto {
    private Long id;
    private String name;
    private String producer;
    private Long price;
    private String fileName;
    private String subtitle;
    private User author;
    private Long likes;
    private boolean meLiked;

    public ProductDto(Product product, Long likes, boolean meLiked) {
        this.id = product.getId();
        this.name = product.getName();
        this.producer = product.getProducer();
        this.price = product.getPrice();
        this.fileName = product.getFileName();
        this.subtitle = product.getSubtitle();
        this.author = product.getAuthor();
        this.likes = likes;
        this.meLiked = meLiked;
    }
}
