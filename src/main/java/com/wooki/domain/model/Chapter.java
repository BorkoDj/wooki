package com.wooki.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

/**
 * Represents a chapter of the book.
 * 
 * @author ccordenier
 * 
 */
@Entity
public class Chapter extends WookiEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_book", nullable = false)
	private Book book;

	/** User friendly title */
	private String title;

	/** Identifier title */
	private String slugTitle;

	/** Content of the book */
	@Lob
	private byte[] content;

	/**
	 * Constructor used to retrieve only required information for chapters
	 * display.
	 * 
	 * @param id
	 * @param title
	 * @param lastModified
	 */
	public Chapter(long id, String title, Date lastModified) {
		this.id = id;
		this.title = title;
		this.setLastModified(lastModified);
	}

	public Chapter() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlugTitle() {
		return slugTitle;
	}

	public void setSlugTitle(String titleSlug) {
		this.slugTitle = titleSlug;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
