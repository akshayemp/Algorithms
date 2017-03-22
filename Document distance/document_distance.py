'''
    Find the document distance.
'''

import sys
import math
import string

def read_file(filename):
    with open(filename) as f:
        return f.read()

translation_table = str.maketrans( string.punctuation + string.ascii_uppercase,
                                     " "*len(string.punctuation) +
                                  string.ascii_lowercase)
def get_words_from_lines(text):
    text = text.translate(translation_table)
    word_list = text.split()
    return word_list
 
def count_frequency(word_list):
    D = {}
    for new_word in word_list:
        if new_word in D:
            D[new_word] = D[new_word] + 1
        else:
            D[new_word] = 1
    return D

def word_frequencies_for_file(filename):
    line_list = read_file(filename)
    word_list = get_words_from_lines(line_list)
    freq_mapping = count_frequency(word_list)
    
    print("File", filename,":")
    print(len(line_list),"lines,")
    print(len(word_list), "words")
    print(len(freq_mapping),"distinct words")

    return freq_mapping

def inner_product(D1,D2):
    sum = 0.0
    for key in D1:
        if key in D2:
            sum += D1[key] * D2[key]
    return sum

def vector_angle(L1,L2):
    numerator = inner_product(L1,L2)
    denominator = math.sqrt(inner_product(L1,L1)*inner_product(L2,L2))
    return math.acos(numerator/denominator)

def main():
    if len(sys.argv) != 3:
        print("Usage: document distance.py filename_1 filename_2")
    else:
        filename_1 = sys.argv[1]
        filename_2 = sys.argv[2]
        sorted_word_list_1 = word_frequencies_for_file(filename_1)
        sorted_word_list_2 = word_frequencies_for_file(filename_2)
        distance = vector_angle(sorted_word_list_1, sorted_word_list_2)
        print("The distance between the documents is: %0.6f (radians)" %distance)

if __name__ == "__main__":
    import profile
    profile.run("main()")


