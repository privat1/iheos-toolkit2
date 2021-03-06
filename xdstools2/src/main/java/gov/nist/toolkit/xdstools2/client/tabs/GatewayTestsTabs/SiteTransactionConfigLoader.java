package gov.nist.toolkit.xdstools2.client.tabs.GatewayTestsTabs;

import gov.nist.toolkit.sitemanagement.client.TransactionOfferings;
import gov.nist.toolkit.xdstools2.client.command.command.GetTransactionOfferingsCommand;
import gov.nist.toolkit.xdstools2.client.util.ClientUtils;

/**
 *
 */
public class SiteTransactionConfigLoader {

    public SiteTransactionConfigLoader() {
    }

    public void load(final CompletionHandler<TransactionOfferings> handler) {
        new GetTransactionOfferingsCommand() {
            @Override
            public void onComplete(TransactionOfferings var1) {
                handler.OnCompletion(var1);
            }
        }.run(ClientUtils.INSTANCE.getCommandContext());
    }
}
