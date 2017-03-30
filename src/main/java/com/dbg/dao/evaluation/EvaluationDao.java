package com.dbg.dao.evaluation;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dbg.model.evaluation.Evaluation;

@Repository
public interface EvaluationDao extends PagingAndSortingRepository<Evaluation, Integer> {
	List<Evaluation> findByPointsBetween(Integer p1, Integer p2);
}
