package com.jwebmp.plugins.bs4.prosidebar.test;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.*;
import com.jwebmp.core.base.html.attributes.GlobalAttributes;
import com.jwebmp.core.base.html.attributes.IFrameAttributes;
import com.jwebmp.plugins.bootstrap4.badge.styles.BSBadgeSuccess;
import com.jwebmp.plugins.bootstrap4.badge.styles.BSBadgeWarning;
import com.jwebmp.plugins.bootstrap4.buttons.styles.BSButtonSecondary;
import com.jwebmp.plugins.bootstrap4.buttons.styles.BSButtonSecondaryOutline;
import com.jwebmp.plugins.bootstrap4.buttons.switches.BSCustomSwitchGroup;
import com.jwebmp.plugins.bootstrap4.containers.BSColumn;
import com.jwebmp.plugins.bootstrap4.containers.BSRow;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownLink;
import com.jwebmp.plugins.bootstrap4.dropdown.parts.BSDropDownMenu;
import com.jwebmp.plugins.bootstrap4.forms.groups.BSFormGroup;
import com.jwebmp.plugins.bootstrap4.images.BSImage;
import com.jwebmp.plugins.bs4.prosidebar.ProSidebar;
import com.jwebmp.plugins.bs4.prosidebar.ProSidebarLayout;
import com.jwebmp.plugins.bs4.prosidebar.ProSidebarPageConfigurator;
import com.jwebmp.plugins.bs4.prosidebar.ProSidebarPulsatingBadge;
import com.jwebmp.plugins.bs4.prosidebar.enumerations.IProSidebarTheme;
import com.jwebmp.plugins.bs4.prosidebar.features.ProSidebarPinFeature;
import com.jwebmp.plugins.bs4.prosidebar.features.ProSidebarSwitchBackgroundFeature;
import com.jwebmp.plugins.bs4.prosidebar.features.ProSidebarSwitchThemeFeature;
import com.jwebmp.plugins.bs4.prosidebar.features.ProSidebarToggleSidebarFeature;
import com.jwebmp.plugins.bs4.prosidebar.parts.ProSidebarBrand;
import com.jwebmp.plugins.bs4.prosidebar.parts.footer.ProSidebarFooter;
import com.jwebmp.plugins.bs4.prosidebar.parts.footer.ProSidebarFooterCheckedItem;
import com.jwebmp.plugins.bs4.prosidebar.parts.footer.ProSidebarFooterLabelledItem;
import com.jwebmp.plugins.bs4.prosidebar.parts.footer.ProSidebarFooterPinnedBottom;
import com.jwebmp.plugins.bs4.prosidebar.parts.header.ProSidebarHeader;
import com.jwebmp.plugins.bs4.prosidebar.parts.header.ProSidebarHeaderUserInfo;
import com.jwebmp.plugins.bs4.prosidebar.parts.header.ProSidebarHeaderUserPic;
import com.jwebmp.plugins.bs4.prosidebar.parts.menu.ProSidebarMenu;
import com.jwebmp.plugins.bs4.prosidebar.parts.menu.ProSidebarMenuDropdownItem;
import com.jwebmp.plugins.bs4.prosidebar.parts.menu.ProSidebarMenuListItem;
import com.jwebmp.plugins.bs4.prosidebar.parts.search.ProSidebarSearch;
import com.jwebmp.plugins.fontawesome5.FontAwesome;
import com.jwebmp.plugins.malihu.enumerations.MalihuScrollbarAxis;
import com.jwebmp.plugins.malihu.enumerations.MalihuScrollbarThemes;
import com.jwebmp.plugins.malihu.options.MalihuScrollBarScrollButtonsOptions;

import static com.jwebmp.plugins.bootstrap4.buttons.BSButtonOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSBackgroundOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSBorderOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSColoursOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSColumnOptions.*;
import static com.jwebmp.plugins.bootstrap4.options.BSSpacingOptions.*;
import static com.jwebmp.plugins.bs4.prosidebar.enumerations.ProSidebarDefaultThemes.*;
import static com.jwebmp.plugins.fontawesome5.icons.FontAwesomeBrandIcons.*;
import static com.jwebmp.plugins.fontawesome5.icons.FontAwesomeIcons.*;
import static com.jwebmp.plugins.fontawesome5.options.FontAwesomeStyles.*;

