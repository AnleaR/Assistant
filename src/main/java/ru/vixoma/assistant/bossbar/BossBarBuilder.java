package ru.vixoma.assistant.bossbar;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import ru.vixoma.assistant.util.Common;

public class BossBarBuilder {
	public final BossBar bar;

	public BossBarBuilder(final BarColor defaultColor, final BarStyle defaultStyle) {
		this.bar = Bukkit.createBossBar("", defaultColor, defaultStyle);
	}

	public BossBarBuilder title(final String title) {
		bar.setTitle(Common.colorize(title));
		return this;
	}

	public BossBarBuilder color(final BarColor color) {
		this.bar.setColor(color);
		return this;
	}

	public BossBarBuilder style(final BarStyle style) {
		this.bar.setStyle(style);
		return this;
	}

	public BossBarBuilder flag(final BarFlag barFlag) {
		if (this.bar.hasFlag(barFlag)) {
			this.bar.removeFlag(barFlag);
		} else {
			this.bar.addFlag(barFlag);
		}
		return this;
	}

	public BossBarBuilder progress(final double progress) {
		this.bar.setProgress(progress);
		return this;
	}

	public BossBar build() {
		return this.bar;
	}
}
