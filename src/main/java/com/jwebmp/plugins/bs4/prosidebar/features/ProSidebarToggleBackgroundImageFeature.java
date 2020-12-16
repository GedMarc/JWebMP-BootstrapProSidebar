package com.jwebmp.plugins.bs4.prosidebar.features;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

public class ProSidebarToggleBackgroundImageFeature<J extends ProSidebarToggleBackgroundImageFeature<J>>
		extends Feature<GlobalFeatures, JavaScriptPart<?>, J>
{
	private IComponentHierarchyBase<?,?> pageWrapper;

	public ProSidebarToggleBackgroundImageFeature(IComponentHierarchyBase<?,?> component, IComponentHierarchyBase<?,?> pageWrapper)
	{
		super("ProSidebarToggleSidebarFeature", component);
		this.pageWrapper = pageWrapper;
	}

	@Override
	protected void assignFunctionsToComponent()
	{
		addQuery(getComponent().asBase().getJQueryID() + renderQuery());
	}

	private String renderQuery()
	{
		return "click(function (e) {" + getNewLine() +
		       "e.preventDefault();" + getNewLine() +
		       "$('" + pageWrapper.asBase().getID(true) + "').toggleClass('sidebar-bg');" + getNewLine() +
		       "});";
	}
}
