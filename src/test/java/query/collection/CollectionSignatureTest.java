package query.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CollectionSignatureTest
{
    
    @Test
    void columnOrderIsKept()
    {
        CollectionSignature signature =
                new CollectionSignature.Builder("one", ColumnType.String)
                .addColumn("two", ColumnType.String)
                .addColumn("three", ColumnType.String)
                .build();
        
        assertThat(signature.columnCount()).isEqualTo(3);
        assertThat(signature.getColumn(0).name).isEqualTo("one");
        assertThat(signature.getColumn(1).name).isEqualTo("two");
        assertThat(signature.getColumn(2).name).isEqualTo("three");
    }
    

}