package com.jwebmp.plugins.bs4.prosidebar.test;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.Body;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Image;
import com.jwebmp.plugins.bootstrap4.badge.styles.BSBadgeSuccess;
import com.jwebmp.plugins.bootstrap4.badge.styles.BSBadgeWarning;
import com.jwebmp.plugins.bootstrap4.images.BSImage;
import com.jwebmp.plugins.bs4.prosidebar.ProSidebar;
import com.jwebmp.plugins.bs4.prosidebar.parts.ProSidebarBrand;
import com.jwebmp.plugins.bs4.prosidebar.parts.footer.*;
import com.jwebmp.plugins.bs4.prosidebar.parts.header.ProSidebarHeader;
import com.jwebmp.plugins.bs4.prosidebar.parts.header.ProSidebarHeaderUserInfo;
import com.jwebmp.plugins.bs4.prosidebar.parts.header.ProSidebarHeaderUserPic;
import com.jwebmp.plugins.bs4.prosidebar.parts.menu.ProSidebarMenu;
import com.jwebmp.plugins.bs4.prosidebar.parts.menu.ProSidebarMenuDropdownItem;
import com.jwebmp.plugins.bs4.prosidebar.parts.search.ProSidebarSearch;
import com.jwebmp.plugins.fontawesome5.FontAwesome;
import com.jwebmp.plugins.malihu.enumerations.MalihuScrollbarAxis;
import com.jwebmp.plugins.malihu.enumerations.MalihuScrollbarThemes;
import com.jwebmp.plugins.malihu.options.MalihuScrollBarScrollButtonsOptions;

import static com.jwebmp.plugins.bootstrap4.options.BSBorderOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSColoursOptions.*;
import static com.jwebmp.plugins.bs4.prosidebar.enumerations.ProSidebarDefaultThemes.*;
import static com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons.*;
import static com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles.*;

public class ProSidebarPage
		extends Page<ProSidebarPage>
{
	private DivSimple<?> pageWrapper = new DivSimple<>().setID("page-wrapper");
	private Body<?, ?> body = new Body<>();
	private ProSidebar<?> sidebar = new ProSidebar<>(pageWrapper);

	private DivSimple<?> rightSide = new DivSimple<>();

	public ProSidebarPage()
	{
		pageWrapper.add(sidebar);

		sidebar.setCssBackgroundClass("bg1");

		sidebar.setShown(true);
		sidebar.setShowBackground(true);
		sidebar.setTheme(Default_Theme);

		String imgUrl = "bower_components/bootstrapprosidebar/src/img/user.jpg";

		sidebar.getContent()
		       .addBrand(new ProSidebarBrand<>()
				                 .setHeaderText("pro sidebar"))
		       .addHeader(new ProSidebarHeader<>()
				                  .setUserPic(new ProSidebarHeaderUserPic<>()
						                              .setUserImage(new BSImage<>(imgUrl).setResponsive(true)
						                                                                 .setRounded(true)
						                                                                 .addAttribute("alt", "User Picture"))
				                             )
				                  .setUserInfo(new ProSidebarHeaderUserInfo<>()
						                               .setUserName("John <strong>Smith</strong>")
						                               .setRole("Administrator")
						                               .setUserStatus(FontAwesome.icon(circle, Solid), "Online", null)
				                              )
		                 )
		       .addSearch(new ProSidebarSearch<>()
				                  .appendIcon(FontAwesome.icon(search, Solid)))
		;


		sidebar.getScrollbarFeature()
		       .getOptions()
		       .setAxis(MalihuScrollbarAxis.Y)
		       .setTheme(MalihuScrollbarThemes.Rounded_Dots)
		       .setScrollButtons(new MalihuScrollBarScrollButtonsOptions<>().setEnable(true))
		       .setScrollInertia(300);


		ProSidebarMenu<?> menu = new ProSidebarMenu();
		menu.getList()
		    .addHeaderMenu("General", null);

		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdownItem<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))
				                     .addSubmenu(new ProSidebarMenuDropdownItem.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );

		menu.getList()
		    .addHeaderMenu("Extras", FontAwesome.icon(circle_notch, Solid));

		sidebar.getContent()
		       .addMenu(menu);

		ProSidebarFooter<?> footer = sidebar.getFooter();

		ProSidebarFooterNotificationsDropDown<?> footerNotificationsDropDown = new ProSidebarFooterNotificationsDropDown<>();

		footerNotificationsDropDown.setIcon(FontAwesome.icon(bell, Solid));
		footerNotificationsDropDown.setBadge(new BSBadgeWarning<>(true).setText("3"));


		ProSidebarFooterNotificationsMenu<?> footerNotificationsMenu = footerNotificationsDropDown.addDropDownNotificationsMenu();
		footerNotificationsMenu.addHeader(FontAwesome.icon(bell, Solid), "Notifications");
		footerNotificationsMenu.addDivider();
		footerNotificationsMenu.addCheckedItem("Lorem ipsum dolor sit amet consectetur adipisicing elit. In totam explicabo",
		                                       "6 minutes ago",
		                                       FontAwesome.icon(check, Solid)
		                                                  .addClass(Text_Success)
		                                                  .addClass("border")
		                                                  .addClass(Border_Success)
		                                      );
		footerNotificationsMenu.addCheckedItem("Lorem ipsum dolor sit amet consectetur adipisicing elit. In totam explicabo",
		                                       "Yesterday",
		                                       FontAwesome.icon(check, Solid)
		                                                  .addClass(Text_Info)
		                                                  .addClass("border")
		                                                  .addClass(Border_Info)
		                                      );
		footerNotificationsMenu.addCheckedItem("Lorem ipsum dolor sit amet consectetur adipisicing elit. In totam explicabo",
		                                       "Tomorrow",
		                                       FontAwesome.icon(check, Solid)
		                                                  .addClass(Text_Danger)
		                                                  .addClass("border")
		                                                  .addClass(Border_Danger)
		                                      );

		footerNotificationsMenu.addDivider();

		footerNotificationsMenu.addItem("View All Notification")
		                       .addClass("text-center");


		ProSidebarFooterMessagesDropDown<?> footerMessagesDropDown = new ProSidebarFooterMessagesDropDown<>();

		footerMessagesDropDown.setIcon(FontAwesome.icon(envelope, Solid));
		footerMessagesDropDown.setBadge(new BSBadgeSuccess<>(true).setText("7"));

		ProSidebarFooterMessagesMenu<?> messagesMenu = footerMessagesDropDown.getMessagesMenu();
		Image img = new Image(imgUrl);
		messagesMenu.addHeader(FontAwesome.icon(envelope, Solid), "Messages");
		messagesMenu.addDivider();
		messagesMenu.addMessageItem("6 minutes ago",
		                            "Lorem ipsum dolor sit amet consectetur adipisicing elit. In totam explicabo",

		                            img
		                           );
		messagesMenu.addMessageItem("Yesterday",
		                            "Lorem ipsum dolor sit amet consectetur adipisicing elit. In totam explicabo",

		                            img
		                           );
		messagesMenu.addMessageItem("Tomorrow",
		                            "Lorem ipsum dolor sit amet consectetur adipisicing elit. In totam explicabo",

		                            img
		                           );

		messagesMenu.addDivider();

		messagesMenu.addItem("View All Messages")
		            .addClass("text-center");


		footer.add(footerNotificationsDropDown);
		footer.add(footerMessagesDropDown);

		;


		pageWrapper.add(rightSide);
		body.add(pageWrapper);
		setBody(body);
	}
}
