# DRExercise
#How To Run:
  Main Class
 * It takes first argument as feature no and requires extra arguments as per Task to be performed

 * Feature 1: To identify sentence boundary and tokenize the text in the path for the input file ("nlp_data.txt")
    Input: Takes input filename "nlp_data.txt" as second argument
    >java Main 1 nlp_data.txt
 
    Outputs an xml file 
 
 * Feature 2: To add rudimentary recognition of proper nouns  in the input file 
    Input: Takes input path for the file with Named-entities ("NER.txt") as second argument and path for the input filename         ("nlp_data.txt") as third argument
    >java Main 2 NER.txt nlp_data.txt

    Outputs an xml file 
 
 * Feature 3: To parallel process the input files and tokenize 
    Input: Takes input path for the directory extracted from the zip file as second argument and path for the file with             Named-entities ("NER.txt") as third argument
    >java Main 3 nlp_data NER.txt

    >java Main 3 <dir-name> NER.txt

    Outputs an xml file for each input file in the zip file 
    

#Implementation
1> The program can be started by running Main class in the package com.dr.nlp.rw. It is responsible to initiate the task for each feature.

2> Data structures[com.dr.nlp.rw.ds] considered are Paragraph, Sentence, Word, Punctuation and NamedEntity. 
The Word, Punctuation and NamedEntity classes extends Items class where the relationship is considered that an item of sentence can be any of these three objects.

3> Task [com.dr.nlp.rw.task]
There are two task for the first two features TokenizerTask and NERTask which further process the text from the file

4>Thread Pool [com.dr.nlp.rw.threadpool]
ThreadPoolManager class creates the threadpool and assign task to worker thread
Worker thread further process the text from the file

#Limitations
1) It is assumed that input files are relatively small and stored as strings.If they are large, there are chances of memory issues.

2) It is assumed that named-entity file is relatively small, and stored as arraylist of strings. If it is large, memory issues can occur and looking up named-entity entry will become costly.

3)The Named entity is identified by looking up in the arraylist for each occurence which gives O(n^2).


