package com.jwebmp.plugins.bs4.prosidebar;

import com.jwebmp.plugins.bootstrap4.badge.BSBadge;
import com.jwebmp.plugins.bootstrap4.badge.BSBadgeOptions;

public class ProSidebarPulsatingBadge<J extends ProSidebarPulsatingBadge<J>>
		extends BSBadge<J>
{

	public ProSidebarPulsatingBadge()
	{
		super(false);
		setup();
	}

	protected void setup()
	{
		setTag("span");
		getClasses().clear();
		addClass("badge-sonar");
		setText((String) null);
	}

	public J setColor(String colour)
	{
		addStyle("background-color", colour);
		return (J) this;
	}

	public J setBorderColor(String colour)
	{
		addStyle("border-color", colour);
		return (J) this;
	}
}
