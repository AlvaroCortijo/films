package com.dbg.dao.category;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dbg.model.category.Category;

@Repository
public interface CategoryDao extends PagingAndSortingRepository<Category, Integer> {

	List<Category> findByNameLike(String name);
	
}
