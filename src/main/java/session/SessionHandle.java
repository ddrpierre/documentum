package session;

import com.documentum.fc.client.IDfSession;
import lombok.RequiredArgsConstructor;

/**
 * Wrapper around {@link IDfSession} to provide {@link AutoCloseable} behavior
 */
@RequiredArgsConstructor
public abstract class SessionHandle implements AutoCloseable
{
    
    /** Wrapped IDfSession */
    public final IDfSession session;
    
    
    @Override
    public abstract void close();
    
    
    /** Creates trivial handle doing nothing on {@link #close()} */
    public static SessionHandle of(IDfSession session)
    {
        return new SessionHandle(session) {
            @Override
            public void close() { }
        };
    }
    
}
