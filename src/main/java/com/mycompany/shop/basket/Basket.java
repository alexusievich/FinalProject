package com.mycompany.shop.basket;

import com.mycompany.shop.item.Item;
import com.mycompany.shop.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Basket {

    @Id
    @GeneratedValue
    private Long id;

    private Integer totalPrice = 0;


    private Long userId;

    @OneToMany
    private List<Item> items = new ArrayList<>();

    public Basket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void recalculateTotalPrice() {
        this.totalPrice = 0;
        items.forEach(item -> this.totalPrice += item.getProduct().getPrice());
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
