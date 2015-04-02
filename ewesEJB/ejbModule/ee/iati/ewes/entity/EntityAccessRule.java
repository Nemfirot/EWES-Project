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
@Table(name = "acl")
@NamedQueries({
		@NamedQuery(name = "EntityAccessRule.findAll", query = "SELECT a FROM EntityAccessRule a"),
		@NamedQuery(name = "EntityAccessRule.findByAclId", query = "SELECT a FROM EntityAccessRule a WHERE a.aclId = :aclId") })
public class EntityAccessRule implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ACL_ID")
	private Integer aclId;
	@JoinColumn(name = "AR_ID", referencedColumnName = "AR_ID")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private EntityAccessRight arId;
	@JoinColumn(name = "ASSIGNED_SUBJECT_ID", referencedColumnName = "ASSIGNED_SUBJECT_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private EntitySubject assignedSubjectId;
	@JoinColumn(name = "COMP_ID", referencedColumnName = "COMP_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private EntityComponent compId;
	@JoinColumn(name = "CREATOR_ID", referencedColumnName = "USER_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private EntityUser creatorId;
	@JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private EntityGroup groupId;
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private EntityUser userId;

	public EntityAccessRule() {
	}

	public EntityAccessRule(Integer aclId) {
		this.aclId = aclId;
	}

	public Integer getAclId() {
		return aclId;
	}

	public void setAclId(Integer aclId) {
		this.aclId = aclId;
	}

	public EntityAccessRight getArId() {
		return arId;
	}

	public void setArId(EntityAccessRight arId) {
		this.arId = arId;
	}

	public EntitySubject getAssignedSubjectId() {
		return assignedSubjectId;
	}

	public void setAssignedSubjectId(EntitySubject assignedSubjectId) {
		this.assignedSubjectId = assignedSubjectId;
	}

	public EntityComponent getCompId() {
		return compId;
	}

	public void setCompId(EntityComponent compId) {
		this.compId = compId;
	}

	public EntityUser getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(EntityUser creatorId) {
		this.creatorId = creatorId;
	}

	public EntityGroup getGroupId() {
		return groupId;
	}

	public void setGroupId(EntityGroup groupId) {
		this.groupId = groupId;
	}

	public EntityUser getUserId() {
		return userId;
	}

	public void setUserId(EntityUser userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (aclId != null ? aclId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof EntityAccessRule)) {
			return false;
		}
		EntityAccessRule other = (EntityAccessRule) object;
		if ((this.aclId == null && other.aclId != null)
				|| (this.aclId != null && !this.aclId.equals(other.aclId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ee.iati.ewes.dto.Acl[ aclId=" + aclId + " ]";
	}

}
