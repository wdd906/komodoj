package org.bitcoinj;

import org.bitcoinj.core.*;
import org.bitcoinj.model.InPut;
import org.bitcoinj.model.OutPut;
import org.bitcoinj.model.SignUtxo;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.script.Script;
import org.bitcoinj.script.ScriptBuilder;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.bitcoinj.core.Utils.HEX;

public class SignTest {


    protected static final BigDecimal DECIMALS = new BigDecimal(10).pow(8);

    static NetworkParameters params = MainNetParams.get();

    @Test
    public void signAndBroadcast() {
        SignUtxo signUtxo = buildOne2OneTransactionFirst();
        Transaction tx = buildTransaction(signUtxo);
        String txid = tx.getHashAsString();
        System.out.println("txid  = " + txid);
        String raw  = HEX.encode(tx.bitcoinSerialize());
        System.out.println("raw = " + raw);
    }

    /**
     * 一对一（vin-vout）交易构建
     * 已验证
     *
     * @return SignUtxo
     */
    private SignUtxo buildOne2OneTransactionFirst() {
        SignUtxo signUtxo = new SignUtxo();
        List<InPut> inPuts = new ArrayList<>();
        InPut inPut = new InPut();
        inPut.setAddress("RHwtxWrVn15pyQQnznEAgGEdZ6Qn8HssHN");
//        inPut.setAddress("RPdSGcBk4TSwzw6yDFsbPYKhAKsgU9gkBi");
        inPut.setAmount(new BigDecimal("0.5").multiply(DECIMALS));
        inPut.setIndex(0);
        inPut.setHash("eb06e1fb2d2363d3531dd7a5ace36f2116c86a68281afa5c3085c940e2cc2d9a");
        inPuts.add(inPut);

        List<OutPut> outPuts = new ArrayList<>();
        OutPut outPut = new OutPut();
        outPut.setAddress("RPK22FUZGX6DHH9xuSTcMiiCx5tQsNhLuP");
        outPut.setAmount(new BigDecimal("0.49999").multiply(DECIMALS));
        outPuts.add(outPut);

        signUtxo.setInPuts(inPuts);
        signUtxo.setOutPuts(outPuts);
        return signUtxo;
    }


    /**
     * 构建交易
     * todo 根据配置中心配置，动态切换主网和测试网
     *
     * @param txJson 构建基础信息
     * @return Transaction
     */
    protected Transaction buildTransaction(SignUtxo signUtxo) {

        Transaction tx = new Transaction(params);
        for (OutPut outPut : signUtxo.getOutPuts()) {
            Address addressL = Address.fromString(params, outPut.getAddress());
            Script script = ScriptBuilder.createOutputScript(addressL);
            tx.addOutput(Coin.valueOf(outPut.getAmount().longValue()), script);
        }

        for (InPut inPut : signUtxo.getInPuts()) {
            String priKey = getKey(inPut.getAddress());
            assert priKey != null;
            DumpedPrivateKey dumpedPrivateKey = DumpedPrivateKey.fromBase58(params, priKey);
            ECKey key = dumpedPrivateKey.getKey();
            TransactionOutPoint outPoint = new TransactionOutPoint(params, inPut.getIndex(), Sha256Hash.wrap(inPut.getHash()));
            Address addressL = Address.fromString(params, inPut.getAddress());
            Script script = ScriptBuilder.createOutputScript(addressL);
            tx.addSignedInput(outPoint, script, key, Transaction.SigHash.ALL, true);
        }
        //必须构建context，不然会构建交易出错
        Context context = new Context(params);
        tx.getConfidence().setSource(TransactionConfidence.Source.NETWORK);
        tx.setPurpose(Transaction.Purpose.USER_PAYMENT);
        tx.setVersion(4);
        return tx;
    }

    /**
     * 获取私钥
     */
    private String getKey(String address) {
        if (address.equals("RHwtxWrVn15pyQQnznEAgGEdZ6Qn8HssHN")) {
            return "Uq5C4ufwvDVGbEDr7dw6XmbAku8uujZ4ba58LXe3DfGa8YWKtE4x";
        }
        if (address.equals("RPdSGcBk4TSwzw6yDFsbPYKhAKsgU9gkBi")) {
            return "UxAAH7ce3EZk6wnUVWnDtktdF9Vrc7DuzonYWyAFynYPzE5eheeM";
        }
        return null;
    }
}
