class DrumKit {
    boolean topHat = true;
    boolean snare = true;

    void playTopHat() {
        System.out.println("ding ding da-ding");
    }

    void playSnare() {
        System.out.println("bang bang ba-bang");
    }
}

class DrumKitTestDrive {
    public static void main(String[] args) {
        DrumKit kit = new DrumKit();
        kit.playSnare();
        kit.snare = false;
        kit.playTopHat();

        if (kit.snare == true) {
            kit.playSnare();
        }
    }
}
