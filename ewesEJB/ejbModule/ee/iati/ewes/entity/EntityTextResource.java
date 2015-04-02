/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.iati.ewes.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "text_resources")
@NamedQueries({
		@NamedQuery(name = "EntityTextResource.findAll", query = "SELECT t FROM EntityTextResource t"),
		@NamedQuery(name = "EntityTextResource.findByResourceId", query = "SELECT t FROM EntityTextResource t WHERE t.textResourcesPK.resourceId = :resourceId"),
		@NamedQuery(name = "EntityTextResource.findByLangId", query = "SELECT t FROM EntityTextResource t WHERE t.textResourcesPK.langId = :langId"),
		@NamedQuery(name = "EntityTextResource.findByResourceText", query = "SELECT t FROM EntityTextResource t WHERE t.resourceText = :resourceText") })
public class EntityTextResource implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected EntityTextResourcesPK textResourcesPK;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 512)
	@Column(name = "RESOURCE_TEXT")
	private String resourceText;

	public EntityTextResource() {
	}

	public EntityTextResource(EntityTextResourcesPK textResourcesPK) {
		this.textResourcesPK = textResourcesPK;
	}

	public EntityTextResource(EntityTextResourcesPK textResourcesPK,
			String resourceText) {
		this.textResourcesPK = textResourcesPK;
		this.resourceText = resourceText;
	}

	public EntityTextResource(String resourceId, int langId) {
		this.textResourcesPK = new EntityTextResourcesPK(resourceId, langId);
	}

	public EntityTextResourcesPK getTextResourcesPK() {
		return textResourcesPK;
	}

	public void setTextResourcesPK(EntityTextResourcesPK textResourcesPK) {
		this.textResourcesPK = textResourcesPK;
	}

	public String getResourceText() {
		return resourceText;
	}

	public void setResourceText(String resourceText) {
		this.resourceText = resourceText;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (textResourcesPK != null ? textResourcesPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof EntityTextResource)) {
			return false;
		}
		EntityTextResource other = (EntityTextResource) object;
		if ((this.textResourcesPK == null && other.textResourcesPK != null)
				|| (this.textResourcesPK != null && !this.textResourcesPK
						.equals(other.textResourcesPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ee.iati.ewes.dto.TextResources[ textResourcesPK="
				+ textResourcesPK + " ]";
	}

}
