package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbuac.model.BudgetRevenues;

public interface BudgetRevenuesRepository extends JpaRepository<BudgetRevenues, Integer> {
}
