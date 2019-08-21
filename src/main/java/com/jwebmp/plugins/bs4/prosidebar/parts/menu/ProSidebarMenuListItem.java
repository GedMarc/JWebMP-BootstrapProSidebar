package com.jwebmp.plugins.bs4.prosidebar.parts.menu;

import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.ListItem;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.badge.BSBadge;

public class ProSidebarMenuListItem<J extends ProSidebarMenuListItem<J>>
		extends ListItem<J>
{
	private final Link<?> link = new Link<>("#");

	private IIcon<?> icon;
	private String text;
	private BSBadge<?> badge;

	public ProSidebarMenuListItem()
	{
		add(link);
	}

	@Override
	public void init()
	{
		if (!isInitialized())
		{
			if (icon != null)
			{
				link.add((IComponentHierarchyBase) icon);
			}
			if (text != null)
			{
				Span menuText = new Span(text);
				menuText.addClass("menu-text");
				link.add(menuText);
			}
			if (badge != null)
			{
				link.add(badge);
			}
		}
		super.init();
	}

	/**
	 * Getter for property 'link'.
	 *
	 * @return Value for property 'link'.
	 */
	public Link<?> getLink()
	{
		return link;
	}

	/**
	 * Getter for property 'icon'.
	 *
	 * @return Value for property 'icon'.
	 */
	public IIcon<?> getIcon()
	{
		return icon;
	}

	/**
	 * Setter for property 'icon'.
	 *
	 * @param icon
	 * 		Value to set for property 'icon'.
	 */
	public J setIcon(IIcon<?> icon)
	{
		this.icon = icon;
		return (J) this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText()
	{
		return text;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public J setText(String text)
	{
		this.text = text;
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
	public J setBadge(BSBadge<?> badge)
	{
		this.badge = badge;
		return (J) this;
	}
}
