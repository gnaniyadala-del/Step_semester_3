package OOP_Fundamentals.class_problems;

public class DuplicateTeamFinder {
    public static String findDuplicateTeam(String[] teamNames) {
        // Plain nested loops comparing each name only to the ones ahead of it
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] teamNames1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(teamNames1)); // Output: Duplicate Found: ByteForce

        String[] teamNames2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(teamNames2)); // Output: No Duplicates Found
    }
}


