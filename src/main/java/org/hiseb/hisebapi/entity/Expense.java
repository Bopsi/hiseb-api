package org.hiseb.hisebapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.lang.Nullable;

@Entity
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String item;

	@Column(nullable = false)
	private double amount;

	@Column(nullable = false)
	private Date paidOn;

	@Column(nullable = false)
	private String paidBy;

	@Column(nullable = false)
	private String paidWith;

	@ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER, optional = false)
	private Category category;

	@ManyToOne(targetEntity = Tag.class, fetch = FetchType.EAGER, optional = false)
	private Tag tag;

	@Column
	@Nullable
	private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPaidOn() {
		return paidOn;
	}

	public void setPaidOn(Date paidOn) {
		this.paidOn = paidOn;
	}

	public String getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}

	public String getPaidWith() {
		return paidWith;
	}

	public void setPaidWith(String paidWith) {
		this.paidWith = paidWith;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
