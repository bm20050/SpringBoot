package com.rubypaper.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Board1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	private String title;
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	private Long cnt;

	public Board1() {
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}

	private Board1(Builder builder) {

		this.seq = builder.seq;

		this.title = builder.title;

		this.writer = builder.writer;

		this.content = builder.content;

		this.createDate = builder.createDate;

	}

	public static Builder builder() {

		return new Builder();

	}

	public static class Builder {

		private Long seq;

		private String title;

		private String writer;

		private String content;

		private Date createDate;

		private Builder() {
		
		}

		private Builder(Long seq, String title, String writer, String content, Date createDate) {

			this.seq = seq;

			this.title = title;

			this.writer = writer;

			this.content = content;

			this.createDate = createDate;

		}

		public Builder id(Long seq) {

			this.seq = seq;

			return this;

		}

		public Builder title(String title) {

			this.title = title;

			return this;

		}

		public Builder writer(String writer) {

			this.writer = writer;

			return this;

		}

		public Builder content(String content) {

			this.content = content;

			return this;

		}

		public Builder createDate(Date createDate) {

			this.createDate = createDate;

			return this;

		}

		public Board1 build() {

			return new Board1(this);

		}

	}
}
