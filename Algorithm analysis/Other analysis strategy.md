---
tags:
  - 🌱
  - ComputerScience 
date: 01--Oct--2022
---

# Other analysis strategy

## Upper bound characteristics
If some recursive algorithm makes a call to itself, we have to solve it using recurrence relations. A fast technique to solve this problem is to determine if the operations within the algorithm is a constant.

Recall $aW(n/b) + f(n)$ in [[Master method]]

If f(n) is some constant, then the time complexity of the algorithm is determined by the number of recursive calls. Eg. if there are $n$ recursive calls, then it is bounded by O(n).

---
Links: 