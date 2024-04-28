package Lesson18Fun;

public class Music {
    private static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        // Create and start a thread that constantly displays the modified content
        Thread displayThread = new Thread(new DisplayTask());
        displayThread.start();

        // Continuously create and start threads to append strings
        while (true) {
            // Create and start new threads
            new Thread(new AppendTask("Mayya ha ha")).start();
            new Thread(new AppendTask("Mayya  ho")).start();
            new Thread(new AppendTask("Mayya  ha")).start();
            try {
                // Pause for a short duration before creating new threads
                Thread.sleep(2100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class AppendTask implements Runnable {
        private String stringToAppend;

        public AppendTask(String stringToAppend) {
            this.stringToAppend = stringToAppend;
        }

        @Override
        public void run() {
            // Synchronize on the StringBuffer to ensure thread safety
            synchronized (stringBuffer) {
                stringBuffer.append(stringToAppend).append(" "); // Append the string
            }
        }
    }

    static class DisplayTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                // Display the modified content of StringBuffer
                synchronized (stringBuffer) {
                    System.out.println("Mayya hi: " + stringBuffer.toString());
                }

                try {
                    // Pause for a short duration before displaying again
                    Thread.sleep(2100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
