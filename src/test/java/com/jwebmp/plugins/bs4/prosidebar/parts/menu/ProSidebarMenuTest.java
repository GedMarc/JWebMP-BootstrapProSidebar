package com.jwebmp.plugins.bs4.prosidebar.parts.menu;

import com.jwebmp.plugins.bootstrap4.badge.styles.BSBadgeSuccess;
import com.jwebmp.plugins.bootstrap4.badge.styles.BSBadgeWarning;
import com.jwebmp.plugins.fontawesome5.FontAwesome;
import org.junit.jupiter.api.Test;

import static com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons.*;
import static com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles.*;

class ProSidebarMenuTest
{
	@Test
	void testThisOut()
	{
		ProSidebarMenu<?> menu = new ProSidebarMenu();
		menu.getList()
		    .addHeaderMenu("General", null);

		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdownItem<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdownItem.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", null, null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		System.out.println(menu.toString(0));
	}

}