package query.collection;

import com.documentum.fc.client.IDfCollection;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.IDfId;
import com.documentum.fc.common.IDfTime;
import lombok.RequiredArgsConstructor;

/**
 * Wrapper around {@link IDfCollection} focusing on data extraction from a collection row
 */
@RequiredArgsConstructor
public class CollectionRow
{
    
    /** Underlying IDfCollection */
    private final IDfCollection coll;
    
    
    public boolean getBoolean(String attrName) throws DfException { return coll.getBoolean(attrName); }
    public int getInt(String attrName) throws DfException { return coll.getInt(attrName); }
    public String getString(String attrName) throws DfException { return coll.getString(attrName); }
    public IDfId getId(String attrName) throws DfException { return coll.getId(attrName); }
    public IDfTime getTime(String attrName) throws DfException { return coll.getTime(attrName); }
    public double getDouble(String attrName) throws DfException { return coll.getDouble(attrName); }
    
}
