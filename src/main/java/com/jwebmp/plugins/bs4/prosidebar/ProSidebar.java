package com.jwebmp.plugins.bs4.prosidebar;

import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.Section;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.plugins.bs4.prosidebar.enumerations.IProSidebarTheme;
import com.jwebmp.plugins.bs4.prosidebar.enumerations.ProSidebarDefaultThemes;
import com.jwebmp.plugins.bs4.prosidebar.features.ProSidebarDropdownMenuFeature;
import com.jwebmp.plugins.bs4.prosidebar.features.ProSidebarToggleSidebarOverlayFeature;
import com.jwebmp.plugins.bs4.prosidebar.parts.ProSidebarContent;
import com.jwebmp.plugins.bs4.prosidebar.parts.footer.ProSidebarFooter;
import com.jwebmp.plugins.malihu.MalihuScrollbarFeature;
import com.jwebmp.plugins.malihu.enumerations.MalihuScrollbarAxis;
import com.jwebmp.plugins.malihu.enumerations.MalihuScrollbarThemes;
import com.jwebmp.plugins.malihu.options.MalihuScrollBarScrollButtonsOptions;

import java.util.Objects;

public class ProSidebar<J extends ProSidebar<J>>
		extends Section<J>
{
	private ComponentHierarchyBase pageWrapper;

	private MalihuScrollbarFeature<?> scrollbarFeature;
	private IProSidebarTheme<?> theme;

	private ProSidebarContent<?> content;
	private ProSidebarFooter<?> footer;

	private boolean showBackground;
	private String cssBackgroundClass;
	private boolean shown;

	public ProSidebar(ComponentHierarchyBase pageWrapper)
	{
		this(pageWrapper, true);
	}

	public ProSidebar(ComponentHierarchyBase pageWrapper, boolean withScroll)
	{
		this.pageWrapper = pageWrapper;

		addClass("sidebar-wrapper");
		setID("sidebar");

		setTag(ComponentTypes.Navigation);

		content = new ProSidebarContent<>();
		content.setID("customScrollbarContentID");
		scrollbarFeature = new MalihuScrollbarFeature<>(content);
		add(content);

		footer = new ProSidebarFooter<>();
		add(footer);

		if (!withScroll)
		{
			content.removeFeature(scrollbarFeature);
		}

		addFeature(new ProSidebarDropdownMenuFeature(this));
		theme = ProSidebarDefaultThemes.Default_Theme;

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
	public ProSidebar<J> setPageWrapper(ComponentHierarchyBase pageWrapper)
	{
		this.pageWrapper = pageWrapper;
		return this;
	}

	/**
	 * Getter for property 'scrollbarFeature'.
	 *
	 * @return Value for property 'scrollbarFeature'.
	 */
	public MalihuScrollbarFeature<?> getScrollbarFeature()
	{
		return scrollbarFeature;
	}

	/**
	 * Setter for property 'scrollbarFeature'.
	 *
	 * @param scrollbarFeature
	 * 		Value to set for property 'scrollbarFeature'.
	 */
	public ProSidebar<J> setScrollbarFeature(MalihuScrollbarFeature<?> scrollbarFeature)
	{
		this.scrollbarFeature = scrollbarFeature;
		return this;
	}

	/**
	 * Getter for property 'theme'.
	 *
	 * @return Value for property 'theme'.
	 */
	public IProSidebarTheme<?> getTheme()
	{
		return theme;
	}

	/**
	 * Setter for property 'theme'.
	 *
	 * @param theme
	 * 		Value to set for property 'theme'.
	 */
	public ProSidebar<J> setTheme(IProSidebarTheme<?> theme)
	{
		pageWrapper.removeClass(theme.toString());
		this.theme = theme;
		pageWrapper.addClass(theme.toString());
		return this;
	}

	/**
	 * Getter for property 'showBackground'.
	 *
	 * @return Value for property 'showBackground'.
	 */
	public boolean isShowBackground()
	{
		return showBackground;
	}

	/**
	 * Setter for property 'showBackground'.
	 *
	 * @param showBackground
	 * 		Value to set for property 'showBackground'.
	 */
	public ProSidebar<J> setShowBackground(boolean showBackground)
	{
		this.showBackground = showBackground;
		if (showBackground)
		{
			pageWrapper.addClass("sidebar-bg");
		}
		else
		{
			pageWrapper.removeClass("sidebar-bg");
		}
		return this;
	}

	/**
	 * Getter for property 'cssBackgroundClass'.
	 *
	 * @return Value for property 'cssBackgroundClass'.
	 */
	public String getCssBackgroundClass()
	{
		return cssBackgroundClass;
	}

	/**
	 * Setter for property 'cssBackgroundClass'.
	 *
	 * @param cssBackgroundClass
	 * 		Value to set for property 'cssBackgroundClass'.
	 */
	public ProSidebar<J> setCssBackgroundClass(String cssBackgroundClass)
	{
		this.cssBackgroundClass = cssBackgroundClass;
		if (Objects.nonNull(cssBackgroundClass))
		{
			pageWrapper.addClass(cssBackgroundClass);
		}
		return this;
	}

	/**
	 * Getter for property 'shown'.
	 *
	 * @return Value for property 'shown'.
	 */
	public boolean isShown()
	{
		return shown;
	}

	/**
	 * Setter for property 'shown'.
	 *
	 * @param shown
	 * 		Value to set for property 'shown'.
	 */
	public ProSidebar<J> setShown(boolean shown)
	{
		this.shown = shown;
		if (shown)
		{
			pageWrapper.addClass("toggled");
		}
		else
		{
			pageWrapper.removeClass("toggled");
		}
		return this;
	}



	/**
	 * Getter for property 'content'.
	 *
	 * @return Value for property 'content'.
	 */
	public ProSidebarContent<?> getContent()
	{
		return content;
	}

	/**
	 * Setter for property 'content'.
	 *
	 * @param content
	 * 		Value to set for property 'content'.
	 */
	public ProSidebar<J> setContent(ProSidebarContent<?> content)
	{
		this.content = content;
		return this;
	}

	/**
	 * Getter for property 'footer'.
	 *
	 * @return Value for property 'footer'.
	 */
	public ProSidebarFooter<?> getFooter()
	{
		return footer;
	}

	/**
	 * Setter for property 'footer'.
	 *
	 * @param footer Value to set for property 'footer'.
	 */
	public ProSidebar<J> setFooter(ProSidebarFooter<?> footer)
	{
		this.footer = footer;
		return this;
	}
}
