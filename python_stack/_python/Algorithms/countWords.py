from collections import Counter

def count_words(list):
    # counts = Counter(list)
    # print(counts)
    remove_duplicates = sorted(set(list))
    for word in remove_duplicates:
        print("The frequency of the word " + word + " " + "is: " + str(list.count(word)))

count_words(["the", "name","of", "the", "rose", "the","english", "patient", "the","greatest", "person", "in", "the", "world", "test", "the", "person","hello"])
