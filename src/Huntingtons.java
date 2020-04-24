public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string
    public static int maxRepeats(String dna) {
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < dna.length() - 2; ) {
            // first check if we are at the end of the string as substring pulls from start up to, but not including the end
            if (dna.length() - i == 3) {
                if (dna.substring(i).equals("CAG")) {
                    count++;
                    if (count > maxCount) maxCount = count;
                }
                if (count > maxCount) maxCount = count;
                break;
            } else if (dna.substring(i, i + 3).equals("CAG")) {
                count++;
                i = i + 3;
                if (count > maxCount) maxCount = count;
            } else {
                count = 0;
                i++;
            }
        }
        return maxCount;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed
    // in linear time
    public static String removeWhitespace(String s) {
        // is the replace method faster than linear time?
        s = s.replace("\n", "");
        s = s.replace("\t", "");
        s = s.replace(" ", "");
        return s;
    }

    // Returns one of the diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", "Huntingtons"
    public static String diagnose(int maxRepeats) {
        if (maxRepeats > 180) return "not human";
        else if (maxRepeats > 39) return "Huntington's";
        else if (maxRepeats > 35) return "high risk";
        else if (maxRepeats > 9) return "normal";
        else return "not human";
    }

    public static void main(String[] args) {
        String fileName = args[0];
        In file = new In(fileName);
        String sequence = file.readAll();
        String sequenceCleaned = removeWhitespace(sequence);
        int maxRepeats = maxRepeats(sequenceCleaned);
        System.out.println("max repeats = " + maxRepeats + "\n" + diagnose(maxRepeats));
    }
}
