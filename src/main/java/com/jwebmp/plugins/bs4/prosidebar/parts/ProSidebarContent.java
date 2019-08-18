package com.jwebmp.plugins.bs4.prosidebar.parts;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.bs4.prosidebar.parts.header.ProSidebarHeader;
import com.jwebmp.plugins.bs4.prosidebar.parts.menu.ProSidebarMenu;
import com.jwebmp.plugins.bs4.prosidebar.parts.search.ProSidebarSearch;

public class ProSidebarContent<J extends ProSidebarContent<J>>
		extends DivSimple<J>
{

	public ProSidebarContent()
	{
		addClass("sidebar-content");
		addStyle("overflow-y", "auto");
	}

	@SuppressWarnings("unchecked")
	public J addBrand(ProSidebarBrand<?> brand)
	{
		add(brand);

		return (J) this;
	}

	@SuppressWarnings("unchecked")
	public J addHeader(ProSidebarHeader<?> header)
	{
		add(header);
		return (J) this;
	}

	@SuppressWarnings("unchecked")
	public J addSearch(ProSidebarSearch<?> search)
	{
		add(search);
		return (J) this;
	}

	@SuppressWarnings("unchecked")
	public J addMenu(ProSidebarMenu<?> menu)
	{
		add(menu);
		return (J) this;
	}
}
