package com.jwebmp.plugins.bs4.prosidebar.parts.footer;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Image;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownMenu;

import static com.jwebmp.core.base.html.attributes.GlobalAttributes.*;
import static com.jwebmp.core.utilities.StaticStrings.*;

public class ProSidebarFooterMessagesMenu<J extends ProSidebarFooterMessagesMenu<J>>
		extends BSDropDownMenu<J>
{
	public ProSidebarFooterMessagesMenu()
	{
		addClass("messages");
		addAttribute(Aria_LabelledBy, "dropdownMenuMessage");
	}

	@SuppressWarnings("unchecked")
	public J addHeader(IIcon<?,?> icon, String text)
	{
		DivSimple<?> div = new DivSimple<>();
		div.addClass("messages-header");
		add(div);

		div.add(icon.getIconComponent());
		div.setText(HTML_TAB + text);
		div.setRenderTextBeforeChildren(false);
		return (J) this;
	}

	public J addMessageItem(String title, String notificationDetail, Image<?> checkIcon, Event<?, ?>... events)
	{
		ProSidebarFooterLabelledItem<?> item = new ProSidebarFooterLabelledItem<>(notificationDetail, title, checkIcon);
		for (Event<?, ?> event : events)
		{
			item.addEvent(event);
		}
		add(item);
		return (J) this;
	}

	public J addItem(ProSidebarFooterLabelledItem<?> item)
	{
		add(item);
		return (J) this;
	}

}
