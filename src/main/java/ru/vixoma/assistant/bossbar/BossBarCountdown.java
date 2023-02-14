package ru.vixoma.assistant.bossbar;

import org.bukkit.boss.BossBar;
import org.bukkit.scheduler.BukkitRunnable;

public class BossBarCountdown extends BukkitRunnable {

	public final BossBar bar;
	public Integer timeLeft;
	public final Integer timeTotal;

	public BossBarCountdown(final BossBar bar, final int times) {
		this.bar = bar;
		this.timeTotal = times;
		this.timeLeft = times;
	}

	@Override
	public void run() {
		if (this.timeLeft > 0) {
			this.bar.setProgress(this.timeLeft / (double) this.timeTotal);
			--this.timeLeft;
		} else {
			this.cancel();
		}
	}
}