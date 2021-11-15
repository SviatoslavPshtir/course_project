/**
 * @author deezzex <3
 */


package org.example.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.enums.Category;
import org.example.entities.enums.Stock;
import org.example.entities.util.ProductHelper;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String producer;
    private Long price;
    private String fileName;
    private String subtitle;


    @ElementCollection(targetClass = Stock.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "product_inStock",joinColumns = @JoinColumn(name = "product_id"))
    @Enumerated(EnumType.STRING)
    private Set<Stock> inStock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User author;

    @ElementCollection(targetClass = Category.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "product_category",joinColumns = @JoinColumn(name = "product_id"))
    @Enumerated(EnumType.STRING)
    private Set<Category> categories;

    @ManyToMany
    @JoinTable(name = "product_likes",
                joinColumns = {@JoinColumn(name = "product_id")},
                inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> likes = new HashSet<>();

    public Product(String name, String producer, Long price, String subtitle, User author) {
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.subtitle = subtitle;
        this.author = author;
    }
}
