package com.dbg.dao.evaluation;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbg.model.evaluation.Evaluation;

@Repository
public interface EvaluationDao extends PagingAndSortingRepository<Evaluation, Integer> {

	@Query(value = "select e from Evaluation e where (:idUser is null OR e.user.id = :idUser) AND (:idFilm is null OR e.film.id = :idFilm)")
	List<Evaluation> findByUserIdAndFilmId(@Param(value = "idUser")Integer idUser, @Param("idFilm") Integer idFilm);
}
