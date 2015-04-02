/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.iati.ewes.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Artur
 */
@Embeddable
public class EntityTextResourcesPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 128)
	@Column(name = "RESOURCE_ID")
	private String resourceId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "LANG_ID")
	private int langId;

	public EntityTextResourcesPK() {
	}

	public EntityTextResourcesPK(String resourceId, int langId) {
		this.resourceId = resourceId;
		this.langId = langId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (resourceId != null ? resourceId.hashCode() : 0);
		hash += (int) langId;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof EntityTextResourcesPK)) {
			return false;
		}
		EntityTextResourcesPK other = (EntityTextResourcesPK) object;
		if ((this.resourceId == null && other.resourceId != null)
				|| (this.resourceId != null && !this.resourceId
						.equals(other.resourceId))) {
			return false;
		}
		if (this.langId != other.langId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ee.iati.ewes.dto.TextResourcesPK[ resourceId=" + resourceId
				+ ", langId=" + langId + " ]";
	}

}
