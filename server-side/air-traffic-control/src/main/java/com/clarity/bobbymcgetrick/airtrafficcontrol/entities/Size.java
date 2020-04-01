package com.clarity.bobbymcgetrick.airtrafficcontrol.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "sizes")
public class Size {
	
	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	@Id
	@Column(name = "size_id")
	@SequenceGenerator(name = "size_id_seq", sequenceName = "size_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "size_id_seq", strategy = GenerationType.AUTO)
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "size_id")
	private int id;
	
	@Column(name = "size_priority")
	private int priority;
	
	@Column(name = "size_name")
	private String name;

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	public Size() {
		super();
	}

	/**
	 * Create new Size with pre-defined priority and name
	 * 
	 * @param sizePriority
	 * @param sizeName
	 */
	public Size(int sizePriority, String sizeName) {
		super();
		this.priority = sizePriority;
		this.name = sizeName;
	}

	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + priority;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Size other = (Size) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (priority != other.priority)
			return false;
		return true;
	}

	/************************************************************************************
	* Getters and Setters
	************************************************************************************/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/************************************************************************************
	* toString()
	************************************************************************************/
	@Override
	public String toString() {
		return "Size [id=" + id + ", priority=" + priority + ", name=" + name + "]";
	}
	
}
