package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbuac.model.TechCharact;

public interface TechCharactRepository extends JpaRepository<TechCharact, Integer> {
}
