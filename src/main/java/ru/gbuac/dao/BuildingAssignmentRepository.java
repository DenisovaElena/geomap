package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbuac.model.BuildingAssignment;

public interface BuildingAssignmentRepository extends JpaRepository<BuildingAssignment, Integer> {
}
