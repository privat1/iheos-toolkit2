/**
 * 
 */
package gov.nist.toolkit.actorfactory;

import java.util.ArrayList;
import java.util.List;

import gov.nist.toolkit.actorfactory.client.SimId;
import gov.nist.toolkit.actorfactory.client.Simulator;
import gov.nist.toolkit.actorfactory.client.SimulatorConfig;
import gov.nist.toolkit.actortransaction.client.ActorType;
import gov.nist.toolkit.configDatatypes.client.TransactionType;
import gov.nist.toolkit.sitemanagement.client.Site;
import gov.nist.toolkit.xdsexception.NoSimulatorException;

/**
 * Factory class for Combined Initiating Gateway Simulator
 * (Initiating Gateway and Initiating Imaging Gateway)
 * 
 * @author Ralph Moulton / MIR WUSTL IHE Development Project <a
 * href="mailto:moultonr@mir.wustl.edu">moultonr@mir.wustl.edu</a>
 *
 */
public class CigActorFactory extends AbstractActorFactory { 
   
   @Override
   protected Simulator buildNew(SimManager simm, SimId newID, boolean configureBase) throws Exception {
   ActorType actorType = ActorType.COMBINED_INITIATING_GATEWAY;
   SimulatorConfig sc;
   if (configureBase) sc = configureBaseElements(actorType, newID);
   else sc = new SimulatorConfig();
   
   SimId simId = sc.getId();
   
   // Group with an Initiating Gateway
   IGActorFactory ig = new IGActorFactory();
   SimulatorConfig igConfig = ig.buildNew(simm, simId, true).getConfig(0);
   sc.add(igConfig);
   
   // Group with an Initiating Imaging Gateway
   IigActorFactory iig = new IigActorFactory();
   SimulatorConfig iigConfig = iig.buildNew(simm, simId, true).getConfig(0);
   sc.add(iigConfig);
   
   return new Simulator(sc);
}

@Override
protected void verifyActorConfigurationOptions(SimulatorConfig sc) {
   
}

public Site getActorSite(SimulatorConfig sc, Site site) throws NoSimulatorException {
   String siteName = sc.getDefaultName();

   if (site == null)
      site = new Site(siteName);
   site.user = sc.getId().user;  // labels this site as coming from a sim

   boolean isAsync = false;

   new IGActorFactory().getActorSite(sc, site);
   new IigActorFactory().getActorSite(sc, site);

   return site;
}

@Override
public List<TransactionType> getIncomingTransactions() {
   List<TransactionType> tt = new ArrayList<TransactionType>();
   tt.addAll(new IGActorFactory().getIncomingTransactions());
   tt.addAll(new IigActorFactory().getIncomingTransactions());
   return tt;
}


}
