package ru.vixoma.assistant.util;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class TextBuilder {
	public TextComponent textComponent;
	public TextComponent currentTextComponent;

	public TextBuilder(final String text) {
		this.textComponent = new TextComponent(Common.colorize(text));
		this.currentTextComponent = this.textComponent;
	}

	public TextBuilder(final TextComponent textComponent) {
		this.textComponent = textComponent;
		this.currentTextComponent = textComponent;
	}

	public TextBuilder addHover(final HoverEvent hoverEvent) {
		this.currentTextComponent.setHoverEvent(hoverEvent);
		return this;
	}

	public TextBuilder addClick(final ClickEvent clickEvent) {
		this.currentTextComponent.setClickEvent(clickEvent);
		return this;
	}

	public TextBuilder addText(final String text) {
		this.textComponent.addExtra(this.currentTextComponent);
		this.currentTextComponent = new TextComponent(Common.colorize(text));
		return this;
	}

	public TextBuilder addTextComponent(final TextComponent textComponent) {
		if (!textComponent.equals(currentTextComponent)) {
			textComponent.addExtra(currentTextComponent);
		}
		this.currentTextComponent = textComponent;
		return this;
	}

	/**
	 * Sets simple color for Current TextComponent
	 *
	 * @param color - minecraft color without "&"
	 */
	public TextBuilder setColor(final String color) {
		this.currentTextComponent.setColor(ChatColor.of(color));
		return this;
	}

	/**
	 * Sets hex color for Current TextComponent
	 *
	 * @param hex - hex color without "#"
	 */
	public TextBuilder setHex(final String hex) {
		this.currentTextComponent.setColor(ChatColor.of("#" + hex));
		return this;
	}

	public TextBuilder setBold(final boolean bold) {
		currentTextComponent.setBold(bold);
		return this;
	}

	public TextBuilder setItalic(final boolean italic) {
		currentTextComponent.setItalic(italic);
		return this;
	}

	public TextBuilder setStrikethrough(final boolean strikethrough) {
		currentTextComponent.setStrikethrough(strikethrough);
		return this;
	}

	public TextBuilder setUnderlined(final boolean underlined) {
		currentTextComponent.setUnderlined(underlined);
		return this;
	}

	public TextBuilder setObfuscated(final boolean obfuscated) {
		currentTextComponent.setObfuscated(obfuscated);
		return this;
	}

	public TextComponent build() {
		if (!this.textComponent.equals(currentTextComponent)) {
			this.textComponent.addExtra(currentTextComponent);
		}
		return this.textComponent;
	}
}