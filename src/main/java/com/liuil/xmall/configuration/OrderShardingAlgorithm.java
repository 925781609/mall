package com.liuil.xmall.configuration;


import com.liuil.xmall.common.Constants;
import com.liuil.xmall.common.util.DateUtils;
import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import java.time.LocalDate;
import java.util.Collection;

/**
 * 精确分片算法，这个Order是订单的意思
 */
public class OrderShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

  @Override
  public String doSharding(Collection<String> collection,
      PreciseShardingValue<Long> preciseShardingValue) {
    Long id = preciseShardingValue.getValue();
    LocalDate date = DateUtils.shardingKeyToDate(preciseShardingValue.getValue());
    String timeString = DateUtils.localDateToString(date, Constants.DATE_FORMAT_YEAR_MONTH);

    for (String e : collection) {
      if (e.endsWith(timeString)) {
        return e;
      }
    }
    throw new IllegalArgumentException();
  }
}
