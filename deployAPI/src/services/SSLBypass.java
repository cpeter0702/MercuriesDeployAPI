package services;

import javax.net.ssl.*;
import java.security.cert.X509Certificate;

public class SSLBypass {
    public static void disableSSLVerification() {
        try {
            // 設置一個忽略所有憑證的 TrustManager
            TrustManager[] trustAllCertificates = new TrustManager[] {
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
            };

            // 設置忽略主機名驗證
            HostnameVerifier trustAllHostnames = (hostname, session) -> true;

            // 安裝忽略 SSL 驗證的設定
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCertificates, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(trustAllHostnames);

            System.out.println("SSL verification disabled.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
