package app;

/**
 *
 * @author monocat-maria <github.com/monocat-maria>
 */
public class Control {

    private byte channel;
    private short volume;
    private boolean on = false;

    public void on() {
        on = true;
        System.out.println("The TV is on.");
    }

    public void off() {
        on = false;
        System.out.println("The TV is off.");
    }

    public void changeChannel(byte newChannel) {
        if (!on) {
            System.out.println("The TV is off.");
        } else {
            if (newChannel > 1 && newChannel < 14) {
                channel = newChannel;
                System.out.println("Channel " + channel + " tuned.");
            } else {
                System.out.println("Invalid channel.\nSelect [CC]Change Channel and type a channel between 2 and 13.");
            }
        }
    }

    public void upVolume() {
        if (!on) {
            System.out.println("The TV is off.");
        } else {
            if (volume < 100) {
                volume++;
            }
            System.out.println("Current volume:" + volume);
        }
    }

    public void downVolume() {
        if (!on) {
            System.out.println("The TV is off.");
        } else {
            if (volume > 0) {
                volume--;
            }
            System.out.println("Current volume:" + volume);
        }
    }

    public void display() {
        if (!on) {
            System.out.println("The TV is off.");
        } else {
            System.out.println("Current channel:" + channel);
            System.out.println("Current volume:" + volume);
        }
    }
}
