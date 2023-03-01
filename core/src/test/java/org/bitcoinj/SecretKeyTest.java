package org.bitcoinj;

import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.LegacyAddress;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.MainNetParams;
import org.junit.Test;

public class SecretKeyTest {

    static NetworkParameters params = MainNetParams.get() ;

    @Test
    public void getKey(){
        ECKey key = new ECKey();
        String address = generateAddressCore(key);
        System.out.println("address = " + address);
        String skey =key.getPrivateKeyAsWiF(params);
        System.out.println("skey = " + skey);
    }
    /**
     * 生成地址
     *
     * @param key key
     * @return String
     */
    public String generateAddressCore(ECKey key) {
        LegacyAddress address = LegacyAddress.fromKey(params, key);
        System.out.println("address.getHash() = " + address.toBase58());
        return address.toBase58();
    }
}
