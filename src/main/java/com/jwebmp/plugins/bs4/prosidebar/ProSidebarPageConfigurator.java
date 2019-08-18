package com.jwebmp.plugins.bs4.prosidebar;

import com.jwebmp.core.Page;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.core.services.IPageConfigurator;

import javax.validation.constraints.NotNull;

public class ProSidebarPageConfigurator implements IPageConfigurator<ProSidebarPageConfigurator>
{
	private static boolean enabled = true;

	@Override
	public @NotNull Page<?> configure(Page<?> page)
	{
		JQueryPageConfigurator.setRequired(true);
		page.addCssReference(ProSidebarReferences.ProSidebarReferenceReference.getCssReference());
		page.addCssReference(ProSidebarReferences.ProSidebarDefaultThemesReference.getCssReference());
		return page;
	}

	@Override
	public boolean enabled()
	{
		return enabled;
	}

	public static boolean isEnabled()
	{
		return enabled;
	}

	public static void setEnabled(boolean enabled)
	{
		ProSidebarPageConfigurator.enabled = enabled;
	}
}
