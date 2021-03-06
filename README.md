# Tournament - Probability of Winning

 There are N mad jokers in a line, numbered from 1 to N.

 The following process occurs until there is only 1 joker left:

 If the number of jokers left alive is odd, then everyone but the joker with the smallest number
 (not necessarily 1, if the joker numbered one is dead, it could be someone else) will engage in a fight.
 Of those who fight, an arbitrary half will come out alive. Therefore, the joker with the smallest index number
 will always be alive after this fight, as will 1/2 of the others.

 If the number of jokers left alive is even, everyone engages in a fight, and exactly half of the jokers come out alive.

 Note: Every joker has an equal chance of coming out alive from a fight.

 For example, if there are initially 5 jokers in a line (numbered 1, 2, 3, 4, and 5):

 Jokers numbered 2, 3, 4, and 5 will engage in a fight. Of these, two arbitrary jokers will come out alive.
 For the purpose of example, we will say that 2 and 3 come out alive. Then, there will be 3 jokers alive: 1, 2, and 3.
 Again, 1 will not have to fight, but 2 and 3 will have to. Here, either 2 and 3 will come out alive;
 again, for the purpose of example, we will say 2 comes out alive. Then, 1 and 2 will be alive. 1 and 2 will fight,
 and the last one standing will be determined based on this fight.

 Now, the purpose of this problem is to determine the probability that the Xth joker is the last one remaining,
 if there are exactly N Jokers initially.

 Constraints:
 1 ≤ N ≤ 14
 1 ≤ X ≤ N
 Input:
 The first and only line contains two space separated integers, N and X.
 
 Code credit - Saurabh Singh (singh.saurabh.p@gmail.com)
