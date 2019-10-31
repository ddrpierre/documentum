package session;

import com.documentum.fc.common.DfException;

/**
 * Abstract logic to obtain a session handle, ie an {@link com.documentum.fc.client.IDfSession}
 */
public interface SessionSource
{
    
    /** Obtains a session wrapped in a {@link SessionHandle} */
    SessionHandle newSessionHandle() throws DfException;
    
}
