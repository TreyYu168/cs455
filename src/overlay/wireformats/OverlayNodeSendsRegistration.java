package overlay.wireformats;

public class OverlayNodeSendsRegistration implements Protocol{

    byte ipAddressLength;
    //byte[ipAddressLength];
    int portNumber;

    public OverlayNodeSendsRegistration() {

    }

    public static void main(String [] args) {
        System.out.println("Begin Main");

        overlay.wireformats.OverlayNodeSendsRegistration overlayNodeSendsRegistration1 = new overlay.wireformats.OverlayNodeSendsRegistration();
        System.out.println(overlayNodeSendsRegistration1);
    }
}
