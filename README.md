# coc-kata
Personal Customized Kata about CoC RPG system (Call of Cthulhu®), not intended to be used by anyone.

[![CodeFactor](https://www.codefactor.io/repository/github/malkaviano/coc-kata/badge)](https://www.codefactor.io/repository/github/malkaviano/coc-kata)

This repo contains copyright material references, I'm the owner of the pdf book, and this project is intended for my own personal EDUCATIONAL purpose.

I'm not, in any way, giving anybody permission to use any of this without Chaosium® permission.

Project Rules / Goals:
- Always test first - TDD inspired;
- To capture all business rules (book rules) to code - DDD inspired;
- Avoid to the maximum primitive types - DDD technique inspired;
- Where specified by the book for the player to choose or roll, the software will make a random choice - Needs to be done for automation;
- Custom types over strings whenever possible - Trying to keep the static analysis power of the compiler on;
- Avoid outside lib dependencies to the core - DDD inspired;
- If needed generate abstrations to simulate concepts of the book, when needed simulate an environment to test concepts;
  - Keep it as simple as possible;

Optional implementations:
- New Age rule for EDU improvement (RandomHumanAgingEffectOnEducation). It cannot go above 99:
  - Age 80's: +5D10
  - Age 70's: +4D10
  - Age 60's: +3D10
  - Age 50's: +2D10
  - Age 40's: +1D10
  - Age 20-39: No change
  - Age < 20: -1D10
