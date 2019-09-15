package com.jwebmp.plugins.bs4.prosidebar.features;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.bs4.prosidebar.ProSidebar;

public class ProSidebarPinFeature<J extends ProSidebarPinFeature<J>>
		extends Feature<GlobalFeatures<?, ?>, JavaScriptPart<?>, J>
{
	private ProSidebar sidebar;

	public ProSidebarPinFeature(String componentId, ComponentHierarchyBase component, ProSidebar sidebar)
	{
		super("ProSidebarPinFeature", component);
		component.setID(componentId);
		this.sidebar = sidebar;
	}

	@Override
	protected void assignFunctionsToComponent()
	{
		addQuery(getComponent().getJQueryID() + renderQuery());
	}

	private String renderQuery()
	{
		return "click(function () {" + getNewLine() +
		       "        if ($('#pageWrapper').hasClass('pinned')) {" + getNewLine() +
		       "            $('#pageWrapper').removeClass('pinned');" + getNewLine() +
		       "            $('" + sidebar.getID(true) + "').unbind( 'hover');" + getNewLine() +
		       "        } else {" + getNewLine() +
		       "            $('#pageWrapper').addClass('pinned');" + getNewLine() +
		       "            $('" + sidebar.getID(true) + "').hover(" + getNewLine() +
		       "                function () {" + getNewLine() +
		       "                    $('#pageWrapper').addClass('sidebar-hovered');" + getNewLine() +
		       "                }," + getNewLine() +
		       "                function () {" + getNewLine() +
		       "                    $('#pageWrapper').removeClass('sidebar-hovered');" + getNewLine() +
		       "                }" + getNewLine() +
		       "            )" + getNewLine() +
		       "        }" + getNewLine() +
		       "    });";
	}

	/**
	 * Getter for property 'sidebar'.
	 *
	 * @return Value for property 'sidebar'.
	 */
	public ProSidebar getSidebar()
	{
		return sidebar;
	}

	/**
	 * Setter for property 'sidebar'.
	 *
	 * @param sidebar Value to set for property 'sidebar'.
	 */
	public ProSidebarPinFeature<J> setSidebar(ProSidebar sidebar)
	{
		this.sidebar = sidebar;
		return this;
	}
}
