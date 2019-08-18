package com.jwebmp.plugins.bs4.prosidebar.features;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.bs4.prosidebar.ProSidebar;

public class ProSidebarPinFeature<J extends ProSidebarPinFeature<J>>
		extends Feature<GlobalFeatures<?, ?>, JavaScriptPart<?>, J>
{
	private ComponentHierarchyBase pageWrapper;
	private ProSidebar sidebar;

	public ProSidebarPinFeature(ComponentHierarchyBase component, ComponentHierarchyBase pageWrapper, ProSidebar sidebar)
	{
		super("ProSidebarPinFeature", component);
		this.pageWrapper = pageWrapper;
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
		       "        if ($(\"" + pageWrapper.getID(true) + "\").hasClass(\"pinned\")) {" + getNewLine() +
		       "            // unpin sidebar when hovered" + getNewLine() +
		       "            $(\"" + pageWrapper.getID(true) + "\").removeClass(\"pinned\");" + getNewLine() +
		       "            $(\"" + sidebar.getID(true) + "\").unbind( \"hover\");" + getNewLine() +
		       "        } else {" + getNewLine() +
		       "            $(\"" + pageWrapper.getID(true) + "\").addClass(\"pinned\");" + getNewLine() +
		       "            $(\"" + sidebar.getID(true) + "\").hover(" + getNewLine() +
		       "                function () {" + getNewLine() +
		       "                    //console.log(\"mouseenter\");" + getNewLine() +
		       "                    $(\"" + pageWrapper.getID(true) + "\").addClass(\"sidebar-hovered\");" + getNewLine() +
		       "                }," + getNewLine() +
		       "                function () {" + getNewLine() +
		       "                    //console.log(\"mouseout \");" + getNewLine() +
		       "                    $(\"" + pageWrapper.getID(true) + "\").removeClass(\"sidebar-hovered\");" + getNewLine() +
		       "                }" + getNewLine() +
		       "            )" + getNewLine() +
		       "        }" + getNewLine() +
		       "    });";
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
	 * @param pageWrapper Value to set for property 'pageWrapper'.
	 */
	public ProSidebarPinFeature<J> setPageWrapper(ComponentHierarchyBase pageWrapper)
	{
		this.pageWrapper = pageWrapper;
		return this;
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
