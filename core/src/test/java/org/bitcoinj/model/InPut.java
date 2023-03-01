package org.bitcoinj.model;


import java.math.BigDecimal;

/**
 * 输入信息
 * @author wdd
 * Date:  2021/3/11 22:40
 */
public class InPut {
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
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
     * HASH交易ID
     */
    private String hash;
    /**
     * 位置
     */
    private long index;
    /**
     * 地址
     */
    private String address;
    /**
     * 金额
     */
    private BigDecimal amount;
}
