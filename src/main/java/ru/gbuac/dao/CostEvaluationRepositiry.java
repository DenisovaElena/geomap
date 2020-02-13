package ru.gbuac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbuac.model.CostEvaluation;

public interface CostEvaluationRepositiry extends JpaRepository<CostEvaluation, Integer> {
}
