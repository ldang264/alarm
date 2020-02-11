package com.github.attemper.alarm.dingtalk;

import com.github.attemper.alarm.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;

/**
 * https://ding-doc.dingtalk.com/doc#/serverapi2/qf2nxq
 */
public class DingTalkAlarm extends AlarmAdapter {

    @Override
    public AppResult sendInternal(Config config, Information information) {
        DingTalkConfig dingTalkConfig = (DingTalkConfig) config;
        StringBuilder webHook = new StringBuilder(dingTalkConfig.getUrl());
        if (StringUtils.isNotBlank(dingTalkConfig.getSecret())) {
            long timestamp = System.currentTimeMillis();
            webHook.append("&timestamp=").append(timestamp)
                    .append("&sign=").append(getSign(timestamp, dingTalkConfig.getSecret()));
        }
        String result = HttpClientSingleton.getInstance().post(webHook.toString(), information);
        return BeanUtil.jsonStr2Bean(result, AppResult.class);
    }

    private String getSign(long timestamp, String secret) {
        try {
            String stringToSign = timestamp + "\n" + secret;
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
            return URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getIndex() {
        return AlarmType.DING_TALK.getValue();
    }
}
