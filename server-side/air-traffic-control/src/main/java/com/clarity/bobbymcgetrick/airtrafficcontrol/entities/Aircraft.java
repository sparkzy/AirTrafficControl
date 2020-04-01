package com.clarity.bobbymcgetrick.airtrafficcontrol.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
* Aircraft Spring Entity for Air-Traffic-Control
* 
* @author Bobby McGetrick
*
*/
@Entity
@Table(name = "aircraft")
public class Aircraft {
	
	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	@Id
	@Column(name = "aircraft_id")
	@SequenceGenerator(name = "aircraft_id_seq", sequenceName = "aircraft_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "aircraft_id_seq", strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id")
	private Type type;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "size_id")
	private Size size;

//	@Column(name = "behind_ac_id")
//	private int behindAcId;
//
//	@Column(name = "ahead_ac_id")
//	private int aheadAcId;

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	public Aircraft() {
		super();
	}

	/**
	 * Create new Aircraft with pre-defined Type and Size
	 * 
	 * @param type
	 * @param size
	 */
	public Aircraft(Type type, Size size) {
		super();
		this.type = type;
		this.size = size;
	}
	
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + aheadAcId;
//		result = prime * result + behindAcId;
		result = prime * result + id;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Aircraft other = (Aircraft) obj;
//		if (aheadAcId != other.aheadAcId)
//			return false;
//		if (behindAcId != other.behindAcId)
//			return false;
		if (id != other.id)
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	/************************************************************************************
	* Getters and Setters
	*************************************************************************************/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

//	public int getBehindAcId() {
//		return behindAcId;
//	}
//
//	public void setBehindAcId(int behindAcId) {
//		this.behindAcId = behindAcId;
//	}
//
//	public int getAheadAcId() {
//		return aheadAcId;
//	}
//
//	public void setAheadAcId(int aheadAcId) {
//		this.aheadAcId = aheadAcId;
//	}	
	
	/************************************************************************************
	* toString()
	************************************************************************************/
//	@Override
//	public String toString() {
//		return "Aircraft [id=" + id + ", type=" + type + ", size=" + size + ", behindAcId=" + behindAcId
//				+ ", aheadAcId=" + aheadAcId + "]";
//	}

	@Override
	public String toString() {
		return "Aircraft [id=" + id + ", type=" + type + ", size=" + size + "]";
	}
	
	
}
