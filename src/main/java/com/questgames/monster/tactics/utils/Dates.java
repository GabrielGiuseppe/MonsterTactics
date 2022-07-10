package com.questgames.monster.tactics.utils;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static java.util.Objects.isNull;
import static org.apache.logging.log4j.util.Strings.isBlank;

public class Dates {

	private static final String INITIAL_TIMESTAMP = "T00:00:00";
	private static final String FINAL_TIMESTAMP = "T23:59:59";
	private static final int FIRST_DAY_OF_MONTH = 1;

	public static String getFormattedDate(LocalDateTime localDateTime, String pattern) {
		if (isNull(localDateTime) || isBlank(pattern)) {
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return localDateTime.format(formatter);
	}

	public static String getFormattedDate(ZonedDateTime localDateTime, String pattern) {
		if (isNull(localDateTime) || isBlank(pattern)) {
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return localDateTime.format(formatter);
	}

	public static String getFormattedDate(LocalDate localDate, String pattern) {
		if (isNull(localDate) || isBlank(pattern)) {
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return localDate.format(formatter);
	}

	public static LocalDate getFormattedDate(String date, String pattern) {
		if (isNull(date) || isBlank(pattern)) {
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDate.parse(date, formatter);
	}

	public static String getFormattedDate(YearMonth yearMonth, String pattern) {
		if (isNull(yearMonth) || isBlank(pattern)) {
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return yearMonth.format(formatter);
	}

	public static LocalDateTime toLocalDateTimeFromGmt(Date gmtDate) {
		if (isNull(gmtDate)) {
			return null;
		}
		Date localDate = new Date();
		Date localDateFromGmt = new Date(gmtDate.getTime() + TimeZone.getDefault().getOffset(localDate.getTime()));
		return localDateFromGmt.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static LocalDateTime getInitialTimestampOfDay(LocalDate localDate) {
		if (isNull(localDate)) {
			return null;
		}
		CharSequence fromText = localDate.toString() + INITIAL_TIMESTAMP;
		return LocalDateTime.parse(fromText, DateTimeFormatter.ISO_DATE_TIME);
	}

	public static LocalDateTime getFinalTimestampOfDay(LocalDate localDate) {
		CharSequence fromText = localDate.toString() + FINAL_TIMESTAMP;
		return LocalDateTime.parse(fromText, DateTimeFormatter.ISO_DATE_TIME);
	}

	public static LocalDateTime getInitialTimestampOfDay(YearMonth yearMonth) {
		LocalDate localDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), FIRST_DAY_OF_MONTH);
		return getInitialTimestampOfDay(localDate);
	}

	public static LocalDateTime getFinalTimestampOfDay(YearMonth yearMonth) {
		int lastDayOfMonth = yearMonth.atEndOfMonth().lengthOfMonth();
		LocalDate localDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), lastDayOfMonth);
		return getFinalTimestampOfDay(localDate);
	}

	public static String getFormattedDate(LocalDateTime localDatetime, String pattern, Locale locale) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern).withLocale(locale);
		return localDatetime.format(formatter);
	}

	public static LocalDate getFirstDay(YearMonth yearMonth) {
		return yearMonth.atDay(FIRST_DAY_OF_MONTH);
	}

	public static LocalDate getLastDay(YearMonth yearMonth) {
		return yearMonth.atEndOfMonth();
	}

	public static LocalDate getLocalDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
		return LocalDate.parse(date, formatter);
	}

	public static LocalDateTime getLocalDateTime(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		date = date + INITIAL_TIMESTAMP;
		return LocalDateTime.parse(date, formatter);
	}

	public static LocalDateTime getLocalDateTime(String dateTime, DateTimeFormatter formatter) {
		return LocalDateTime.parse(dateTime, formatter);
	}

	public static LocalDateTime getLocalDateTime(String date, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDateTime.parse(date, formatter);
	}

	public static String getLocalDateTimeFromTimeMillis(long timeMillis, String pattern) {
		LocalDateTime localDateFromTimeMillis = LocalDateTime.ofInstant(Instant.ofEpochMilli(timeMillis),
				TimeZones.getDefault());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return formatter.format(localDateFromTimeMillis);
	}

	public static LocalDateTime getLocalDateTime(XMLGregorianCalendar date) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.toGregorianCalendar().getTimeInMillis()),
				ZoneOffset.UTC);
	}

	public static Integer getCurrentYear() {
		return Year.now().getValue();
	}

	public static Integer getCurrentMonth() {
		return MonthDay.now().getMonthValue();
	}

	public static Integer getCurrentDayOfMonth() {
		return MonthDay.now().getDayOfMonth();
	}

	public static LocalDateTime addDaysToCurrentDate(Integer days) {
		return LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC).plus(days, ChronoUnit.DAYS);
	}

	public static LocalDate addDaysToCurrentDate(Long days) {
		return LocalDate.now(TimeZones.getDefault()).plusDays(days);
	}

	public static Integer addDaysToCurrentYear(Integer days) {
		LocalDateTime now = addDaysToCurrentDate(days);
		return now.getYear();
	}

	public static Integer addDaysToCurrentMonth(Integer days) {
		LocalDateTime now = addDaysToCurrentDate(days);
		return now.getMonthValue();
	}

	public static Integer addDaysToCurrentDayOfMonth(Integer days) {
		LocalDateTime now = addDaysToCurrentDate(days);
		return now.getDayOfMonth();
	}

	public static String getStringCurrentMonth() {

		Integer currentMonth = getCurrentMonth();

		String month = currentMonth.toString();

		if (currentMonth < 10) {
			month = "0" + currentMonth.toString();
		}

		return month;
	}

	public static String addDaysStringCurrentMonth(Integer days) {

		Integer currentMonth = addDaysToCurrentMonth(days);

		String month = currentMonth.toString();

		if (currentMonth < 10) {
			month = "0" + currentMonth.toString();
		}

		return month;
	}

	public static String getCurrentDateAmericanFormat() {

		String year = getCurrentYear().toString();
		String month = getStringCurrentMonth();
		String day = getCurrentDayOfMonth().toString();

		return year + "-" + month + "-" + day;
	}

	public static String addDaysToAmericanFormatCurrentDate(Integer days) {

		String year = addDaysToCurrentYear(days).toString();
		String month = addDaysStringCurrentMonth(days);
		String day = addDaysToCurrentDayOfMonth(days).toString();

		return year + "-" + month + "-" + day;
	}

	public static LocalDate yesterday() {
		return today().minusDays(1);
	}

	public static LocalDate today() {
		return LocalDate.now(TimeZones.getDefault());
	}

	public static String today(String pattern) {
		return getFormattedDate(today(), pattern);
	}

	public static boolean isSameLocalDate(LocalDateTime date1, LocalDateTime date2) {
		return date1.toLocalDate().equals(date2.toLocalDate());
	}

	public static String getFormattedTime(LocalTime localTime, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return localTime.format(formatter);
	}

	public static int getCurrentHourDay() {
		return LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).getHour();
	}

	public static LocalDateTime getCurrentDateTime() {
		return LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
	}

	public final static LocalDate converterDateOrbitall(String date) {

		final String PATTERN_DATE_ORBITALL = "ddMMyy";

		LocalDate dateResult = Dates.getFormattedDate(date, PATTERN_DATE_ORBITALL);

		return dateResult;
	}
}
