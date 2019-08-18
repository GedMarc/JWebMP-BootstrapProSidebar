package com.jwebmp.plugins.bs4.prosidebar.parts.tests;

import com.jwebmp.plugins.bootstrap4.images.BSImage;
import com.jwebmp.plugins.bs4.prosidebar.parts.header.ProSidebarHeader;
import com.jwebmp.plugins.fontawesome5.FontAwesome;
import com.jwebmp.plugins.fontawesome5.config.FontAwesome5PageConfigurator;
import org.junit.jupiter.api.Test;

import static com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons.*;
import static com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles.*;

class ProSidebarHeaderTest
{
	@Test
	void testMe()
	{
		FontAwesome5PageConfigurator.setIncludeAll(true);
		ProSidebarHeader<?> header = new ProSidebarHeader<>();
		header.getUserPic()
		      .setUserImage(new BSImage<>("img/user.jpg").setResponsive(true)
		                                                 .setRounded(true)
		                                                 .addAttribute("alt", "User Image")
		                   );

		header.getUserInfo().setUserName("John <strong>Smith</strong>");
		header.getUserInfo().setRole("Administrator")

		;
		header.getUserInfo().setUserStatus(new FontAwesome<>(Solid, circle), "Online", null);

		System.out.println(header.toString(0));
	}
}