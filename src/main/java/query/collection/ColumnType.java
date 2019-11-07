package query.collection;

import com.documentum.fc.common.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ColumnType
{
    
    public static final ColumnType Boolean = new ColumnType();
    public static final ColumnType Int = new ColumnType();
    public static final ColumnType String = new ColumnType();
    public static final ColumnType Id = new ColumnType();
    public static final ColumnType Time = new ColumnType();
    public static final ColumnType Double = new ColumnType();
    
    /** Other (unsupported) cases */
    public static final ColumnType Other = new ColumnType();
    
    
    /** Deduces corresponding {@link ColumnType} from given {@link com.documentum.fc.common.IDfAttr} */
    public static ColumnType of(IDfAttr attr)
    {
        if (! attr.isRepeating()) {
            switch (attr.getDataType()) {
                case IDfValue.DF_BOOLEAN: return Boolean;
                case IDfValue.DF_INTEGER: return Int;
                case IDfValue.DF_STRING:  return String;
                case IDfValue.DF_ID:      return Id;
                case IDfValue.DF_TIME:    return Time;
                case IDfValue.DF_DOUBLE:  return Double;
            }
        }
        
        return Other;
    }
    
}
