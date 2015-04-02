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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ee.iati.ewes.dto.DTOGroup;

/**
 *
 * @author Artur
 */
@Entity
@Table(name = "ewes_groups")
@NamedQueries({
		@NamedQuery(name = "EntityGroup.findAll", query = "SELECT e FROM EntityGroup e"),
		@NamedQuery(name = "EntityGroup.findByGroupId", query = "SELECT e FROM EntityGroup e WHERE e.groupId = :groupId"),
		@NamedQuery(name = "EntityGroup.findByTitle", query = "SELECT e FROM EntityGroup e WHERE e.title = :title"),
		@NamedQuery(name = "EntityGroup.findByDescription", query = "SELECT e FROM EntityGroup e WHERE e.description = :description") })
public class EntityGroup implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "GROUP_ID")
	private Integer groupId;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 128)
	@Column(name = "TITLE")
	private String title;
	@Size(max = 512)
	@Column(name = "DESCRIPTION")
	private String description;
	/*@JoinColumn(name = "PARENT_ID", referencedColumnName = "GROUP_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	private EntityGroup parent;*/
	@Basic(optional = true)
	@Column(name = "PARENT_ID")
	private Integer parent;

	public EntityGroup() {
	}
	
	public EntityGroup(DTOGroup dto) {
		this.groupId = dto.getGroupId();
		this.title = dto.getTitle();
		this.description = dto.getDescription();
		this.parent = dto.getParent();
	}

	public EntityGroup(Integer groupId) {
		this.groupId = groupId;
	}

	public EntityGroup(Integer groupId, String title) {
		this.groupId = groupId;
		this.title = title;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*public EntityGroup getParentId() {
		return parent;
	}

	public void setParentId(EntityGroup parentId) {
		this.parent = parentId;
	}*/

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (groupId != null ? groupId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof EntityGroup)) {
			return false;
		}
		EntityGroup other = (EntityGroup) object;
		if ((this.groupId == null && other.groupId != null)
				|| (this.groupId != null && !this.groupId.equals(other.groupId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ee.iati.ewes.dto.EwesGroups[ groupId=" + groupId + " ]";
	}
	
	public DTOGroup toDTO()
	{
		//DTOGroup dtoParent = null == parent ? null : parent.toDTO();
		DTOGroup dtoRet = new DTOGroup(groupId, title, description, parent); 
		return dtoRet;
	}
}
