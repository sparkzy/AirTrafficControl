package com.clarity.bobbymcgetrick.airtrafficcontrol.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class Type {
	
	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	@Id
	@Column(name = "type_id")
	@SequenceGenerator(name = "type_id_seq", sequenceName = "type_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "type_id_seq", strategy = GenerationType.AUTO)
//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "type_id")
	private int id;
	
	@Column(name = "type_priority")
	private int priority;
	
	@Column(name = "type_name")
	private String name;

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create new Type with pre-defined priority and name
	 * 
	 * @param typePriority
	 * @param typeName
	 */
	public Type(int typePriority, String typeName) {
		super();
		this.priority = typePriority;
		this.name = typeName;
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
		Type other = (Type) obj;
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
		return "Type [id=" + id + ", priority=" + priority + ", name=" + name + "]";
	}

}
