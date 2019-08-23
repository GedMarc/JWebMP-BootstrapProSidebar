package com.jwebmp.plugins.bs4.prosidebar.parts.footer;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Image;
import com.jwebmp.core.base.html.Paragraph;
import com.jwebmp.core.base.html.Strong;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownLink;

public class ProSidebarFooterLabelledItem<J extends ProSidebarFooterLabelledItem<J>>
		extends BSDropDownLink<J>
{
	private DivSimple<?> notificationContentDiv = new DivSimple<>().addClass("message-content");
	private DivSimple<?> contentDiv = new DivSimple<>().addClass("content");
	private DivSimple<?> picDiv = new DivSimple<>().addClass("pic");

	private DivSimple<?> titleDiv = new DivSimple<>().addClass("message-title");
	private DivSimple<?> detailDiv = new DivSimple<>().addClass("message-detail");

	private String notificationDetail;
	private String title;
	private Image<?> image;

	public ProSidebarFooterLabelledItem()
	{
		//No config required
	}

	public ProSidebarFooterLabelledItem(String title,String notificationDetail , Image<?> image)
	{
		this.notificationDetail = notificationDetail;
		this.title = title;
		this.image = image;
	}

	@Override
	public void init()
	{
		if (!isInitialized())
		{
			notificationContentDiv.add(picDiv);
			notificationContentDiv.add(contentDiv);
			contentDiv.add(titleDiv);
			contentDiv.add(detailDiv);

			if (image != null)
			{
				picDiv.add(image);
			}
			if (title != null)
			{
				titleDiv.add(new Strong(title));
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
	public DivSimple<?> getPicDiv()
	{
		return picDiv;
	}

	/**
	 * Setter for property 'iconDiv'.
	 *
	 * @param picDiv
	 * 		Value to set for property 'iconDiv'.
	 */
	@SuppressWarnings("unchecked")
	public J setPicDiv(DivSimple<?> picDiv)
	{
		this.picDiv = picDiv;
		return (J) this;
	}

	/**
	 * Getter for property 'timeDiv'.
	 *
	 * @return Value for property 'timeDiv'.
	 */
	public DivSimple<?> getTitleDiv()
	{
		return titleDiv;
	}

	/**
	 * Setter for property 'timeDiv'.
	 *
	 * @param titleDiv
	 * 		Value to set for property 'timeDiv'.
	 */
	@SuppressWarnings("unchecked")
	public J setTitleDiv(DivSimple<?> titleDiv)
	{
		this.titleDiv = titleDiv;
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
	public String getTitle()
	{
		return title;
	}

	/**
	 * Setter for property 'timeAgo'.
	 *
	 * @param title
	 * 		Value to set for property 'timeAgo'.
	 */
	@SuppressWarnings("unchecked")
	public J setTitle(String title)
	{
		this.title = title;
		return (J) this;
	}

	/**
	 * Getter for property 'checkIcon'.
	 *
	 * @return Value for property 'checkIcon'.
	 */
	public Image<?> getImage()
	{
		return image;
	}

	/**
	 * Setter for property 'checkIcon'.
	 *
	 * @param image
	 * 		Value to set for property 'checkIcon'.
	 */
	@SuppressWarnings("unchecked")
	public J setImage(Image<?> image)
	{
		this.image = image;
		return (J) this;
	}
}
