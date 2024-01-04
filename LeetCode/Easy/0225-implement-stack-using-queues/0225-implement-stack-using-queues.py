from queue import Queue

class MyStack:

    def __init__(self):
        self.main_queue = Queue()
        self.support_queue = Queue()

    def push(self, x: int) -> None:
        self.main_queue.put(x)

        while not self.support_queue.empty():
            self.main_queue.put(self.support_queue.get())
        
        self.main_queue, self.support_queue = self.support_queue, self.main_queue

    def pop(self) -> int:
        return self.support_queue.get()

    def top(self) -> int:
        return self.support_queue.queue[0]

    def empty(self) -> bool:
        return self.support_queue.empty()