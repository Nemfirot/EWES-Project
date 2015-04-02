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
@Table(name = "subjects")
@NamedQueries({
		@NamedQuery(name = "EntitySubjectDescription.findAll", query = "SELECT s FROM EntitySubjectDescription s"),
		@NamedQuery(name = "EntitySubjectDescription.findBySubjectId", query = "SELECT s FROM EntitySubjectDescription s WHERE s.subjectId = :subjectId"),
		@NamedQuery(name = "EntitySubjectDescription.findByTitleId", query = "SELECT s FROM EntitySubjectDescription s WHERE s.titleId = :titleId") })
public class EntitySubjectDescription implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "SUBJECT_ID")
	private Integer subjectId;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 128)
	@Column(name = "TITLE_ID")
	private String titleId;

	public EntitySubjectDescription() {
	}

	public EntitySubjectDescription(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public EntitySubjectDescription(Integer subjectId, String titleId) {
		this.subjectId = subjectId;
		this.titleId = titleId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (subjectId != null ? subjectId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof EntitySubjectDescription)) {
			return false;
		}
		EntitySubjectDescription other = (EntitySubjectDescription) object;
		if ((this.subjectId == null && other.subjectId != null)
				|| (this.subjectId != null && !this.subjectId
						.equals(other.subjectId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ee.iati.ewes.dto.Subjects[ subjectId=" + subjectId + " ]";
	}

}
