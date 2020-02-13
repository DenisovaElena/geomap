package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbuac.model.CostOfOwnership;

public interface CostOfOwnershipRepository extends JpaRepository<CostOfOwnership, Integer> {
}
