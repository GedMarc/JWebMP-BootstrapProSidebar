package com.jwebmp.plugins.bs4.prosidebar.parts.footer;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.attributes.GlobalAttributes;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.badge.BSBadge;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownLink;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownMenu;

import static com.jwebmp.plugins.bootstrap4.options.BSTypographyOptions.*;

public class ProSidebarFooter<J extends ProSidebarFooter<J>>
		extends DivSimple<J>
{
	private ProSidebarFooterPinnedBottom pinnedBottom;

	public ProSidebarFooter()
	{
		addClass("sidebar-footer");
	}

	public J addNotificationStyleButton(ProSidebarFooterNotificationsDropDown<?> dropDown)
	{
		add(dropDown);
		return (J) this;
	}

	public J addNotificationStyleButton(IIcon<?> buttonIcon, BSBadge<?> buttonBadge, IIcon<?> headerIcon, String headerText,
	                                    String viewAllText, Event<?, ?> viewAllEvent,
	                                    ProSidebarFooterCheckedItem... items)
	{
		ProSidebarFooterNotificationsDropDown<?> footerNotificationsDropDown = new ProSidebarFooterNotificationsDropDown<>();

		footerNotificationsDropDown.setIcon(buttonIcon);
		footerNotificationsDropDown.setBadge(buttonBadge);

		ProSidebarFooterNotificationsMenu<?> footerNotificationsMenu = footerNotificationsDropDown.addDropDownNotificationsMenu();
		if (headerIcon != null || headerText != null)
		{
			footerNotificationsMenu.addHeader(headerIcon, headerText);
		}
		footerNotificationsMenu.addDivider();

		for (ProSidebarFooterCheckedItem item : items)
		{
			footerNotificationsMenu.addItem(item);
		}
		footerNotificationsMenu.addDivider();

		BSDropDownLink<?> link = footerNotificationsMenu.addItem(viewAllText)
		                                                .addClass(Text_Center);
		if (viewAllEvent != null)
		{
			link.addEvent(viewAllEvent);
		}

		add(footerNotificationsDropDown);
		return (J) this;
	}


	public J addMessagesStyleButton(IIcon<?> buttonIcon, BSBadge<?> buttonBadge, IIcon<?> headerIcon, String headerText,
	                                String viewAllText, Event<?, ?> viewAllEvent,
	                                ProSidebarFooterLabelledItem... items)
	{

		ProSidebarFooterMessagesDropDown<?> footerMessagesDropDown = new ProSidebarFooterMessagesDropDown<>();

		footerMessagesDropDown.setIcon(buttonIcon);
		footerMessagesDropDown.setBadge(buttonBadge);

		ProSidebarFooterMessagesMenu<?> messagesMenu = footerMessagesDropDown.getMessagesMenu();
		if (headerIcon != null || headerText != null)
		{
			messagesMenu.addHeader(headerIcon, headerText);
		}
		messagesMenu.addDivider();

		for (ProSidebarFooterLabelledItem item : items)
		{
			messagesMenu.add(item);
		}

		messagesMenu.addDivider();

		BSDropDownLink<?> link = messagesMenu.addItem(viewAllText)
		                                     .addClass(Text_Center);
		if (viewAllEvent != null)
		{
			link.addEvent(viewAllEvent);
		}

		add(footerMessagesDropDown);
		return (J) this;
	}

	public J addDropDown(IIcon<?> buttonIcon, BSBadge<?> buttonBadge,
	                     BSDropDownMenu<?> dropDownMenu)
	{
		ProSidebarFooterMessagesDropDown<?> footerMessagesDropDown = new ProSidebarFooterMessagesDropDown<>();
		footerMessagesDropDown.setIcon(buttonIcon);
		footerMessagesDropDown.setBadge(buttonBadge);

		footerMessagesDropDown.getChildren()
		                      .remove(footerMessagesDropDown.getMessagesMenu());

		footerMessagesDropDown.add(dropDownMenu);

		dropDownMenu.addAttribute(GlobalAttributes.Aria_LabelledBy, "dropdownMenuMessage");

		add(footerMessagesDropDown);
		return (J) this;

	}

	public J addButton(IIcon<?> buttonIcon, BSBadge<?> buttonBadge, Event<?, ?>... event)
	{
		DivSimple<?> div = new DivSimple<>();
		Link<?> link = new Link<>("#");
		link.add(buttonIcon.getIconComponent());
		if (buttonBadge != null)
		{
			link.add(buttonBadge);
		}
		for (Event<?, ?> event1 : event)
		{
			link.addEvent(event1);
		}
		div.add(link);
		add(div);
		return (J) this;
	}

	@Override
	public void init()
	{
		if (!isInitialized())
		{
			if (pinnedBottom != null)
			{
				add(pinnedBottom);
			}
		}
		super.init();
	}

	/**
	 * Getter for property 'pinnedBottom'.
	 *
	 * @return Value for property 'pinnedBottom'.
	 */
	public ProSidebarFooterPinnedBottom getPinnedBottom()
	{
		return pinnedBottom;
	}

	/**
	 * Setter for property 'pinnedBottom'.
	 *
	 * @param pinnedBottom
	 * 		Value to set for property 'pinnedBottom'.
	 */
	public J setPinnedBottom(ProSidebarFooterPinnedBottom pinnedBottom)
	{
		this.pinnedBottom = pinnedBottom;
		return (J) this;
	}
}
