package org.usermanagement.core.component;

import org.model.usermanagement.PersistentLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.usermanagement.core.db.PersistenceHandler;
import org.usermanagement.core.exception.BaseException;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 26/9/18
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("tokenRepository")
@Transactional
public class TokenRepository implements PersistentTokenRepository {
    static final Logger logger = LoggerFactory.getLogger(TokenRepository.class);

    @Autowired(required = true)
    @Qualifier("DB")
    private PersistenceHandler persistenceHandler;

    public void createNewToken(PersistentRememberMeToken token) {
        logger.info("Creating Token for user : {}", token.getUsername());

        PersistentLogin persistentLogin = new PersistentLogin();
        persistentLogin.setUsername(token.getUsername());
        persistentLogin.setSeries(token.getSeries());
        persistentLogin.setToken(token.getTokenValue());
        persistentLogin.setLast_used(token.getDate());
        try {
            persistenceHandler.saveObject(null, persistentLogin);
        } catch (BaseException b) {
            b.printStackTrace();
        }
    }

    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        logger.info("Fetch Token if any for seriesId : {}", seriesId);
        try {
            PersistentLogin persistentLogin = (PersistentLogin) persistenceHandler.getObjectByProperty(PersistentLogin.class, "series", seriesId);
            return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(), persistentLogin.getToken(), persistentLogin.getLast_used());
        } catch (Exception e) {
            logger.info("Token not found...");
        }
        return null;
    }

    private PersistentLogin getToken(String seriesId) {
        logger.info("Fetch Token if any for seriesId : {}", seriesId);
        try {
            List<PersistentLogin> persistentLogins = (List<PersistentLogin>)persistenceHandler.getObjectByProperty(PersistentLogin.class, "series", seriesId);
            if ((persistentLogins != null) && (!persistentLogins.isEmpty())) {
                return (PersistentLogin) persistentLogins.get(0);
            }
        } catch (Exception e) {
            logger.info("Token not found...");
        }
        return null;
    }

    public void removeUserTokens(String username) {
        logger.info("Removing Token if any for user : {}", username);
        try {
            List<PersistentLogin> persistentLogins = (List<PersistentLogin>)persistenceHandler.getObjectByProperty(PersistentLogin.class, "username", username);
            if ((persistentLogins != null) && (!persistentLogins.isEmpty())) {
                logger.info("rememberMe was selected");
                this.persistenceHandler.deleteObject(null, persistentLogins.get(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Removing token not found...");
        }
    }

    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
        logger.info("Updating Token for seriesId : {}", seriesId);
        PersistentLogin persistentLogin = getToken(seriesId);
        persistentLogin.setToken(tokenValue);
        persistentLogin.setLast_used(lastUsed);
        try {
            this.persistenceHandler.saveObject(null, persistentLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
