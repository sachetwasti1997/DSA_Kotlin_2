package graphs

import java.util.*
import kotlin.collections.ArrayList

class NodeBFS(name: String) {
    val name: String = name
    val children = mutableListOf<NodeBFS>()

    fun breadthFirstSearch(): List<String> {
        // Write your code here.
        val resList = ArrayList<String>()
        val que: Queue<NodeBFS> = LinkedList()
        que.add(this)
        while (!que.isEmpty()) {
            val nd = que.poll()
            for (i in nd.children) {
                que.add(i)
            }
            resList.add(nd.name)
        }
        return resList
    }
}