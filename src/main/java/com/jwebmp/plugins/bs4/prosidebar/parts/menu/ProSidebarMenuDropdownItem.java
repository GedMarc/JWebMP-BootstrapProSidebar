package com.jwebmp.plugins.bs4.prosidebar.parts.menu;

import com.jwebmp.core.Event;
import com.jwebmp.core.base.html.*;
import com.jwebmp.core.base.html.interfaces.children.ListChildren;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.badge.BSBadge;

public class ProSidebarMenuDropdownItem<J extends ProSidebarMenuDropdownItem<J>>
		extends ListItem<J>
{
	private final Link<?> link = new Link<>("#");

	private IIcon<?,?> icon;
	private String text;
	private BSBadge<?> badge;

	public ProSidebarMenuDropdownItem()
	{
		addClass("sidebar-dropdown");
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
	public J setIcon(IIcon<?,?> icon)
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

	public J addSubmenu(ProSidebarMenuSubMenu<?> subMenu)
	{
		add(subMenu);
		return (J)this;
	}

	public static class ProSidebarMenuSubMenu<J extends ProSidebarMenuSubMenu<J>>
			extends DivSimple<J>
	{
		private final List<ListChildren, ?, ?, ?> list = new List<>();

		public ProSidebarMenuSubMenu()
		{
			addClass("sidebar-submenu");
			add(list);
		}

		public J addSubItem(String label, BSBadge<?> badge, IIcon<?,?> icon, Event<?, ?> clickEvent)
		{
			ListItem<?> li = new ListItem<>();
			Link<?> link = new Link<>("#").setText(label)
			                              .setRenderTextBeforeChildren(true);
			if (badge != null)
			{
				link.add(badge);
			}
			li.add(link);
			if (clickEvent != null)
			{
				link.addEvent(clickEvent);
			}

			list.add(li);

			return (J) this;
		}
	}
}
