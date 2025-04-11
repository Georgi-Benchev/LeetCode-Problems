package graphs;

import java.util.*;
// beats 12% of ppl 12ms runtime 2times slower than average
public class Task207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, HashSet<Integer>> coursesMap = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            coursesMap.put(i, new HashSet<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int conditionCourse = prerequisite[1];
            coursesMap.get(course).add(conditionCourse);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!coursesMap.get(i).isEmpty()) {
                Set<Integer> visited = new HashSet<>();
                if (isCycle(coursesMap, i, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCycle(Map<Integer, HashSet<Integer>> conditions, int numToCheck, Set<Integer> visitedNums) {

        if (visitedNums.contains(numToCheck)) {
            return true;
        }

        if (conditions.get(numToCheck).isEmpty()) {
            return false;
        }
        visitedNums.add(numToCheck);

        List<Integer> copyConditions = conditions.get(numToCheck).stream().toList();

        for (int condition : copyConditions) {
            if (!conditions.get(condition).isEmpty() && isCycle(conditions, condition, visitedNums)) {
                return true;
            } else {
                conditions.get(numToCheck).remove(condition);
            }
        }

        return false;
    }

}