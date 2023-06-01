package com.interview;

/**
 * Created on 26/2/16, 9:33 AM
 * TournamentProbability.java
 *
 * @author gshankar
 */

/**
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
 */

public class TournamentWinningProbability {

    private static double[][] probabilities;

    public static void main(String[] args) {
        double sumOfProbability = 0.0;
        int n = 6;
        probabilities = new double[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            double probability = probability(n, i);
            sumOfProbability += probability;
            System.out.println("N=" + n + ", X=" + i + " : " + probability);
        }

        System.out.println("Sum = " + sumOfProbability);
    }

    static double probability(int N, int X) {
        if (N == 2) {
            return 0.5;
        }

        double prob = 0;

        if (probabilities[N][X] > 0) {
            return probabilities[N][X];
        }

        if (N % 2 == 0) {
            prob = 0.5 * probabilityAllRanks(N, X);
        } else {
            if (X == 1) {
                prob = probability(N / 2 + 1, X);
            } else {
                prob = 0.5 * probablityAllRanksWithoutFirst(N, X);
            }
        }

        probabilities[N][X] = prob;

        return prob;
    }

    static double probablityAllRanksWithoutFirst(int N, int X) {
        double totalWaysWithX = choose(N - 2, (N - 1) / 2 - 1);

        double probabilityOfWinning = 0;
        for (int i = 1; i <= (N - 1) / 2; i++) {
            probabilityOfWinning += (choose(X - 2, i - 1) * choose((N - X), (N - 1) / 2 - i) / totalWaysWithX) * probability((N + 1) / 2, i + 1);
        }
        return probabilityOfWinning;
    }

    static double probabilityAllRanks(int N, int X) {
        double totalWaysWithX = choose(N - 1, N / 2 - 1);

        double probabilityOfWinning = 0;
        for (int i = 1; i <= N / 2; i++) {
            probabilityOfWinning += (choose(X - 1, i - 1) * choose((N - X), N / 2 - i) / totalWaysWithX) * probability(N / 2, i);
        }
        return probabilityOfWinning;
    }

    private static int choose(int n, int c) {
        if (n < c) {
            return 0;
        }
        if (n == c || c == 0) {
            return 1;
        }
        return choose(n - 1, c - 1) + choose(n - 1, c);
    }
}