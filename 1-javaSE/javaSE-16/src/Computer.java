
public class Computer {

	public void drive(USB usb){
		usb.run();
	}
	
	public USB getUsb() {
//		return new Mouse();
		return new Cellphone();
	}
	
}
