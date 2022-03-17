public class SessionTime {

    private int hours;
    private int minutes;
    String apm;

    // Simple object that contains only the time properties needed for this program.

    public SessionTime (int hours, int minutes, String apm) {
        this.hours = hours;
        this.minutes = minutes;
        this.apm = apm.toUpperCase();
    }

    @Override
    public String toString() {
        if (hours < 10 && minutes < 10) {
            return "0" + hours +
                    ":" + "0" + minutes +
                    apm;
        }
        else if (minutes < 10) {
            return  hours +
                    ":" + "0" + minutes +
                    apm;
        }
        else if (hours < 10) {
            return "0" + hours +
                    ":" + minutes +
                    apm;
        }
        else {
            return  hours +
                    ":" + minutes +
                    apm;
        }
    }

    public String add(int addedMinutes) {

        if (minutes + addedMinutes >= 60 && hours == 12) {
            hours = 1;
            minutes = minutes + addedMinutes - 60;
            if (apm.equalsIgnoreCase("am")) {
                apm = "PM";
            }
            else {
                apm = "AM";
            }
            return toString();
        }
        else if (minutes + addedMinutes >= 60) {
            hours = hours + 1;
            minutes = minutes + addedMinutes - 60;
            return toString();
        }
        else {
            minutes = minutes + addedMinutes;
            return toString();
        }

    }

}
