package ee.iati.ewes.dto;

public class DTOGroup extends DTOBase {
	private static final long serialVersionUID = 1L;
	
	private Integer		groupId;
	private String		title;
	private String		description;
	private Integer		parent;

	public Integer getGroupId()						{ return groupId; }
	public void setGroupId(Integer groupId)			{ this.groupId = groupId; }

	public String getTitle()						{ return title; }
	public void setTitle(String title)				{ this.title = title; }

	public String getDescription()					{ return description; }
	public void setDescription(String description)	{ this.description = description; }

	/*public DTOGroup getParent()					{ return parent; }
	public void setParentId(DTOGroup parent)		{ this.parent = parent; }*/

	public Integer getParent()						{ return parent; }
	public void setParent(Integer parent)			{ this.parent = parent; }
	
	public DTOGroup() { }
	public DTOGroup(Integer groupId, String title, String description, Integer parent) 
	{ 
		this.groupId = groupId;
		this.title = title;
		this.description = description;
		this.parent = parent;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DTOGroup other = (DTOGroup) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (groupId == null) {
			if (other.groupId != null) {
				return false;
			}
		} else if (!groupId.equals(other.groupId)) {
			return false;
		}
		if (parent == null) {
			if (other.parent != null) {
				return false;
			}
		} else if (!parent.equals(other.parent)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "DTOGroup [groupId=" + groupId + ", title=" + title
				+ ", description=" + description + ", parent=" + parent + "]";
	}	
}