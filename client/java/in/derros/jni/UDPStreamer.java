package in.derros.jni;

// UDPStreamer JNI Interface
// @author R-J Alexander Fang
//

public class UDPStreamer {

	private native byte[] _n_grabFrame();
	private native void   _n_sendFrame();
	private native void   _n_showFrame_blocking();
    private native void _n_init();
    public UDPStreamer(String lp) { System.load(lp); _n_init();  }

	public byte[] grabFrame() {
		return _n_grabFrame();
	}

	public void sendFrame() { while(true) { _n_sendFrame(); } }

	public void showFrameBlocking() { _n_showFrame_blocking(); }

	public static void main(String[] args) {
		UDPStreamer streamer = new UDPStreamer("/home/alex/Projects/test-img-streaming/client/build/libUDPStreamer.so");
			while(true) {
                byte[] b = streamer.grabFrame();
	            System.out.println(b.length);
            }

    }
}
