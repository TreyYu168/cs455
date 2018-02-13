package overlay.wireformats;

public interface Protocol {

    class OverlayNodeSendsRegistration{
        final byte messageType = 2;
    }
    class RegistryReportsRegistrationStatus{
        final byte messageType = 3;
    }
    class OverlayNodeSendsDeregistration{
        final byte messageType = 4;
    }
    class RegistryReportsDeregistrationStatus{
        final byte messageType = 5;
    }
    class RegistrySendsNodeManifest{
        final byte messageType = 6;
    }
    class NodeReportsOverlaySetupStatus{
        final byte messageType = 7;
    }
    class RegistryRequestsTaskInitiate{
        final byte messageType = 8;
    }
    class OverlayNodeSendsData{
        final byte messageType = 9;
    }
    class OverlayNodeReportsTaskFinished{
        final byte messageType = 10;
    }
    class RegistryRequestsTrafficSummary{
        final byte messageType = 11;
    }
    class OverlayNodeReportsTrafficSummary{
        final byte messageType = 12;
    }

}
