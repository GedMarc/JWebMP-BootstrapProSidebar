package com.jwebmp.plugins.bs4.prosidebar.parts.search;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.inputs.InputSearchType;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.IIcon;
import com.jwebmp.plugins.bootstrap4.forms.groups.sets.BSFormInputGroup;

import jakarta.validation.constraints.NotNull;

public class ProSidebarSearch<J extends ProSidebarSearch<J>>
		extends DivSimple<J>
{
	private DivSimple<?> containDiv = new DivSimple<>();
	private BSFormInputGroup<?, InputSearchType<?>> inputGroup;

	private String placeHolder;
	private IIcon<?,?> icon;

	public ProSidebarSearch()
	{
		addClass("sidebar-item sidebar-search");
		this.inputGroup = new BSFormInputGroup<>();
		inputGroup.setInput(new InputSearchType<>().addClass("search-menu"));
		super.add(containDiv);
		add(this.inputGroup);
	}

	@Override
	public @NotNull J add(@NotNull GlobalChildren newChild)
	{
		containDiv.add(newChild);
		return (J) this;
	}

	@Override
	public @NotNull J add(@NotNull Integer position, @NotNull GlobalChildren newChild)
	{
		containDiv.add(position, newChild);
		return (J) this;
	}

	@Override
	public boolean remove(GlobalChildren childToRemove)
	{
		return containDiv.remove(childToRemove);
	}

	/**
	 * Getter for property 'inputGroup'.
	 *
	 * @return Value for property 'inputGroup'.
	 */
	public BSFormInputGroup<?, ?> getInputGroup()
	{
		return inputGroup;
	}

	/**
	 * Setter for property 'inputGroup'.
	 *
	 * @param inputGroup
	 * 		Value to set for property 'inputGroup'.
	 */
	public ProSidebarSearch<J> setInputGroup(BSFormInputGroup<?, InputSearchType<?>> inputGroup)
	{
		this.inputGroup = inputGroup;
		return this;
	}

	public InputSearchType<?> getInput()
	{
		return inputGroup.getInput();
	}

	@SuppressWarnings("unchecked")
	public J setSearchInput(InputSearchType<?> searchType)
	{
		inputGroup.setInput(searchType);
		searchType.addClass("search-menu");
		return (J) this;
	}

	/**
	 * Appends an icon
	 *
	 * @param icon
	 * 		The icon to use
	 */
	public ProSidebarSearch<J> appendIcon(IIcon<?,?> icon)
	{
		if (icon != null)
		{
			inputGroup.append(icon.getIconComponent(),true);
		}
		return this;
	}

	/**
	 * Appends an icon
	 *
	 * @param icon
	 * 		The icon to use
	 */
	public ProSidebarSearch<J> prependIcon(IIcon<?,?> icon)
	{
		if (icon != null)
		{
			inputGroup.prepend(icon.getIconComponent());
		}
		return this;
	}
}
