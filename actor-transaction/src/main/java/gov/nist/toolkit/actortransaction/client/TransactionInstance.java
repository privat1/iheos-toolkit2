package gov.nist.toolkit.actortransaction.client;

import com.google.gwt.user.client.rpc.IsSerializable;
import gov.nist.toolkit.configDatatypes.client.TransactionType;

/**
 *
 */
public class TransactionInstance implements IsSerializable {
    public String simId = null;
    public String label = null;   // message id
    public String labelInterpretedAsDate = null;
    public String name = null;    // transaction type code
    public TransactionType nameInterpretedAsTransactionType = null;
    public ActorType actorType = null;

    public String toString() {
        return
                simId
                        + " " +
                actorType
                        + " " +
                        ((nameInterpretedAsTransactionType == null) ? name : nameInterpretedAsTransactionType)
                        + " " +
                ((labelInterpretedAsDate == null) ? label : labelInterpretedAsDate)
                ;

    }
}
