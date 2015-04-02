/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.iati.ewes.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Artur
 */
@Entity
@Table(name = "tasks")
@NamedQueries({
		@NamedQuery(name = "EntityTask.findAll", query = "SELECT t FROM EntityTask t"),
		@NamedQuery(name = "EntityTask.findByTaskId", query = "SELECT t FROM EntityTask t WHERE t.taskId = :taskId"),
		@NamedQuery(name = "EntityTask.findByDescr", query = "SELECT t FROM EntityTask t WHERE t.descr = :descr"),
		@NamedQuery(name = "EntityTask.findByStartDate", query = "SELECT t FROM EntityTask t WHERE t.startDate = :startDate"),
		@NamedQuery(name = "EntityTask.findByEndDate", query = "SELECT t FROM EntityTask t WHERE t.endDate = :endDate") })
public class EntityTask implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "TASK_ID")
	private Integer taskId;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1024)
	@Column(name = "DESCR")
	private String descr;
	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@Basic(optional = false)
	@NotNull
	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	@JoinColumn(name = "ASSIGNED_SUBJECT_ID", referencedColumnName = "ASSIGNED_SUBJECT_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private EntitySubject assignedSubjectId;

	public EntityTask() {
	}

	public EntityTask(Integer taskId) {
		this.taskId = taskId;
	}

	public EntityTask(Integer taskId, String descr, Date endDate) {
		this.taskId = taskId;
		this.descr = descr;
		this.endDate = endDate;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public EntitySubject getAssignedSubjectId() {
		return assignedSubjectId;
	}

	public void setAssignedSubjectId(EntitySubject assignedSubjectId) {
		this.assignedSubjectId = assignedSubjectId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (taskId != null ? taskId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof EntityTask)) {
			return false;
		}
		EntityTask other = (EntityTask) object;
		if ((this.taskId == null && other.taskId != null)
				|| (this.taskId != null && !this.taskId.equals(other.taskId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ee.iati.ewes.dto.Tasks[ taskId=" + taskId + " ]";
	}

}
