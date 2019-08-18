package com.jwebmp.plugins.bs4.prosidebar.parts.header;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.bootstrap4.images.BSImage;

public class ProSidebarHeaderUserPic<J extends ProSidebarHeaderUserPic<J>>
		extends DivSimple<J>
{
	private BSImage<?> userImage;

	public ProSidebarHeaderUserPic()
	{
		addClass("user-pic");
	}

	public BSImage<?> getUserImage()
	{
		if (userImage == null)
		{
			userImage = new BSImage<>();
			add(userImage);
		}
		return userImage;
	}

	public ProSidebarHeaderUserPic<J> setUserImage(BSImage<?> userImage)
	{
		this.userImage = userImage;
		if (userImage != null)
		{
			add(userImage);
		}
		return this;
	}
}
