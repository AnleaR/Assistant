package ru.vixoma.assistant;

import lombok.Getter;
import org.mineacademy.fo.plugin.SimplePlugin;

public final class AssistantPlugin extends SimplePlugin {

	@Getter
	public static AssistantPlugin Instance;

	@Override
	protected void onPluginStart() {
		
	}

	@Override
	protected void onReloadablesStart() {
		Instance = this;
		getLogger().info("Assistant API is loaded.");
	}
}
