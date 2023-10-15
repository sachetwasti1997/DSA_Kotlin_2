package graphs

class Node(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()

    private fun dfsHelper(nodes: MutableList<String>, currentNode: Node) {
        if (currentNode.children.isEmpty()) {
            nodes.add(currentNode.name)
            return
        }
        nodes.add(currentNode.name)
        for (child in currentNode.children)
            dfsHelper(nodes, child)
    }

    fun depthFirstSearch(): List<String> {
        // Write your code here.
        val resList = ArrayList<String>()
        dfsHelper(resList, this)
        return resList
    }
}