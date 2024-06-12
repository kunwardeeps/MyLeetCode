class Trie:
    class TrieNode:
        def __init__(self):
            self.children = [None] * 26
            self.item = ""

    def __init__(self):
        self.root = self.TrieNode()

    def addWord(self, word):
        node = self.root
        for c in word:
            index = ord(c) - ord('a')
            if not node.children[index]:
                node.children[index] = self.TrieNode()
            node = node.children[index]
        node.item = word

    def search(self, word):
        return self.match(list(word), 0, self.root)

    def match(self, chs, k, node):
        if k == len(chs):
            return node.item != ""
        if chs[k] != '.':
            index = ord(chs[k]) - ord('a')
            return node.children[index] and self.match(chs, k + 1, node.children[index])
        else:
            for child in node.children:
                if child and self.match(chs, k + 1, child):
                    return True
        return False

t = Trie()
t.addWord("word")
t.addWord("hello")
print(t.search("word") == True)
print(t.search("hello") == True)
print(t.search("abc") == False)