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
@Table(name = "components")
@NamedQueries({
		@NamedQuery(name = "EntityComponent.findAll", query = "SELECT c FROM EntityComponent c"),
		@NamedQuery(name = "EntityComponent.findByCompId", query = "SELECT c FROM EntityComponent c WHERE c.compId = :compId"),
		@NamedQuery(name = "EntityComponent.findByTitleId", query = "SELECT c FROM EntityComponent c WHERE c.titleId = :titleId"),
		@NamedQuery(name = "EntityComponent.findByDescrId", query = "SELECT c FROM EntityComponent c WHERE c.descrId = :descrId") })
public class EntityComponent implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "COMP_ID")
	private Integer compId;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 128)
	@Column(name = "TITLE_ID")
	private String titleId;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 128)
	@Column(name = "DESCR_ID")
	private String descrId;

	public EntityComponent() {
	}

	public EntityComponent(Integer compId) {
		this.compId = compId;
	}

	public EntityComponent(Integer compId, String titleId, String descrId) {
		this.compId = compId;
		this.titleId = titleId;
		this.descrId = descrId;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public String getDescrId() {
		return descrId;
	}

	public void setDescrId(String descrId) {
		this.descrId = descrId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (compId != null ? compId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof EntityComponent)) {
			return false;
		}
		EntityComponent other = (EntityComponent) object;
		if ((this.compId == null && other.compId != null)
				|| (this.compId != null && !this.compId.equals(other.compId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ee.iati.ewes.dto.Components[ compId=" + compId + " ]";
	}

}
