package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TeamUtil {

	static SimpleDateFormat formatter;

	// 添加数字中文化的方法
	public static String format(String text) {
		for (int i = 0; i < 10; i++) {
			text = text.replace((char) ('0' + i), "零一二三四五六七八九".charAt(i));
		}
		return text;
	}

	// 评分制
	public static String grade(int totalGrade, int getGrade) {
		float grade = totalGrade;
		int t = (int) ((getGrade / grade) * 100);
		switch (t / 10) {
		case 10:
			return "很好";
		case 9:
			return "很好";
		case 8:
			return "很好";
		case 7:
			return "好";
		case 6:
			return "一般";
		case 5:
			return "一般";
		default:
			return "差";
		}
	}

	// 5级评分制评分
	public static String grade(int ggg) {

		switch (ggg / 10) {
		case 9:
			return "优秀";
		case 8:
			return "中";
		case 7:
			return "良";
		case 6:
			return "及格";
		default:
			return "不及格";
		}
	}

	// 一段yyyy-MM-dd HH:mm:ss字符串分成年月日三段
	// 2017-11-09 15:08:50
	//
	public static String timeToYear(String time) {
		String year = time.substring(0, 4);
		return year;
	}

	public static String timeToMonth(String time) {
		String month = time.substring(5, 7);
		return month;
	}

	//
	public static String timeToDay(String time) {
		String day = time.substring(8, 10);
		return day;
	}

	public static String getStringSecond() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return "0000-00-00";
		}

	}

	public static String getDay_Of_Week(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String week = sdf.format(date);
		return week;
	}

	public static String getWeek_Of_Month(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("W");
		String week = sdf.format(date);
		return week;
	}

	public static Date getDateSecond() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return secondDate;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String getStringDay() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Date getDateDay() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return secondDate;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String getTimeChou() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date secondDate = new Date();
		String date = formatter.format(secondDate);
		try {
			secondDate = formatter.parse(date);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return "00000000";
		}
	}

	public static String getUuid() {
		UUID uuid = UUID.randomUUID();
		String s = uuid.toString();
		return s;
	}

	// 判断一个字符是否是中文
	public static boolean isChinese(char c) {
		return c >= 0x4E00 && c <= 0x9FA5;// 根据字节码判断
	}

	// 判断一个字符串是否含有中文
	public static boolean isChinese(String str) {
		if (str == null)
			return false;
		for (char c : str.toCharArray()) {
			if (isChinese(c))
				return true;// 有一个中文字符就返回
		}
		return false;
	}

	// 判断一个字符串是否都为数字
	public static boolean isDigit(String strNum) {
		if (strNum == null)
			return false;
		Pattern pattern = Pattern.compile("[0-9]{1,}");
		Matcher matcher = pattern.matcher((CharSequence) strNum);
		return matcher.matches();
	}

	// 压缩多个文件成一个zip文件
	public static void zipFiles(List<File> srcfile, File zipfile) {
		byte[] buf = new byte[1024];
		try {
			// ZipOutputStream类：完成文件或文件夹的压缩
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
			for (File f : srcfile) {
				FileInputStream in = new FileInputStream(f);
				out.putNextEntry(new ZipEntry(f.getName()));
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				out.closeEntry();
				in.close();
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
