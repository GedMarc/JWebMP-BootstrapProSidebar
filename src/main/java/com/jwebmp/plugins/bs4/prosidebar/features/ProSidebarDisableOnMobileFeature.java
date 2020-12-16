package com.jwebmp.plugins.bs4.prosidebar.features;

import com.jwebmp.core.Feature;
import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

public class ProSidebarDisableOnMobileFeature<J extends ProSidebarDisableOnMobileFeature<J>>
		extends Feature<GlobalFeatures, JavaScriptPart<?>, J>
{
	private IComponentHierarchyBase<?,?> pageWrapper;

	public ProSidebarDisableOnMobileFeature(IComponentHierarchyBase<?,?> component, IComponentHierarchyBase<?,?> pageWrapper)
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
		return "if (!/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) {" + getNewLine() +
		       "        $(\".sidebar-content\").mCustomScrollbar({" + getNewLine() +
		       "            axis: \"y\"," + getNewLine() +
		       "            autoHideScrollbar: true," + getNewLine() +
		       "            scrollInertia: 300" + getNewLine() +
		       "        });" + getNewLine() +
		       "        $(\".sidebar-content\").addClass(\"desktop\");" + getNewLine() +
		       "" + getNewLine() +
		       "    }";
	}
}
