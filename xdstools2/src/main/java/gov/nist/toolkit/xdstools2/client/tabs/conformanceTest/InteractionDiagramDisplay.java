package gov.nist.toolkit.xdstools2.client.tabs.conformanceTest;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import gov.nist.toolkit.interactiondiagram.client.widgets.InteractionDiagram;
import gov.nist.toolkit.session.client.logtypes.TestOverviewDTO;
import gov.nist.toolkit.xdstools2.client.Xdstools2;
import gov.nist.toolkit.xdstools2.client.util.ClientUtils;

/**
 *
 */
public class InteractionDiagramDisplay extends FlowPanel {

    public InteractionDiagramDisplay(TestOverviewDTO testResultDTO) {
        InteractionDiagram diagram = new InteractionDiagram(ClientUtils.INSTANCE.getEventBus(), testResultDTO);
        if (diagram.hasMeaningfulDiagram()) {
            add(new HTML("<p><b>Interaction Sequence:</b></p>"));
            add(diagram);
            add(new HTML("<br/>"));
        }

    }
}
