package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbuac.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
