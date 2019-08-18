package com.jwebmp.plugins.bs4.prosidebar.parts.header;

import com.jwebmp.core.base.html.DivSimple;

public class ProSidebarHeader<J extends ProSidebarHeader<J>>
		extends DivSimple<J>
{
	private ProSidebarHeaderUserPic<?> userPic;
	private ProSidebarHeaderUserInfo<?> userInfo;

	public ProSidebarHeader()
	{
		addClass("sidebar-item sidebar-header d-flex flex-nowrap");
	}

	/**
	 * Getter for property 'userPic'.
	 *
	 * @return Value for property 'userPic'.
	 */
	public ProSidebarHeaderUserPic<?> getUserPic()
	{
		if (userPic == null)
		{
			userPic = new ProSidebarHeaderUserPic<>();
			add(userPic);
		}
		return userPic;
	}

	/**
	 * Setter for property 'userPic'.
	 *
	 * @param userPic
	 * 		Value to set for property 'userPic'.
	 */
	public ProSidebarHeader<J> setUserPic(ProSidebarHeaderUserPic<?> userPic)
	{
		this.userPic = userPic;
		if (userPic != null)
		{
			add(userPic);
		}
		return this;
	}

	/**
	 * Getter for property 'userInfo'.
	 *
	 * @return Value for property 'userInfo'.
	 */
	public ProSidebarHeaderUserInfo<?> getUserInfo()
	{
		if (userInfo == null)
		{
			userInfo = new ProSidebarHeaderUserInfo<>();
			add(userInfo);
		}
		return userInfo;
	}

	/**
	 * Setter for property 'userInfo'.
	 *
	 * @param userInfo
	 * 		Value to set for property 'userInfo'.
	 */
	public ProSidebarHeader<J> setUserInfo(ProSidebarHeaderUserInfo<?> userInfo)
	{
		this.userInfo = userInfo;
		if (userInfo != null)
		{
			add(userInfo);
		}
		return this;
	}
}