public class ProSidebarPage
		extends Page<ProSidebarPage>
{
	private Body<?, ?> body = new Body<>();
	private ProSidebar<?> sidebar;

	public ProSidebarPage()
	{
		System.setErr(System.out);
		ProSidebarLayout<?> layout = new ProSidebarLayout<>();
		sidebar = layout.getSidebar();
		sidebar.setID("sidebar");

		sidebar.setCssBackgroundClass("bg1");

		sidebar.setShown(true);
		sidebar.setShowBackground(true);
		sidebar.setTheme(Default_Theme);

		sidebar.getScrollbarFeature()
		       .getOptions()
		       .setAxis(MalihuScrollbarAxis.Y)
		       .setTheme(MalihuScrollbarThemes.Rounded_Dots)
		       .setScrollButtons(new MalihuScrollBarScrollButtonsOptions<>().setEnable(true))
		       .setScrollInertia(300);

		String imgUrl = "bower_components/bootstrapprosidebar/src/img/user.jpg";

		buildSearchSection(imgUrl);
		buildMenu();
		buildFooterSection(imgUrl);

		buildDisplayPage(layout);


		body.add(layout);
		setBody(body);

	}

	private void buildSearchSection(String imgUrl)
	{
		ProSidebarSearch<?> searchSection = new ProSidebarSearch<>()
				                                    .appendIcon(FontAwesome.icon(search, Solid));
		searchSection.getInput()
		             .setPlaceholder("Search...");

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
		       .addSearch(searchSection)
		;
	}

	private void buildMenu()
	{
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
		    .addItem(new ProSidebarMenuListItem<>()
				             .setIcon(FontAwesome.icon(calendar, Solid))
				             .setText("Calendar")
				             .setBadge(new BSBadgeWarning<>(true).setText("New"))
		            );

		menu.getList()
		    .addHeaderMenu("Extras", FontAwesome.icon(circle_notch, Solid));

		sidebar.getContent()
		       .addMenu(menu);
	}

	private void buildDisplayPage(ProSidebarLayout<?> layout)
	{
		BSButtonSecondary<?> toggleButton = new BSButtonSecondary<>()
				                                    .addClass("rounded-0")
				                                    .addAttribute("href", "#")
				                                    .setTag("a")
				                                    .add(new Span<>("Toggle Button"));
		BSButtonSecondaryOutline<?> pinButton = new BSButtonSecondaryOutline<>()
				                                        .addClass("rounded-0")
				                                        .addAttribute("href", "#")
				                                        .setTag("a")
				                                        .add(new Span<>("Pin Button"));

		toggleButton.addFeature(new ProSidebarToggleSidebarFeature("toggleButton", toggleButton, new DivSimple<>().setID("pageWrapper")));

		pinButton.addFeature(new ProSidebarPinFeature("pinButton", pinButton, sidebar));

		layout.getMainContent()
		      .getContainer()
		      .add(BSRow.newInstance()
		                .add(new BSFormGroup<>().addClass(Col_Md_12)
		                                        .add(new H2("Pro Sidebar"))
		                                        .add("This is a responsive sidebar template with dropdown menu based on bootstrap framework."))
		                .add(new BSFormGroup<>().addClass(Col_Md_12)
		                                        .add(new IFrame<>("https://ghbtns.com/github-btn.html?user=azouaoui-med&repo=pro-sidebar-template&type=star&count=true&size=small"
				                                        , "githubStarCount"
				                                        , 100, 30)
				                                             .addAttribute(IFrameAttributes.FrameBorder, "0")
				                                             .addAttribute(IFrameAttributes.Scrolling, "0"))
		                                        .add(new IFrame<>("https://ghbtns.com/github-btn.html?user=azouaoui-med&repo=pro-sidebar-template&type=fork&count=true&size=small"
				                                        , "githubForkCount"
				                                        , 100, 30)
				                                             .addAttribute(IFrameAttributes.FrameBorder, "0")
				                                             .addAttribute(IFrameAttributes.Scrolling, "0")
		                                            )
		                    )
		                .add(new BSFormGroup<>().addClass(Col_Md_12)
		                                        .add(toggleButton)
		                                        .add(pinButton)
		                    )
		          );

		layout.add(new HorizontalRule());

		buildThemesSection(layout);
		buildBackgroundSection(layout);
		buildSwitchOptions(layout);
		buildThanksBar(layout);

	}

	private void buildThemesSection(ProSidebarLayout<?> layout)
	{
		BSFormGroup<?, ?> themeSelection = new BSFormGroup<>().addClass(Col_Md_12);
		themeSelection.addFeature(new ProSidebarSwitchThemeFeature<>(themeSelection));
		for (IProSidebarTheme iProSidebarTheme : ProSidebarPageConfigurator.getAvailableThemes())
		{
			Link<?> link = new Link<>("#")
					               .addAttribute("data-sidebar-theme", iProSidebarTheme.toString())
					               .addClass("theme")
					               .addClass(iProSidebarTheme.toString());
			themeSelection.add(link);
		}

		layout.add(BSRow.newInstance()
		                .add(new BSFormGroup<>().addClass(Col_Md_12)
		                                        .add(new H3("Themes"))
		                                        .add("Here are more themes that you can use")
		                    )
		                .add(themeSelection)
		          );

	}

	private void buildBackgroundSection(ProSidebarLayout<?> layout)
	{
		BSFormGroup<?, ?> themeSelection = new BSFormGroup<>().addClass(Col_Md_12);
		themeSelection.addFeature(new ProSidebarSwitchBackgroundFeature<>(themeSelection, "bg2"));
		for (String iProSidebarTheme : ProSidebarPageConfigurator.getAvailableBackgrounds())
		{
			Link<?> link = new Link<>("#")
					               .addAttribute("data-sidebar-bg", iProSidebarTheme.toString())
					               .addClass("theme theme-bg")
					               .addClass(iProSidebarTheme.toString());
			themeSelection.add(link);
		}

		layout.add(BSRow.newInstance()
		                .add(new BSFormGroup<>().addClass(Col_Md_12)
		                                        .add(new H3("Backgrounds"))
		                                        .add("You can also use background images")
		                    )
		                .add(themeSelection)
		          );
	}

	private void buildSwitchOptions(ProSidebarLayout<?> layout)
	{
		BSCustomSwitchGroup<?> themeSelection = new BSCustomSwitchGroup<>().addClass(Col_Md_12)
		                                                                   .addClass(Margin_Left_3);
		themeSelection.getLabel()
		              .setText("Background Image");

		themeSelection.setCustomControl(true);

		layout.add(BSRow.newInstance()
		                .add(themeSelection)
		          );

		BSCustomSwitchGroup<?> borderRadius = new BSCustomSwitchGroup<>().addClass(Col_Md_12)
		                                                                 .addClass(Margin_Left_3);
		borderRadius.getLabel()
		            .setText("Border Radius");

		layout.add(BSRow.newInstance()
		                .add(borderRadius)
		          );
	}

	private void buildThanksBar(ProSidebarLayout<?> layout)
	{
		layout.add(HorizontalRule.getInstance());
		layout.add(BSRow.newInstance()
		                .add(BSColumn.newInstance(Col_Md_12)
		                             .add(new SmallText<>("Made with <i class=\"fa fa-heart text-danger\" aria-hidden=\"true\"></i> by <span\n" +
				                                                  "                                class=\"text-secondary font-weight-bold\">Mohamed\n" +
				                                                  "                                Azouaoui</span>"))));
		
		BSFormGroup<?, ?> group = new BSFormGroup<>().addClass(Col_Md_12);
		Link<?> githubLink = new Link<>("https://github.com/azouaoui-med", "_blank")
				                 .addClass(Btn)
				                 .addClass(Btn_Sm)
				                 .addClass(Bg_Secondary)
				                 .addClass(Shadow_Sm)
				                 .addClass(Rounded_0)
				                 .addClass(Text_Light)
				                 .addClass(Margin_Right_3)
				                 .addClass(Margin_Bottom_3)
				                 .add(FontAwesome.icon(github, Brand)
				                                 .addAttribute(GlobalAttributes.Aria_Hidden, "true"));
		Link<?> twitterLink = new Link<>("https://twitter.com/azouaoui_med", "_blank")
				                     .addClass(Btn)
				                     .addClass(Btn_Sm)
				                     .addClass(Bg_Secondary)
				                     .addClass(Shadow_Sm)
				                     .addClass(Rounded_0)
				                     .addClass(Text_Light)
				                     .addClass(Margin_Right_3)
				                     .addClass(Margin_Bottom_3)
				                     .add(FontAwesome.icon(twitter, Brand)
				                                     .addAttribute(GlobalAttributes.Aria_Hidden, "true"));
		Link<?> instagramLink = new Link<>("https://www.instagram.com/azouaoui_med/", "_blank")
				                      .addClass(Btn)
				                      .addClass(Btn_Sm)
				                      .addClass(Bg_Secondary)
				                      .addClass(Shadow_Sm)
				                      .addClass(Rounded_0)
				                      .addClass(Text_Light)
				                      .addClass(Margin_Right_3)
				                      .addClass(Margin_Bottom_3)
				                      .add(FontAwesome.icon(instagram, Brand)
				                                      .addAttribute(GlobalAttributes.Aria_Hidden, "true"));
		Link<?> linkedInLink = new Link<>("https://www.linkedin.com/in/mohamed-azouaoui/", "_blank")
				                        .addClass(Btn)
				                        .addClass(Btn_Sm)
				                        .addClass(Bg_Secondary)
				                        .addClass(Shadow_Sm)
				                        .addClass(Rounded_0)
				                        .addClass(Text_Light)
				                        .addClass(Margin_Right_3)
				                        .addClass(Margin_Bottom_3)
				                        .add(FontAwesome.icon(linkedin_in, Brand)
				                                        .addAttribute(GlobalAttributes.Aria_Hidden, "true"));

		group.add(githubLink);
		group.add(twitterLink);
		group.add(instagramLink);
		group.add(linkedInLink);
		layout.add(BSRow.newInstance().add(group).addClass(Margin_Top_3));
	}

	private void buildFooterSection(String imgUrl)
	{
		ProSidebarFooter<?> footer = sidebar.getFooter();

		footer.addNotificationStyleButton(FontAwesome.icon(bell, Solid),
		                                  new BSBadgeWarning<>(true).setText("3"),
		                                  FontAwesome.icon(bell, Solid),
		                                  "Notifications",
		                                  "View All Notifications",
		                                  null,
		                                  new ProSidebarFooterCheckedItem<>("Lorem ipsum dolor sit amet consectetur adipisicing elit. In totam explicabo",
		                                                                    "6 minutes ago",
		                                                                    FontAwesome.icon(check, Solid)
		                                                                               .addClass(Text_Success)
		                                                                               .addClass(Border)
		                                                                               .addClass(Border_Success)),
		                                  new ProSidebarFooterCheckedItem<>("Lorem ipsum dolor sit amet consectetur adipisicing elit. In totam explicabo",
		                                                                    "6 minutes ago",
		                                                                    FontAwesome.icon(exclamation_triangle, Solid)
		                                                                               .addClass(Text_Warning)
		                                                                               .addClass(Border)
		                                                                               .addClass(Border_Warning)),
		                                  new ProSidebarFooterCheckedItem<>("Lorem ipsum dolor sit amet consectetur adipisicing elit. In totam explicabo",
		                                                                    "Tomorrow",
		                                                                    FontAwesome.icon(holly_berry, Solid)
		                                                                               .addClass(Text_Danger)
		                                                                               .addClass(Border)
		                                                                               .addClass(Border_Danger)
		                                  ));

		Image img = new Image(imgUrl);
		footer.addMessagesStyleButton(FontAwesome.icon(envelope, Solid),
		                              new BSBadgeSuccess<>(true).setText("7"),
		                              FontAwesome.icon(envelope, Solid),
		                              "Messages",
		                              "View All Messages",
		                              null,
		                              new ProSidebarFooterLabelledItem<>("John",
		                                                                 "Lorem ipsum dolor sit amet consectetur adipisicing elit. In totam explicabo",
		                                                                 img),
		                              new ProSidebarFooterLabelledItem<>("Steven",
		                                                                 "Lorem ipsum dolor sit amet consectetur adipisicing elit. In totam explicabo",
		                                                                 img),
		                              new ProSidebarFooterLabelledItem<>("Adam",
		                                                                 "Lorem ipsum dolor sit amet consectetur adipisicing elit. In totam explicabo",
		                                                                 img)
		                             );


		footer.addDropDown(FontAwesome.icon(cog, Solid),
		                   new ProSidebarPulsatingBadge<>(),
		                   new BSDropDownMenu<>()
				                   .add(new BSDropDownLink<>("My Profile"))
				                   .add(new BSDropDownLink<>("Help"))
				                   .add(new BSDropDownLink<>("Settings"))
		                  );

		footer.addButton(FontAwesome.icon(power_off, Solid), null);

		footer.setPinnedBottom(new ProSidebarFooterPinnedBottom<>().setIcon(FontAwesome.icon(ellipsis_h, Solid)));
	}
}
