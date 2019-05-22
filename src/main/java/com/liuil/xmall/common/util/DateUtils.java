package com.liuil.xmall.common.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.StringUtils;

public class DateUtils {

  private static final Long START_UNIX_TIME = 1477929600000L;

  /**
   * 将LocalDate 转换为 字符串格式的时间
   *
   * @param pattern 要格式化的时间格式，比如年月（201905）：yyyyMM
   * @return 格式为：年月日的时间
   */
  public static String localDateToString(LocalDate date, String pattern) {
    if (StringUtils.isEmpty(pattern)) {
      return "";
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return date.format(formatter);
  }

  /**
   * shardingkey转换为LocalDate
   */
  public static LocalDate shardingKeyToDate(Long key) {
    Long unixTime = key >> 22;
    unixTime += START_UNIX_TIME;
    return Instant.ofEpochMilli(unixTime).atZone(ZoneId.systemDefault()).toLocalDate();
  }

  /**
   * LocalDate转换成shardingKey
   */
  public static Long dateToShardingKey(LocalDate localDate) {
    Long milliseconde = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    milliseconde -= START_UNIX_TIME;
    return milliseconde << 22;
  }

  /**
   * String 转 localDate
   */
  public static LocalDate stringDateToLocalDate(String stringDate, String pattern) {
    if (StringUtils.isBlank(pattern)) {
      return null;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return LocalDate.parse(stringDate, formatter);
  }

  /**
   * String date 转sharding key
   */
  public static Long stringDateToShardingKey(String stringDate, String pattern) {
    LocalDate localDate = stringDateToLocalDate(stringDate, pattern);
    return dateToShardingKey(localDate);
  }

}
