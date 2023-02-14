package ru.vixoma.assistant.util;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.boss.BossBar;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.vixoma.assistant.AssistantPlugin;
import ru.vixoma.assistant.bossbar.BossBarCountdown;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
	public static final Pattern hexPattern;
	public static final Pattern gradientPattern;
	public static final Pattern rainbowPattern;
	public static Map<Integer, String> alphabet;

	static {
		Common.alphabet = new HashMap<>();
		hexPattern = Pattern.compile("&#[a-fA-F0-9]{6}");
		gradientPattern = Pattern.compile("&#g.[a-fA-F0-9]{6}.[a-fA-F0-9]{6}");
		rainbowPattern = Pattern.compile("&#r");
		Common.alphabet.put(0, "0");
		Common.alphabet.put(1, "1");
		Common.alphabet.put(2, "2");
		Common.alphabet.put(3, "3");
		Common.alphabet.put(4, "4");
		Common.alphabet.put(5, "5");
		Common.alphabet.put(6, "6");
		Common.alphabet.put(7, "7");
		Common.alphabet.put(8, "8");
		Common.alphabet.put(9, "9");
		Common.alphabet.put(11, "%");
		Common.alphabet.put(12, "@");
		Common.alphabet.put(13, "#");
		Common.alphabet.put(14, "$");
		Common.alphabet.put(15, "!");
		Common.alphabet.put(16, "?");
		Common.alphabet.put(17, "*");
		Common.alphabet.put(18, "<");
		Common.alphabet.put(19, ">");
		Common.alphabet.put(20, "~");
		Common.alphabet.put(21, "A");
		Common.alphabet.put(22, "B");
		Common.alphabet.put(23, "C");
		Common.alphabet.put(24, "D");
		Common.alphabet.put(25, "E");
		Common.alphabet.put(26, "F");
		Common.alphabet.put(27, "G");
		Common.alphabet.put(28, "H");
		Common.alphabet.put(29, "I");
		Common.alphabet.put(30, "J");
		Common.alphabet.put(31, "K");
		Common.alphabet.put(32, "L");
		Common.alphabet.put(33, "M");
		Common.alphabet.put(34, "N");
		Common.alphabet.put(35, "O");
		Common.alphabet.put(36, "P");
		Common.alphabet.put(37, "Q");
		Common.alphabet.put(38, "R");
		Common.alphabet.put(39, "S");
		Common.alphabet.put(40, "T");
		Common.alphabet.put(41, "U");
		Common.alphabet.put(42, "V");
		Common.alphabet.put(43, "W");
		Common.alphabet.put(44, "X");
		Common.alphabet.put(45, "Y");
		Common.alphabet.put(46, "Z");
		Common.alphabet.put(47, "a");
		Common.alphabet.put(48, "b");
		Common.alphabet.put(49, "c");
		Common.alphabet.put(50, "d");
		Common.alphabet.put(51, "e");
		Common.alphabet.put(52, "f");
		Common.alphabet.put(53, "g");
		Common.alphabet.put(54, "h");
		Common.alphabet.put(55, "i");
		Common.alphabet.put(56, "j");
		Common.alphabet.put(57, "k");
		Common.alphabet.put(58, "l");
		Common.alphabet.put(59, "m");
		Common.alphabet.put(60, "n");
		Common.alphabet.put(61, "o");
		Common.alphabet.put(62, "p");
		Common.alphabet.put(63, "q");
		Common.alphabet.put(64, "r");
		Common.alphabet.put(65, "s");
		Common.alphabet.put(66, "t");
		Common.alphabet.put(67, "u");
		Common.alphabet.put(68, "v");
		Common.alphabet.put(69, "w");
		Common.alphabet.put(70, "x");
		Common.alphabet.put(71, "y");
		Common.alphabet.put(72, "z");
		Common.alphabet.put(73, "А");
		Common.alphabet.put(74, "Б");
		Common.alphabet.put(75, "В");
		Common.alphabet.put(76, "Г");
		Common.alphabet.put(77, "Д");
		Common.alphabet.put(78, "Е");
		Common.alphabet.put(79, "Ё");
		Common.alphabet.put(80, "Ж");
		Common.alphabet.put(81, "З");
		Common.alphabet.put(82, "И");
		Common.alphabet.put(83, "Й");
		Common.alphabet.put(84, "К");
		Common.alphabet.put(85, "Л");
		Common.alphabet.put(86, "М");
		Common.alphabet.put(87, "Н");
		Common.alphabet.put(88, "О");
		Common.alphabet.put(89, "П");
		Common.alphabet.put(90, "Р");
		Common.alphabet.put(91, "С");
		Common.alphabet.put(92, "Т");
		Common.alphabet.put(93, "У");
		Common.alphabet.put(94, "Ф");
		Common.alphabet.put(95, "Х");
		Common.alphabet.put(96, "Ц");
		Common.alphabet.put(97, "Ч");
		Common.alphabet.put(98, "Ш");
		Common.alphabet.put(99, "Щ");
		Common.alphabet.put(100, "Ъ");
		Common.alphabet.put(101, "Ы");
		Common.alphabet.put(102, "Ь");
		Common.alphabet.put(103, "Э");
		Common.alphabet.put(104, "Ю");
		Common.alphabet.put(105, "Я");
		Common.alphabet.put(106, "а");
		Common.alphabet.put(107, "б");
		Common.alphabet.put(108, "в");
		Common.alphabet.put(109, "г");
		Common.alphabet.put(110, "д");
		Common.alphabet.put(111, "е");
		Common.alphabet.put(112, "ё");
		Common.alphabet.put(113, "ж");
		Common.alphabet.put(114, "з");
		Common.alphabet.put(115, "и");
		Common.alphabet.put(116, "й");
		Common.alphabet.put(117, "к");
		Common.alphabet.put(118, "л");
		Common.alphabet.put(119, "м");
		Common.alphabet.put(120, "н");
		Common.alphabet.put(121, "о");
		Common.alphabet.put(122, "п");
		Common.alphabet.put(123, "р");
		Common.alphabet.put(124, "с");
		Common.alphabet.put(125, "т");
		Common.alphabet.put(126, "у");
		Common.alphabet.put(127, "ф");
		Common.alphabet.put(128, "х");
		Common.alphabet.put(129, "ц");
		Common.alphabet.put(130, "ч");
		Common.alphabet.put(131, "ш");
		Common.alphabet.put(132, "щ");
		Common.alphabet.put(133, "ъ");
		Common.alphabet.put(134, "ы");
		Common.alphabet.put(135, "ь");
		Common.alphabet.put(136, "э");
		Common.alphabet.put(137, "ю");
		Common.alphabet.put(138, "я");
		Common.alphabet.put(139, "&");
		Common.alphabet.put(140, "(");
		Common.alphabet.put(141, ")");
		Common.alphabet.put(142, "[");
		Common.alphabet.put(143, "]");
		Common.alphabet.put(144, ",");
		Common.alphabet.put(145, ".");
		Common.alphabet.put(146, "/");
		Common.alphabet.put(147, ";");
		Common.alphabet.put(148, "'");
		Common.alphabet.put(149, "^");
		Common.alphabet.put(150, "=");
		Common.alphabet.put(151, "+");
		Common.alphabet.put(152, "-");
		Common.alphabet.put(153, " ");
	}

	public static String colorize(String message) {
		message = replaceSpecialSymbols(message);
		for (Matcher matcher = Common.rainbowPattern.matcher(message); matcher.find(); matcher = Common.rainbowPattern.matcher(message)) {
			final int start = matcher.start();
			final int end = matcher.end();
			String text = message.substring(end);
			int next = message.length();
			String style = "";
			while (text.length() >= 2) {
				if (text.charAt(0) == '&') {
					if (!isStyle(text.substring(0, 2))) {
						break;
					}
					style += text.substring(0, 2);
					final int nextSymbol = text.replaceFirst("&", " ").indexOf("&");
					if (nextSymbol == -1) {
						text = message.substring(end + style.length());
					} else {
						text = text.substring(2);
					}
				} else {
					if (text.contains("&")) {
						next = end + text.indexOf("&");
						text = message.substring(end, next);
						break;
					}
					break;
				}
			}
			message = message.replace(message.substring(start, next), rainbow(text, style));
		}
		for (Matcher matcher = Common.gradientPattern.matcher(message); matcher.find(); matcher = Common.gradientPattern.matcher(message)) {
			final int start = matcher.start();
			final int end = matcher.end();
			final String color = message.substring(start, end);
			String text2 = message.substring(end);
			int next2 = message.length();
			String style2 = "";
			while (text2.length() >= 2) {
				if (text2.charAt(0) == '&') {
					if (!isStyle(text2.substring(0, 2))) {
						break;
					}
					style2 += text2.substring(0, 2);
					final int nextSymbol2 = text2.replaceFirst("&", " ").indexOf("&");
					if (nextSymbol2 == -1) {
						text2 = message.substring(end + style2.length());
					} else {
						text2 = text2.substring(2);
					}
				} else {
					if (text2.contains("&")) {
						next2 = end + text2.indexOf("&");
						text2 = message.substring(end, next2);
						break;
					}
					break;
				}
			}
			final String fromHex = color.substring(4, 10);
			final String toHex = color.substring(11, 17);
			message = message.replace(message.substring(start, next2), gradient(fromHex, toHex, text2, style2));
		}
		for (Matcher matcher = Common.hexPattern.matcher(message); matcher.find(); matcher = Common.hexPattern.matcher(message)) {
			final String color2 = message.substring(matcher.start(), matcher.end());
			message = message.replace(color2, ChatColor.of(color2.substring(1)) + "");
		}
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public static String withOutColors(String message) {
		for (Matcher matcher = Common.rainbowPattern.matcher(message); matcher.find(); matcher = Common.rainbowPattern.matcher(message)) {
			final int start = matcher.start();
			final int end = matcher.end();
			message = message.replace(message.substring(start, end), "");
		}
		for (Matcher matcher = Common.gradientPattern.matcher(message); matcher.find(); matcher = Common.gradientPattern.matcher(message)) {
			final int start = matcher.start();
			final int end = matcher.end();
			message = message.replace(message.substring(start, end), "");
		}
		for (Matcher matcher = Common.hexPattern.matcher(message); matcher.find(); matcher = Common.hexPattern.matcher(message)) {
			final int start = matcher.start();
			final int end = matcher.end();
			message = message.replace(message.substring(start, end), "");
		}
		while (message.contains("&")) {
			final int i = message.indexOf("&");
			message = message.replace(message.substring(i, i + 2), "");
		}
		return message;
	}

	public static Color hexToRgb(final String hex) throws IndexOutOfBoundsException {
		return new Color(Integer.valueOf(hex.substring(0, 2), 16), Integer.valueOf(hex.substring(2, 4), 16), Integer.valueOf(hex.substring(4, 6), 16));
	}

	public static String rgbToHex(final Color rgb) throws IndexOutOfBoundsException {
		final int red = rgb.getRed();
		final int green = rgb.getGreen();
		final int blue = rgb.getBlue();
		final Color color = new Color(red, green, blue);
		final StringBuilder hex = new StringBuilder(Integer.toHexString(color.getRGB() & 0xFFFFFF));
		while (hex.length() < 6) {
			hex.insert(0, "0");
		}
		return hex.toString();
	}

	public static String gradient(final String fromHEX, final String toHEX, final String message, final String style) {
		final Color from = hexToRgb(fromHEX);
		final Color to = hexToRgb(toHEX);
		final int length = message.length();
		if (length == 0) {
			return "";
		}
		final Map<Integer, Color> rgbMap = new HashMap<>();
		final int fromRed = from.getRed();
		final int fromGreen = from.getGreen();
		final int fromBlue = from.getBlue();
		int differenceRed = to.getRed() - fromRed;
		int differenceGreen = to.getGreen() - fromGreen;
		int differenceBlue = to.getBlue() - fromBlue;
		differenceRed = ((differenceRed == 0) ? 0 : (differenceRed / length));
		differenceGreen = ((differenceGreen == 0) ? 0 : (differenceGreen / length));
		differenceBlue = ((differenceBlue == 0) ? 0 : (differenceBlue / length));
		for (int i = 0; i < length; ++i) {
			final Color color = new Color(fromRed + differenceRed * i, fromGreen + differenceGreen * i, fromBlue + differenceBlue * i);
			rgbMap.put(i, color);
		}
		final Map<Integer, String> hexMap = new HashMap<>();
		for (int j = 0; j < rgbMap.size(); ++j) {
			hexMap.put(j, rgbToHex(rgbMap.get(j)));
		}
		final StringBuilder stringBuilder = new StringBuilder();
		for (int k = 0; k < hexMap.size(); ++k) {
			stringBuilder.append("&#").append(hexMap.get(k)).append(style).append(message.charAt(k));
		}
		return stringBuilder.toString();
	}

	public static String rainbow(String message, final String style) {
		boolean endsWithSpace = false;
		final StringBuilder spaces = new StringBuilder();
		if (message.endsWith(" ")) {
			endsWithSpace = true;
			spaces.append(" ");
			for (int i = 2; i < message.length() && message.substring(0, message.length() - i).endsWith(" "); ++i) {
				spaces.append(" ");
			}
		}
		boolean spaceAdded = false;
		int length = message.length();
		if (length < 7) {
			final StringBuilder messageBuilder = new StringBuilder(message);
			for (int j = 7 - length; j > 0; --j) {
				messageBuilder.append(" ");
			}
			message = messageBuilder.toString();
			spaceAdded = true;
		}
		length = message.length();
		final List<String> strings = new ArrayList<>();
		int ratio;
		for (int divider = 7; !message.equals(""); message = message.replaceFirst(message.substring(0, ratio), ""), length = message.length(), --divider) {
			ratio = length / divider;
			strings.add(message.substring(0, ratio));
		}
		final List<String> finalStrings = new ArrayList<>();
		if (!strings.get(0).equals(" ") || !spaceAdded) {
			finalStrings.add(gradient("fa0505", "f79c14", strings.get(0), style));
		}
		if (!strings.get(1).equals(" ") || !spaceAdded) {
			finalStrings.add(gradient("f79c14", "f4f711", strings.get(1), style));
		}
		if (!strings.get(2).equals(" ") || !spaceAdded) {
			finalStrings.add(gradient("f4f711", "24f711", strings.get(2), style));
		}
		if (!strings.get(3).equals(" ") || !spaceAdded) {
			finalStrings.add(gradient("24f711", "0afafa", strings.get(3), style));
		}
		if (!strings.get(4).equals(" ") || !spaceAdded) {
			finalStrings.add(gradient("0afafa", "284bfa", strings.get(4), style));
		}
		if (!strings.get(5).equals(" ") || !spaceAdded) {
			finalStrings.add(gradient("284bfa", "7b07f0", strings.get(5), style));
		}
		if (!strings.get(6).equals(" ") || !spaceAdded) {
			finalStrings.add(gradient("7b07f0", "fa0505", strings.get(6), style));
		}
		final StringBuilder stringBuilder = new StringBuilder();
		for (final String finalString : finalStrings) {
			stringBuilder.append(finalString);
		}
		String result = stringBuilder.toString().trim();
		if (!result.equals("") && result.charAt(result.length() - 1) == ' ') {
			result = result.substring(0, result.length() - 1);
		}
		return endsWithSpace ? (result + (Object) spaces) : result;
	}

	public static boolean isStyle(final String str) {
		return str.startsWith("&") && (str.equals("&r") || str.equals("&l") || str.equals("&o") || str.equals("&n") || str.equals("&m") || str.equals("&k"));
	}

	public static String replaceSpecialSymbols(String message) {
		if (message.contains(":)")) {
			message = message.replaceAll(":\\)", "\u263a");
		}
		if (message.contains(":(")) {
			message = message.replaceAll(":\\(", "\u2639");
		}
		if (message.contains("<3")) {
			message = message.replaceAll("<3", "\u2764");
		}
		if (message.contains("-_-")) {
			message = message.replaceAll("-_-", "\u0ca0_\u0ca0");
		}
		if (message.contains("*-*")) {
			message = message.replaceAll("\\*-\\*", "\u271e");
		}
		if (message.contains("^-^")) {
			message = message.replaceAll("\\^-\\^", "\u273f");
		}
		return message;
	}

	public static int getMessageLengthWithoutColor(String message) {
		int length = 0;
		Matcher rainbowMatcher = Common.rainbowPattern.matcher(message);
		Matcher gradientMatcher = Common.gradientPattern.matcher(message);
		Matcher hexMatcher = Common.hexPattern.matcher(message);
		while (rainbowMatcher.find()) {
			final String color = message.substring(rainbowMatcher.start(), rainbowMatcher.end());
			message = message.replace(color, "");
			rainbowMatcher = Common.rainbowPattern.matcher(message);
			length = message.length();
		}
		while (gradientMatcher.find()) {
			final String color = message.substring(gradientMatcher.start(), gradientMatcher.end());
			message = message.replace(color, "");
			gradientMatcher = Common.gradientPattern.matcher(message);
			length = message.length();
		}
		while (hexMatcher.find()) {
			final String color = message.substring(hexMatcher.start(), hexMatcher.end());
			message = message.replace(color, "");
			hexMatcher = Common.hexPattern.matcher(message);
			length = message.length();
		}
		while (message.contains("&")) {
			final String color = message.substring(message.indexOf("&"), message.indexOf("&") + 1);
			message = message.replace(color, "");
			length = message.length();
		}
		return length;
	}

	public static boolean containsNonAlphabetSymbols(final String message) {
		for (int i = 0; i < message.length(); ++i) {
			if (!Common.alphabet.containsValue(String.valueOf(message.charAt(i)))) {
				return true;
			}
		}
		return false;
	}

	public static String getColorRussianName(final org.bukkit.ChatColor color) {
		switch (color) {
			case AQUA -> {
				return "Голубой";
			}
			case BLACK -> {
				return "Чёрный";
			}
			case BLUE -> {
				return "Синий";
			}
			case DARK_AQUA -> {
				return "Бирюзовый";
			}
			case DARK_BLUE -> {
				return "Тёмно-синий";
			}
			case DARK_GRAY -> {
				return "Тёмно-серый";
			}
			case DARK_GREEN -> {
				return "Тёмно-зелёный";
			}
			case DARK_PURPLE -> {
				return "Фиолетовый";
			}
			case DARK_RED -> {
				return "Тёмно-красный";
			}
			case GOLD -> {
				return "Золотой";
			}
			case GRAY -> {
				return "Серый";
			}
			case GREEN -> {
				return "Зелёный";
			}
			case LIGHT_PURPLE -> {
				return "Пурпурный";
			}
			case RED -> {
				return "Красный";
			}
			case WHITE -> {
				return "Белый";
			}
			case YELLOW -> {
				return "Жёлтый";
			}
			default -> {
				return null;
			}
		}
	}

	public static String getFullFormatedStringTime(int seconds) {
		final StringBuilder stringBuilder = new StringBuilder();
		if (seconds >= 2592000) {
			stringBuilder.append(getMonths(seconds)).append(" мес. ");
			seconds -= 2592000 * getMonths(seconds);
			if (seconds >= 604800) {
				stringBuilder.append(getWeeks(seconds)).append(" нед. ");
				seconds -= 604800 * getWeeks(seconds);
			}
			if (seconds >= 86400) {
				stringBuilder.append(getDays(seconds)).append(" дн. ");
				seconds -= 86400 * getDays(seconds);
			}
			if (seconds >= 3600) {
				stringBuilder.append(getHours(seconds)).append(" ч. ");
				seconds -= 3600 * getHours(seconds);
			}
			if (seconds >= 60) {
				stringBuilder.append(getMinutes(seconds)).append(" мин. ");
				seconds -= 60 * getMinutes(seconds);
			}
			if (seconds != 0) {
				stringBuilder.append(seconds).append(" сек.");
			}
		} else if (seconds >= 604800) {
			stringBuilder.append(getWeeks(seconds)).append(" нед. ");
			seconds -= 604800 * getWeeks(seconds);
			if (seconds >= 86400) {
				stringBuilder.append(getDays(seconds)).append(" дн. ");
				seconds -= 86400 * getDays(seconds);
			}
			if (seconds >= 3600) {
				stringBuilder.append(getHours(seconds)).append(" ч. ");
				seconds -= 3600 * getHours(seconds);
			}
			if (seconds >= 60) {
				stringBuilder.append(getMinutes(seconds)).append(" мин. ");
				seconds -= 60 * getMinutes(seconds);
			}
			if (seconds != 0) {
				stringBuilder.append(seconds).append(" сек.");
			}
		} else if (seconds >= 86400) {
			stringBuilder.append(getDays(seconds)).append(" дн. ");
			seconds -= 86400 * getDays(seconds);
			if (seconds >= 3600) {
				stringBuilder.append(getHours(seconds)).append(" ч. ");
				seconds -= 3600 * getHours(seconds);
			}
			if (seconds >= 60) {
				stringBuilder.append(getMinutes(seconds)).append(" мин. ");
				seconds -= 60 * getMinutes(seconds);
			}
			if (seconds != 0) {
				stringBuilder.append(seconds).append(" сек. ");
			}
		} else if (seconds >= 3600) {
			stringBuilder.append(getHours(seconds)).append(" ч. ");
			seconds -= 3600 * getHours(seconds);
			if (seconds >= 60) {
				stringBuilder.append(getMinutes(seconds)).append(" мин. ");
				seconds -= 60 * getMinutes(seconds);
			}
			if (seconds != 0) {
				stringBuilder.append(seconds).append(" сек.");
			}
		} else if (seconds >= 60) {
			stringBuilder.append(getMinutes(seconds)).append(" мин. ");
			seconds -= 60 * getMinutes(seconds);
			if (seconds != 0) {
				stringBuilder.append(seconds).append(" сек.");
			}
		} else {
			stringBuilder.append(seconds).append(" сек.");
		}
		return stringBuilder.toString();
	}

	public static int getMonths(final int seconds) {
		return seconds / 2592000;
	}

	public static int getWeeks(final int seconds) {
		return seconds / 604800;
	}

	public static int getDays(final int seconds) {
		return seconds / 86400;
	}

	public static int getHours(final int seconds) {
		return seconds / 3600;
	}

	public static int getMinutes(final int seconds) {
		return seconds / 60;
	}

	public static List<Player> getOnlinePlayers() {
		return new ArrayList<>(Bukkit.getOnlinePlayers());
	}

	public static List<Player> getOfflinePlayers() {
		final List<Player> players = new ArrayList<>();
		for (final OfflinePlayer player : Bukkit.getOfflinePlayers()) {
			players.add(player.getPlayer());
		}
		return players;
	}

	public static List<Player> getAllPlayers() {
		final List<Player> players = getOnlinePlayers();
		players.addAll(getOfflinePlayers());
		return players;
	}

	public static void sendMessages(final Player player, final String... messages) {
		for (final String message : messages) {
			player.sendMessage(colorize(message));
		}
	}

	public static void sendMessages(final CommandSender sender, final String... messages) {
		for (final String message : messages) {
			sender.sendMessage(colorize(message));
		}
	}

	public static void sendTitle(final Player player, final String mainString, final String underString) {
		player.sendTitle(colorize(mainString), colorize(underString), 10, 60, 10);
	}

	public static void sendTitle(final Player player, final String mainString, final String underString, final int fadeIn, final int stay, final int fadeOut) {
		player.sendTitle(colorize(mainString), colorize(underString), fadeIn, stay, fadeOut);
	}

	public static void sendActionBar(final Player player, final String message) {
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(colorize(message)));
	}

	public static void sendGlobalBossBar(final BossBar bar, final int time) {
		Bukkit.getOnlinePlayers().forEach(player -> {
			bar.setTitle(PlaceholderAPI.setPlaceholders(player, bar.getTitle()));
			bar.addPlayer(player);
		});
		new BossBarCountdown(bar, time).runTaskTimer(AssistantPlugin.getInstance(), 0L, 20L);
		AssistantPlugin.getInstance().getServer().getScheduler()
				.runTaskLater(AssistantPlugin.getInstance(), bar::removeAll, time * 20L);
	}

	public static void sendBossBar(final BossBar bar, final int time, final Player player) {
		bar.setTitle(PlaceholderAPI.setPlaceholders(player, bar.getTitle()));
		bar.addPlayer(player);
		new BossBarCountdown(bar, time).runTaskTimer(AssistantPlugin.getInstance(), 0L, 20L);
		AssistantPlugin.getInstance().getServer().getScheduler()
				.runTaskLater(AssistantPlugin.getInstance(), bar::removeAll, time * 20L);
	}
}