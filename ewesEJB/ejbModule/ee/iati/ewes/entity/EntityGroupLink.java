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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import ee.iati.ewes.dto.DTOGroupLink;
import ee.iati.ewes.utils.GROUP_LINK_TYPE;

/**
 *
 * @author Artur
 */
@Entity
@Table(name = "group_links")
@NamedQueries({
		@NamedQuery(name = "EntityGroupLink.findAll", query = "SELECT g FROM EntityGroupLink g"),
		@NamedQuery(name = "EntityGroupLink.findByGroupLinkId", query = "SELECT g FROM EntityGroupLink g WHERE g.groupLinkId = :groupLinkId") })
public class EntityGroupLink implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "GROUP_LINK_ID")
	private Integer groupLinkId;
	@Column(name = "GROUP_ID")
	@Basic(optional = false)
	private Integer groupId;
	@Column(name = "LINK_TYPE_ID")
	@Basic(optional = false)
	private Integer linkTypeId;
	@Column(name = "USER_ID")
	@Basic(optional = false)
	private Integer userId;

	public EntityGroupLink() {
	}
	
	public EntityGroupLink(DTOGroupLink dtoGroupLink)
	{
		this.groupLinkId = dtoGroupLink.getGroupLinkId();
		this.groupId = dtoGroupLink.getGroupId();
		this.linkTypeId = dtoGroupLink.getLinkType().ordinal();
		this.userId = dtoGroupLink.getUserId();
	}

	public EntityGroupLink(Integer groupLinkId) {
		this.groupLinkId = groupLinkId;
	}

	public Integer getGroupLinkId() {
		return groupLinkId;
	}

	public void setGroupLinkId(Integer groupLinkId) {
		this.groupLinkId = groupLinkId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getLinkTypeId() {
		return linkTypeId;
	}

	public void setLinkTypeId(Integer linkTypeId) {
		this.linkTypeId = linkTypeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (groupLinkId != null ? groupLinkId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof EntityGroupLink)) {
			return false;
		}
		EntityGroupLink other = (EntityGroupLink) object;
		if ((this.groupLinkId == null && other.groupLinkId != null)
				|| (this.groupLinkId != null && !this.groupLinkId
						.equals(other.groupLinkId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ee.iati.ewes.dto.GroupLinks[ groupLinkId=" + groupLinkId + " ]";
	}
	
	public DTOGroupLink toDTO()
	{
		return new DTOGroupLink(groupLinkId, groupId, GROUP_LINK_TYPE.convert(linkTypeId), userId);
	}
}
