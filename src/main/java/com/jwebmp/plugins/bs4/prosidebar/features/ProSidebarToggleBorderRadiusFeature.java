package com.jwebmp.plugins.bs4.prosidebar.features;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

public class ProSidebarToggleBorderRadiusFeature<J extends ProSidebarToggleBorderRadiusFeature<J>>
		extends Feature<GlobalFeatures<?, ?>, JavaScriptPart<?>, J>
{
	private ComponentHierarchyBase pageWrapper;

	public ProSidebarToggleBorderRadiusFeature(ComponentHierarchyBase component, ComponentHierarchyBase pageWrapper)
	{
		super("ProSidebarToggleBorderRadiusFeature", component);
		this.pageWrapper = pageWrapper;
	}

	@Override
	protected void assignFunctionsToComponent()
	{
		addQuery(getComponent().getJQueryID() + renderQuery());
	}

	private String renderQuery()
	{
		return "click(function () {" + getNewLine() +
		       " $('" + pageWrapper.getID(true) + "').toggleClass(\"boder-radius-on\");" + getNewLine() +
		       "});";
	}
}
