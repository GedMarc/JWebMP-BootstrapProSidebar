package com.jwebmp.plugins.bs4.prosidebar;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;

import javax.validation.constraints.NotNull;

public class ProSidebarLayout<J extends ProSidebarLayout<J>>
		extends DivSimple<J>
{
	private ProSidebar<?> sidebar;
	private ProSidebarMainContent<?> mainContent;

	public ProSidebarLayout()
	{
		addClass("page-wrapper");
		setID("pageWrapper");
		sidebar = new ProSidebar<>(this);
		mainContent = new ProSidebarMainContent<>();
		super.add(sidebar);
		super.add(mainContent);
	}

	public ProSidebarLayout(ProSidebar<?> sidebar, ProSidebarMainContent<?> mainContent)
	{
		addClass("page-wrapper");
		setID("pageWrapper");
		this.sidebar = sidebar;
		super.add(sidebar);
		this.mainContent = mainContent;
		super.add(mainContent);
	}

	public ProSidebar<?> getSidebar()
	{
		return sidebar;
	}

	public J setSidebar(ProSidebar<?> sidebar)
	{
		this.sidebar = sidebar;
		return (J) this;
	}

	public ProSidebarMainContent<?> getMainContent()
	{
		return mainContent;
	}

	public J setMainContent(ProSidebarMainContent<?> mainContent)
	{
		this.mainContent = mainContent;
		return (J) this;
	}

	@Override
	public @NotNull J add(@NotNull Integer position, @NotNull IComponentHierarchyBase newChild)
	{
		mainContent.getContainer()
		           .add(position, newChild);
		return (J) this;
	}

	@Override
	public @NotNull J add(@NotNull IComponentHierarchyBase newChild)
	{
		mainContent.getContainer()
		           .add(newChild);
		return (J) this;
	}
}
