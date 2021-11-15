/**
 * @author deezzex <3
 */


package org.example.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class ConfirmedOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Вкажіть місто доставки!")
    private String cityDestination;
    @NotBlank(message = "Вкажіть вулицю доставки!")
    private String streetDestination;
    @NotBlank(message = "Вкажіть номер телефону одержувача")
    private String phone;
    @NotBlank(message = "Вкажіть імя одержувача")
    private String firstNameOfCustomer;
    @NotBlank(message = "Вкажіть прізвище одержувача")
    private String lastNameOfCustomer;
    private Long total;

    @ElementCollection(targetClass = Status.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "order_status",joinColumns = @JoinColumn(name = "order_id"))
    @Enumerated(EnumType.STRING)
    private Set<Status> statuses;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="confirmOrderId")
    private Set<Order> orders;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User author;


    public ConfirmedOrder(String cityDestination, String streetDestination,String phone, String firstNameOfCustomer, String lastNameOfCustomer ,Set<Order> orders,Long total) {
        this.cityDestination = cityDestination;
        this.streetDestination = streetDestination;
        this.phone = phone;
        this.firstNameOfCustomer = firstNameOfCustomer;
        this.lastNameOfCustomer = lastNameOfCustomer;
        this.orders = orders;
        this.total=total;
    }
}
