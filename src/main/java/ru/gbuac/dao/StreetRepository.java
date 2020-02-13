package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbuac.model.Street;

public interface StreetRepository extends JpaRepository<Street, Integer> {
}
