package virtualMachine;

public class Printer implements Device {
	String buffer;
	
	public Printer () {
		buffer = null;
	}
	
	@Override
	public void busIn(String line) {
		buffer = line;
	
		Print();
	}

	@Override
	public String busOut() {
		// TODO Auto-generated method stub
		return null;
	}

	private void Print() {
		System.out.println(buffer);
	}
}
