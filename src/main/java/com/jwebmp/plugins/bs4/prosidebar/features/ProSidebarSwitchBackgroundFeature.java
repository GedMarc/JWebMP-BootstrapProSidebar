package com.jwebmp.plugins.bs4.prosidebar.features;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

public class ProSidebarSwitchBackgroundFeature<J extends ProSidebarSwitchBackgroundFeature<J>>
		extends Feature<GlobalFeatures, JavaScriptPart<?>, J>
{
	private String backgroundImageClass;

	public ProSidebarSwitchBackgroundFeature(IComponentHierarchyBase<?,?> component, String initialBackgroundImage)
	{
		super("ProSidebarSwitchBackgroundFeature", component);
		this.backgroundImageClass = initialBackgroundImage;
	}

	/**
	 * Getter for property 'backgroundImageClass'.
	 *
	 * @return Value for property 'backgroundImageClass'.
	 */
	public String getBackgroundImageClass()
	{
		return backgroundImageClass;
	}

	/**
	 * Setter for property 'backgroundImageClass'.
	 *
	 * @param backgroundImageClass
	 * 		Value to set for property 'backgroundImageClass'.
	 */
	public ProSidebarSwitchBackgroundFeature<J> setBackgroundImageClass(String backgroundImageClass)
	{
		this.backgroundImageClass = backgroundImageClass;
		getComponent().asAttributeBase().addAttribute("prosidebar-data-bg", backgroundImageClass);
		return this;
	}

	@Override
	protected void assignFunctionsToComponent()
	{
		addQuery(renderQuery());
	}

	private String renderQuery()
	{
		return "$('[data-sidebar-bg]').click(function () {" + getNewLine() +
		       "        $('[data-sidebar-bg]').removeClass('selected');" + getNewLine() +
		       "        $(this).addClass('selected');" + getNewLine() +
		       "        $('#pageWrapper').removeClass(bgs);" + getNewLine() +
		       "        $('#pageWrapper').addClass($(this).attr('data-sidebar-bg'));" + getNewLine() +
		       "    });" + getNewLine();
	}
}
