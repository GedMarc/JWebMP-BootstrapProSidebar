package com.jwebmp.plugins.bs4.prosidebar;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.bootstrap4.containers.BSContainer;
import com.jwebmp.plugins.bs4.prosidebar.features.ProSidebarToggleSidebarOverlayFeature;

import static com.jwebmp.plugins.bootstrap4.options.BSContainerOptions.*;

public class ProSidebarMainContent<J extends ProSidebarMainContent<J>>
		extends DivSimple<J>
{
	private DivSimple<?> overlay;
	private BSContainer<?> container;

	public ProSidebarMainContent()
	{
		setTag("main");
		addClass("page-content");
		//addClass("pt-2");
		overlay = new DivSimple<>().addClass("overlay")
		                           .setID("overlay");
		container = BSContainer.newInstance(Container_Fluid)
		                       .setID("content-updater");
		add(overlay);
		add(container);

		overlay.addFeature(new ProSidebarToggleSidebarOverlayFeature(overlay));
	}

	public DivSimple<?> getOverlay()
	{
		return overlay;
	}

	public BSContainer<?> getContainer()
	{
		return container;
	}
}
