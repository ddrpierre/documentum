package session;

import com.documentum.fc.client.DfClient;
import com.documentum.fc.client.DfServiceException;
import com.documentum.fc.client.IDfSession;
import com.documentum.fc.client.IDfSessionManager;
import com.documentum.fc.common.DfException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Simpler variant of {@link IDfSessionManager} restricted to single docbase
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleSessionManager implements SessionSource
{
    
    /** Underlying IDfSessionManager */
    private final IDfSessionManager manager;
    
    /** Name of target docbase */
    @Getter
    private final String docbaseName;
    
    
    /** Creates a new handle-wrapped {@link IDfSession} */
    public SessionHandle newSessionHandle() throws DfServiceException
    {
        return new SessionHandle(manager.newSession(docbaseName)) {
            @Override
            public void close() {
                manager.release(session);
            }
        };
    }
    
    
    /** Constructs a {@link SimpleSessionManager} from given credentials */
    public static SimpleSessionManager from(LoginInfo loginInfo, String docbaseName) throws DfException
    {
        IDfSessionManager manager = DfClient.getLocalClient().newSessionManager();
        manager.setIdentity(docbaseName, loginInfo.toIDfLoginInfo());
        
        return new SimpleSessionManager(manager, docbaseName);
    }
    
}
