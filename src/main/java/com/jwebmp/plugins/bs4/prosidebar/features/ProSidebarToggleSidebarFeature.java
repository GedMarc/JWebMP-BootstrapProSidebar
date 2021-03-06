package com.jwebmp.plugins.bs4.prosidebar.features;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

public class ProSidebarToggleSidebarFeature<J extends ProSidebarToggleSidebarFeature<J>>
		extends Feature<GlobalFeatures, JavaScriptPart<?>, J>
{
	private IComponentHierarchyBase<?,?> pageWrapper;

	public ProSidebarToggleSidebarFeature(String componentId,IComponentHierarchyBase<?,?> component, IComponentHierarchyBase<?,?> pageWrapper)
	{
		super("ProSidebarToggleSidebarFeature", component);
		component.setID(componentId);
		this.pageWrapper = pageWrapper;
	}

	@Override
	protected void assignFunctionsToComponent()
	{
		addQuery(getComponent().asBase().getJQueryID() + renderQuery());
	}

	private String renderQuery()
	{
		return "click(function () {" + getNewLine() +
		       " $('" + pageWrapper.asBase().getID(true) + "').toggleClass('toggled');" + getNewLine() +
		       "});";
	}
}
