package com.jwebmp.plugins.bs4.prosidebar;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

public class ProSidebarModuleInclusion implements IGuiceScanModuleInclusions<ProSidebarModuleInclusion>
{
	@Override
	public @NotNull Set<String> includeModules()
	{
		Set<String> set = new HashSet<>();
		set.add("com.jwebmp.plugins.bs4.prosidebar");
		return set;
	}
}
