
public class Mouse implements USB{

	@Override
	public void run() {
		System.out.println("mouse run...");
	}

	@Override
	public void stop() {
		System.out.println("mouse stop...");
	}
	
	public void leftClick() {
		System.out.println("left click...");
	}

	public void rightClick() {
		System.out.println("right click...");
	}
	
}
