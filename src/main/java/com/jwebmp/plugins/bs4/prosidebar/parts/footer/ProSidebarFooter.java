package com.jwebmp.plugins.bs4.prosidebar.parts.footer;

import com.jwebmp.core.base.html.DivSimple;

public class ProSidebarFooter<J extends ProSidebarFooter<J>>
		extends DivSimple<J>
{
	public ProSidebarFooter()
	{
		addClass("sidebar-footer");
	}

	public J addDropDown(ProSidebarFooterNotificationsDropDown<?> dropDown)
	{
		add(dropDown);
		return (J)this;
	}
}
