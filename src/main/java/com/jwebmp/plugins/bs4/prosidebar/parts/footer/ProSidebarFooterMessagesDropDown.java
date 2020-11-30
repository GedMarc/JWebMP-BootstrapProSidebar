package com.jwebmp.plugins.bs4.prosidebar.parts.footer;

import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.badge.BSBadge;
import com.jwebmp.plugins.bootstrap4.dropdown.BSDropDown;

import static com.jwebmp.core.base.html.attributes.GlobalAttributes.*;
import static com.jwebmp.core.base.html.attributes.LinkAttributes.*;

public class ProSidebarFooterMessagesDropDown<J extends ProSidebarFooterMessagesDropDown<J>>
		extends BSDropDown<J>
{
	private IIcon<?,?> icon;
	private Link<?> dropDownLink = new Link<>("#");
	private BSBadge<?> badge;

	private ProSidebarFooterMessagesMenu<?> messagesMenu;

	public ProSidebarFooterMessagesDropDown()
	{
		dropDownLink.addAttribute(Data_Toggle, "dropdown");
		dropDownLink.addAttribute(Aria_HasPopup, "true");
		dropDownLink.addAttribute(Aria_Expanded, "false");
		add(dropDownLink);

		messagesMenu = new ProSidebarFooterMessagesMenu<>();
		add(messagesMenu);
	}

	@Override
	public void init()
	{
		if (!isInitialized())
		{
			if (icon != null)
			{
				dropDownLink.add((IComponentHierarchyBase) icon);
			}
			if (badge != null)
			{
				dropDownLink.add(badge);
			}
		}
		super.init();
	}



	/**
	 * Getter for property 'icon'.
	 *
	 * @return Value for property 'icon'.
	 */
	public IIcon<?,?> getIcon()
	{
		return icon;
	}

	/**
	 * Setter for property 'icon'.
	 *
	 * @param icon
	 * 		Value to set for property 'icon'.
	 */
	@SuppressWarnings("unchecked")
	public J setIcon(IIcon<?,?> icon)
	{
		this.icon = icon;
		return (J) this;
	}

	/**
	 * Getter for property 'dropDownLink'.
	 *
	 * @return Value for property 'dropDownLink'.
	 */
	public Link<?> getDropDownLink()
	{
		return dropDownLink;
	}

	/**
	 * Setter for property 'dropDownLink'.
	 *
	 * @param dropDownLink
	 * 		Value to set for property 'dropDownLink'.
	 */
	@SuppressWarnings("unchecked")
	public J setDropDownLink(Link<?> dropDownLink)
	{
		this.dropDownLink = dropDownLink;
		return (J) this;
	}

	/**
	 * Getter for property 'badge'.
	 *
	 * @return Value for property 'badge'.
	 */
	public BSBadge<?> getBadge()
	{
		return badge;
	}

	/**
	 * Setter for property 'badge'.
	 *
	 * @param badge
	 * 		Value to set for property 'badge'.
	 */
	@SuppressWarnings("unchecked")
	public J setBadge(BSBadge<?> badge)
	{
		this.badge = badge;
		if (badge != null)
		{
			badge.addClass("notification");
		}
		return (J) this;
	}

	/**
	 * Getter for property 'messagesMenu'.
	 *
	 * @return Value for property 'messagesMenu'.
	 */
	public ProSidebarFooterMessagesMenu<?> getMessagesMenu()
	{
		return messagesMenu;
	}

	/**
	 * Setter for property 'messagesMenu'.
	 *
	 * @param messagesMenu Value to set for property 'messagesMenu'.
	 */
	public ProSidebarFooterMessagesDropDown<J> setMessagesMenu(ProSidebarFooterMessagesMenu<?> messagesMenu)
	{
		this.messagesMenu = messagesMenu;
		return this;
	}
}
