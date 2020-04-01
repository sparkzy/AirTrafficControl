package com.clarity.bobbymcgetrick.airtrafficcontrol.entities;

import java.util.List;

/**
* AircraftQueue Spring Entity for Air-Traffic-Control
* 
* @author Bobby McGetrick
*
*/
public class AircraftQueue {

	/************************************************************************************
	 * Fields
	 ************************************************************************************/
	List<Aircraft> queue;

	/************************************************************************************
	 * Constructors
	 ************************************************************************************/
	public AircraftQueue() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create a new AircraftQueue with a previously constructed List of Aircraft
	 * 
	 * @param queue
	 */
	public AircraftQueue(List<Aircraft> queue) {
		super();
		this.queue = queue;
	}
		
	/************************************************************************************
	 * hashCode() and equals()
	 ************************************************************************************/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((queue == null) ? 0 : queue.hashCode());
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
		AircraftQueue other = (AircraftQueue) obj;
		if (queue == null) {
			if (other.queue != null)
				return false;
		} else if (!queue.equals(other.queue))
			return false;
		return true;
	}
	
	/************************************************************************************
	* Getters and Setters
	*************************************************************************************/
	public List<Aircraft> getQueue() {
		return queue;
	}

	public void setQueue(List<Aircraft> queue) {
		this.queue = queue;
	}
	
	/************************************************************************************
	* toString()
	*************************************************************************************/
	@Override
	public String toString() {
		return "AircraftQueue [queue=" + queue + "]";
	}
}
