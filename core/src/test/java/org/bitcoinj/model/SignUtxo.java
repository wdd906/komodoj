package org.bitcoinj.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author wdd
 * Date:  2021/3/11 18:40
 */
public class SignUtxo implements Serializable {
    public List<InPut> getInPuts() {
        return inPuts;
    }

    public void setInPuts(List<InPut> inPuts) {
        this.inPuts = inPuts;
    }

    public List<OutPut> getOutPuts() {
        return outPuts;
    }

    public void setOutPuts(List<OutPut> outPuts) {
        this.outPuts = outPuts;
    }

    /**
     * 输入（出金方信息）
     */
    List<InPut> inPuts;
    /**
     * 输出（入金方）
     */
    List<OutPut> outPuts;
}
