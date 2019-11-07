package query.collection;

import com.documentum.fc.client.IDfCollection;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.IDfAttr;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds information about the columns of an {@link IDfCollection}
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CollectionSignature
{
    
    private final List<Column> columns;
    
    
    /** Constructs corresponding {@link CollectionSignature} from a given {@link IDfCollection} */
    public static CollectionSignature of(IDfCollection coll) throws DfException
    {
        IDfAttr attr = coll.getAttr(0);  //always at least 1 column
        Builder builder = new Builder(attr.getName(), ColumnType.of(attr));
        
        for (int i = 1; i < coll.getAttrCount(); ++i)
        {
            attr = coll.getAttr(i);
            builder.addColumn(attr.getName(), ColumnType.of(attr));
        }
        
        return builder.build();
    }
    
    
    /** Returns number of columns */
    public int columnCount() { return columns.size(); }
    
    /** Returns {@link Column} at given <code>index</code> */
    public Column getColumn(int index)
    {
        return columns.get(index);
    }
    
    
    /** Basic information about a collection column */
    @RequiredArgsConstructor
    public static class Column
    {
        /** Name of the column */
        public final String name;
        /** Type of the column */
        public final ColumnType type;
    }
    
    
    /** Builder for {@link CollectionSignature}, allows construction without having an {@link IDfCollection} */
    public static class Builder
    {
        
        private final List<Column> columns = new ArrayList<>();
        
        
        /** Constructs a new builder with first column as specified */
        public Builder(String name, ColumnType type) { addColumn(name, type); }
        
        
        /** Adds another column */
        public Builder addColumn(String name, ColumnType type)
        {
            columns.add(new Column(name, type));
            return this;
        }
        
        /** Builds {@link CollectionSignature} from current state */
        public CollectionSignature build() { return new CollectionSignature(columns); }
        
    }
    
}
