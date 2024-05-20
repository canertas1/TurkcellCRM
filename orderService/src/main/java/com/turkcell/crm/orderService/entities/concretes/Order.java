package com.turkcell.crm.orderService.entities.concretes;

import com.turkcell.crm.accountService.accountService.entities.concretes.Account;
import com.turkcell.crm.orderService.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order")
public class Order extends BaseEntity {


    @Column(name="total_amount")
    private double totalAmount;

    @OneToOne
    @JoinColumn(name="account", referencedColumnName = "id")
    private Account account;




}
