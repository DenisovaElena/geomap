package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbuac.model.StreetType;

public interface StreetTypeRepository extends JpaRepository<StreetType, Integer> {
}
