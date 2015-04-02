package ee.iati.ewes.web.beans.tree;

import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

public class UserNode extends NamedNodeWithKey implements TreeNode {
	private static final long serialVersionUID = 1L;
	
	private TreeNode parent;
	
	public UserNode()							{ this.setType("USER"); }
	
	public List<TreeNode> getChildren()			{ return null; }
	public void setParent(TreeNode parent)		{ this.parent = parent; }
	@Override
	public TreeNode getParent() 				{ return parent; }
	
	@Override
	public TreeNode getChildAt(int childIndex)	{ return null; }
	@Override
	public int getChildCount() 					{ return 0; }
	@Override
	public int getIndex(TreeNode node) 			{ return 0; }
	@Override
	public boolean getAllowsChildren() 			{ return false; }
	@Override
	public boolean isLeaf()						{ return true; }
	@Override
	public Enumeration<TreeNode> children()		{ return null; }
}
