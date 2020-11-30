package com.jwebmp.plugins.bs4.prosidebar.parts;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.interfaces.IIcon;

public class ProSidebarBrand<J extends ProSidebarBrand<J>>
		extends DivSimple<J>
{
	private final Link<?> headerLink = new Link<>("#");

	public ProSidebarBrand()
	{
		addClass("sidebar-item sidebar-brand");
		add(headerLink);
	}

	/**
	 * Getter for property 'headerLink'.
	 *
	 * @return Value for property 'headerLink'.
	 */
	public Link<?> getHeaderLink()
	{
		return headerLink;
	}

	/**
	 * Sets the text for the header
	 *
	 * @param text
	 * 		Text
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setHeaderText(String text)
	{
		getHeaderLink().setText(text);
		return (J) this;
	}

	/**
	 * Adds an icon component to the header
	 *
	 * @param icon
	 * 		THe icon
	 * @param frontOrBack
	 * 		If it should be placed left or right
	 *
	 * @return Whatever should be returned
	 */
	@SuppressWarnings("unchecked")
	public J addIcon(IIcon<?,?> icon, boolean frontOrBack)
	{
		if (frontOrBack)
		{
			headerLink.add(0, icon.getIconComponent());
		}
		else
		{
			headerLink.add(icon.getIconComponent());
		}
		return (J) this;
	}

	/**
	 * Sets the link address for the underlink header link object
	 * @param address
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setHeaderLinkAddress(String address)
	{
		headerLink.setDirectToAddress(address);
		return (J) this;
	}


}
