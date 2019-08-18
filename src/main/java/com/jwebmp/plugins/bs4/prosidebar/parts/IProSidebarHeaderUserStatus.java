package com.jwebmp.plugins.bs4.prosidebar.parts;

import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.ICssStructure;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bs4.prosidebar.parts.header.ProSidebarHeaderUserStatus;

import java.util.Comparator;

public interface IProSidebarHeaderUserStatus<C extends IComponentHierarchyBase, A extends Enum & AttributeDefinitions, J extends ProSidebarHeaderUserStatus<C, A, J>>
		extends Comparator<J>, Comparable<J>,
				        ICssStructure<J>
{
	J addStatus(IIcon<?> icon, String status, String colour);
}
