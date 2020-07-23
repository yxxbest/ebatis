package com.ymm.ebatis.sample.condition.base;

import com.ymm.ebatis.core.annotation.Must;
import lombok.Data;

/**
 * @author weilong.hu
 * @since 2020/7/13 14:24
 */
@Data
public class Protocol {

    @Must
    private Integer protocolStatus = 0;
    @Must
    private RateMode rateMode = new RateMode();

}
