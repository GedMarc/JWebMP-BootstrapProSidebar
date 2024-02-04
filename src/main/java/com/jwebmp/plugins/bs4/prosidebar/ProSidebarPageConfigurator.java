package com.jwebmp.plugins.bs4.prosidebar;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.bs4.prosidebar.enumerations.IProSidebarTheme;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;

import jakarta.validation.constraints.NotNull;
import java.util.Set;
import java.util.TreeSet;

import static com.guicedee.services.jsonrepresentation.json.StaticStrings.STRING_SPACE;
import static com.jwebmp.core.utilities.StaticStrings.*;

@PluginInformation(pluginName = "Bootstrap Pro Sidebar",
		pluginUniqueName = "bootstrap-pro-sidebar",
		pluginDescription = "Responsive sidebar template with dropdown menu based on bootstrap framwork",
		pluginVersion = "3.5.0",
		pluginDependancyUniqueIDs = "bootstrap",
		pluginCategories = "bootstrap, sidebar, menu, navigation",
		pluginSubtitle = "Pro sidebar template",
		pluginGitUrl = "https://github.com/GedMarc/JWebMP-BootstrapProSidebar",
		pluginSourceUrl = "https://github.com/azouaoui-med/pro-sidebar-template",
		pluginWikiUrl = "https://github.com/GedMarc/JWebMP-BootstrapProSidebar/wiki",
		pluginOriginalHomepage = "https://azouaoui-med.github.io/pro-sidebar-template/src/",
		pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins.bootstrap/jwebmp-bootstrap-pro-sidebar",
		pluginIconUrl = "",
		pluginIconImageUrl = "",
		pluginLastUpdatedDate = "2020/12/14",
		pluginArtifactId = "jwebmp-bootstrap-pro-sidebar",
		pluginGroupId = "com.jwebmp.plugins.bootstrap",
		pluginModuleName = "com.jwebmp.plugins.bs4.prosidebar",
		pluginStatus = PluginStatus.Released
)
public class ProSidebarPageConfigurator implements IPageConfigurator<ProSidebarPageConfigurator>
{
	private static boolean enabled = true;

	private static Set<String> availableBackgrounds = new TreeSet<>();
	static {
		availableBackgrounds.add("bg1");
		availableBackgrounds.add("bg2");
		availableBackgrounds.add("bg3");
		availableBackgrounds.add("bg4");
	}
	private static Set<IProSidebarTheme<?>> availableThemes = new TreeSet<>();
	static {
		for (ClassInfo subclass : new ClassGraph().enableAllInfo()
		                                          .enableClassInfo()
		                                          .scan()
		                                          .getClassesImplementing(IProSidebarTheme.class.getCanonicalName()))
		{
			IProSidebarTheme[] en = (IProSidebarTheme[]) subclass.loadClass()
			                                                     .getEnumConstants();
			for (IProSidebarTheme iProSidebarTheme : en)
			{
				availableThemes.add(iProSidebarTheme);
			}
		}
	}

	@Override
	public @NotNull Page<?> configure(Page<?> page)
	{
		JQueryPageConfigurator.setRequired(true);
		
		page.addJavaScriptReference(ProSidebarReferences.ProSidebarReferenceReference.getJavaScriptReference());
		page.addCssReference(ProSidebarReferences.ProSidebarReferenceReference.getCssReference());
		page.addCssReference(ProSidebarReferences.ProSidebarDefaultThemesReference.getCssReference());

		StringBuilder sb = new StringBuilder();
		for (String availableBackground : availableBackgrounds)
		{
			sb.append(availableBackground)
			  .append(STRING_SPACE);
		}

		page.addVariable("bgs = \"" + sb.toString() + "\"");
		sb = new StringBuilder();
		for (IProSidebarTheme<?> availableTheme : availableThemes)
		{
			sb.append(availableTheme)
			  .append(STRING_SPACE);
		}
		page.addVariable("sidebar_themes = \"" + sb.toString() + "\"");

		return page;
	}

	@Override
	public boolean enabled()
	{
		return enabled;
	}

	public static boolean isEnabled()
	{
		return enabled;
	}

	public static void setEnabled(boolean enabled)
	{
		ProSidebarPageConfigurator.enabled = enabled;
	}

	public static Set<String> getAvailableBackgrounds()
	{
		return availableBackgrounds;
	}

	public static void setAvailableBackgrounds(Set<String> availableBackgrounds)
	{
		ProSidebarPageConfigurator.availableBackgrounds = availableBackgrounds;
	}

	public static Set<IProSidebarTheme<?>> getAvailableThemes()
	{
		return availableThemes;
	}

	public static void setAvailableThemes(Set<IProSidebarTheme<?>> availableThemes)
	{
		ProSidebarPageConfigurator.availableThemes = availableThemes;
	}
}
