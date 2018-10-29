/*
 * Copyright 2013 Google Inc.
 * Copyright 2015 Andreas Schildbach
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bitcoinj.params;

import org.bitcoinj.core.*;
import org.bitcoinj.net.discovery.*;

import java.net.*;

import static com.google.common.base.Preconditions.*;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
public class MainNetParams extends AbstractBitcoinNetParams {
    public static final int MAINNET_MAJORITY_WINDOW = 1000;
    public static final int MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED = 950;
    public static final int MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE = 750;

    public MainNetParams() {
        super();
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        maxTarget = Utils.decodeCompactBits(0x1d00ffffL);
        dumpedPrivateKeyHeader = 128;
        addressHeader = 0;
        p2shHeader = 5;
        segwitAddressHrp = "bc";
        port = 7770;
        packetMagic = 0xf9eee48d;
        bip32HeaderPub = 0x0488B21E; //Komodo - The 4 byte header that serializes in base58 to "xpub".
        bip32HeaderPriv = 0x0488ADE4; //Komodo - The 4 byte header that serializes in base58 to "xprv"

        majorityEnforceBlockUpgrade = MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE;
        majorityRejectBlockOutdated = MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED;
        majorityWindow = MAINNET_MAJORITY_WINDOW;

        genesisBlock.setDifficultyTarget(0x1d00ffffL);
        genesisBlock.setTime(1231006505L);
        genesisBlock.setNonce(2083236893);
        id = ID_MAINNET;
        subsidyDecreaseBlockCount = 840000;
        spendableCoinbaseDepth = 100;
        String genesisHash = genesisBlock.getHashAsString();
        checkState(genesisHash.equals("027e3758c3a65b12aa1046462b486d0a63bfa1beae327897f56c5cfb7daaae71"),
                genesisHash);

        // This contains (at a minimum) the blocks which are not BIP30 compliant. BIP30 changed how duplicate
        // transactions are handled. Duplicated transactions could occur in the case where a coinbase had the same
        // extraNonce and the same outputs but appeared at different heights, and greatly complicated re-org handling.
        // Having these here simplifies block connection logic considerably.
        checkpoints.put(91722, Sha256Hash.wrap("00000000000271a2dc26e7667f8419f2e15416dc6955e5a6c6cdf3f2574dd08e"));
        checkpoints.put(91812, Sha256Hash.wrap("00000000000af0aed4792b1acee3d966af36cf5def14935db8de83d6f9306f2f"));
        checkpoints.put(91842, Sha256Hash.wrap("00000000000a4d0a398161ffc163c503763b1f4360639393e0e4c8e300e0caec"));
        checkpoints.put(91880, Sha256Hash.wrap("00000000000743f190a18c5577a3c2d2a1f610ae9601ac046a38084ccb7cd721"));
        checkpoints.put(200000, Sha256Hash.wrap("000000000000034a7dedef4a161fa058a2d67a173a90155f3a2fe6fc132e0ebf"));

        checkpoints.put(0, Sha256Hash.wrap("027e3758c3a65b12aa1046462b486d0a63bfa1beae327897f56c5cfb7daaae71")) /* updated */;
        checkpoints.put(5000, Sha256Hash.wrap("0x049cfc91eef411e96603a42c9a77c5e30e9fe96f783ab818f4c00fb56fb29b6c"));
        checkpoints.put(10000, Sha256Hash.wrap("0x0a0169db3614311cd4181deb73cfcf7f640e7dc956cda34e0121a0351925e9ae"));
        checkpoints.put(15000, Sha256Hash.wrap("0x00f0bd236790e903321a2d22f85bd6bf8a505f6ef4eddb20458a65d37e14d142"));
        checkpoints.put(20000, Sha256Hash.wrap("0x01bbf0c38892bdcced62b538329cf63bc7badca3e7e1bff8eb10345436871c6e"));
        checkpoints.put(25000, Sha256Hash.wrap("0x04ca27808268dda8f942b647a6df844be1b263a661a13740293db962022d1f9e"));
        checkpoints.put(30000, Sha256Hash.wrap("0x04c9e8cfbcd37399085e529b50147de8afb80c76c48752c122d56f23316a7acb"));
        checkpoints.put(35000, Sha256Hash.wrap("0x00815f1240354cff7487c67f7dff78e248cb9053ed2c92751d1a9ad42d3eaedf"));
        checkpoints.put(40000, Sha256Hash.wrap("0x00eafd9dfb1e5f1bf1cca0c49be628538900daf69b665464443d29c2c3b6a2fe"));
        checkpoints.put(45000, Sha256Hash.wrap("0x0377730632caf694b92f40d03ae0fbe5bd86a1205014b71d975453ac793b0af9"));
        checkpoints.put(50000, Sha256Hash.wrap("0x00076e16d3fa5194da559c17cf9cf285e21d1f13154ae4f7c7b87919549345aa"));
        checkpoints.put(55000, Sha256Hash.wrap("0x0005a0701a83e05b639418ea4c87018544a4d22b2b49e5f111161e8ffc455108"));
        checkpoints.put(60000, Sha256Hash.wrap("0x0000296fc15f8599b7c6561d0e0a96f24766135ed79107b603d6dd6e55142c0d"));
        checkpoints.put(65000, Sha256Hash.wrap("0x000861f5d7970d5399733b4605074d47f877d6536f74ffae6f08e871ee29e6f2"));
        checkpoints.put(70000, Sha256Hash.wrap("0x0002af1d487c567526c517b52996944dca344e139cddca77c2e72f746e73b263"));
        checkpoints.put(75000, Sha256Hash.wrap("0x0d08129659be5f105e70c047769359eaf3475d61a726750859fdca3e1a2bf5cc"));
        checkpoints.put(80000, Sha256Hash.wrap("0x0af5f3f1caae4f08c74a82689731d1ef8e55107c06f9a996e251b8ecb96989ad"));
        checkpoints.put(85000, Sha256Hash.wrap("0x00000c8ee29086c5fb39eddad0619773b9ce936c77c13e5e5118a4998e939544"));
        checkpoints.put(90000, Sha256Hash.wrap("0x06d3bb7f9ee5b55f67b2dc13c680699a2f736f43a44b4e4cfd41a58aa00f063f"));
        checkpoints.put(95000, Sha256Hash.wrap("0x0670981b269879aae83a88f6f0c4db34763c93fd410d96435f2acb4e6580b976"));
        checkpoints.put(100000, Sha256Hash.wrap("0x0f02eb1f3a4b89df9909fec81a4bd7d023e32e24e1f5262d9fc2cc36a715be6f"));
        checkpoints.put(105000, Sha256Hash.wrap("0x018b97d7e6d259add24afe0e08fc125dc21d734e8831b68b430f5c3896deb4af"));
        checkpoints.put(110000, Sha256Hash.wrap("0x09644ff52734e0e911a9ba7ecd03cf7995b25301840a9637891ef9af69f59c32"));
        checkpoints.put(115000, Sha256Hash.wrap("0x0ee382b4729b8ceb918a92913f9c144a6a4f8a50bfc0f8b4aac5b12592caed7f"));
        checkpoints.put(120000, Sha256Hash.wrap("0x082a7918a0dd9cb2df65f55acb8d0a4a535b3fa684d92c3ebcb24ed7019d975b"));
        checkpoints.put(125000, Sha256Hash.wrap("0x00008f76c4484fd539c9d02fc69c40a50b6f9e00984d33890b85cc0324159e9e"));
        checkpoints.put(130000, Sha256Hash.wrap("0x011b09e53acfe46f310e8c960a9c4f4f490cc7b2cd3791d7a6a80d6e8ac96b36"));
        checkpoints.put(135000, Sha256Hash.wrap("0x01e0cd48358fa05646baa6f00e26717474d6049a537c8861b324d1f497dc3d4a"));
        checkpoints.put(140000, Sha256Hash.wrap("0x0e6db36fd8a9d1b7baf359c8bd5c76635d0bcada973a75b5d2028ca3baea4961"));
        checkpoints.put(145000, Sha256Hash.wrap("0x00010c40b57316ce6cde076807c9db956452a3c82cb09fe7d56c6bb1a7e24726"));
        checkpoints.put(150000, Sha256Hash.wrap("0x0a817f15b9da636f453a7a01835cfc534ed1a55ce7f08c566471d167678bedce"));
        checkpoints.put(155000, Sha256Hash.wrap("0x0528084fd00223bd9747635d7a4d8cc79f158795cad654efb78e4e4cc5f23d6a"));
        checkpoints.put(160000, Sha256Hash.wrap("0x00003a09f26ae9fb7ebbfa3ef589b81ccd8909a82430f7414bc68d5a5a3316ab"));
        checkpoints.put(165000, Sha256Hash.wrap("0x00004a0c6a29e7d1f22ea4e44d05e861fec5fcd8eebc5a61574c4ecf29dbb9be"));
        checkpoints.put(170000, Sha256Hash.wrap("0x0cf9eac27badc0ae9a2b370dd7cc3fcb550f139349551e60978f394a2e1b262b"));
        checkpoints.put(175000, Sha256Hash.wrap("0x0000137856b825d431da27ff4c3cf22f5482fa21952d45b0db0ec6774fb9b510"));
        checkpoints.put(180000, Sha256Hash.wrap("0x000000b0afcccf98aa0afb6ac61050892bd9415857d66313d1f67fd1bbac312f"));
        checkpoints.put(185000, Sha256Hash.wrap("0x00c2af8f88d84de080067f8ae1c25754e32e5516d20c11f85b9adae2d683687b"));
        checkpoints.put(190000, Sha256Hash.wrap("0x00000033d85b3e7d19e02278ef300b8ab957d3dd3e58b4c81166ba0a58af5c3f"));
        checkpoints.put(195000, Sha256Hash.wrap("0x000000964b6068be1dd4ee6893d183e86cba82a2744fb5439c463d0ba7e053b6"));
        checkpoints.put(200000, Sha256Hash.wrap("0x000001763a9337328651ca57ac487cc0507087be5838fb74ca4165ff19f0e84f"));
        checkpoints.put(205000, Sha256Hash.wrap("0x049fc6832e64a75ae898b32804e151e7561ea49082858c3d4af89a7de4b82f06"));
        checkpoints.put(210000, Sha256Hash.wrap("0x0000000d9078b9c9604cc663eafafba8f3643bb3f3ddbb78fed4993236e1edb5"));
        checkpoints.put(215000, Sha256Hash.wrap("0x00060089ecc21bcc62094e2f7f0448fe163415f6ef2f2aafe047757889ca82fe"));
        checkpoints.put(220000, Sha256Hash.wrap("0x000082c78e6c2a13a9c23dd7a6faaf962fc133142b4a2d07725561f59c03bfa2"));
        checkpoints.put(225000, Sha256Hash.wrap("0x00030026483167fe13505cf27049307ce42e0d9c5aa093aed10baa4f49edf4ca"));
        checkpoints.put(230000, Sha256Hash.wrap("0x000183a3e17988060a35776b99c1f0b43393bbe7153b2718dfc57f428191de4e"));
        checkpoints.put(235000, Sha256Hash.wrap("0x000184995f0ec024ed3783e322c8cfa5e68d9f0c77c3aaea301b22d311619156"));
        checkpoints.put(240000, Sha256Hash.wrap("0x0000002cc7cf6d0a44ab57f9bd3bfa11a865bbf1cd87a2081095bc90981633a3"));
        checkpoints.put(245000, Sha256Hash.wrap("0x004c5f19a88c8fe8a604006dbd2d44c94baef2a00876a17d8e2be2124003f979"));
        checkpoints.put(250000, Sha256Hash.wrap("0x0dd54ef5f816c7fde9d2b1c8c1a26412b3c761cc5dd3901fa5c4cd1900892fba"));
        checkpoints.put(255000, Sha256Hash.wrap("0x0b6da9e4f50c8bc7a92c539bc7474ffd6c29e0a8531f0dbbbc261fff1f990827"));
        checkpoints.put(260000, Sha256Hash.wrap("0x0cac8b12bf7233ee5a68fcde9e251852b177833fefa2a9f39ec28474b0851cb9"));
        checkpoints.put(265000, Sha256Hash.wrap("0x04feb5b4029f3b8b8eb3e6661a78eadd1a26b4af00ac59b5f05b261afcfd2818"));
        checkpoints.put(270000, Sha256Hash.wrap("0x01bc5897bd20b8b61acf4989987ba85fbc37d9ebe848924aa8effcb08bf48fe0"));
        checkpoints.put(275000, Sha256Hash.wrap("0x0416bc29eb5a12231826e546ba90fcd38aeef387ff77b45849cd418a9c1a6f12"));
        checkpoints.put(280000, Sha256Hash.wrap("0x000007593e9880b171d46bce59aa0cec2a1b1f53d1fd7e8f71ccb2b9182374a4"));
        checkpoints.put(285000, Sha256Hash.wrap("0x05a338b2d90cd79740221fe8635b7a834f2e486fcbb2464a4294f5a21231a5f5"));
        checkpoints.put(290000, Sha256Hash.wrap("0x064ca3912cdcd833702d07a530e98bc5c6c1cd738a8825c7240b17cd68ca0cc4"));
        checkpoints.put(295000, Sha256Hash.wrap("0x036b3bb318d743fd78db983a9aadd52869991d48913c4eebe2a074387d67cc5a"));
        checkpoints.put(300000, Sha256Hash.wrap("0x000000fa5efd1998959926047727519ed7de06dcf9f2cd92a4f71e907e1312dc"));
        checkpoints.put(305000, Sha256Hash.wrap("0x00003656231e83de2348755153ed175794696a113d7e8a15c01f90fdb7c2f287"));
        checkpoints.put(310000, Sha256Hash.wrap("0x0cf6baf727eb931da0813ed8b032648c4766be79e146b0d40c643f9d8edf40f7"));
        checkpoints.put(315000, Sha256Hash.wrap("0x082469974c152ebe69f1787f0d06aa5d9dd1dc69c880febde7eac2bc800146dd"));
        checkpoints.put(320000, Sha256Hash.wrap("0x0000063df36b99bfb2516f55cb548a5baed1f2d8ae69c3559dc478c5c2eb32df"));
        checkpoints.put(325000, Sha256Hash.wrap("0x0cb926b303a1514ba0a2f729af88ccb143517f396e9e0bde09b0736900698e0f"));
        checkpoints.put(330000, Sha256Hash.wrap("0x000000be3d8bb6e31c3b534819aae7014cbbe9a44ab3e799dc1bfc724c6ab184"));
        checkpoints.put(335000, Sha256Hash.wrap("0x0d0756608189fd5bbd8ec50e76180074e69e973439cc09df49134e4cb970ed4d"));
        checkpoints.put(340000, Sha256Hash.wrap("0x0d814eacdb9c97003d703c0ff79b1b97b9ed8615fe12b1afaede946e5fdfe0a7"));
        checkpoints.put(345000, Sha256Hash.wrap("0x000000c2910f510f1de325d300202da1a391f2719dd378173299151c3da94e85"));
        checkpoints.put(350000, Sha256Hash.wrap("0x0000000228ef321323f81dae00c98d7960fc7486fb2d881007fee60d1e34653f"));
        checkpoints.put(355000, Sha256Hash.wrap("0x03e6a55e382b478e0fab9c3584da3629fd9b977986a333a406b24b0d3559bf44"));
        checkpoints.put(360000, Sha256Hash.wrap("0x0859c86dd718bcb5b58af06389197794e2beea6239653f2e6fa7b8a7433d29ea"));
        checkpoints.put(365000, Sha256Hash.wrap("0x07896332665c707a8f55398a998e7878e8d2681ba79dd95c2859b1dafc9343d0"));
        checkpoints.put(370000, Sha256Hash.wrap("0x040efd8c64cf5cf96ecf75468741a8880d1386eb5e349bef0a55116d4023944c"));
        checkpoints.put(375000, Sha256Hash.wrap("0x053029e7599a09fe6c01203997d7ca738dd4c6d216a433695a0d514def1eccc0"));
        checkpoints.put(380000, Sha256Hash.wrap("0x0cae44e7a421c389b88a5a204d3e39779e93aeacaab1b693741bf279fd0c8acd"));
        checkpoints.put(385000, Sha256Hash.wrap("0x0b4032d2c799ba93644231ce57134dd24e13ec0dc267c1ed5912389691d2bd72"));
        checkpoints.put(390000, Sha256Hash.wrap("0x0afd0f166f33a881ef289af7ea7010d58c4bbd560dee10b561c79e1b8dfd0593"));
        checkpoints.put(395000, Sha256Hash.wrap("0x083774b88cf1b138d67c242d9b33c54f69d7e901b5e8144dc4a2303ab9927102"));
        checkpoints.put(400000, Sha256Hash.wrap("0x036d294c5be96f4c0efb28e652eb3968231e87204a823991a85c5fdab3c43ae6"));
        checkpoints.put(405000, Sha256Hash.wrap("0x0522e33bb2161fb1b33acef9a4a438fcf420dcae8a0b472e234d223d731c42b2"));
        checkpoints.put(410000, Sha256Hash.wrap("0x0361d06aa807c66b87befea8119a485341d1118b694c3dbb4c3cf0b85ac69e9b"));
        checkpoints.put(415000, Sha256Hash.wrap("0x072d5653d8673f64ef8b9c655f7b8021072070a072b799013ff6e96de99a59e6"));
        checkpoints.put(420000, Sha256Hash.wrap("0x013b693d66955be69d4501cb1d307ca323a5c8473e25866ae7e700cdce0c654f"));
        checkpoints.put(425000, Sha256Hash.wrap("0x0ef0c55af27c6971289a790dee2b2ec728fb9c6555ff9306c07f1083cf0fb4b5"));
        checkpoints.put(430000, Sha256Hash.wrap("0x0ccbeeaba28291e0316a9cf54c005097c61dc67ba6f32283406d6c83b828da00"));
        checkpoints.put(435000, Sha256Hash.wrap("0x020ed6b7fe1124400baba7feed463ba0c90e7e6903493fdc1a1a18c4a506055a"));
        checkpoints.put(440000, Sha256Hash.wrap("0x055aaadca1908abeedc831a3f9115aa31284fc223d010590caf7b612960b61a4"));
        checkpoints.put(445000, Sha256Hash.wrap("0x06d2327fa25ea7e2be742fc0e45fc4f9adb41811f21be0357f8543c5434df715"));
        checkpoints.put(450000, Sha256Hash.wrap("0x0906ef1e8dc194f1f03bd4ce1ac8c6992fd721ef2c5ccbf4871ec8cdbb456c18"));
        checkpoints.put(455000, Sha256Hash.wrap("0x0b8b92eec29eb20262dcf9916f0ca36d6abf0c39d321d3f480a5535cb978db71"));
        checkpoints.put(460000, Sha256Hash.wrap("0x0cb04591f69a255b1127aaff3bbd59eaa21a5d9cca999de197516c251895c536"));
        checkpoints.put(465000, Sha256Hash.wrap("0x029985ae78d8bb8fd170aeb3ab02ea76134ed0c19ae00211cc28a61fe5755b88"));
        checkpoints.put(470000, Sha256Hash.wrap("0x01a2f4b56f37b223e75572862ad1ba956ec179332f8cd40590d7253563c86ba8"));
        checkpoints.put(475000, Sha256Hash.wrap("0x0a34c6f9d4d9cb8c78c14b8041a7cc1874cfcbb22a34a5c068d1d6ff3ed9fdf0"));
        checkpoints.put(480000, Sha256Hash.wrap("0x0ebab25030179996ae25969f34f6a297c7ffce1994f9b4186082a47032a9a7dc"));
        checkpoints.put(485000, Sha256Hash.wrap("0x06a096e6bccf3b85537a30f95db6a414deacc0509bc84da264c2830df1a1d9b0"));
        checkpoints.put(490000, Sha256Hash.wrap("0x0af828930ef13405cb536b88a3d1d4e0d84dc79ee260402c56bfa86e261c74ff"));
        checkpoints.put(495000, Sha256Hash.wrap("0x09d44905bfd12849d3c2178b2ba882f8e9d6565b6e4d7a97c70a92bd6de7c5e6"));
        checkpoints.put(500000, Sha256Hash.wrap("0x0bebdb417f7a51fe0c36fcf94e2ed29895a9a862eaa61601272866a7ecd6391b"));
        checkpoints.put(505000, Sha256Hash.wrap("0x0c1609f4f3561baa1fc975877948af94d2107c88686a9821bc240016cc87d953"));
        checkpoints.put(510000, Sha256Hash.wrap("0x0cf9a5a4997b871e615e5e398627e45fa15b3e6970ae22b47bdd11b0f5fa0fa7"));
        checkpoints.put(515000, Sha256Hash.wrap("0x034171d4819e9961de13309743a32a179abede97d60ea64101dc04c97a1a0807"));
        checkpoints.put(520000, Sha256Hash.wrap("0x0648fa44d5bbc2cc04a782e083c11df64ac06185f0f8e11a7416625ebb6409a6"));
        checkpoints.put(525000, Sha256Hash.wrap("0x0000000ef17d63af3159e52cd351b6f000536ad88adc3a937bb747955fed58a2"));
        checkpoints.put(530000, Sha256Hash.wrap("0x08e3af153995ba09e50086b64145cf4cd57db6b29f16f06f28d80d7f6121cfad"));
        checkpoints.put(535000, Sha256Hash.wrap("0x02a0ffd00b51e2061b85de50a9223d9c84f4e357dc1046397bb9d7d4a827a3fb"));
        checkpoints.put(540000, Sha256Hash.wrap("0x04bf07d026af29025c1ac2815e067f4a41d2872701ac9780eb3015d51cdcd854"));
        checkpoints.put(545000, Sha256Hash.wrap("0x0a0d6d86635946792ad0dca57ed227a5360fc8b6d79e47132aac11e90a4963ce"));
        checkpoints.put(550000, Sha256Hash.wrap("0x06df52fc5f9ba03ccc3a7673b01ab47990bd5c4947f6e1bc0ba14d21cd5bcccd"));
        checkpoints.put(555000, Sha256Hash.wrap("0x0baf38eea8e08fcad3a9d760f27377e79c291b08e7fb4920cadd5cb7bab547f3"));
        checkpoints.put(560000, Sha256Hash.wrap("0x00000004c34abbf1366adbae965b644c01debf15409acc715ff51cb221d92dd7"));
        checkpoints.put(565000, Sha256Hash.wrap("0x067bae7119f083e0fa1820bc8e25dcfa7717e42aabaef18beefd87d974953dfb"));
        checkpoints.put(570000, Sha256Hash.wrap("0x00000011a7ce7b628b7be17777d8dea2574d83f165e23c9e44aa705975820fd3"));
        checkpoints.put(575000, Sha256Hash.wrap("0x0e1110a193a30d3f8d369017233a2486b11c748b3d033859a2eb7b37062d303e"));
        checkpoints.put(580000, Sha256Hash.wrap("0x083cb58484aff80f48e3537e0451d49e544b3efa3da97274800c91e567d33a92"));
        checkpoints.put(585000, Sha256Hash.wrap("0x0224cf835428d03472edf4f7b6fcc63b9d8d6f1d5a90ad8186bf123d541b4ea8"));
        checkpoints.put(590000, Sha256Hash.wrap("0x0cfcf3b9517894e4df49db5faf8b74f3a9e01eb83c0cc5051c115d4424615dae"));
        checkpoints.put(595000, Sha256Hash.wrap("0x0000000a45266983dd81e0df381a3b0455699b2f76d5b4d3f17b87d657a1b56d"));
        checkpoints.put(600000, Sha256Hash.wrap("0x00000005080d5689c3b4466e551cd1986e5d2024a62a79b1335afe12c42779e4"));
        checkpoints.put(605000, Sha256Hash.wrap("0x0000001c691da36848542299af859d4eb3fa408a0f425b1fbe6d622d2100623a"));
        checkpoints.put(610000, Sha256Hash.wrap("0x040d8c7a0ac89e3ed8605a198583a795986aacbf18722a9897d7b925bcf757f6"));
        checkpoints.put(615000, Sha256Hash.wrap("0x0449cf00fc36206389c14cbf1d762f8b96bb0440ccea5b46703e7c69b0e2bc42"));
        checkpoints.put(620000, Sha256Hash.wrap("0x07227a41340c25ee1a7e9b60414259780202ffa990079fc91d8faeac9af03e60"));
        checkpoints.put(625000, Sha256Hash.wrap("0x047c2472fe2afabb3d38decf24bba4ba712b60e7a1782f4afae3ede3f912f493"));
        checkpoints.put(630000, Sha256Hash.wrap("0x0a7f1f04e66260cf972ab1374a9126b8abc1adaa3ab4669db5d4d4ddb9ad493d"));
        checkpoints.put(635000, Sha256Hash.wrap("0x048df95165eb821dabf37ef28cf7f3be72e216e95377684253dab806985b50a4"));
        checkpoints.put(640000, Sha256Hash.wrap("0x066b3c6a6a3c8dc58bef509a972c3e3ade14493b40e1b361ecbc928134e302be"));
        checkpoints.put(645000, Sha256Hash.wrap("0x07d059888c9ade3bbe16d6b4d70ee9b8302d104b37a3c6cd61f81012aabd0e1e"));
        checkpoints.put(650000, Sha256Hash.wrap("0x039a3cb760cc6e564974caf69e8ae621c14567f3a36e4991f77fd869294b1d52"));
        checkpoints.put(655000, Sha256Hash.wrap("0x089350ee8d28b44837eb4b1fe77704953d5de2077f10c74a888d9d3ea1e13c2a"));
        checkpoints.put(660000, Sha256Hash.wrap("0x000000023f8a582a61ae2f6fab6fe8197e79b7a68aaac67432421b09f1bdd4ba"));
        checkpoints.put(665000, Sha256Hash.wrap("0x0b16edce865e7a0d662115774e0c0d3abbf9c69004155b693ddc933f051bfb26"));
        checkpoints.put(670000, Sha256Hash.wrap("0x09070b109b089490bc372fd8358abae352d6db0e46ade6ed2200e4d4ff7aa6af"));
        checkpoints.put(675000, Sha256Hash.wrap("0x08d9edeed3b6ac55991e9f32af0218ff8fa9dc808078623f4c831eb09d4f186b"));
        checkpoints.put(680000, Sha256Hash.wrap("0x00000003eb2b30bfac929d3496acecab19625ac9f854a86aaf9678bea99e1cc1"));
        checkpoints.put(681777, Sha256Hash.wrap("0x0000243296b9b26c040f471fdd9398ef72e57062cf05c19b9ba2fefac8165306"));
        //checkpoints.put(150000, Sha256Hash.wrap("00000000b6bc56656812a5b8dcad69d6ad4446dec23b5ec456c18641fb5381ba")) /* updated */;
        //checkpoints.put(500000, Sha256Hash.wrap("")) /* Replace with notarized block */;
        //checkpoints.put(1000000, Sha256Hash.wrap("")) /* Replace with notarized block */;

        dnsSeeds = new String[] {
                "seeds.komodoplatform.com",    // kolo
                "static.kolo.supernet.org", // kolo
                "dynamic.kolo.supernet.org" // kolo
        };

        // httpSeeds = new HttpDiscovery.Details[] {
        //         // Andreas Schildbach
        //         new HttpDiscovery.Details(
        //                 ECKey.fromPublicOnly(Utils.HEX.decode("0238746c59d46d5408bf8b1d0af5740fe1a6e1703fcb56b2953f0b965c740d256f")),
        //                 URI.create("http://httpseed.bitcoin.schildbach.de/peers")
        //         )
        // };

        // addrSeeds = new int[] {
        //         0x1ddb1032, 0x6242ce40, 0x52d6a445, 0x2dd7a445, 0x8a53cd47, 0x73263750, 0xda23c257, 0xecd4ed57,
        //         0x0a40ec59, 0x75dce160, 0x7df76791, 0x89370bad, 0xa4f214ad, 0x767700ae, 0x638b0418, 0x868a1018,
        //         0xcd9f332e, 0x0129653e, 0xcc92dc3e, 0x96671640, 0x56487e40, 0x5b66f440, 0xb1d01f41, 0xf1dc6041,
        //         0xc1d12b42, 0x86ba1243, 0x6be4df43, 0x6d4cef43, 0xd18e0644, 0x1ab0b344, 0x6584a345, 0xe7c1a445,
        //         0x58cea445, 0xc5daa445, 0x21dda445, 0x3d3b5346, 0x13e55347, 0x1080d24a, 0x8e611e4b, 0x81518e4b,
        //         0x6c839e4b, 0xe2ad0a4c, 0xfbbc0a4c, 0x7f5b6e4c, 0x7244224e, 0x1300554e, 0x20690652, 0x5a48b652,
        //         0x75c5c752, 0x4335cc54, 0x340fd154, 0x87c07455, 0x087b2b56, 0x8a133a57, 0xac23c257, 0x70374959,
        //         0xfb63d45b, 0xb9a1685c, 0x180d765c, 0x674f645d, 0x04d3495e, 0x1de44b5e, 0x4ee8a362, 0x0ded1b63,
        //         0xc1b04b6d, 0x8d921581, 0x97b7ea82, 0x1cf83a8e, 0x91490bad, 0x09dc75ae, 0x9a6d79ae, 0xa26d79ae,
        //         0x0fd08fae, 0x0f3e3fb2, 0x4f944fb2, 0xcca448b8, 0x3ecd6ab8, 0xa9d5a5bc, 0x8d0119c1, 0x045997d5,
        //         0xca019dd9, 0x0d526c4d, 0xabf1ba44, 0x66b1ab55, 0x1165f462, 0x3ed7cbad, 0xa38fae6e, 0x3bd2cbad,
        //         0xd36f0547, 0x20df7840, 0x7a337742, 0x549f8e4b, 0x9062365c, 0xd399f562, 0x2b5274a1, 0x8edfa153,
        //         0x3bffb347, 0x7074bf58, 0xb74fcbad, 0x5b5a795b, 0x02fa29ce, 0x5a6738d4, 0xe8a1d23e, 0xef98c445,
        //         0x4b0f494c, 0xa2bc1e56, 0x7694ad63, 0xa4a800c3, 0x05fda6cd, 0x9f22175e, 0x364a795b, 0x536285d5,
        //         0xac44c9d4, 0x0b06254d, 0x150c2fd4, 0x32a50dcc, 0xfd79ce48, 0xf15cfa53, 0x66c01e60, 0x6bc26661,
        //         0xc03b47ae, 0x4dda1b81, 0x3285a4c1, 0x883ca96d, 0x35d60a4c, 0xdae09744, 0x2e314d61, 0x84e247cf,
        //         0x6c814552, 0x3a1cc658, 0x98d8f382, 0xe584cb5b, 0x15e86057, 0x7b01504e, 0xd852dd48, 0x56382f56,
        //         0x0a5df454, 0xa0d18d18, 0x2e89b148, 0xa79c114c, 0xcbdcd054, 0x5523bc43, 0xa9832640, 0x8a066144,
        //         0x3894c3bc, 0xab76bf58, 0x6a018ac1, 0xfebf4f43, 0x2f26c658, 0x31102f4e, 0x85e929d5, 0x2a1c175e,
        //         0xfc6c2cd1, 0x27b04b6d, 0xdf024650, 0x161748b8, 0x28be6580, 0x57be6580, 0x1cee677a, 0xaa6bb742,
        //         0x9a53964b, 0x0a5a2d4d, 0x2434c658, 0x9a494f57, 0x1ebb0e48, 0xf610b85d, 0x077ecf44, 0x085128bc,
        //         0x5ba17a18, 0x27ca1b42, 0xf8a00b56, 0xfcd4c257, 0xcf2fc15e, 0xd897e052, 0x4cada04f, 0x2f35f6d5,
        //         0x382ce8c9, 0xe523984b, 0x3f946846, 0x60c8be43, 0x41da6257, 0xde0be142, 0xae8a544b, 0xeff0c254,
        //         0x1e0f795b, 0xaeb28890, 0xca16acd9, 0x1e47ddd8, 0x8c8c4829, 0xd27dc747, 0xd53b1663, 0x4096b163,
        //         0x9c8dd958, 0xcb12f860, 0x9e79305c, 0x40c1a445, 0x4a90c2bc, 0x2c3a464d, 0x2727f23c, 0x30b04b6d,
        //         0x59024cb8, 0xa091e6ad, 0x31b04b6d, 0xc29d46a6, 0x63934fb2, 0xd9224dbe, 0x9f5910d8, 0x7f530a6b,
        //         0x752e9c95, 0x65453548, 0xa484be46, 0xce5a1b59, 0x710e0718, 0x46a13d18, 0xdaaf5318, 0xc4a8ff53,
        //         0x87abaa52, 0xb764cf51, 0xb2025d4a, 0x6d351e41, 0xc035c33e, 0xa432c162, 0x61ef34ae, 0xd16fddbc,
        //         0x0870e8c1, 0x3070e8c1, 0x9c71e8c1, 0xa4992363, 0x85a1f663, 0x4184e559, 0x18d96ed8, 0x17b8dbd5,
        //         0x60e7cd18, 0xe5ee104c, 0xab17ac62, 0x1e786e1b, 0x5d23b762, 0xf2388fae, 0x88270360, 0x9e5b3d80,
        //         0x7da518b2, 0xb5613b45, 0x1ad41f3e, 0xd550854a, 0x8617e9a9, 0x925b229c, 0xf2e92542, 0x47af0544,
        //         0x73b5a843, 0xb9b7a0ad, 0x03a748d0, 0x0a6ff862, 0x6694df62, 0x3bfac948, 0x8e098f4f, 0x746916c3,
        //         0x02f38e4f, 0x40bb1243, 0x6a54d162, 0x6008414b, 0xa513794c, 0x514aa343, 0x63781747, 0xdbb6795b,
        //         0xed065058, 0x42d24b46, 0x1518794c, 0x9b271681, 0x73e4ffad, 0x0654784f, 0x438dc945, 0x641846a6,
        //         0x2d1b0944, 0x94b59148, 0x8d369558, 0xa5a97662, 0x8b705b42, 0xce9204ae, 0x8d584450, 0x2df61555,
        //         0xeebff943, 0x2e75fb4d, 0x3ef8fc57, 0x9921135e, 0x8e31042e, 0xb5afad43, 0x89ecedd1, 0x9cfcc047,
        //         0x8fcd0f4c, 0xbe49f5ad, 0x146a8d45, 0x98669ab8, 0x98d9175e, 0xd1a8e46d, 0x839a3ab8, 0x40a0016c,
        //         0x6d27c257, 0x977fffad, 0x7baa5d5d, 0x1213be43, 0xb167e5a9, 0x640fe8ca, 0xbc9ea655, 0x0f820a4c,
        //         0x0f097059, 0x69ac957c, 0x366d8453, 0xb1ba2844, 0x8857f081, 0x70b5be63, 0xc545454b, 0xaf36ded1,
        //         0xb5a4b052, 0x21f062d1, 0x72ab89b2, 0x74a45318, 0x8312e6bc, 0xb916965f, 0x8aa7c858, 0xfe7effad,
        // };
    }

    private static MainNetParams instance;
    public static synchronized MainNetParams get() {
        if (instance == null) {
            instance = new MainNetParams();
        }
        return instance;
    }

    @Override
    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }
}
