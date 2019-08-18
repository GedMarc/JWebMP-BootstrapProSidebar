package com.jwebmp.plugins.bs4.prosidebar.test;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.Body;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.bootstrap4.badge.styles.BSBadgeSuccess;
import com.jwebmp.plugins.bootstrap4.badge.styles.BSBadgeWarning;
import com.jwebmp.plugins.bootstrap4.images.BSImage;
import com.jwebmp.plugins.bs4.prosidebar.ProSidebar;
import com.jwebmp.plugins.bs4.prosidebar.parts.ProSidebarBrand;
import com.jwebmp.plugins.bs4.prosidebar.parts.header.ProSidebarHeader;
import com.jwebmp.plugins.bs4.prosidebar.parts.header.ProSidebarHeaderUserInfo;
import com.jwebmp.plugins.bs4.prosidebar.parts.header.ProSidebarHeaderUserPic;
import com.jwebmp.plugins.bs4.prosidebar.parts.menu.ProSidebarMenu;
import com.jwebmp.plugins.bs4.prosidebar.parts.menu.ProSidebarMenuDropdown;
import com.jwebmp.plugins.bs4.prosidebar.parts.search.ProSidebarSearch;
import com.jwebmp.plugins.fontawesome5.FontAwesome;

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


		ProSidebarMenu<?> menu = new ProSidebarMenu();
		menu.getList()
		    .addHeaderMenu("General", null);

		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		menu.getList()
		    .addMenuDropdown(new ProSidebarMenuDropdown<>()
				                     .setIcon(FontAwesome.icon(tachometer_alt, Solid))
				                     .setText("Dashboard")
				                     .setBadge(new BSBadgeWarning<>(true).setText("New"))

				                     .addSubmenu(new ProSidebarMenuDropdown.ProSidebarMenuSubMenu<>()
						                                 .addSubItem("Dashboard 1",
						                                             new BSBadgeSuccess<>(true)
								                                 , null, null)
						                                 .addSubItem("Dashboard 2", new BSBadgeSuccess<>().setText("pro"), null, null)
						                                 .addSubItem("Dashboard 3", null, null, null)
				                                )
		                    );
		sidebar.getContent()
		       .addMenu(menu)
		;

		pageWrapper.add(rightSide);
		body.add(pageWrapper);
		setBody(body);
	}
}
