package com.jwebmp.plugins.bs4.prosidebar.parts.footer;

import com.jwebmp.core.base.ComponentHierarchyBase;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownLink;
import com.jwebmp.plugins.bs4.prosidebar.parts.menu.IProSidebarMenuItem;

public class ProSidebarFooterCheckedItem<J extends ProSidebarFooterCheckedItem<J>>
		extends BSDropDownLink<J>
	implements IProSidebarMenuItem<J>
{
	private DivSimple<?> notificationContentDiv = new DivSimple<>().addClass("notification-content");
	private DivSimple<?> contentDiv = new DivSimple<>().addClass("content");
	private DivSimple<?> iconDiv = new DivSimple<>().addClass("icon");
	private DivSimple<?> timeDiv = new DivSimple<>().addClass("notification-time");
	private DivSimple<?> detailDiv = new DivSimple<>().addClass("notification-detail");

	private String notificationDetail;
	private String timeAgo;
	private IIcon<?,?> checkIcon;

	public ProSidebarFooterCheckedItem()
	{
		//No config required
	}

	public ProSidebarFooterCheckedItem(String notificationDetail, String timeAgo, IIcon<?,?> checkIcon)
	{
		this.notificationDetail = notificationDetail;
		this.timeAgo = timeAgo;
		this.checkIcon = checkIcon;
	}

	public ProSidebarFooterCheckedItem(String notificationDetail, ComponentHierarchyBase timeAgo, IIcon<?,?> checkIcon)
	{
		this.notificationDetail = notificationDetail;
		this.timeAgo = timeAgo.setTiny(true)
		                      .toString(0);
		this.checkIcon = checkIcon;
	}

	@Override
	public void init()
	{
		if (!isInitialized())
		{
			notificationContentDiv.add(iconDiv);
			notificationContentDiv.add(contentDiv);
			contentDiv.add(detailDiv);
			contentDiv.add(timeDiv);

			if (checkIcon != null)
			{
				iconDiv.add(checkIcon.getIconComponent());
			}
			if (timeAgo != null)
			{
				timeDiv.add(timeAgo);
			}
			if (notificationDetail != null)
			{
				detailDiv.add(new Paragraph<>(notificationDetail).setTextOnly(true));
			}

			add(notificationContentDiv);
		}
		super.init();
	}

	/**
	 * Getter for property 'notificationContentDiv'.
	 *
	 * @return Value for property 'notificationContentDiv'.
	 */
	public DivSimple<?> getNotificationContentDiv()
	{
		return notificationContentDiv;
	}

	/**
	 * Setter for property 'notificationContentDiv'.
	 *
	 * @param notificationContentDiv
	 * 		Value to set for property 'notificationContentDiv'.
	 */
	@SuppressWarnings("unchecked")
	public J setNotificationContentDiv(DivSimple<?> notificationContentDiv)
	{
		this.notificationContentDiv = notificationContentDiv;
		return (J) this;
	}

	/**
	 * Getter for property 'contentDiv'.
	 *
	 * @return Value for property 'contentDiv'.
	 */
	public DivSimple<?> getContentDiv()
	{
		return contentDiv;
	}

	/**
	 * Setter for property 'contentDiv'.
	 *
	 * @param contentDiv
	 * 		Value to set for property 'contentDiv'.
	 */
	@SuppressWarnings("unchecked")
	public J setContentDiv(DivSimple<?> contentDiv)
	{
		this.contentDiv = contentDiv;
		return (J) this;
	}

	/**
	 * Getter for property 'iconDiv'.
	 *
	 * @return Value for property 'iconDiv'.
	 */
	public DivSimple<?> getIconDiv()
	{
		return iconDiv;
	}

	/**
	 * Setter for property 'iconDiv'.
	 *
	 * @param iconDiv
	 * 		Value to set for property 'iconDiv'.
	 */
	@SuppressWarnings("unchecked")
	public J setIconDiv(DivSimple<?> iconDiv)
	{
		this.iconDiv = iconDiv;
		return (J) this;
	}

	/**
	 * Getter for property 'timeDiv'.
	 *
	 * @return Value for property 'timeDiv'.
	 */
	public DivSimple<?> getTimeDiv()
	{
		return timeDiv;
	}

	/**
	 * Setter for property 'timeDiv'.
	 *
	 * @param timeDiv
	 * 		Value to set for property 'timeDiv'.
	 */
	@SuppressWarnings("unchecked")
	public J setTimeDiv(DivSimple<?> timeDiv)
	{
		this.timeDiv = timeDiv;
		return (J) this;
	}

	/**
	 * Getter for property 'detailDiv'.
	 *
	 * @return Value for property 'detailDiv'.
	 */
	public DivSimple<?> getDetailDiv()
	{
		return detailDiv;
	}

	/**
	 * Setter for property 'detailDiv'.
	 *
	 * @param detailDiv
	 * 		Value to set for property 'detailDiv'.
	 */
	@SuppressWarnings("unchecked")
	public J setDetailDiv(DivSimple<?> detailDiv)
	{
		this.detailDiv = detailDiv;
		return (J) this;
	}

	/**
	 * Getter for property 'notificationDetail'.
	 *
	 * @return Value for property 'notificationDetail'.
	 */
	public String getNotificationDetail()
	{
		return notificationDetail;
	}

	/**
	 * Setter for property 'notificationDetail'.
	 *
	 * @param notificationDetail
	 * 		Value to set for property 'notificationDetail'.
	 */
	@SuppressWarnings("unchecked")
	public J setNotificationDetail(String notificationDetail)
	{
		this.notificationDetail = notificationDetail;
		return (J) this;
	}

	/**
	 * Getter for property 'timeAgo'.
	 *
	 * @return Value for property 'timeAgo'.
	 */
	public String getTimeAgo()
	{
		return timeAgo;
	}

	/**
	 * Setter for property 'timeAgo'.
	 *
	 * @param timeAgo
	 * 		Value to set for property 'timeAgo'.
	 */
	@SuppressWarnings("unchecked")
	public J setTimeAgo(String timeAgo)
	{
		this.timeAgo = timeAgo;
		return (J) this;
	}

	/**
	 * Getter for property 'checkIcon'.
	 *
	 * @return Value for property 'checkIcon'.
	 */
	public IIcon<?,?> getCheckIcon()
	{
		return checkIcon;
	}

	/**
	 * Setter for property 'checkIcon'.
	 *
	 * @param checkIcon
	 * 		Value to set for property 'checkIcon'.
	 */
	@SuppressWarnings("unchecked")
	public J setCheckIcon(IIcon<?,?> checkIcon)
	{
		this.checkIcon = checkIcon;
		return (J) this;
	}
}
