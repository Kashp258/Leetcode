import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        // If the input string is empty, return an empty list
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }

        // Mapping of digits to corresponding letters
        String[] digitToLetters = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        // Initialize the result list with an empty string
        List<String> result = new ArrayList<>();
        result.add("");

        // Iterate through each digit in the input string
        for (char digit : digits.toCharArray()) {
            int digitIndex = digit - '0';  // Convert digit to integer index
            String letters = digitToLetters[digitIndex];  // Get corresponding letters

            // Create a temporary list to store new combinations
            List<String> tempList = new ArrayList<>();

            // For each existing combination, append each letter
            for (String combination : result) {
                for (char letter : letters.toCharArray()) {
                    tempList.add(combination + letter);  // Form new combinations
                }
            }

            // Update the result list with the new combinations
            result = tempList;
        }

        return result;  // Return the final list of combinations
    }
}