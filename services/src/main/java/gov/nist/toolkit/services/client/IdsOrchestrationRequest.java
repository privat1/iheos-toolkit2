package gov.nist.toolkit.services.client;

import gov.nist.toolkit.sitemanagement.client.SiteSpec;

/**
 *
 */
public class IdsOrchestrationRequest extends AbstractOrchestrationRequest {
   private static final long serialVersionUID = 1L;

   SiteSpec siteUnderTest;

   /**
    * @return the {@link #siteUnderTest} value.
    */
   public SiteSpec getSiteUnderTest() {
      return siteUnderTest;
   }

   /**
    * @param siteUnderTest the {@link #siteUnderTest} to set
    */
   public void setSiteUnderTest(SiteSpec siteUnderTest) {
      this.siteUnderTest = siteUnderTest;
   }
}
