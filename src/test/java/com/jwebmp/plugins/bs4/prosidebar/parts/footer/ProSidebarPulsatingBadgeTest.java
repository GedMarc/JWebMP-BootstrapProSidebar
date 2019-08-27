package com.jwebmp.plugins.bs4.prosidebar.parts.footer;

import com.jwebmp.core.htmlbuilder.css.colours.ColourHex;
import com.jwebmp.plugins.bs4.prosidebar.ProSidebarPulsatingBadge;
import org.junit.jupiter.api.Test;

class ProSidebarPulsatingBadgeTest
{

	@Test
	void testSetColor()
	{
		ProSidebarPulsatingBadge tt = new ProSidebarPulsatingBadge();
		tt.setColor("blue");
		tt.setBorderColor("blue");

		System.out.println(tt.toString(0));
	}
}