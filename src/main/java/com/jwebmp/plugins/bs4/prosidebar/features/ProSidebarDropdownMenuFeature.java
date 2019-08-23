package com.jwebmp.plugins.bs4.prosidebar.features;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

public class ProSidebarDropdownMenuFeature<J extends ProSidebarDropdownMenuFeature<J>>
		extends Feature<GlobalFeatures<?, ?>, JavaScriptPart<?>, J>
{

	private int slideUpRate = 200;
	private int slideDownRate = 200;

	public ProSidebarDropdownMenuFeature(ComponentHierarchyBase component)
	{
		super("ProSidebarDropdownMenuFeature", component);
	}

	@Override
	protected void assignFunctionsToComponent()
	{
		addQuery("$(\".sidebar-dropdown > a\")." + renderQuery(slideUpRate, slideDownRate));
	}

	private String renderQuery(Integer slideUpRate, Integer slideDownRate)
	{
		return "click(function () {" + getNewLine() +
		       "    $(\".sidebar-submenu\").slideUp(" + slideUpRate + ");" + getNewLine() +
		       "        if ($(this).parent().hasClass(\"active\")) {" + getNewLine() +
		       "            $(\".sidebar-dropdown\").removeClass(\"active\");" + getNewLine() +
		       "            $(this).parent().removeClass(\"active\");" + getNewLine() +
		       "        } else {" + getNewLine() +
		       "            $(\".sidebar-dropdown\").removeClass(\"active\");" + getNewLine() +
		       "            $(this).next(\".sidebar-submenu\").slideDown(" + slideDownRate + ");" + getNewLine() +
		       "            $(this).parent().addClass(\"active\");" + getNewLine() +
		       "        }" + getNewLine() +
		       "});" + getNewLine();
	}

	/**
	 * Getter for property 'slideUpRate'.
	 *
	 * @return Value for property 'slideUpRate'.
	 */
	public int getSlideUpRate()
	{
		return slideUpRate;
	}

	/**
	 * Setter for property 'slideUpRate'.
	 *
	 * @param slideUpRate
	 * 		Value to set for property 'slideUpRate'.
	 */
	public ProSidebarDropdownMenuFeature<J> setSlideUpRate(int slideUpRate)
	{
		this.slideUpRate = slideUpRate;
		return this;
	}

	/**
	 * Getter for property 'slideDownRate'.
	 *
	 * @return Value for property 'slideDownRate'.
	 */
	public int getSlideDownRate()
	{
		return slideDownRate;
	}

	/**
	 * Setter for property 'slideDownRate'.
	 *
	 * @param slideDownRate
	 * 		Value to set for property 'slideDownRate'.
	 */
	public ProSidebarDropdownMenuFeature<J> setSlideDownRate(int slideDownRate)
	{
		this.slideDownRate = slideDownRate;
		return this;
	}
}
