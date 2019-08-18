package com.jwebmp.plugins.bs4.prosidebar.parts;

import com.jwebmp.plugins.bs4.prosidebar.parts.header.ProSidebarHeaderUserStatus;
import com.jwebmp.plugins.fontawesome5.FontAwesome;
import com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons;
import org.junit.jupiter.api.Test;

import static com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles.*;

class ProSidebarHeaderUserStatusTest
{

	@Test
	void addStatus()
	{
		ProSidebarHeaderUserStatus status = new ProSidebarHeaderUserStatus();
		status.asMe()
		      .addStatus(new FontAwesome<>(Duotone, FontAwesomeIcons.circle),"Online",null);
		System.out.println(status.toString(0));
	}

}