package ee.iati.ewes.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-29T17:27:56.421+0300")
@StaticMetamodel(EntityAccessRule.class)
public class EntityAccessRule_ {
	public static volatile SingularAttribute<EntityAccessRule, Integer> aclId;
	public static volatile SingularAttribute<EntityAccessRule, EntityAccessRight> arId;
	public static volatile SingularAttribute<EntityAccessRule, EntitySubject> assignedSubjectId;
	public static volatile SingularAttribute<EntityAccessRule, EntityComponent> compId;
	public static volatile SingularAttribute<EntityAccessRule, EntityUser> creatorId;
	public static volatile SingularAttribute<EntityAccessRule, EntityGroup> groupId;
	public static volatile SingularAttribute<EntityAccessRule, EntityUser> userId;
}
