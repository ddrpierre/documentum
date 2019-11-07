package query.collection;

import com.documentum.fc.client.IDfCollection;
import com.documentum.fc.common.DfException;
import lombok.RequiredArgsConstructor;

/**
 * Wrapper around {@link IDfCollection} focusing on row traversal
 */
@RequiredArgsConstructor
public class CollectionCursor implements AutoCloseable
{
    
    /** Underlying IDfCollection */
    private final IDfCollection coll;
    
    
    /** Advances cursor, returning whether new position has row data */
    public boolean next() throws DfException { return coll.next(); }
    
    /** Constructs {@link CollectionSignature} corresponding to underlying {@link IDfCollection} */
    public CollectionSignature getSignature() throws DfException
    {
        return CollectionSignature.of(coll);
    }
    
    /** Views underlying collection as a {@link CollectionRow} for data extraction */
    public CollectionRow viewAsRow() { return new CollectionRow(coll); }
    
    
    @Override
    public void close() throws DfException { coll.close(); }
    
}
