package com.jwebmp.plugins.bs4.prosidebar.enumerations;

import static com.jwebmp.core.utilities.StaticStrings.*;

public enum ProSidebarDefaultThemes implements IProSidebarTheme<ProSidebarDefaultThemes>
{
	Default_Theme,
	Legacy_Theme,
	Chiller_Theme,
	Ice_Theme,
	Cool_Theme,
	Light_Theme;

	@Override
	public String toString()
	{
		return name().toLowerCase()
		             .replace(CHAR_UNDERSCORE, CHAR_DASH);
	}
}
