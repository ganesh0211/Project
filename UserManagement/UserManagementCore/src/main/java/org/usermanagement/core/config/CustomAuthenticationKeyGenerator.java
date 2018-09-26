package org.usermanagement.core.config;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 26/9/18
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomAuthenticationKeyGenerator implements AuthenticationKeyGenerator
{
    private static final String CLIENT_ID = "client_id";
    private static final String SCOPE = "scope";
    private static final String USERNAME = "username";
    private String algorithm = "SHA-256";

    public CustomAuthenticationKeyGenerator(String algorithm)
    {
        this.algorithm = algorithm;
    }

    public String extractKey(OAuth2Authentication authentication)
    {
        Map<String, String> values = new LinkedHashMap();
        OAuth2Request authorizationRequest = authentication.getOAuth2Request();
        if (!authentication.isClientOnly()) {
            values.put("username", authentication.getName());
        }
        values.put("client_id", authorizationRequest.getClientId());
        if (authorizationRequest.getScope() != null) {
            values.put("scope", OAuth2Utils.formatParameterList(new TreeSet(authorizationRequest.getScope())));
        }
        return generateKey(values);
    }

    public String getAlgorithm()
    {
        return this.algorithm;
    }

    public String setAlgorithm(String algorithm)
    {
        this.algorithm = algorithm;
        return this.algorithm;
    }

    protected String generateKey(Map<String, String> values)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance(this.algorithm);
            byte[] bytes = digest.digest(values.toString().getBytes("UTF-8"));
            return String.format("%032x", new Object[] { new BigInteger(1, bytes) });
        }
        catch (NoSuchAlgorithmException nsae)
        {
            throw new IllegalStateException(this.algorithm + " algorithm not available.  Fatal (should be in the JDK).", nsae);
        }
        catch (UnsupportedEncodingException uee)
        {
            throw new IllegalStateException("UTF-8 encoding not available.  Fatal (should be in the JDK).", uee);
        }
    }
}
