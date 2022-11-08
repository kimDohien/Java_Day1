package day12;

public class TvRemoConA implements TvRemoteController {

	private int channel;
	private int volumn;
	private boolean power;

	@Override
	public void turn() {
		power = !power;

	}

	@Override
	public void channel(int channel) {
		if (!power) {
			return;
		}
		this.channel = channel;
		System.out.println("채널 : " + channel);

	}

	@Override
	public void channelUp() {
		if (!power) {
			return;
		}
		channel++;
		System.out.println("채널 : " + channel);

	}

	@Override
	public void channelDown() {
		if (!power) {
			return;
		}
		channel--;
		channel = channel < 1 ? 999 : channel;
		System.out.println("볼륨 : " + volumn);

	}

	@Override
	public void volumnUp() {
		if (!power) {
			return;
		}
		volumn++;
		volumn = volumn > 30 ? 30 : volumn;
		System.out.println("볼륨 : " + volumn);

	}

	@Override
	public void volumnDown() {
		if(!power) {
			return;
		}
		volumn++; 
		volumn =volumn <0 ? 0 : volumn;
	}

	public void print() {
		System.out.println("전원 : " + (power ? "ON" : "OFF"));
		System.out.println("채널 : " + channel);
		System.out.println("볼륨 : " + volumn);
	}

}
