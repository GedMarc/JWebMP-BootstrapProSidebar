package com.jwebmp.plugins.bs4.prosidebar.parts.menu;

import com.jwebmp.core.base.html.List;
import com.jwebmp.core.base.html.ListItem;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;
import com.jwebmp.core.base.html.interfaces.children.ListChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IIcon;

import static com.jwebmp.core.utilities.StaticStrings.*;

public class ProSidebarMenuList<C extends ListChildren, A extends Enum & AttributeDefinitions, E extends GlobalEvents, J extends List<C, A, E, J>>
		extends List<C, A, E, J>
{
	public ProSidebarMenuList()
	{
	//	addClass("prosidebar-menu-list");
	}

	public J addHeaderMenu(String headerMenuText)
	{
		return addHeaderMenu(headerMenuText, null);
	}

	@SuppressWarnings("unchecked")
	public J addHeaderMenu(String headerMenuText, IIcon<?> icon)
	{
		ListItem<?> li = new ListItem<>().addClass("header-menu");
		Span span = new Span();
		span.setText(headerMenuText);
		if (icon != null)
		{
			span.add(icon.getIconComponent());
			span.setRenderTextBeforeChildren(false);
			span.setText(HTML_TAB + headerMenuText);
		}
		li.add(span);
		add((C) li);
		return (J) this;
	}

	@SuppressWarnings("unchecked")
	public J addMenuDropdown(ProSidebarMenuDropdownItem<?> dropdown)
	{
		add((C) dropdown);
		return (J) this;
	}

	@SuppressWarnings("unchecked")
	public J addItem(ProSidebarMenuListItem<?> dropdown)
	{
		add((C) dropdown);
		return (J) this;
	}
}
