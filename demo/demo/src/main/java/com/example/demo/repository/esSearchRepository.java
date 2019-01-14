package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.esSearch.blog;

public interface esSearchRepository extends
		ElasticsearchRepository<blog, String> {
	
	// return page is already have different page filter
	Page<blog> findDistinctblogByTitleContainingOrSummaryContainingOrContentContaining(
			String title, String summary, String content);

}
