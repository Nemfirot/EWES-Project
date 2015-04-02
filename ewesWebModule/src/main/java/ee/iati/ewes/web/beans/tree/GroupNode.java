package ee.iati.ewes.web.beans.tree;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

import com.google.common.collect.Iterators;

public class GroupNode extends NamedNodeWithKey implements TreeNode {
	private static final long serialVersionUID = 1L;
	
	private List<TreeNode> childNodes = new ArrayList<TreeNode>();
	private TreeNode parent = null;
	
	public GroupNode()							{ this.setType("GROUP"); }
	
	public List<TreeNode> getChildren()			{ return childNodes; }
	public void setParent(TreeNode parent)		{ this.parent = parent; }
	@Override
	public TreeNode getParent()					{ return parent; }
	
	@Override
	public TreeNode getChildAt(int childIndex)	{ return childNodes.get(childIndex); }
	@Override
	public int getChildCount()					{ return childNodes.size(); }
	@Override
	public int getIndex(TreeNode node)			{ return childNodes.indexOf(node); }
	@Override
	public boolean getAllowsChildren()			{ return true; }
	@Override
	public boolean isLeaf()						{ return childNodes.isEmpty(); }
	@Override
	public Enumeration<TreeNode> children()		{ return Iterators.asEnumeration(childNodes.iterator()); }
}
