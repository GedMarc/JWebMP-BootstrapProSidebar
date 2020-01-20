package com.jwebmp.plugins.bs4.prosidebar.parts.header;

import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bs4.prosidebar.parts.IProSidebarHeaderUserStatus;

import static com.jwebmp.core.utilities.StaticStrings.*;

public class ProSidebarHeaderUserStatus<C extends IComponentHierarchyBase, A extends Enum & AttributeDefinitions, J extends ProSidebarHeaderUserStatus<C, A, J>>
		extends Span<C, A, J>
		implements IProSidebarHeaderUserStatus<C, A, J>
{
	public ProSidebarHeaderUserStatus()
	{
		addClass("user-status");
	}

	@Override
	@SuppressWarnings("unchecked")
	public J addStatus(IIcon<?> icon, String status, String colour)
	{
		var c = icon.getIconComponent();
		if (colour != null)
		{
			c.addStyle("color", colour);
		}
		add((C) c);
		add((C) new Span<>(HTML_TAB + status));

		return (J) this;
	}

	public IProSidebarHeaderUserStatus<C, A, J> asMe()
	{
		return this;
	}
}
