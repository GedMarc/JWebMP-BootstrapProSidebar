package com.jwebmp.plugins.bs4.prosidebar;

import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.Section;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.plugins.bs4.prosidebar.enumerations.IProSidebarTheme;
import com.jwebmp.plugins.bs4.prosidebar.enumerations.ProSidebarDefaultThemes;
import com.jwebmp.plugins.bs4.prosidebar.features.ProSidebarDropdownMenuFeature;
import com.jwebmp.plugins.bs4.prosidebar.parts.ProSidebarContent;
import com.jwebmp.plugins.bs4.prosidebar.parts.footer.ProSidebarFooter;
import com.jwebmp.plugins.malihu.MalihuScrollbarFeature;

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
	@SuppressWarnings("unchecked")
	public J setPageWrapper(ComponentHierarchyBase pageWrapper)
	{
		this.pageWrapper = pageWrapper;
		return (J) this;
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
	@SuppressWarnings("unchecked")
	public J setScrollbarFeature(MalihuScrollbarFeature<?> scrollbarFeature)
	{
		this.scrollbarFeature = scrollbarFeature;
		return (J) this;
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
	@SuppressWarnings("unchecked")
	public J setTheme(IProSidebarTheme<?> theme)
	{
		pageWrapper.removeClass(theme.toString());
		this.theme = theme;
		pageWrapper.addClass(theme.toString());
		return (J) this;
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
	@SuppressWarnings("unchecked")
	public J setShowBackground(boolean showBackground)
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
		return (J) this;
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
	@SuppressWarnings("unchecked")
	public J setCssBackgroundClass(String cssBackgroundClass)
	{
		this.cssBackgroundClass = cssBackgroundClass;
		if (Objects.nonNull(cssBackgroundClass))
		{
			pageWrapper.addClass(cssBackgroundClass);
		}
		return (J) this;
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
	@SuppressWarnings("unchecked")
	public J setShown(boolean shown)
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
		return (J) this;
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
	@SuppressWarnings("unchecked")
	public J setContent(ProSidebarContent<?> content)
	{
		this.content = content;
		return (J) this;
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
	 * @param footer
	 * 		Value to set for property 'footer'.
	 */
	@SuppressWarnings("unchecked")
	public J setFooter(ProSidebarFooter<?> footer)
	{
		this.footer = footer;
		return (J) this;
	}
}
