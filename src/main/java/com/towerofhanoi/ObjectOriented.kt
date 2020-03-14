package com.towerofhanoi

class Stack {
    var capacity: Int = 0
    var top: Int = 0
    var array = arrayOfNulls<Int>(capacity)
}

class ObjectOriented {
    fun createStack(capacity: Int) : Stack {
        var stack = Stack()
        stack.capacity = capacity
        stack.top = -1
        stack.array = arrayOfNulls<Int>(stack.capacity)
        return stack
    }

    fun isFull(stack: Stack) : Boolean {
        return (stack.top == stack.capacity - 1)
    }

    fun isEmpty(stack: Stack) : Boolean {
        return (stack.top == -1)
    }

    fun push(stack: Stack, item: Int) {
        if (isFull(stack))
            return
        stack.array[++stack.top] = item
    }

    fun pop(stack: Stack) : Int {
        if (isEmpty(stack))
            return Int.MIN_VALUE
        return stack.array[stack.top--]!!
    }

    fun moveDisksBetweenTwoPoles(src: Stack, dest: Stack, s: Char, d: Char) {
        var pole1TopDisk = pop(src);
        var pole2TopDisk = pop(dest);

        if (pole1TopDisk == Int.MIN_VALUE) {
            push(src, pole2TopDisk)
            moveDisk(d, s, pole2TopDisk)
        }
        else if (pole2TopDisk == Int.MIN_VALUE) {
            push(dest, pole1TopDisk)
            moveDisk(s, d, pole1TopDisk)
        }
        else if (pole1TopDisk > pole2TopDisk) {
            push(src, pole1TopDisk)
            push(src, pole2TopDisk)
            moveDisk(d, s, pole2TopDisk)
        }
        else {
            push(dest, pole2TopDisk)
            push(dest, pole1TopDisk)
            moveDisk(s, d, pole1TopDisk)
        }
    }

    fun moveDisk(fromPeg: Char, toPeg: Char, disk: Int) {
        println("Move disk " + disk + " from " + fromPeg + " to " + toPeg)
    }

    fun iterativeLoop(numOfDisks: Int, src: Stack, aux: Stack, dest: Stack) {
        var s = 'A' // Source
        var a = 'B' // Aux
        var d = 'C' // Destination


        if (numOfDisks % 2 == 0) {
            var temp = d
            d = a
            a = temp
        }
        var totalNumOfMoves = (Math.pow(2.0, numOfDisks.toDouble()) - 1).toInt()

        for (i in numOfDisks downTo 1)
            push(src, i)

        for (i in 1..totalNumOfMoves) {
            if (i % 3 == 1) moveDisksBetweenTwoPoles(src, dest, s, d)
            if (i % 3 == 2) moveDisksBetweenTwoPoles(src, aux, s, a)
            if (i % 3 == 0) moveDisksBetweenTwoPoles(aux, dest, a, d)
        }
    }
}