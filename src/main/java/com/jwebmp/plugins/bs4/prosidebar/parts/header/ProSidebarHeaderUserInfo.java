package com.jwebmp.plugins.bs4.prosidebar.parts.header;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Span;
import com.jwebmp.core.base.interfaces.IIcon;

public class ProSidebarHeaderUserInfo<J extends ProSidebarHeaderUserInfo<J>>
		extends DivSimple<J>
{
	private final Span<?, ?, ?> userNameSpan = new Span<>();
	private final Span<?, ?, ?> userRoleSpan = new Span<>();

	private final ProSidebarHeaderUserStatus<?, ?, ?> status = new ProSidebarHeaderUserStatus<>();

	public ProSidebarHeaderUserInfo()
	{
		addClass("user-info");
		userNameSpan.addClass("user-name");
		userRoleSpan.addClass("user-role");
		add(userNameSpan);
		add(userRoleSpan);
		add(status);
	}

	@SuppressWarnings("unchecked")
	public J setUserName(String userName)
	{
		userNameSpan.setText(userName);
		return (J)this;
	}

	@SuppressWarnings("unchecked")
	public J setRole(String role)
	{
		userRoleSpan.setText(role);
		return (J)this;
	}

	@SuppressWarnings("unchecked")
	public J setUserStatus(IIcon<?> icon, String status, String colour)
	{
		this.status.addStatus(icon, status, colour);
		return (J)this;
	}

}
