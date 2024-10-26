val br = System.`in`.bufferedReader()

lateinit var edge:Array<ArrayList<Int>>
lateinit var treeCnt: IntArray
lateinit var visited: BooleanArray

fun makeSubTreeCnt(n: Int,r: Int, q: Int){

    visited[r] =  true
    if(edge[r].isEmpty()){
        return
    }

    for(next in edge[r]){
        if(visited[next]) continue
        makeSubTreeCnt(n,next,q)
        treeCnt[r]+=treeCnt[next]
    }
}

fun main() = with(System.out.bufferedWriter()) {

    val (n,r,q) = br.readLine().split(' ').map{it.toInt()}
    edge = Array(n+1){ArrayList<Int>()}
    treeCnt = IntArray(n+1){1}
    visited = BooleanArray(n+1)

    for(i in 0 until n-1){
        val (from, to) = br.readLine().split(' ').map{it.toInt()}
        edge[from].add(to)
        edge[to].add(from)
    }

    makeSubTreeCnt(n,r,q)

    for(i in 0 until q){
        write("${treeCnt[br.readLine().toInt()]}\n")
    }

    close()
}