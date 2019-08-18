package com.jwebmp.plugins.bs4.prosidebar.features;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

public class ProSidebarSwitchBackgroundFeature<J extends ProSidebarSwitchBackgroundFeature<J>>
		extends Feature<GlobalFeatures<?, ?>, JavaScriptPart<?>, J>
{
	private ComponentHierarchyBase pageWrapper;

	private String backgroundImageClass;

	public ProSidebarSwitchBackgroundFeature(ComponentHierarchyBase component, ComponentHierarchyBase pageWrapper, String initialBackgroundImage)
	{
		super("ProSidebarSwitchBackgroundFeature", component);
		this.pageWrapper = pageWrapper;
		this.backgroundImageClass = initialBackgroundImage;
		getComponent().addAttribute("prosidebar-data-bg", initialBackgroundImage);
	}

	/**
	 * Getter for property 'pageWrapper'.
	 *
	 * @return Value for property 'pageWrapper'.
	 */
	public ComponentHierarchyBase getPageWrapper()
	{
		return pageWrapper;
	}

	/**
	 * Setter for property 'pageWrapper'.
	 *
	 * @param pageWrapper
	 * 		Value to set for property 'pageWrapper'.
	 */
	public ProSidebarSwitchBackgroundFeature<J> setPageWrapper(ComponentHierarchyBase pageWrapper)
	{
		this.pageWrapper = pageWrapper;
		return this;
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
		getComponent().addAttribute("prosidebar-data-bg", backgroundImageClass);
		return this;
	}

	@Override
	protected void assignFunctionsToComponent()
	{
		addQuery(getComponent().getJQueryID() + renderQuery());
	}

	private String renderQuery()
	{
		return "$('#" + getComponent().getID() + "[prosidebar-data-bg]').click(function () {" + getNewLine() +
		       "        $('[prosidebar-data-bg]').removeClass(\"selected\");" + getNewLine() +
		       "        $(this).addClass(\"selected\");" + getNewLine() +
		       "        $('#" + pageWrapper.getID() + "').removeClass(bgs);" + getNewLine() +
		       "        $('#" + pageWrapper.getID() + "').addClass($(this).attr('prosidebar-data-bg'));" + getNewLine() +
		       "    })";
	}
}
