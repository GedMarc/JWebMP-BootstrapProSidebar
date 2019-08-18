package com.jwebmp.plugins.bs4.prosidebar.parts.menu;

import com.jwebmp.core.base.html.DivSimple;

public class ProSidebarMenu<J extends ProSidebarMenu<J>>
		extends DivSimple<J>
{
	private final ProSidebarMenuList<?,?,?,?> list = new ProSidebarMenuList();

	public ProSidebarMenu()
	{
		addClass("sidebar-item sidebar-menu");
		add(list);
	}

	public ProSidebarMenuList<?,?,?,?> getList()
	{
		return list;
	}
}
