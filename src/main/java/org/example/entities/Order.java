/**
 * @author deezzex <3
 */


package org.example.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "ord")
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product;

    private boolean completed;
    @NotBlank(message = "Введіть кількість товару!")
    private String count;


    public Order(User author, Product product,boolean completed,String count) {
        this.author = author;
        this.product = product;
        this.completed=completed;
        this.count=count;
    }

    @Override
    public String toString() {
        return product.getName() + " - " + count;
    }
}
