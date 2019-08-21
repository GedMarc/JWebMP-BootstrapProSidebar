package com.jwebmp.plugins.bs4.prosidebar.parts.footer;

import com.jwebmp.plugins.bootstrap4.badge.styles.BSBadgeWarning;
import com.jwebmp.plugins.fontawesome5.FontAwesome;
import org.junit.jupiter.api.Test;

import static com.jwebmp.plugins.bootstrap4.options.BSBorderOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSColoursOptions.*;
import static com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons.*;
import static com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles.*;

class ProSidebarFooterTest
{

	@Test
	void testAddDropDown()
	{
		ProSidebarFooterNotificationsDropDown<?> footer = new ProSidebarFooterNotificationsDropDown<>();

		footer.setIcon(FontAwesome.icon(circle, Solid));
		footer.setBadge(new BSBadgeWarning<>(true).setText("3"));

		ProSidebarFooterNotificationsMenu<?> menu = footer.addDropDownNotificationsMenu();

		menu.addHeader(FontAwesome.icon(bell, Solid), "Notifications");
		menu.addDivider();
		menu.addCheckedItem("Lorem ipsum dolor sit amet consectetur adipisicing elit. In totam explicabo",
		                    "6 minutes ago",
		                    FontAwesome.icon(check, Solid)
		                               .addClass(Text_Success)
		                               .addClass("border")
		                               .addClass(Border_Success)
		                   );

		System.out.println(footer.toString(true));
	}
}