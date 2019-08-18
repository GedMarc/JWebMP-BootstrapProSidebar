package com.jwebmp.plugins.bs4.prosidebar.features;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

public class ProSidebarSwitchThemeFeature<J extends ProSidebarSwitchThemeFeature<J>>
		extends Feature<GlobalFeatures<?, ?>, JavaScriptPart<?>, J>
{
	private ComponentHierarchyBase pageWrapper;

	private String themeClass;

	public ProSidebarSwitchThemeFeature(ComponentHierarchyBase component, ComponentHierarchyBase pageWrapper, String initialThemeClass)
	{
		super("ProSidebarSwitchThemeFeature", component);
		this.pageWrapper = pageWrapper;
		this.themeClass = initialThemeClass;
		getComponent().addAttribute("data-theme", initialThemeClass);
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
	public ProSidebarSwitchThemeFeature<J> setPageWrapper(ComponentHierarchyBase pageWrapper)
	{
		this.pageWrapper = pageWrapper;
		return this;
	}

	/**
	 * Getter for property 'backgroundImageClass'.
	 *
	 * @return Value for property 'backgroundImageClass'.
	 */
	public String getThemeClass()
	{
		return themeClass;
	}

	/**
	 * Setter for property 'backgroundImageClass'.
	 *
	 * @param themeClass
	 * 		Value to set for property 'backgroundImageClass'.
	 */
	public ProSidebarSwitchThemeFeature<J> setThemeClass(String themeClass)
	{
		this.themeClass = themeClass;
		getComponent().addAttribute("data-theme", themeClass);
		return this;
	}

	@Override
	protected void assignFunctionsToComponent()
	{
		addQuery(getComponent().getJQueryID() + renderQuery());
	}

	private String renderQuery()
	{
		return getComponent().getJQueryID() + "click(function () {" + getNewLine() +
		       "        $('[data-theme]').removeClass(\"selected\");" + getNewLine() +
		       "        $(this).addClass(\"selected\");" + getNewLine() +
		       "        $('#" + pageWrapper.getID() + "').removeClass(bgs);" + getNewLine() +
		       "        $('#" + pageWrapper.getID() + "').addClass($(this).attr('data-theme'));" + getNewLine() +
		       "    })";
	}
}
