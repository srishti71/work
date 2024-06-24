package graph

class PossibleBipartition {

    fun possibleBipartition(n: Int, dislikes: Array<IntArray>): Boolean {
        val adjacency = mutableMapOf<Int, MutableList<Int>>()

        for (i in 0 until dislikes.size) {
            val a = dislikes[i][0]
            val b = dislikes[i][1]
            val list1 = adjacency.getOrDefault(a, mutableListOf<Int>())
            list1.add(b)
            adjacency[a] = list1
            val list2 = adjacency.getOrDefault(b, mutableListOf<Int>())
            list2.add(a)
            adjacency[b] = list2
        }

        val parent = IntArray(n + 1) { 0 }
        for (i in 1..n) {
            parent[i] = i
        }

        val dsu = UnionFind(parent, IntArray(n + 1) { 0 })

        for (node in 1..n) {
            if (!adjacency.containsKey(node)) continue

            for (neighbor in adjacency.get(node)!!) {
                if (dsu.find(node) == dsu.find(neighbor)) return false

                dsu.union(adjacency.get(node)!!.get(0), neighbor)
            }
        }

        return true
    }

    data class UnionFind(val parent: IntArray, val rank: IntArray) {

        fun find(i: Int): Int {
            if (parent[i] == i) return parent[i]
            else return find(parent[i])
        }


        fun union(x: Int, y: Int) {

            val xset = find(x)
            val yset = find(y)

            if (xset == yset) return
            else if (rank[xset] < rank[yset]) {
                parent[xset] = yset
            } else if (rank[xset] > rank[yset]) {
                parent[yset] = xset
            } else {
                parent[yset] = xset
                rank[xset]++
            }
        }

    }
}