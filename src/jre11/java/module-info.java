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
	requires java.validation;

	requires transitive com.jwebmp.plugins.bootstrap4;
	requires transitive com.jwebmp.plugins.malihuscrollbar;

	requires com.google.guice;
	requires io.github.classgraph;

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.bs4.prosidebar.ProSidebarPageConfigurator;
}
