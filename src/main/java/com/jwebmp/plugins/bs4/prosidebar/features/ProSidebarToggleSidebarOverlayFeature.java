package com.jwebmp.plugins.bs4.prosidebar.features;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

public class ProSidebarToggleSidebarOverlayFeature<J extends ProSidebarToggleSidebarOverlayFeature<J>>
		extends Feature<GlobalFeatures<?, ?>, JavaScriptPart<?>, J>
{

	public ProSidebarToggleSidebarOverlayFeature(ComponentHierarchyBase component)
	{
		super("ProSidebarToggleSidebarOverlayFeature", component);
	}

	@Override
	protected void assignFunctionsToComponent()
	{
		addQuery(getComponent().getJQueryID() + renderQuery());
	}

	private String renderQuery()
	{
		return "click(function () {" + getNewLine() +
		       " $('.page-wrapper')" +
		       ".toggleClass('toggled');" + getNewLine() +
		       "});" + getNewLine();
	}
}
