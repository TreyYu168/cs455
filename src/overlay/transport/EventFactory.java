package overlay.transport;

import overlay.wireformats.*;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class EventFactory {
    private static EventFactory ourInstance = new EventFactory();

    public static EventFactory getInstance() {
        return ourInstance;
    }

    private EventFactory() {
    }

    public void buildEvent(byte[] marshaledBytes) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(marshaledBytes);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        byte messageType = dataInputStream.readByte();

        switch (messageType) {
            case 2:
                OverlayNodeSendsRegistration overlayNodeSendsRegistration = new OverlayNodeSendsRegistration(marshaledBytes);
                break;
            case 3:
                RegistryReportsRegistrationStatus registryReportsRegistrationStatus = new RegistryReportsRegistrationStatus(marshaledBytes);
                break;
            case 4:
                OverlayNodeSendsDeregistration overlayNodeSendsDeregistration = new OverlayNodeSendsDeregistration(marshaledBytes);
                break;
            case 5:
                RegistryReportsDeregistrationStatus registryReportsDeregistrationStatus = new RegistryReportsDeregistrationStatus(marshaledBytes);
                break;
            case 6:
                RegistrySendsNodeManifest registrySendsNodeManifest = new RegistrySendsNodeManifest(marshaledBytes);
                break;
            case 7:
                NodeReportsOverlaySetupStatus nodeReportsOverlaySetupStatus = new NodeReportsOverlaySetupStatus(marshaledBytes);
                break;
            case 8:
                RegistryRequestsTaskInitiate registryRequestsTaskInitiate = new RegistryRequestsTaskInitiate(marshaledBytes);
                break;
            case 9:
                OverlayNodeSendsData overlayNodeSendsData = new OverlayNodeSendsData(marshaledBytes);
                break;
            case 10:
                OverlayNodeReportsTaskFinished overlayNodeReportsTaskFinished = new OverlayNodeReportsTaskFinished(marshaledBytes);
                break;
            case 11:
                RegistryRequestsTrafficSummary registryRequestsTrafficSummary = new RegistryRequestsTrafficSummary();
                break;
            case 12:
                OverlayNodeReportsTrafficSummary overlayNodeReportsTrafficSummary = new OverlayNodeReportsTrafficSummary(marshaledBytes);
        }
    }
}
