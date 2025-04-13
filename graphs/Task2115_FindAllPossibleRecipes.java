package graphs;

import java.util.*;

// 29%
public class Task2115_FindAllPossibleRecipes {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        Map<String, List<String>> recipesMap = new HashMap<>();
        Set<String> unlimitedSupplies = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> ing = ingredients.get(i);
            String recep = recipes[i];
            if (ing.isEmpty() || ing.stream().filter(e -> !unlimitedSupplies.contains(e)).toArray().length == 0) {
                result.add(recep);
                unlimitedSupplies.add(recep);
            } else {
                recipesMap.put(recep, ing);
            }
        }

        boolean validTry = true;
        while (validTry) {
            validTry = false;

            for (String recipe : recipesMap.keySet()) {
                if (recipesMap.get(recipe).stream().filter(e -> !unlimitedSupplies.contains(e)).toArray().length == 0) {
                    validTry = true;
                    result.add(recipe);
                    unlimitedSupplies.add(recipe);
                    recipesMap.remove(recipe);
                    break;
                }
            }
        }

        return result;
    }
}
