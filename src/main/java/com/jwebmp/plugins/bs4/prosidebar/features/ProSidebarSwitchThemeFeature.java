package com.jwebmp.plugins.bs4.prosidebar.features;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

public class ProSidebarSwitchThemeFeature<J extends ProSidebarSwitchThemeFeature<J>>
		extends Feature<GlobalFeatures<?, ?>, JavaScriptPart<?>, J>
{
	public ProSidebarSwitchThemeFeature(ComponentHierarchyBase component)
	{
		super("ProSidebarSwitchThemeFeature", component);

	}

	@Override
	protected void assignFunctionsToComponent()
	{
		addQuery(renderQuery());
	}

	private String renderQuery()
	{
		return "$('[data-sidebar-theme]').click(function () {" + getNewLine() +
		       "        $('[data-sidebar-theme]').removeClass('selected');" + getNewLine() +
		       "        $(this).addClass('selected');" + getNewLine() +
		       "        $('.page-wrapper').removeClass(sidebar_themes);" + getNewLine() +
		       "        $('.page-wrapper').addClass($(this).attr('data-sidebar-theme'));" + getNewLine() +
		       "    })" + getNewLine();
	}
}
