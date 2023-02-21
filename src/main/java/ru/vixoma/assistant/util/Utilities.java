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

import static net.md_5.bungee.api.ChatColor.*;

public class Utilities {
	public static final Pattern hexPattern;
	public static final Pattern gradientPattern;
	public static final Pattern rainbowPattern;
	public static Map<Integer, String> alphabet;

	static {
		Utilities.alphabet = new HashMap<>();
		hexPattern = Pattern.compile("&#[a-fA-F0-9]{6}");
		gradientPattern = Pattern.compile("&#g.[a-fA-F0-9]{6}.[a-fA-F0-9]{6}");
		rainbowPattern = Pattern.compile("&#r");
		Utilities.alphabet.put(0, "0");
		Utilities.alphabet.put(1, "1");
		Utilities.alphabet.put(2, "2");
		Utilities.alphabet.put(3, "3");
		Utilities.alphabet.put(4, "4");
		Utilities.alphabet.put(5, "5");
		Utilities.alphabet.put(6, "6");
		Utilities.alphabet.put(7, "7");
		Utilities.alphabet.put(8, "8");
		Utilities.alphabet.put(9, "9");
		Utilities.alphabet.put(11, "%");
		Utilities.alphabet.put(12, "@");
		Utilities.alphabet.put(13, "#");
		Utilities.alphabet.put(14, "$");
		Utilities.alphabet.put(15, "!");
		Utilities.alphabet.put(16, "?");
		Utilities.alphabet.put(17, "*");
		Utilities.alphabet.put(18, "<");
		Utilities.alphabet.put(19, ">");
		Utilities.alphabet.put(20, "~");
		Utilities.alphabet.put(21, "A");
		Utilities.alphabet.put(22, "B");
		Utilities.alphabet.put(23, "C");
		Utilities.alphabet.put(24, "D");
		Utilities.alphabet.put(25, "E");
		Utilities.alphabet.put(26, "F");
		Utilities.alphabet.put(27, "G");
		Utilities.alphabet.put(28, "H");
		Utilities.alphabet.put(29, "I");
		Utilities.alphabet.put(30, "J");
		Utilities.alphabet.put(31, "K");
		Utilities.alphabet.put(32, "L");
		Utilities.alphabet.put(33, "M");
		Utilities.alphabet.put(34, "N");
		Utilities.alphabet.put(35, "O");
		Utilities.alphabet.put(36, "P");
		Utilities.alphabet.put(37, "Q");
		Utilities.alphabet.put(38, "R");
		Utilities.alphabet.put(39, "S");
		Utilities.alphabet.put(40, "T");
		Utilities.alphabet.put(41, "U");
		Utilities.alphabet.put(42, "V");
		Utilities.alphabet.put(43, "W");
		Utilities.alphabet.put(44, "X");
		Utilities.alphabet.put(45, "Y");
		Utilities.alphabet.put(46, "Z");
		Utilities.alphabet.put(47, "a");
		Utilities.alphabet.put(48, "b");
		Utilities.alphabet.put(49, "c");
		Utilities.alphabet.put(50, "d");
		Utilities.alphabet.put(51, "e");
		Utilities.alphabet.put(52, "f");
		Utilities.alphabet.put(53, "g");
		Utilities.alphabet.put(54, "h");
		Utilities.alphabet.put(55, "i");
		Utilities.alphabet.put(56, "j");
		Utilities.alphabet.put(57, "k");
		Utilities.alphabet.put(58, "l");
		Utilities.alphabet.put(59, "m");
		Utilities.alphabet.put(60, "n");
		Utilities.alphabet.put(61, "o");
		Utilities.alphabet.put(62, "p");
		Utilities.alphabet.put(63, "q");
		Utilities.alphabet.put(64, "r");
		Utilities.alphabet.put(65, "s");
		Utilities.alphabet.put(66, "t");
		Utilities.alphabet.put(67, "u");
		Utilities.alphabet.put(68, "v");
		Utilities.alphabet.put(69, "w");
		Utilities.alphabet.put(70, "x");
		Utilities.alphabet.put(71, "y");
		Utilities.alphabet.put(72, "z");
		Utilities.alphabet.put(73, "А");
		Utilities.alphabet.put(74, "Б");
		Utilities.alphabet.put(75, "В");
		Utilities.alphabet.put(76, "Г");
		Utilities.alphabet.put(77, "Д");
		Utilities.alphabet.put(78, "Е");
		Utilities.alphabet.put(79, "Ё");
		Utilities.alphabet.put(80, "Ж");
		Utilities.alphabet.put(81, "З");
		Utilities.alphabet.put(82, "И");
		Utilities.alphabet.put(83, "Й");
		Utilities.alphabet.put(84, "К");
		Utilities.alphabet.put(85, "Л");
		Utilities.alphabet.put(86, "М");
		Utilities.alphabet.put(87, "Н");
		Utilities.alphabet.put(88, "О");
		Utilities.alphabet.put(89, "П");
		Utilities.alphabet.put(90, "Р");
		Utilities.alphabet.put(91, "С");
		Utilities.alphabet.put(92, "Т");
		Utilities.alphabet.put(93, "У");
		Utilities.alphabet.put(94, "Ф");
		Utilities.alphabet.put(95, "Х");
		Utilities.alphabet.put(96, "Ц");
		Utilities.alphabet.put(97, "Ч");
		Utilities.alphabet.put(98, "Ш");
		Utilities.alphabet.put(99, "Щ");
		Utilities.alphabet.put(100, "Ъ");
		Utilities.alphabet.put(101, "Ы");
		Utilities.alphabet.put(102, "Ь");
		Utilities.alphabet.put(103, "Э");
		Utilities.alphabet.put(104, "Ю");
		Utilities.alphabet.put(105, "Я");
		Utilities.alphabet.put(106, "а");
		Utilities.alphabet.put(107, "б");
		Utilities.alphabet.put(108, "в");
		Utilities.alphabet.put(109, "г");
		Utilities.alphabet.put(110, "д");
		Utilities.alphabet.put(111, "е");
		Utilities.alphabet.put(112, "ё");
		Utilities.alphabet.put(113, "ж");
		Utilities.alphabet.put(114, "з");
		Utilities.alphabet.put(115, "и");
		Utilities.alphabet.put(116, "й");
		Utilities.alphabet.put(117, "к");
		Utilities.alphabet.put(118, "л");
		Utilities.alphabet.put(119, "м");
		Utilities.alphabet.put(120, "н");
		Utilities.alphabet.put(121, "о");
		Utilities.alphabet.put(122, "п");
		Utilities.alphabet.put(123, "р");
		Utilities.alphabet.put(124, "с");
		Utilities.alphabet.put(125, "т");
		Utilities.alphabet.put(126, "у");
		Utilities.alphabet.put(127, "ф");
		Utilities.alphabet.put(128, "х");
		Utilities.alphabet.put(129, "ц");
		Utilities.alphabet.put(130, "ч");
		Utilities.alphabet.put(131, "ш");
		Utilities.alphabet.put(132, "щ");
		Utilities.alphabet.put(133, "ъ");
		Utilities.alphabet.put(134, "ы");
		Utilities.alphabet.put(135, "ь");
		Utilities.alphabet.put(136, "э");
		Utilities.alphabet.put(137, "ю");
		Utilities.alphabet.put(138, "я");
		Utilities.alphabet.put(139, "&");
		Utilities.alphabet.put(140, "(");
		Utilities.alphabet.put(141, ")");
		Utilities.alphabet.put(142, "[");
		Utilities.alphabet.put(143, "]");
		Utilities.alphabet.put(144, ",");
		Utilities.alphabet.put(145, ".");
		Utilities.alphabet.put(146, "/");
		Utilities.alphabet.put(147, ";");
		Utilities.alphabet.put(148, "'");
		Utilities.alphabet.put(149, "^");
		Utilities.alphabet.put(150, "=");
		Utilities.alphabet.put(151, "+");
		Utilities.alphabet.put(152, "-");
		Utilities.alphabet.put(153, " ");
	}

