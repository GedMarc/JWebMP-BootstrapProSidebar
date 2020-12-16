import com.jwebmp.plugins.bs4.prosidebar.ProSidebarModuleInclusion;

module com.jwebmp.plugins.bs4.prosidebar {

	exports com.jwebmp.plugins.bs4.prosidebar;
	exports com.jwebmp.plugins.bs4.prosidebar.enumerations;
	exports com.jwebmp.plugins.bs4.prosidebar.parts;
	exports com.jwebmp.plugins.bs4.prosidebar.parts.search;
	exports com.jwebmp.plugins.bs4.prosidebar.parts.footer;
	exports com.jwebmp.plugins.bs4.prosidebar.parts.header;
	exports com.jwebmp.plugins.bs4.prosidebar.parts.menu;
	exports com.jwebmp.plugins.bs4.prosidebar.features;

	requires com.jwebmp.core;
	requires jakarta.validation;

	requires transitive com.jwebmp.plugins.bootstrap4;
	requires transitive com.jwebmp.plugins.malihuscrollbar;

	requires com.google.guice;

	opens com.jwebmp.plugins.bs4.prosidebar to com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.bs4.prosidebar.parts to com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.bs4.prosidebar.parts.search to com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.bs4.prosidebar.parts.menu to com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.bs4.prosidebar.parts.header to com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.bs4.prosidebar.parts.footer to com.jwebmp.core, com.google.guice;

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.bs4.prosidebar.ProSidebarPageConfigurator;
	provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with ProSidebarModuleInclusion;
	
}
