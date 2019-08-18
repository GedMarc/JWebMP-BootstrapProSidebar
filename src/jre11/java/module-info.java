module com.jwebmp.plugins.bs4.prosidebar {

	exports com.jwebmp.plugins.bs4.prosidebar;
	exports com.jwebmp.plugins.bs4.prosidebar.features;

	requires com.jwebmp.core;
	requires java.validation;

	requires com.jwebmp.plugins.bootstrap4;
	requires com.jwebmp.plugins.malihuscrollbar;

	requires com.google.guice;

	provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.bs4.prosidebar.ProSidebarPageConfigurator;
}
