# coc-universe
A CoC RPG system computer modeling. For educational purposes only.

Project Rules / Goals:
- Always test first - TDD inspired;
- To capture all business rules (book rules) to code - DDD inspired;
- Avoid to the maximum primitive types - DDD technique inspired;
- Where specified by the book for the player to choose or roll, the software will make a random choice - Needs to be done for automation;
- Custom types over strings whenever possible - Trying to keep the static analysis power of the compiler on;
- Avoid outside lib dependencies to the core - DDD inspired;
- If needed generate abstractions to simulate concepts of the book, when needed simulate an environment to test concepts;
  - Keep it as simple as possible;

Skill Roll:
- Determining the Difficulty Level
    - Regular difficulty level: an average example of what would challenge a competent person. The player needs to roll equal to or below their full skill or characteristic in order to succeed. This should be used in the vast majority of cases.

    - Hard difficulty level: this task would challenge a professional. The player needs to roll equal to or below a half of their skill or characteristic in order to succeed. This should only be used occasionally.

    - Extreme difficulty level: this task would challenge an expert; it is on the border of what is humanly possible. The player needs to roll equal to or below a fifth of their skill or characteristic in order to succeed. This should be reserved for extreme situations.

Chaosium® Inc., Call of Cthulhu®, etc. are registered trademarks.