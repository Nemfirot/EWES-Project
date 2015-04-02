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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Artur
 */
@Entity
@Table(name = "link_types")
@NamedQueries({
		@NamedQuery(name = "EntityLinkType.findAll", query = "SELECT l FROM EntityLinkType l"),
		@NamedQuery(name = "EntityLinkType.findByLinkTypeId", query = "SELECT l FROM EntityLinkType l WHERE l.linkTypeId = :linkTypeId"),
		@NamedQuery(name = "EntityLinkType.findByComponentId", query = "SELECT l FROM EntityLinkType l WHERE l.componentId = :componentId"),
		@NamedQuery(name = "EntityLinkType.findByLinkTitleId", query = "SELECT l FROM EntityLinkType l WHERE l.linkTitleId = :linkTitleId"),
		@NamedQuery(name = "EntityLinkType.findByLinkDescriptionId", query = "SELECT l FROM EntityLinkType l WHERE l.linkDescriptionId = :linkDescriptionId") })
public class EntityLinkType implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "LINK_TYPE_ID")
	private Integer linkTypeId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "COMPONENT_ID")
	private int componentId;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 128)
	@Column(name = "LINK_TITLE_ID")
	private String linkTitleId;
	@Size(max = 128)
	@Column(name = "LINK_DESCRIPTION_ID")
	private String linkDescriptionId;

	public EntityLinkType() {
	}

	public EntityLinkType(Integer linkTypeId) {
		this.linkTypeId = linkTypeId;
	}

	public EntityLinkType(Integer linkTypeId, int componentId, String linkTitleId) {
		this.linkTypeId = linkTypeId;
		this.componentId = componentId;
		this.linkTitleId = linkTitleId;
	}

	public Integer getLinkTypeId() {
		return linkTypeId;
	}

	public void setLinkTypeId(Integer linkTypeId) {
		this.linkTypeId = linkTypeId;
	}

	public int getComponentId() {
		return componentId;
	}

	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	public String getLinkTitleId() {
		return linkTitleId;
	}

	public void setLinkTitleId(String linkTitleId) {
		this.linkTitleId = linkTitleId;
	}

	public String getLinkDescriptionId() {
		return linkDescriptionId;
	}

	public void setLinkDescriptionId(String linkDescriptionId) {
		this.linkDescriptionId = linkDescriptionId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (linkTypeId != null ? linkTypeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof EntityLinkType)) {
			return false;
		}
		EntityLinkType other = (EntityLinkType) object;
		if ((this.linkTypeId == null && other.linkTypeId != null)
				|| (this.linkTypeId != null && !this.linkTypeId
						.equals(other.linkTypeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ee.iati.ewes.dto.LinkTypes[ linkTypeId=" + linkTypeId + " ]";
	}

}
