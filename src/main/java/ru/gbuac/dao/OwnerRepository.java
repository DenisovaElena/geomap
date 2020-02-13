package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbuac.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
