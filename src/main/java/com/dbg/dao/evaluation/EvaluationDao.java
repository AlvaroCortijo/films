package com.dbg.dao.evaluation;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbg.model.evaluation.Evaluation;
import com.dbg.model.film.Film;
import com.dbg.model.user.User;

@Repository
public interface EvaluationDao extends PagingAndSortingRepository<Evaluation, Integer> {

	@Query(value = "select e from Evaluation e where (:idUser is null OR e.user.id = :idUser) AND (:idFilm is null OR e.film.id = :idFilm) AND (:idCategory is null OR e.film.category.id = :idCategory)")
	List<Evaluation> findByUserIdAndFilmIdAndCategoryId(@Param(value = "idUser")Integer idUser, @Param("idFilm") Integer idFilm, @Param("idCategory") Integer idCategory);
	
	@Query(value = "select e from Evaluation e where (:name is null OR e.user.name LIKE %:name%) AND (:title is null OR e.film.title LIKE %:title%)")
	List<Evaluation> findByUserNameAndFilmTitle(@Param(value="name") String name, @Param(value="title") String title);

	Evaluation findById(Integer id);
	
	@Query(value="select u from User u where u.id = :id")
	User findByUserId(@Param(value="id") Integer id);

	@Query(value="select f from Film f where f.id = :id")
	Film findByFilmId(@Param(value="id") Integer id);

}
