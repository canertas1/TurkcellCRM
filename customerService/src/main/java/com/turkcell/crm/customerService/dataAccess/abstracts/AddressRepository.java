package com.turkcell.crm.customerService.dataAccess.abstracts;

import com.turkcell.crm.customerService.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
