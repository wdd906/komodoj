package org.bitcoinj.model;

import java.math.BigDecimal;

/**
 * 输出信息
 * @author wdd
 * Date:  2021/3/11 22:40
 */
public class OutPut {
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 订单号
     */
    private Long orderId;
    /**
     * address
     */
    private String address;
    /**
     * 金额
     */
    private BigDecimal amount;
}