	public static String colorize(String message) {
		message = replaceSpecialSymbols(message);
		for (Matcher matcher = Utilities.rainbowPattern.matcher(message); matcher.find(); matcher = Utilities.rainbowPattern.matcher(message)) {
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
		for (Matcher matcher = Utilities.gradientPattern.matcher(message); matcher.find(); matcher = Utilities.gradientPattern.matcher(message)) {
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
		for (Matcher matcher = Utilities.hexPattern.matcher(message); matcher.find(); matcher = Utilities.hexPattern.matcher(message)) {
			final String color2 = message.substring(matcher.start(), matcher.end());
			message = message.replace(color2, ChatColor.of(color2.substring(1)) + "");
		}
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public static List<String> colorize(final List<String> messages) {
		final List<String> result = new ArrayList<>();
		for (final String msg : messages) {
			result.add(colorize(msg));
		}
		return result;
	}

	public static String withOutColors(String message) {
		for (Matcher matcher = Utilities.rainbowPattern.matcher(message); matcher.find(); matcher = Utilities.rainbowPattern.matcher(message)) {
			final int start = matcher.start();
			final int end = matcher.end();
			message = message.replace(message.substring(start, end), "");
		}
		for (Matcher matcher = Utilities.gradientPattern.matcher(message); matcher.find(); matcher = Utilities.gradientPattern.matcher(message)) {
			final int start = matcher.start();
			final int end = matcher.end();
			message = message.replace(message.substring(start, end), "");
		}
		for (Matcher matcher = Utilities.hexPattern.matcher(message); matcher.find(); matcher = Utilities.hexPattern.matcher(message)) {
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
			message = message.replaceAll(":\\)", "☺");
		}
		if (message.contains(":(")) {
			message = message.replaceAll(":\\(", "☹");
		}
		if (message.contains("<3")) {
			message = message.replaceAll("<3", "❤");
		}
		if (message.contains("-_-")) {
			message = message.replaceAll("-_-", "ಠ_ಠ");
		}
		if (message.contains("*-*")) {
			message = message.replaceAll("\\*-\\*", "✞");
		}
		if (message.contains("^-^")) {
			message = message.replaceAll("\\^-\\^", "✿");
		}
		return message;
	}

	public static int getMessageLengthWithoutColor(String message) {
		int length = 0;
		Matcher rainbowMatcher = Utilities.rainbowPattern.matcher(message);
		Matcher gradientMatcher = Utilities.gradientPattern.matcher(message);
		Matcher hexMatcher = Utilities.hexPattern.matcher(message);
		while (rainbowMatcher.find()) {
			final String color = message.substring(rainbowMatcher.start(), rainbowMatcher.end());
			message = message.replace(color, "");
			rainbowMatcher = Utilities.rainbowPattern.matcher(message);
			length = message.length();
		}
		while (gradientMatcher.find()) {
			final String color = message.substring(gradientMatcher.start(), gradientMatcher.end());
			message = message.replace(color, "");
			gradientMatcher = Utilities.gradientPattern.matcher(message);
			length = message.length();
		}
		while (hexMatcher.find()) {
			final String color = message.substring(hexMatcher.start(), hexMatcher.end());
			message = message.replace(color, "");
			hexMatcher = Utilities.hexPattern.matcher(message);
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
			if (!Utilities.alphabet.containsValue(String.valueOf(message.charAt(i)))) {
				return true;
			}
		}
		return false;
	}

	public static String getColorRussianName(final ChatColor color) {
		if (AQUA.equals(color)) {
			return "Голубой";
		} else if (BLACK.equals(color)) {
			return "Чёрный";
		} else if (BLUE.equals(color)) {
			return "Синий";
		} else if (DARK_AQUA.equals(color)) {
			return "Бирюзовый";
		} else if (DARK_BLUE.equals(color)) {
			return "Тёмно-синий";
		} else if (DARK_GRAY.equals(color)) {
			return "Тёмно-серый";
		} else if (DARK_GREEN.equals(color)) {
			return "Тёмно-зелёный";
		} else if (DARK_PURPLE.equals(color)) {
			return "Фиолетовый";
		} else if (DARK_RED.equals(color)) {
			return "Тёмно-красный";
		} else if (GOLD.equals(color)) {
			return "Золотой";
		} else if (GRAY.equals(color)) {
			return "Серый";
		} else if (GREEN.equals(color)) {
			return "Зелёный";
		} else if (LIGHT_PURPLE.equals(color)) {
			return "Пурпурный";
		} else if (RED.equals(color)) {
			return "Красный";
		} else if (WHITE.equals(color)) {
			return "Белый";
		} else if (YELLOW.equals(color)) {
			return "Жёлтый";
		}
		return null;
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

	public static void sendMessages(final Player player, final List<String> messages) {
		for (final String message : messages) {
			player.sendMessage(colorize(message));
		}
	}

	public static void sendMessages(final CommandSender sender, final List<String> messages) {
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