import java.util.*

class PossibleRecipe {
    fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {
        val map = mutableMapOf<String, MutableSet<Int>>()
        for (recipe in recipes) {
            map[recipe] = mutableSetOf<Int>()
        }
        val size = recipes.size
        val dependency = IntArray(size) { 0 }
        for (i in recipes.indices) {
            for (ingredient in ingredients[i]) {
                if (map.containsKey(ingredient)) {
                    map[ingredient]!!.add(i) // who is dependent on
                    dependency[i] += 1 // dependency count
                }
            }
        }
        val result = mutableListOf<String>()
        val supply = supplies.toMutableSet()
        val queue = LinkedList<Int>()
        for (i in 0 until size) {
            if (dependency[i] == 0) {
                queue.add(i)
            }
        }



        while (queue.isNotEmpty()) {
            val index = queue.poll()
            var canBePrepared = true
            for (ingredient in ingredients[index]) {
                if (!supply.contains(ingredient)) {
                    canBePrepared = false
                    break
                }
            }
            if (canBePrepared) {
                result.add(recipes[index])
                supply.add(recipes[index])
                if (map.containsKey(recipes[index])) {
                    val list = map[recipes[index]]!!
                    for (ele in list) {
                        dependency[ele] -= 1
                        if (dependency[ele] == 0) {
                            queue.add(ele)
                        }
                    }
                }
            }
        }
        println(result)
        return result
    }
}

fun main() {
    val recipes = arrayOf("bread","sandwich", "burger")
    val ingredients = listOf(listOf("yeast", "flour"), listOf("bread","meat"), listOf("sandwich","meat","bread"))
    val supplies = arrayOf("yeast","flour","meat")
    val possibleRecipe = PossibleRecipe()
    possibleRecipe.findAllRecipes(recipes, ingredients, supplies)
}