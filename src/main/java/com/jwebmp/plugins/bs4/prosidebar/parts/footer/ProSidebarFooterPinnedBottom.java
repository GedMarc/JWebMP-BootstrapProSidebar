package com.jwebmp.plugins.bs4.prosidebar.parts.footer;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.interfaces.IIcon;

public class ProSidebarFooterPinnedBottom<J extends ProSidebarFooterPinnedBottom<J>>
		extends DivSimple<J>
{
	private IIcon<?,?> icon;
	private Link<?> link = new Link<>("#");

	public ProSidebarFooterPinnedBottom()
	{
		addClass("pinned-footer");
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
	public ProSidebarFooterPinnedBottom<J> setIcon(IIcon<?,?> icon)
	{
		this.icon = icon;
		return this;
	}

	@Override
	public void init()
	{
		if (!isInitialized())
		{
			if (icon != null)
			{
				link.add(icon.getIconComponent());
				add(link);
			}
		}
		super.init();
	}
}
