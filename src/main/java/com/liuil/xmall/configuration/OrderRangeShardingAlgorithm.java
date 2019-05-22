package com.liuil.xmall.configuration;

import com.google.common.collect.Range;
import com.liuil.xmall.common.Constants;
import com.liuil.xmall.common.util.DateUtils;
import io.shardingsphere.core.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.RangeShardingAlgorithm;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 范围分片算法
 */
public class OrderRangeShardingAlgorithm implements RangeShardingAlgorithm<Long> {

  @Override
  public Collection<String> doSharding(Collection<String> collection,
      RangeShardingValue<Long> rangeShardingValue) {
    Collection<String> result = new ArrayList<>();
    Range<Long> valueRange = rangeShardingValue.getValueRange();
    LocalDate start = DateUtils.shardingKeyToDate(valueRange.lowerEndpoint());
    LocalDate end = DateUtils.shardingKeyToDate(valueRange.upperEndpoint());
    for (LocalDate d = start; d.isBefore(end) || d.isEqual(end); d = d.plusMonths(1)) {
      String date = DateUtils.localDateToString(d, Constants.DATE_FORMAT_YEAR_MONTH);
      for (String each : collection) {
        if (each.endsWith(date)) {
          result.add(each);
          break;
        }
      }
    }
    return result;
  }
}
