package com.example.demo.esSearch;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "blog", type = "blog")
public class blog implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String title;
	private String content;
	private String summary;

	// JPA initlize
	protected blog() {

	}

	public blog(String id, String title, String content, String summary) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.summary = summary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}
