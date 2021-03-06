package gov.nist.toolkit.xdstools2.client.tabs.actorConfigTab;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import gov.nist.toolkit.xdstools2.client.event.Xdstools2EventBus;
import gov.nist.toolkit.xdstools2.client.util.ClientUtils;
import gov.nist.toolkit.xdstools2.client.widgets.AdminPasswordDialogBox;
import gov.nist.toolkit.xdstools2.client.PasswordManagement;
import gov.nist.toolkit.xdstools2.client.widgets.PopupMessage;

class SaveButtonClickHandler implements ClickHandler {
	/**
	 * 
	 */
	private ActorConfigTab actorConfigTab;
	
	public SaveButtonClickHandler(ActorConfigTab actorConfigTab) {
		this.actorConfigTab = actorConfigTab;
	}
	
	public void onClick(ClickEvent event) {
		if (actorConfigTab.currentEditSite.getName().equals(actorConfigTab.newSiteName)) {
			new PopupMessage("You must give site a real name before saving");
			return;
		}

		if (PasswordManagement.isSignedIn) {
			actorConfigTab.saveSignedInCallback.onSuccess(true);
			((Xdstools2EventBus) ClientUtils.INSTANCE.getEventBus()).fireActorsConfigUpdatedEvent();
		}
		else {
			PasswordManagement.addSignInCallback(actorConfigTab.saveSignedInCallback);

			new AdminPasswordDialogBox(actorConfigTab.getTabTopPanel());
		}
	}

}