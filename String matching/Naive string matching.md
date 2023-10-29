---
tags:
  - 🌱
  - ComputerScience 
date: 30--Oct--2022
---

# Naïve string matching

Given a Pattern p and Text t and we want to find if p exists in t. We can use the naive approach of checking if p exists in t by matching each character of pattern to text. If there is a match, pattern found, else shift the current starting point by 1 and repeat the check.

## Proof of strategy
- Pattern p with length m
- Text t with length n
Suppose we match the first m characters of t with pattern, and it is identical, then a match is found.
If there is a mismatch, we check the first m+1 characters of t with pattern. We keep repeating the strategy till n-m position. If at n-m, a match is not found, then the pattern does not exist in the text.

## Code
```java
stringMatch(String p, String t) {
    int m = p.length();
    int n = t.length();
    int i = 0, j = 0;
    while (j < n-m) {
        while(p[i] == t[j]){
            if (i==m){
                // Pattern full match found
                return true;
            }
            j++; i++;
        }
        // Push j back to its starting position + 1
        // If it was at index 0, we now check from index 1
        j = j-i+1;
        i = 0;
    }
    return false;
}
```

---
Links: 