package com.jwebmp.plugins.bs4.prosidebar;

import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.interfaces.IReferencePool;

public enum ProSidebarReferences
		implements IReferencePool
{
	ProSidebarReferenceReference(//new JavascriptReference(),
	                             null,
	                             new CSSReference("ProSidebarCSSReference", 1.0d, "bower_components/bootstrapprosidebar/src/css/main.css")),

	ProSidebarDefaultThemesReference(//new JavascriptReference(),
	                             null,
	                             new CSSReference("ProSidebarCSSThemesReference", 1.0d, "bower_components/bootstrapprosidebar/src/css/sidebar-themes.css")),


	;

	/**
	 * The actual javascript
	 */
	private JavascriptReference javaScriptReference;
	/**
	 * The actual css reference
	 */
	private CSSReference cssReference;


	/**
	 * Constructs a new reference pool
	 *
	 * @param javaScriptReference
	 * @param cssReference
	 */
	ProSidebarReferences(JavascriptReference javaScriptReference, CSSReference cssReference)
	{
		this.javaScriptReference = javaScriptReference;
		this.cssReference = cssReference;
	}


	@Override
	public CSSReference getCssReference()
	{
		return cssReference;
	}

	@Override
	public void setCssReference(CSSReference cssReference)
	{
		this.cssReference = cssReference;
	}

	@Override
	public JavascriptReference getJavaScriptReference()
	{
		return javaScriptReference;
	}

	@Override
	public void setJavaScriptReference(JavascriptReference javaScriptReference)
	{
		this.javaScriptReference = javaScriptReference;
	}
}
