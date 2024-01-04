class MyQueue:

    def __init__(self):
        self.main_stack = []
        self.support_stack = []
        

    def push(self, x: int) -> None:
        self.main_stack.append(x)

    def pop(self) -> int:
        if len(self.support_stack)==0:
            while not len(self.main_stack)==0:
                self.support_stack.append(self.main_stack.pop())
        return self.support_stack.pop()
        
    def peek(self) -> int:
        if len(self.support_stack)==0:
                    while not len(self.main_stack)==0:
                        self.support_stack.append(self.main_stack.pop())
        return self.support_stack[-1]
        

    def empty(self) -> bool:
         return len(self.support_stack) == 0 and len(self.main_stack) == 0