/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.iati.ewes.entity;

import java.io.Serializable;

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

/**
 *
 * @author Artur
 */
@Entity
@Table(name = "assigned_subjects")
@NamedQueries({
		@NamedQuery(name = "EntitySubject.findAll", query = "SELECT a FROM EntitySubject a"),
		@NamedQuery(name = "EntitySubject.findByAssignedSubjectId", query = "SELECT a FROM EntitySubject a WHERE a.assignedSubjectId = :assignedSubjectId") })
public class EntitySubject implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ASSIGNED_SUBJECT_ID")
	private Integer assignedSubjectId;
	@JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private EntityGroup groupId;
	@JoinColumn(name = "SUBJECT_ID", referencedColumnName = "SUBJECT_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private EntitySubjectDescription subjectId;
	@JoinColumn(name = "TEACHER_ID", referencedColumnName = "USER_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private EntityUser teacherId;

	public EntitySubject() {
	}

	public EntitySubject(Integer assignedSubjectId) {
		this.assignedSubjectId = assignedSubjectId;
	}

	public Integer getAssignedSubjectId() {
		return assignedSubjectId;
	}

	public void setAssignedSubjectId(Integer assignedSubjectId) {
		this.assignedSubjectId = assignedSubjectId;
	}

	public EntityGroup getGroupId() {
		return groupId;
	}

	public void setGroupId(EntityGroup groupId) {
		this.groupId = groupId;
	}

	public EntitySubjectDescription getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(EntitySubjectDescription subjectId) {
		this.subjectId = subjectId;
	}

	public EntityUser getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(EntityUser teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (assignedSubjectId != null ? assignedSubjectId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof EntitySubject)) {
			return false;
		}
		EntitySubject other = (EntitySubject) object;
		if ((this.assignedSubjectId == null && other.assignedSubjectId != null)
				|| (this.assignedSubjectId != null && !this.assignedSubjectId
						.equals(other.assignedSubjectId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ee.iati.ewes.dto.AssignedSubjects[ assignedSubjectId="
				+ assignedSubjectId + " ]";
	}

}
