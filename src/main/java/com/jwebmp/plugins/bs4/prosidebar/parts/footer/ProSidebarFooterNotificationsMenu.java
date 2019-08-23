package com.jwebmp.plugins.bs4.prosidebar.parts.footer;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownMenu;

import static com.jwebmp.core.base.html.attributes.GlobalAttributes.*;
import static com.jwebmp.core.utilities.StaticStrings.*;

public class ProSidebarFooterNotificationsMenu<J extends ProSidebarFooterNotificationsMenu<J>>
		extends BSDropDownMenu<J>
{
	public ProSidebarFooterNotificationsMenu()
	{
		addClass("notifications");
		addAttribute(Aria_LabelledBy, "dropdownMenuMessage");
	}


	@SuppressWarnings("unchecked")
	public J addHeader(IIcon<?> icon, String text)
	{
		DivSimple<?> div = new DivSimple<>();
		div.addClass("notifications-header");
		add(div);

		if (icon != null)
		{
			div.add(icon.getIconComponent());
		}
		div.setText(HTML_TAB + (text == null ? "" : text));
		div.setRenderTextBeforeChildren(false);
		return (J) this;
	}

	public J addItem(String notificationDetail, String timeAgo, IIcon<?> checkIcon, Event<?, ?>... events)
	{
		ProSidebarFooterCheckedItem<?> item = new ProSidebarFooterCheckedItem<>(notificationDetail, timeAgo, checkIcon);
		for (Event<?, ?> event : events)
		{
			item.addEvent(event);
		}
		add(item);
		return (J) this;
	}

	public J addItem(ProSidebarFooterCheckedItem<?> item)
	{
		add(item);
		return (J) this;
	}

}
