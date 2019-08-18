package com.jwebmp.plugins.bs4.prosidebar;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.plugins.fontawesome5.config.FontAwesome5PageConfigurator;
import com.jwebmp.plugins.fontawesome5.config.FontAwesomeReferenceType;
import com.jwebmp.undertow.GuicedUndertow;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

class ProSidebarTest
{

	@Test
	void testHtmlOutput()
	{
		Page<?> p = new Page<>();
		DivSimple<?> divSimple = new DivSimple<>();
		p.getBody()
		 .add(divSimple);
		divSimple.setID("page-wrapper");

		divSimple
				.add(new ProSidebar<>(p.getBody()).setID("sidebar"));

		p.getOptions().setDynamicRender(false);

		System.out.println(p.toString(0));
	}

	public static void main(String[] args) throws Exception
	{
		FontAwesome5PageConfigurator.setFontAwesomeReferenceType(FontAwesomeReferenceType.WebFontCSS);
		FontAwesome5PageConfigurator.setIncludeSolid(true);

		LogFactory.configureConsoleColourOutput(Level.FINE);
		GuicedUndertow.boot("localhost", 9999);
		System.out.println("done");
	}
}