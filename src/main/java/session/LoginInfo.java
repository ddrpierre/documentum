package session;

import com.documentum.fc.common.DfLoginInfo;
import com.documentum.fc.common.IDfLoginInfo;
import lombok.RequiredArgsConstructor;

/**
 * Simple immutable variant of {@link IDfLoginInfo}
 */
@RequiredArgsConstructor
public class LoginInfo
{
    
    public final String user;
    public final String password;
    
    
    /** Converts into a {@link IDfLoginInfo} */
    public IDfLoginInfo toIDfLoginInfo()
    {
        IDfLoginInfo li = new DfLoginInfo();
        li.setUser(user);
        li.setPassword(password);
        
        return li;
    }
    
}
